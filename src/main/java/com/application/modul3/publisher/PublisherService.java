package com.application.modul3.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.book.Book;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	public Publisher createPublisher(Publisher publisher) {
		return publisherRepository.saveAndFlush(publisher);
	}

	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}

	public Publisher getPublisherById(Integer id) {
		Optional<Publisher> publisherOpt = publisherRepository.findById(id);
		if (publisherOpt.isPresent()) {
			return publisherOpt.get();
		}
		return null;
	}

	public void deletePublisherById(Integer id) {
		publisherRepository.deleteById(id);
	}

}
