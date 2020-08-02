package com.openshift.coursecatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.openshift.coursecatalogue.model.Users;
import com.openshift.coursecatalogue.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class UserController {

	@Autowired
	private UserService usersService;

	@RequestMapping("/getUser")
	public Users getUserName(@RequestParam String name) {
		Users users = usersService.getByName(name);
		return users;
	}

	@GetMapping(value = "/sendTemporaryPassword")
	public ResponseEntity<String> sendTemporaryPassword(@RequestBody JsonNode userNode) {
		String result = "";
		try {
			result = usersService.sendTemporaryPassword(userNode.get("email").asText(),
					userNode.get("userName").asText());
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping(path = "/insetUser")
	public ResponseEntity<String> insetUser(@RequestBody JsonNode userNode) {
		String result = "";
		try {
			Users user = new Users();
			user.setEmail(userNode.get("email").asText());
			user.setName(userNode.get("name").asText());
			user.setPassword(userNode.get("password").asText());
			user.setAdmin_access(userNode.get("admin_access").asBoolean());
			user.setRole(userNode.get("role").asText());
			result = usersService.insertUsers(user);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);

		}
	}
}
