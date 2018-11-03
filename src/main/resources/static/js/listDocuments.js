define(['doc', 'ajax'], function($, ajax) {
	'use strict'
	document.addEventListener("DOMContentLoaded", function() {
		
		var $successMessage = $('#success-message'),
			$errorMessage = $('#error-message');
		
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
				}),
				signAs = $('input[name="selected-signer"]:checked').data('signas');
			
			var urlParams = new URLSearchParams(window.location.search);
			
			var batch = {
				'signer_key': selectedSignerKey,
				'sign_as': signAs,
				'document_keys': documentKeys,
				'access_token': urlParams.get('accessToken')
			};
			
			$errorMessage.removeClass('enabled');
			$successMessage.removeClass('enabled');
			
			ajax.post('/documents/batch', batch, {
				'success': function(response, xhr) {
					var $link = $successMessage.find('.link');
					
					$link.html(response.url);
					$link.attr('href', response.url)
					$successMessage.addClass('enabled');
					$('#signers-switch').first().checked = false;
				},
				'error': function(response, xhr){
					$errorMessage.addClass('enabled');
				},
				'complete': function(){
					$sendButton.removeClass('loading');
				}
			}, {
				headers: {
					"Content-Type": "application/json"
				},
				async: true
			});
		});
		
		$('.close').on('click', function() {
			$successMessage.removeClass('enabled');
		});
		
	});
});
