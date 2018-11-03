define(['doc', 'ajax'], function($, ajax) {
	'use strict'
	document.addEventListener("DOMContentLoaded", function() {
		
		var $message = $('#message');
		
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
			
			$message.removeClass('error');
			
			ajax.post('/documents/batch', batch, {
				'success': function(response, xhr) {
					$message.html('URL para assinatura: <a target="_blank" href="' + response.url + '">' + response.url + '</a>');
					$message.addClass('success');
				},
				'error': function(response, xhr){
					$message.html('Ocorreu um erro ao criar o lote :(');
					$message.removeClass('success');
					$message.addClass('error');
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
		
	});
});
