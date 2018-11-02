define(['doc', 'ajax'], function($, ajax) {
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
		
		$('.main-content').on('click', function(e) {
			var isMenuEnabled = $('.signers-switch:checked').isPresent() && $('#menu').hasClass('enabled');
			
			if (isMenuEnabled) {
				e.preventDefault();
				$('#signers-switch').first().checked = false;
			}
		});
		
		$('#send-documents').on('click', function(e) {
			e.preventDefault();
			
			var $sendButton = $(this);
			
			$sendButton.addClass('loading');
			
			var selectedSignerKey = $('input[name="selected-signer"]:checked').val(),
				documentKeys = $('.documents .switch').els.map(function(document) {
					return document.id;
				});
			
			var batch = {
				'signer': selectedSignerKey,
				'documents': documentKeys
			};
			
			ajax.post('/documents/batch', batch, {
				'succes': function(response) {
					console.log('success ' + response);
				},
				'error': function(response){
					console.log('error ' + response);
				},
				'complete': function(){
					$sendButton.removeClass('loading');
				}
			});
		});
		
	});
});
