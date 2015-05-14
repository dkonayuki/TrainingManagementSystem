$(document).ready(function() {
	console.log("aa");
	$(function () {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	});
	$("#training-list .training-delete-btn").on("click", function() {
		var id = $(this).parents(".training-item").data("id");
		console.log("trainings/" + id);
		$.ajax({
			method: "DELETE",
			url: "trainings/" + id
		});
		return false;
	});
});