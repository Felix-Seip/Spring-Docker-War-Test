package com.prostep.examples;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/app")
public class AppRestController {
	
	private static final String APP_INFO = "http://localhost:8080/actuator/info";
	private static final String APP_HEALTH = "http://localhost:8080/actuator/health";
	
	@RequestMapping(value = "/")
	public Model getAppInfoAndHealth(Model model) {
		
		
		RestTemplate restTemplate = new RestTemplate();
        String info = restTemplate.getForObject(APP_INFO, String.class);
        String health = restTemplate.getForObject(APP_HEALTH, String.class);
		
        ObjectMapper objectMapper = new ObjectMapper();
        InfoObject infoObject = null;
        HealthObject healthObject = null;
        try {
			infoObject = objectMapper.readValue(info, InfoObject.class);
			healthObject = objectMapper.readValue(health, HealthObject.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("info", infoObject);
		model.addAttribute("health", healthObject);
		
		return model;
	}
	
	@RequestMapping(value = "/info")
	public Object getInfo() {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(APP_INFO, Object.class);
	}
	
	@RequestMapping(value = "/health")
	public Object getHealth() {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(APP_HEALTH, Object.class);
	}
	
}
