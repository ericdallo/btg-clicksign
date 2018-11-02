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
		
		$('input[name="selected-signer"]').on('change', function() {
			
			var selectedSigner = $(this);
			
			if (selectedSigner.first().checked) {
				$('#batch-resume').addClass('signer-selected');
			}
		});
		
	});
});
