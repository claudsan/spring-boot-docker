package br.com.microservices.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document
public class Product {

	@ApiModelProperty(position=1,hidden=true)
	private ObjectId _id = new ObjectId();
	
	@ApiModelProperty(position=5)
	public String product_id;
	
	@ApiModelProperty(position=2)
	public String name;
	
	@ApiModelProperty(position=3)
	public Float list_price;
	
	@ApiModelProperty(position=4)
	public Integer sku;
	
	@ApiModelProperty(hidden=true)
	public String get_id() {
		return _id.toHexString();
	}

}
