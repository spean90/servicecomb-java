package com.spean.servicecomb.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/** 
* @author siping_huang 
* @Date 2019年7月22日 下午3:24:31
* @Desc 
*/
@Service
public class AuthenticationService {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
  private static final String DOORMAN_ADDRESS = "cse://authcenter";

  private final RestTemplate restTemplate;

  @Autowired
  AuthenticationService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;

    this.restTemplate.setErrorHandler(new ResponseErrorHandler() {
      @Override
      public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return false;
      }

      @Override
      public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
      }
    });
  }

  @HystrixCommand(fallbackMethod = "timeout")
  public ResponseEntity<String> validate(String token) {
    logger.info("Validating token {}", token);
    
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(
        DOORMAN_ADDRESS + "/auth/validate",
        validationRequest(token),
        String.class
    );

    if (!responseEntity.getStatusCode().is2xxSuccessful()) {
      logger.warn("No such user found with token {}", token);
    }
    logger.info("Validated request of token {} to be user {}", token, responseEntity.getBody());
    return responseEntity;
  }

  private ResponseEntity<String> timeout(String token) {
    logger.warn("Request to validate token {} timed out", token);
    return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
  }

  private HttpEntity<Token> validationRequest(String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

    return new HttpEntity<>(new Token(token), headers);
  }
}
