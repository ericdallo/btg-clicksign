package com.ericdallo.btgclicksign.list;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "All lists were not created successfully")
public class AllListsNotCreatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
}
