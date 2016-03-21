package tech.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import tech.test.service.RoundRobinService;

@Controller
public class RoundRobinController {

	@Autowired
	RoundRobinService roundRobinService;
	
	@RequestMapping(value = "/rest/generateGame/{count}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> initiateBill(@PathVariable(value="count") int count) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap = (HashMap<String, Object>) roundRobinService.generateGame(count);
		
		return hashMap;
	}
	
	
} 
