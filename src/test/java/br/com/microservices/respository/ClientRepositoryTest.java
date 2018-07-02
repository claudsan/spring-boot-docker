package br.com.microservices.respository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.microservices.model.Address;
import br.com.microservices.model.Client;
import br.com.microservices.model.ClientType;
import br.com.microservices.model.Product;
import br.com.microservices.repository.ClientRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository repository;

	private Client claudsan, rafaela, rogerio;
	
	@Before
    public void setUp() {
        repository.deleteAll();
        claudsan = createClient("claudsan","111");
        rafaela = createClient("rafaela","222");
        rogerio = createClient("Rogério","333");
    }

	@Test
    public void setsIdOnSave() {
        claudsan = repository.save(claudsan);
        rogerio = repository.save(rogerio);
        rafaela = repository.save(rafaela);
        assertThat(claudsan.get_id()).isNotNull();
        assertThat(rogerio.get_id()).isNotNull();
        assertThat(rafaela.get_id()).isNotNull();
    }
	
	@Test
    public void findsByExample() {
		Client probe = createClient("marcos", "8746");
		repository.save(probe);
		
        List<Client> result = repository.findAll(Example.of(probe));
        assertThat(result).hasSize(1).extracting("name").contains("marcos");
    }	
	
	@Test
    public void findProductsByClientId() {
		Client probe = createClient("marcos", "8746");
		repository.save(probe);
		
        List<Client> result = repository.findAll(Example.of(probe));
        assertThat(result).hasSize(1).extracting("client_id").contains("8746");
    }
	
	public static Client createClient(String nome, String clientId) {
		Random r = new Random();
		int randInt = r.nextInt(100);
		
		List<Address> ad = new ArrayList<Address>();
		Address address = new Address();
		address.street = "RUA X, "+clientId;
		address.city = "Uberlândia";
		address.state = "MG";
		address.zip = "38400000";
		ad.add(address);
		
		List<ClientType> clientType = new ArrayList<ClientType>();
		
		Client c = new Client();
		c.name = nome;
		c.client_id = clientId;
		c.addresses = ad;
		c.email = nome+"_"+clientId+"@email.com.br";
		c.client_type = clientType;
		c.created_on = Calendar.getInstance().getTime();
		c.document_id = (clientId.length()+nome.length()+Calendar.getInstance().getTimeInMillis())/randInt;
		c.phone_number = clientId+" "+c.document_id;
		
		List<Product> products = new ArrayList<Product>();
		Product p = new Product();
		p.list_price = 2.99F;
		p.name = "Atendente Humanizado";
		p.product_id = "123abc";
		p.sku = 555555555;
		products.add(p);
		
		c.products = products ;
		
		return c;
	}

}

