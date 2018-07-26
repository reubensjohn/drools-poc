package com.zyngl.raas.poc.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestParam;

import com.zyngl.raas.poc.api.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/v1/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Jewellary API - tells the discount on type of a jewellary", produces = "application/json")
public interface ProductService {

	
	@GET				//JAX-RS Annotation
	@Path("/{type}")	//JAX-RS Annotation
	@ApiOperation(		//Swagger Annotation
			value = "Get the discount on a type of Jewellary e.g 'Diamond,Gold,Silver,Copper etc.' by URI, via standard json header", 
			response = Product.class)  
	@ApiResponses(value = {		//Swagger Annotation
		@ApiResponse(code = 200, message = "Resource found"),
	    @ApiResponse(code = 404, message = "Resource not found")
	})
	public Response getDiscount(@ApiParam @PathParam("type") String productType);
	
	///////////////////////////////////////////////////////////////
	
	public Response getProductDiscount(@ApiParam("The Product Type. Can not be Empty")
		@RequestParam(required = true) String type);
}