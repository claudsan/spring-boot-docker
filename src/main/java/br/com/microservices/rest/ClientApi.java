package br.com.microservices.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservices.object.Client;
import br.com.microservices.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Operations for clients")
@RestController
@RequestMapping("/client")
public class ClientApi {

	private final ClientRepository repository;
    
	@Autowired
    public ClientApi(ClientRepository repository) {
        this.repository = repository;
    }
	
	@ApiOperation("Find all clients")
	@RequestMapping(value="/",method = RequestMethod.GET)
    public List<Client> findAll(HttpServletResponse response) {
		List<Client> result = repository.findAll();
		if(result.isEmpty())
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		else
			response.setStatus(HttpServletResponse.SC_OK);
        return result;
    }
	
	@ApiOperation("Create new client")
	@RequestMapping(method = RequestMethod.PUT)
    public Client insert(@RequestBody Client client, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
        return repository.insert(client);
    }
    
	@ApiOperation("Delete client")
	@RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Client client, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        repository.delete(client);
    }
    
}
