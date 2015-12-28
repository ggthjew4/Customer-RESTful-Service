package com.rga.demo.rest.resource;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.intf.ICustomerLogoutService;
import com.rga.demo.common.intf.ICustomerLoginService;
import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.vo.LoginRequestBody;
import com.rga.demo.vo.LoginResponseBody;

@RestController
@RequestMapping("/session")
public class LoginController {


	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ICustomerLoginService loginService;
	
	@Autowired
	private ICustomerLogoutService logoutService;

	@RequestMapping(value = "login", consumes = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<LoginResponseBody> login(@RequestBody LoginRequestBody vo) {
		final CustomerAuthentication authentication = loginService.porcessLogin(vo.getCustomerName(), vo.getPassword());
		return new ResponseEntity<LoginResponseBody>(new LoginResponseBody(authentication.getToken(),vo.getCustomerName(),"Login Success!"), HttpStatus.OK);
	}

	@RequestMapping(value = "logout",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(@RequestParam("customerName") String customerName) {
		logoutService.processLogout(customerName);
	}

}
