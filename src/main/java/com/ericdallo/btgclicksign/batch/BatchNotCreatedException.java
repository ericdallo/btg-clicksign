package com.ericdallo.btgclicksign.batch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Batch not created")
public class BatchNotCreatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
