package com.application.modul3.client.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.client.Client;
import com.application.modul3.client.dto.ClientDTO;

@Service
public class ClientMapper {

	public ClientDTO client2ClientDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(client.getId());
		clientDTO.setName(client.getName());
		return clientDTO;
	}

	public Client clientDTO2Client(ClientDTO clientDTO) {
		Client client = new Client();
		client.setName(clientDTO.getName());
		return client;
	}

	public List<ClientDTO> clientList2ClientListDTO(List<Client> clients) {
		return clients.stream().map(client -> client2ClientDTO(client)).collect(Collectors.toList());
	}
}
