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
		timeout = window.setTimeout(reloadTrainingList, 200);

		return false;
	});

});

function filterTrainingList(url){
  var timeout; // add delay time
  window.clearTimeout(timeout); //clear delay 
  timeout = window.setTimeout(function() {
	  reloadTrainingList('./?filter=past&name=');
  }, 200);
  return false;
}

function preparePage() {
	var name = getParameterByName("name");
	$("#training-searh input").val(name);
}

function reloadTrainingList() {
	
	var query = $("#training-search input").val();
	var toUrl="./trainings?name=" + query;
	$.ajax({
		type: "GET",
		url: toUrl,
		success: function(data) {
			$("#training-list").html(data);
		},
		error: function(XHR, message, errorThrown) {
			console.log(errorThrown);
		}
	});
	
	window.history.replaceState({}, "Trainings", toUrl);

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






//functions used in home page
function updateTrainingTab(here){
	var activeTab= $("#activeTrainingTab").val();
	$(activeTab).removeClass("active");
	$('training_tab_in').addClass("active");
	$("#activeTrainingTab").val(here);
}

function queryTrainingList(toUrl){
	$.ajax({
		type: "GET",
		url: toUrl,
		success: function(data) {
			//update the page fragment
            //use a different file otherwise will refresh the entire html body of the page
			$("#training_list").html(data);
		},
		error: function(XHR, message, errorThrown) {
			console.log(errorThrown);
		}
	});
	
	window.history.replaceState({}, "Trainings", toUrl);

}

function reloadTrainingHomePage(){
	var query = $("#training_form input").val();
	var filter= $("#training_form_filter").val();
	var toUrl="./?filter="+filter+"&name=" + query;
	queryTrainingList(toUrl);
}