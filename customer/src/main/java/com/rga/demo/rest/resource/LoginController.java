package com.rga.demo.rest.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Map login() {
		Map map = new HashMap();
		map.put("t", "gg");
		return map;
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout() {

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class UserNotFoundException extends RuntimeException {

		private static final long serialVersionUID = -9052367867893519929L;

		public UserNotFoundException(String userId) {
			super("could not find user '" + userId + "'.");
		}
	}
}
