package com.dcs.balaji.exception.advice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @author deepakdubey
 * @since 26 December 2019
 * @version 1.0
 */
@RestControllerAdvice(annotations = RestController.class)
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class DCSTaxExceptionHandler {

}
