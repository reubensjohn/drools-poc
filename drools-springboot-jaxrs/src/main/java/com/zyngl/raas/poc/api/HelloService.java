package com.zyngl.raas.poc.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zyngl.raas.poc.api.model.Hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/v1/hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Hello API - say hello the world", produces = "application/json")
public interface HelloService {

	@GET						//JAX-RS Annotation
	@Path("/{name}")	//JAX-RS Annotation
	@ApiOperation(				//Swagger Annotation
			value = "Say hello by providing the name by URI, via standard json header", 
			response = Hello.class)  
	@ApiResponses(value = {		//Swagger Annotation
		@ApiResponse(code = 200, message = "Resource found"),
	    @ApiResponse(code = 404, message = "Resource not found")
	})
	public Response sayHelloByGet(@ApiParam @PathParam("name") String name);
}