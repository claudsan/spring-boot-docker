package br.com.microservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document
public class Address {

	@ApiModelProperty(position=1)
	public String street;
	
	@ApiModelProperty(position=2)
	public String city; 
	
	@ApiModelProperty(position=3)
	public String state;
	
	@ApiModelProperty(position=4)
	public String zip;

}
