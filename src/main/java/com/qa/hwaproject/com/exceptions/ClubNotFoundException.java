package com.qa.hwaproject.com.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Club does not exist with that ID")
public class ClubNotFoundException extends EntityNotFoundException {

}
