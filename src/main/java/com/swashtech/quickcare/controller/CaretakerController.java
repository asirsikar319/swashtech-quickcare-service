package com.swashtech.quickcare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api//caretaker")
public class CaretakerController {

	@ApiOperation(value = "Reguster Caretaker", response = Iterable.class)
	@RequestMapping(value = "/registerCaretaker", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> registerCaretaker(@RequestBody String input) {
		return null;
	}

	@ApiOperation(value = "Caretaker List", response = Iterable.class)
	@RequestMapping(value = "/listCaretaker", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> listCaretaker(@RequestBody String input) {
		return null;
	}
	
	@ApiOperation(value = "Caretaker Patients List", response = Iterable.class)
	@RequestMapping(value = "/listCaretakerPatients", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> listCaretakerPatients(@RequestBody String input) {
		return null;
	}
	
	@ApiOperation(value = "Accept Patient Request", response = Iterable.class)
	@RequestMapping(value = "/acceptRequest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> acceptRequest(@RequestBody String input) {
		return null;
	}
	
	@ApiOperation(value = "Reject Patient Request", response = Iterable.class)
	@RequestMapping(value = "/rejectequest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> rejectequest(@RequestBody String input) {
		return null;
	}
	
	@ApiOperation(value = "Patient History", response = Iterable.class)
	@RequestMapping(value = "/patientHistory", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> patientHistory(@RequestBody String input) {
		return null;
	}
	
	@ApiOperation(value = "Feedback Received from Customer", response = Iterable.class)
	@RequestMapping(value = "/listFeedback", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> listFeedback(@RequestBody String input) {
		return null;
	}

}
