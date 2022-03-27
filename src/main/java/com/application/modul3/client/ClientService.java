package com.application.modul3.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client createClient(Client client) {
		return clientRepository.saveAndFlush(client);
	}

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	public void deleteClientById(Integer id) {
		clientRepository.deleteById(id);
	}

	public Client updateClient(Client client, Integer id) {
		Client clientUpdate = getClientById(id);
		clientUpdate.setName(client.getName());
		clientRepository.flush();
		return clientUpdate;
	}

	public Client getClientById(Integer id) {
		Optional<Client> clientOpt = clientRepository.findById(id);
		if (clientOpt.isPresent()) {
			return clientOpt.get();
		}
		return null;

	}

}
