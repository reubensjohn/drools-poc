package com.zyngl.raas.poc.api.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@ApiModel(description = "Class representing a Product.")
//public class Product implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@ApiModelProperty(notes = "The type of Jewellary", example = "Diamond", required = true, position = 0)
//	private String type;
//	@ApiModelProperty(notes = "The discount on the Jewellary", example = "10%", required = false, position = 1)
//	private int discount;
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public int getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(int discount) {
//		this.discount = discount;
//	}
//
//}

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type;
	private int discount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
