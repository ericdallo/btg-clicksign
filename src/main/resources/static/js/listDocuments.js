define(['doc'], function($) {
	'use strict'
	document.addEventListener("DOMContentLoaded", function() {
		
		$('.documents .switch').on('change', function() {
			
			var hasSomeDocumentSelected = $('.documents .switch:checked').isPresent();
			
			if (hasSomeDocumentSelected) {
				$('#menu').addClass('enabled');
			} else {
				$('#menu').removeClass('enabled');
			}
		});
		
	});
});
