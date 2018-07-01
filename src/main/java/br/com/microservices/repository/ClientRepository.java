package br.com.microservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.microservices.object.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {
	
}
