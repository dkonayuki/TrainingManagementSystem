$(document).ready(function() {
	preparePage();
	
	$(function () {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	});
	
	$("#training-list").on("click", ".training-delete-btn", function() {
		var id = $(this).parents(".training-item").data("id");
		
		var r = confirm("Are you sure?");
		if (r == true) {
			$.ajax({
				type: "DELETE",
				url: "/trainings/" + id,
				success: function(data) {
					window.location.reload();
				},
				error: function(XHR, message, errorThrown) {
					console.log(errorThrown);
				}

			});
		} else {
		}
		

		return false;
	});

	/*For live search*/
	var timeout; // add delay time
	$("#training-search input").keyup(function() {
		window.clearTimeout(timeout); //clear delay
		timeout = window.setTimeout(reloadTrainingList, 500);

		return false;
	});

});

function preparePage() {
	var name = getParameterByName("name");
	$("#training-search input").val(name);
}

function reloadTrainingList() {
	
	var query = $("#training-search input").val();
	
	$.ajax({
		type: "GET",
		url: "/trainings?name=" + query,
		success: function(data) {
			$("#training-list").html(data);
		},
		error: function(XHR, message, errorThrown) {
			console.log(errorThrown);
		}
	});
	
	window.history.replaceState({}, "Trainings", "./trainings?name=" + query);

}

/*get url params*/
function getParameterByName(key,target){
	var values = [];
	if(!target){
		//decode url first
    target = decodeURIComponent(location.href);
	}
	
	key = key.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
	
	var pattern = key + '=([^&#]+)';
	var o_reg = new RegExp(pattern,'ig');
	while(true){
    var matches = o_reg.exec(target);
    if(matches && matches[1]){
      values.push(decodeURIComponent(matches[1]));
    }
    else{
      break;
    }
	}
	
	if(!values.length){
		return null;   
	}
	else {
		return values;
	}

}