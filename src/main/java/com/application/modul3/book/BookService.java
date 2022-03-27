package com.application.modul3.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.author.Author;
import com.application.modul3.author.AuthorService;
import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;

	// cream o inregistrare si o salvam
	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	public Book createBook(Book book, Set<Integer> authorIds) {
		Set<Author> authors = authorService.getAuthors(authorIds);
		for (Author author : authors) {
			book.addAuthor(author);
		}
		return bookRepository.save(book);
	}

	// obtinem toate inreg din db
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// obtinem o inregistrare dupa id
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	}

	// stergerea unei carte
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	// update
	public Book updateBook(Book book, Integer id) {
		Book bookUpdate = getBookById(id);
		bookUpdate.setTitleBook(book.getTitleBook());
		bookUpdate.setYearBook(book.getYearBook());
		bookUpdate.setIsbnBook(book.getIsbnBook());
		bookRepository.flush();
		return bookUpdate;
	}

	// testata doar de Camelia!
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

}
