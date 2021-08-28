package com.swashtech.quickcare.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swashtech.quickcare.services.CustomerService;
import com.swashtech.utils.JSchemaUtility;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JSchemaUtility jSchemaUtility;

	@Autowired
	CustomerService customerService;

	@ApiOperation(value = "Register Customer", response = Iterable.class)
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> registerCustomer(@RequestBody String input) {
		long start = System.currentTimeMillis();
		logger.info("start registerCustomer...");
		ResponseEntity<String> response = null;
		JSONObject resp = new JSONObject();
		try {
			JSONObject jInput = new JSONObject(input);
			JSONObject schema = jSchemaUtility.readResourceFile("validateCustomer.json");
			JSONObject schemaOutput = jSchemaUtility.validateSchema(schema, jInput);
			if (schemaOutput != null && "Success".equals(schemaOutput.getString("status"))) {
				JSONObject json = customerService.registerCustomer(jInput);
				if (json != null && "Success".equals(json.getString("status"))) {
					response = new ResponseEntity<String>(json.toString(), HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<String>(json.toString(), HttpStatus.BAD_REQUEST);
				}
			} else {
				response = new ResponseEntity<String>(schemaOutput.toString(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp.put("status", "Error");
			resp.put("message", e.getMessage());
			response = new ResponseEntity<String>(resp.toString(), HttpStatus.BAD_REQUEST);
		}
		logger.info("registerCustomer response : " + response);
		logger.info("Time taken for registerCustomer() : " + (System.currentTimeMillis() - start) + " ms");
		return response;
	}

	@ApiOperation(value = "Add Patient", response = Iterable.class)
	@RequestMapping(value = "/addpatient", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addpatient(@RequestBody String input) {
		return null;
	}

	@ApiOperation(value = "Patient List", response = Iterable.class)
	@RequestMapping(value = "/listPatient", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> listPatient(@RequestBody String input) {
		return null;
	}

	@ApiOperation(value = "Book Caretaker for Patient", response = Iterable.class)
	@RequestMapping(value = "/bookCaretaker", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> bookCaretaker(@RequestBody String input) {
		return null;
	}

	@ApiOperation(value = "Caretaker Requested List", response = Iterable.class)
	@RequestMapping(value = "/requestlist", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> requestlist(@RequestBody String input) {
		return null;
	}

	@ApiOperation(value = "Cancel Caretaker Request", response = Iterable.class)
	@RequestMapping(value = "/cancelrequest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> cancelrequest(@RequestBody String input) {
		return null;
	}

	@ApiOperation(value = "Caretaker Feedback", response = Iterable.class)
	@RequestMapping(value = "/caretakerFeedback", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> caretakerFeedback(@RequestBody String input) {
		return null;
	}
}
