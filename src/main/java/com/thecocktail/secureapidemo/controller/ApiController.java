package com.thecocktail.secureapidemo.controller;

import com.thecocktail.secureapidemo.domain.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @RequestMapping(value = "/public", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message publicEndpoint() {
        return new Message("Hello from a public endpoint! You don't need to be authenticated to see this.");
    }

    @RequestMapping(value = "/private", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message privateEndpoint() {
        return new Message("Hello from a private endpoint! You need to be authenticated to see this.");
    }

    @RequestMapping(value = "/private-scoped", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message privateScopedEndpoint() {
        return new Message("Hello from a private endpoint! You need to be authenticated and have a scope of read:messages to see this.");
    }
}
