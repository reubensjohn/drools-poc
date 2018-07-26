package com.zyngl.raas.poc.api.impl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zyngl.raas.poc.api.ProductService;
import com.zyngl.raas.poc.api.model.Product;
import com.zyngl.raas.poc.services.JewelleryShopService;

@Component
public class ProductServiceImpl implements ProductService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private final JewelleryShopService jewelleryShopService;

	@Autowired
	public ProductServiceImpl(JewelleryShopService jewelleryShopService) {
		this.jewelleryShopService = jewelleryShopService;
	}


	public Response getDiscount(String productType) {
		LOGGER.info("v1/product/{} - {}", productType, MediaType.APPLICATION_JSON);
		return this.getProductDiscount(productType);
	}
	
	///////////////////////////////////////////////////////////////
	
	public Response getProductDiscount(String type) {

		Product product = new Product();
		product.setType(type);
		jewelleryShopService.getProductDiscount(product);
		return Response.status(Status.OK).entity(product).build();
	}

}