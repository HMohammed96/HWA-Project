package com.qa.hwaproject.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Player does not exist with that ID")
public class PlayerNotFoundException extends EntityNotFoundException {

}
