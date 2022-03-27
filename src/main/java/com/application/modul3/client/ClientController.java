package com.application.modul3.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.client.dto.ClientDTO;
import com.application.modul3.client.mapper.ClientMapper;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientMapper clientMapper;

	@PostMapping
	public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
		Client createClient = clientService.createClient(clientMapper.clientDTO2Client(clientDTO));
		return clientMapper.client2ClientDTO(createClient);
	}

	@GetMapping("/list")
	public List<ClientDTO> getAllClients() {
		return clientMapper.clientList2ClientListDTO(clientService.getAllClients());
	}

	@GetMapping("/{id}")
	public Client getClientById(@PathVariable Integer id) {
		return clientService.getClientById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteClientById(@PathVariable Integer id) {
		clientService.deleteClientById(id);
	}

	@PutMapping("/{id}")
	public Client updateClient(@RequestBody Client client, @PathVariable Integer id) {
		return clientService.updateClient(client, id);
	}

}
