package br.com.microservices.rest;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.microservices.model.Client;
import br.com.microservices.model.Product;
import br.com.microservices.repository.ClientRepository;
import br.com.microservices.respository.ClientRepositoryTest;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClientApiTest {

	final String BASE_PATH = "http://localhost:8080/client/";
	private RestTemplate restTemplate;
	private ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private ClientRepository repository;

	private Client claudsan, rafaela, rogerio;

	@Before
	public void setUp() {
		repository.deleteAll();
		claudsan = ClientRepositoryTest.createClient("claudsan", "111");
		rafaela = ClientRepositoryTest.createClient("rafaela", "222");
		rogerio = ClientRepositoryTest.createClient("Rogério", "333");

		restTemplate = new RestTemplate();
	}

	@Test
	public void findAll() throws IOException {
		repository.save(claudsan);
		repository.save(rafaela);
		repository.save(rogerio);
		
		String response = restTemplate.getForObject(BASE_PATH, String.class);
		List<Client> clients = MAPPER.readValue(response,MAPPER.getTypeFactory().constructCollectionType(List.class, Client.class));
		Assert.assertEquals(3, clients.size());
	}

	
	@Test
	public void findProductsByClientId() throws IOException {
		repository.save(claudsan);
		String response = restTemplate.getForObject(BASE_PATH+"find-products-by-client-id/"+claudsan.client_id, String.class);
		List<Product> products = MAPPER.readValue(response,MAPPER.getTypeFactory().constructCollectionType(List.class, Product.class));
		Product product = products.get(0);
		Assert.assertEquals(product.product_id, claudsan.products.get(0).product_id);
	}
}
