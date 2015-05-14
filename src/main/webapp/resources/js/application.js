$(document).ready(function() {
	console.log("aa");
	/*$(function () {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		console.log(token);
		console.log(header);
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	});*/
	$("#training-list .training-delete-btn").on("click", function() {
		var id = $(this).parents(".training-item").data("id");
		console.log("trainings/" + id);
		$.ajax({
			type: "DELETE",
			url: "http://localhost:4555/trainings/" + id,
			success: function(data) {
				console.log(data);
			},
			error: function(XHR, message, errorThrown) {
				console.log(errorThrown);
			}
		
		});
		return false;
	});
});