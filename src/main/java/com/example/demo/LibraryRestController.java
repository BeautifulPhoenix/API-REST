package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this annotation is for tell this class that it is a REST CONTROLLER CLASS
@RestController
@RequestMapping("apilibrary")
public class LibraryRestController {

	@Autowired
	BookService bookservice;

	// here we are creating our endpoint rest api
	@GetMapping("books")
	public Iterable<Book> getAllBooks() {
		// to-do
		return bookservice.queryBook();
	}

	@GetMapping("newspapers")
	public Iterable<Newspaper> getAllNewsPaper() {
		return null;

	}

	@GetMapping("fakenews")
	public String getAllFakenew() {
		return "elreydimite";

	}

	@GetMapping("authors")
	public Iterable<author> getAllAuthors() {

		return authorservice.queryauthor();
	}

	@GetMapping("Movies")
	public Iterable<Movie> getAllMovies() {

		return Movieservice.queryMovies();
	}
}
