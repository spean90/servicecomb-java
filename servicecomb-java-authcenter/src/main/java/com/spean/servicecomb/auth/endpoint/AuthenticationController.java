package com.spean.servicecomb.auth.endpoint;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spean.servicecomb.auth.AuthenticationService;

/**
 * @author siping_huang
 * @Date 2019年7月19日 下午5:27:30
 * @Desc
 */
@RestSchema(schemaId = "authenticationRestEndpoint")
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	static final String USERNAME = "username";
	static final String PASSWORD = "password";

	private final AuthenticationService authenticationService;
	private final AuthorizationHeaderGenerator authorizationHeaderGenerator;

	@Autowired
	AuthenticationController(AuthenticationService authenticationService,
			AuthorizationHeaderGenerator authorizationHeaderGenerator) {
		this.authenticationService = authenticationService;
		this.authorizationHeaderGenerator = authorizationHeaderGenerator;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> login(@RequestParam(USERNAME) String username,
			@RequestParam(PASSWORD) String password) {

		logger.info("Received login request from user {}", username);
		String token = authenticationService.authenticate(username, password);
		HttpHeaders headers = authorizationHeaderGenerator.generate(token);

		logger.info("Authenticated user {} successfully", username);
		return new ResponseEntity<>("Welcome, " + username, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String validate(@RequestBody Token token) {
		logger.info("Received validation request of token {}", token);
		return authenticationService.validate(token.getToken());
	}
}
