package br.com.microservices.object;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document
public class Address {

	private String street;
	
	@ApiModelProperty(position=2)
	private String city; 
	
	@ApiModelProperty(position=3)
	private String state;
	
	@ApiModelProperty(position=4)
	private String zip;

	@ApiModelProperty(position=1)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
