/**
 * 
 */
package com.gr.moi.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorController extends AbstractErrorController {

	

	public BasicErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
		// TODO Auto-generated constructor stub
	}

	@RequestMapping
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,true);
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(body, status);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
