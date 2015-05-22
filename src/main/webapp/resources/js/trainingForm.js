$(document).ready(function() {
	// minus button "thing"
	$('.btn-add').each(function(){
		$this = $(this);
		$this.removeClass('btn-add').addClass('btn-remove');
		$this.removeClass('btn-success').addClass('btn-danger');
		$this.find('.glyphicon-plus').removeClass('glyphicon-plus').addClass('glyphicon-minus');
	});
	
	$('.btn-remove:last').removeClass('btn-danger').addClass('btn-success');
	$($('.btn-remove:last')).find('.glyphicon-minus').addClass('glyphicon-plus').removeClass('glyphicon-minus');
	$('.btn-remove:last').removeClass('btn-remove').addClass('btn-add');
	console.log($($('.btn-remove:last')).find('.glyphicon-minus'));
	
	// decode hidden input outline into (date, content)inputs
	$this = $('#trainingForm');
	$this.find('.outline-input').each(function() {

		$t2 = $(this);
		$input_date = $t2.parents('tr').find('input.outline-date:first');
		$input_text = $t2.parents('tr').find('input.outline-text:first');
		str = decodeURIComponent($t2.val());
		console.log("str IS " + str);
		if (!str)
			return;
		var mjson = jQuery.parseJSON(str);
		$input_date.val(mjson["outline-date"]);
		$input_text.val(mjson["outline-text"]);
	});
});

// function to serialize input to JSON array
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

$(function() {
	
	// set 

	// Date time pickers
	$('#id_date').datetimepicker({
		format : "D/MM/YYYY, HH:mm"
	});
	$('#id_duedate').datetimepicker({
		format : "D/MM/YYYY, HH:mm"
	});

	$('.date_selector').datetimepicker({
		format : "D/MM/YYYY, HH:mm"
	});
	// Multiselect
	$('#venue').multiselect({
		buttonWidth : '400px',
		dropRight : true
	});

	// add more button
	$(document).on('click',
		'.btn-add',
		function(e) {
			e.preventDefault();
			var controlForm = $('.add-training form:first .goal-div div:first');
			var currentEntry = $(this).parents('.entry:first');
			var newEntry = $(currentEntry.clone()).appendTo(controlForm);

			newEntry.find('input').val('');
			controlForm
				.find('.entry:not(:last) .btn-add')
				.removeClass('btn-add')
				.addClass('btn-remove')
				.removeClass('btn-success')
				.addClass('btn-danger')
				.html('<span class="glyphicon type-input glyphicon-minus"></span>');
		}).on('click', '.btn-remove', function(e) {
			$(this).parents('.entry:first').remove();
			e.preventDefault();
			return false;
		});

	// add more outline button
	$(document).on(
		'click',
		'.btn-add-outline',
		function(e) {
			e.preventDefault();
			var controlForm = $('.outline-table:first');
			var currentEntry = $(this).parents('.entry-row:first');
			var newEntry = $(currentEntry.clone()).appendTo(controlForm);
			newEntry.find('input').val('');
			newEntry.find('.date_selector').datetimepicker({
				format : "D/MM/YYYY, HH:mm"
			});
			controlForm
				.find('.entry-row:not(:last) .btn-add-outline')
				.removeClass('btn-add-outline')
				.addClass('btn-remove-outline')
				.removeClass('btn-success')
				.addClass('btn-danger')
				.html('<span class="glyphicon type-row glyphicon-minus"></span>');
		}).on('click', '.btn-remove-outline', function(e) {
				$(this).parents('.entry-row:first').remove();
				e.preventDefault();
				return false;
			});

	// handle form submit and serialize fields

	$('#trainingForm').on(
		'submit',
		function(e) {
			// e.preventDefault();
			$this = $(this);
			$this.find('.outline-input').each(
				function() {
					$t2 = $(this);
					$inputs = $t2.parents('tr').find('input').not($t2);
					enc = encodeURIComponent(JSON.stringify($inputs
						.serializeObject()));
					$t2.val(enc);
				});
				$this.find('.outline-text').each(function() {
					// This urlencodes value of outlines
					this.value = encodeURIComponent(this.value);
				});
			});
});