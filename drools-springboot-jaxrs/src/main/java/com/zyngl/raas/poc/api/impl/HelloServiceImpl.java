package com.zyngl.raas.poc.api.impl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zyngl.raas.poc.api.HelloService;
import com.zyngl.raas.poc.api.model.Hello;

@Component
public class HelloServiceImpl implements HelloService{

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

	public Response sayHelloByGet(String name) {
		LOGGER.info("v1/hello/{} - {}", name, MediaType.APPLICATION_JSON);
		return this.constructHelloResponse(name, MediaType.APPLICATION_JSON);
	}
	
	///////////////////////////////////////////////////////////////

	private Response constructHelloResponse(String name, String via) {
		//for testing how we handle 404
		if ("404".equals(name)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Hello result = new Hello();
		result.setMsg(String.format("Hello %s - %s", name, via));
		return Response.status(Status.OK).entity(result).build();
	}
}