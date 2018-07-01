package br.com.microservices.object;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection="clients")
public class Client {

	@ApiModelProperty(position=1,hidden=true)
	private ObjectId _id = new ObjectId();
	
	@ApiModelProperty(position=2)
	public String name;
	
	@ApiModelProperty(position=3)
	public Long document_id;

	@ApiModelProperty(position=4)
	public String phone_number;
	
	@ApiModelProperty(position=5)
	public String email;
	
	@Id
	@ApiModelProperty(position=6)
	public String client_id;
	
	
	@ApiModelProperty(allowableValues = "VIP, NORMAL",position=7)
	public List<ClientType> client_type;
	
	@ApiModelProperty(position=8)
	public List<Product> products;
	
	@ApiModelProperty(position=9)
	public List<Address> addresses;
	
	@ApiModelProperty(position=10)
	public Date created_on;

	@ApiModelProperty(hidden=true)
	public String get_id() {
		return _id.toHexString();
	}

}
