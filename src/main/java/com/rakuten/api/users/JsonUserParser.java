package com.rakuten.api.users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.rakuten.PenguinSoldiers.models.account.Account;

public class JsonUserParser {

	private String url = "http://rogin.cloudapp.net/api/users/";

	private String fullAccountLabel = "full_account";
	private String nameLabel = "name";
	private String employeeNoLabel = "employee_no";
	private String emailLabel = "email";
	private String organizationsLabel = "organizations";

	public RakutenUser parse(String url) throws MalformedURLException,
			IOException {
		// String url=this.url+username+".json";
		// get an instance of the json parser from the json factory

		JsonParser parser = this.getParser(url);
		if (parser == null)
			return null;

		// continue parsing the token till the end of input is reached
		RakutenUser ru = new RakutenUser();
		while (!parser.isClosed()) {
			JsonToken token = parser.nextToken();
			if (token == null)
				break;
			if (JsonToken.FIELD_NAME.equals(token)) {
				if (this.fullAccountLabel.equals(parser.getCurrentName())) {
					token = parser.nextToken();
					ru.setFullAccount(parser.getText());
				} else if (this.nameLabel.equals(parser.getCurrentName())) {
					token = parser.nextToken();
					ru.setName(parser.getText());
				} else if (JsonToken.FIELD_NAME.equals(token)
						&& this.employeeNoLabel.equals(parser.getCurrentName())) {
					token = parser.nextToken();
					ru.setEmployeeNo(parser.getText());
				} else if (JsonToken.FIELD_NAME.equals(token)
						&& this.emailLabel.equals(parser.getCurrentName())) {
					token = parser.nextToken();
					ru.setEmail(parser.getText());
				} else if (this.organizationsLabel.equals(parser
						.getCurrentName())) {
					// break here, information after this is not relevant now
					break;
				}
			}
		}

		return ru;
	}

	public boolean isUsernameExists(String url) throws JsonParseException,
			IOException {
		return getParser(url) != null;
	}

	public JsonParser getParser(String url) throws JsonParseException,
			IOException {
		try {
			JsonFactory factory = new JsonFactory();
			return factory.createJsonParser(new URL(url));
		} catch (FileNotFoundException ioe) {
			return null;
		}
	}

	public Account getAccount(String url) throws MalformedURLException,
			IOException {
		return Converter.RakutenUserToAccount(parse(url));
	}

	public Account getAccountByUsername(String username)
			throws MalformedURLException, IOException {
		return Converter.RakutenUserToAccount(parse(this.url + username
				+ ".json"));
	}

}
