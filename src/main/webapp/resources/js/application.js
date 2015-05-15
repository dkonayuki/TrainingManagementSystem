$(document).ready(function() {
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
			type: "DELETE",
			url: "trainings/" + id,
			success: function(data) {
				window.location.reload();
			},
			error: function(XHR, message, errorThrown) {
				console.log(errorThrown);
			}
		
		});
		return false;
	});
});