package com.crystalrunhealthcare.eventvalidation.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystalrunhealthcare.eventrules.model.Patient;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Medevantage
 *
 */
@Api(value = "EventController")
@RestController

public class EventController {
	@Autowired
	private KieSession session;

	/**
	 * inserts all the patient details in kiesession and fire the rules
	 * 
	 * @param patient
	 * @return event
	 */
	
	@ApiOperation(value = "Return the event name", response = Iterable.class, tags = "return events")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"), 
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "HTTP error!!!"),})


	@PostMapping("/validateEvent")
	public Patient orderNow(@RequestBody Patient patient) {
		session.insert(patient);
		session.fireAllRules();
		for (Object object : session.getObjects()) {
			session.delete(session.getFactHandle(object));
		}
		return patient;
	}

}
