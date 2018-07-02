package br.com.microservices.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum ClientType implements Serializable {
	VIP,NORMAL
}
