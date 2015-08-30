package com.rga.demo.rest.resource;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class UserController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Map list() {
		return null;

	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		return new ResponseEntity<String>("", null, HttpStatus.OK);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ResponseEntity<String> add() {
		return new ResponseEntity<String>("", null, HttpStatus.CREATED);
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete() {
		return new ResponseEntity<String>("", null, HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity<String> update() {
		return new ResponseEntity<String>("", null, HttpStatus.OK);
	}

}
