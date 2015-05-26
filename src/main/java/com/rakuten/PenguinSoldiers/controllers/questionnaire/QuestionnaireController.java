package com.rakuten.PenguinSoldiers.controllers.questionnaire;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaire;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaireForm;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaireRepository;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingUserRepository;
import com.rakuten.PenguinSoldiers.support.web.MessageHelper;
import com.rakuten.PenguinSoldiers.util.ControllerUtil;
import com.rakuten.PenguinSoldiers.util.form.QuestionaireConverter;

@Controller
public class QuestionnaireController {

	@Autowired
	private TrainingRepository tr;

	@Autowired
	private TrainingUserRepository tur;

	@Autowired
	private AccountRepository ar;

	@Autowired
	private StandardQuestionnaireRepository sqr;

	@RequestMapping(value = "feedback/form", method = RequestMethod.GET)
	public String question(@RequestParam("tId") String tId,
			Principal principal, Model model, RedirectAttributes ra) {

		Long userId = ControllerUtil.getUserAccount(ar).getId();

		Long trainingId = Long.parseLong(tId);
		boolean isRegistered = tur.findByTrainingIdAndAccountId(trainingId,
				userId) != null;
		boolean isCompleted = sqr.completed(trainingId, userId) != null;
		if (!isRegistered || isCompleted) {
			if (isCompleted)
				MessageHelper.addInfoAttribute(ra, "feedback.completed");
			if (!isRegistered)
				MessageHelper.addInfoAttribute(ra, "feedback.not_registered");
			return "redirect:/";
		}

		StandardQuestionnaireForm sqf = new StandardQuestionnaireForm();
		Training t = tr.findById(Integer.parseInt(tId));
		sqf.setTrainingId(t.getId().longValue());
		sqf.setTrainingName(t.getName());
		model.addAttribute("sqForm", sqf);
		return "training/Questionnaire";
	}

	@RequestMapping(value = "feedback/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute StandardQuestionnaireForm sqForm,
			Principal principal, Model model, RedirectAttributes ra) {

		Long userId = ControllerUtil.getUserAccount(ar).getId();
		Long trainingId = sqForm.getTrainingId();
		boolean isRegistered = tur.findByTrainingIdAndAccountId(trainingId,
				userId) != null;
		boolean isCompleted = sqr.completed(trainingId, userId) != null;
		if (!isRegistered || isCompleted) {
			if (isCompleted)
				MessageHelper.addInfoAttribute(ra, "feedback.completed");
			if (!isRegistered)
				MessageHelper.addInfoAttribute(ra, "feedback.not_registered");
			return "redirect:/";
		}

		StandardQuestionnaire sq = QuestionaireConverter
				.toStandardQuestionaire(sqForm);
		sq.setUserId(ControllerUtil.getUserAccount(ar).getId());
		sqr.save(sq);

		MessageHelper.addInfoAttribute(ra, "feedback.success");
		return "redirect:/";
	}

	@RequestMapping(value = "feedback/view", method = RequestMethod.GET, headers = "x-requested-with=XMLHttpRequest")
	public String show(@RequestParam("qId") String qId, Principal principal,
			Model model, RedirectAttributes ra) {

		StandardQuestionnaire sq = sqr.findById(new Long(qId));

		model.addAttribute("sq", sq);
		return "/training/_show_q";
	}
}