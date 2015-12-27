package com.rga.demo.rest.resource;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.common.model.RGACustomer;
import com.rga.demo.vo.CreateCustomerRequestBody;

@RestController
@RequestMapping("/resources")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<RGACustomer>> list() {
		return new ResponseEntity<List<RGACustomer>>(customerService.loadAllCustomers(), HttpStatus.OK);
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ResponseEntity<RGACustomer> get(@PathVariable Integer id) {
		final RGACustomer customer = customerService.loadUserById(id);
		return new ResponseEntity<RGACustomer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "create", consumes = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<RGACustomer> create(@RequestBody final CreateCustomerRequestBody body) {
		return new ResponseEntity<RGACustomer>(customerService.createCustomer(body.getUsername(), body.getPassword(), body.getEmail()), HttpStatus.CREATED);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		customerService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "update", consumes = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<RGACustomer> update(@RequestBody final CreateCustomerRequestBody body) {
		return new ResponseEntity<RGACustomer>(customerService.update(new RGACustomer(body)), HttpStatus.OK);
	}

}
