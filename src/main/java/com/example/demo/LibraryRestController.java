package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this annotation is for tell this class that it is a REST CONTROLLER CLASS
@RestController
@RequestMapping("apilibrary")
public class LibraryRestController {

	@Autowired
	BookService bookservice;
	@Autowired
	Authorservice authorservice;

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
	public Iterable<Author> getAllAuthors() {

		return authorservice.querryAuthorsFromArray();
	}

	@GetMapping("Movies")
	public Iterable<Movie> getAllMovies() {

		return Movieservice.queryMovies();
	}

	@PostMapping(path = "/addauthor", consumes = "application/json")
	public Author createAuthor(@RequestBody Author author) {
		System.out.println("This is the object that gets from client/postman in java class book: " + author);

		Author authorsaved = authorservice.addAuthorToArray(author);

		return authorsaved;

	}

	/**
	 * @DeleteMapping("/deleteAuthor/{name}")
	 * public String deleteauthor(@PathVariable String name) {
	 * 
	 * String responsedelete = "";
	 * 
	 * if (authorservice.findAuthorByTilte(name) != -1) {
	 * authorservice.deleteAuthorFromArray(name);
	 * responsedelete = responsedelete + "Author: " + name + " - deleted succes";
	 * } else
	 * responsedelete = responsedelete + "Author: " + name + " - not deleted fail";
	 * 
	 * return responsedelete;
	 * }
	 * 
	 */

	/*
	 * 
	 * if (authorservice.findAuthorByTilte(name) != -1) {
	 * authorservice.deleteAuthorFromArray(name);
	 * responsedelete = responsedelete + "Author: " + name + " - deleted succes";
	 * } else {
	 * responsedelete = responsedelete + "Author: " + name + " - not deleted fail";
	 * }
	 */

	@DeleteMapping("/deleteAuthor/{name}")
	public ResponseEntity<Author> deleteauthor(@PathVariable String name, Author authorFromRest) {
		String responsedelete = "";
		Author authorToDeletede = null;

		int indexAuthor = authorservice.findAuthorByName(name);
		if (indexAuthor != -1) {
			responsedelete = name;

			authorservice.deleteAuthorFromArray(responsedelete);

			System.out.println("Author found " + responsedelete);
		} else {
			responsedelete = responsedelete + "Author: " + name + " - not deleted fail";
			System.out.println("Author Not found " + responsedelete);

		}

		var headers = new HttpHeaders();
		headers.add("Responsedelete", "deleteauthor executed");
		headers.add("version", "1.0 Api Author object");
		headers.add("Executed Output", responsedelete);

		return ResponseEntity.accepted().headers(headers).body(authorToDeletede);

	}

	@PostMapping("/replaceAuthor/{name}")
	public ResponseEntity<Author> updateAuthor(@PathVariable String name, @RequestBody Author authorFromRest) {

		String responseUpdate = "";
		Author authorToUpdate = null;

		int indexAuthor = authorservice.findAuthorByName(name);
		if (indexAuthor == -1) {
			responseUpdate = responseUpdate + "Author not found";
		} else {

			authorToUpdate = authorservice.getAuthorByIndex(indexAuthor);

			responseUpdate += "Author found";
			boolean updated = false;

			if (authorFromRest.getname() != null) {
				responseUpdate += "Name value updated: " + authorFromRest.getname() + "(old value: "
						+ authorToUpdate.getname() + ")";
				authorToUpdate.setname(authorFromRest.getname());
				updated = true;

			}

			if (authorFromRest.getcountry() != null) {
				responseUpdate += "Country value updated: " + authorFromRest.getcountry() + "( old value: "
						+ authorToUpdate.getcountry() + ")";
				authorToUpdate.setcountry(authorFromRest.getcountry());
				updated = true;

			}

			if (authorFromRest.getdob() != 0) {
				responseUpdate += " - dob int value updated: " + authorFromRest.getdob() + "(old value: "
						+ authorToUpdate.getdob() + ")";
				authorToUpdate.setdob(authorFromRest.getdob());
				updated = true;

			}

			if (authorFromRest.getqtyBooks() != 0) {
				responseUpdate += "- qtyBooks int value updated: " + authorFromRest.getqtyBooks() + "(old value: "
						+ authorToUpdate.getqtyBooks() + ")";
				authorToUpdate.setqtyBooks(authorFromRest.getqtyBooks());
				updated = true;

			}

			if (!updated)
				responseUpdate += " - try to update but any field updated - something wrong happened";
			else
				authorservice.replaceAuthor(indexAuthor, authorToUpdate);
		}

		var headers = new HttpHeaders();
		headers.add("ResponseUpdate", "updateAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", responseUpdate);

		return ResponseEntity.accepted().headers(headers).body(authorToUpdate);

	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public Book createBook(@RequestBody Book book) {

		System.out.println("This is the object that gets from client/postman in java class book: " + book);

		Book bookesaved = bookservice.addBookToArray(book);

		return bookesaved;

	}

	@DeleteMapping("/deleteBook/{title}")
	public String deleteBook(@PathVariable String title) {

		String responsedelete = "";

		if (bookservice.findBookByTilte(title) != -1) {
			bookservice.deleteBookFromArray(title);
			responsedelete = responsedelete + "Book: " + title + " - deleted succes";
		} else
			responsedelete = responsedelete + "Book: " + title + " - not deleted fail";

		return responsedelete;
	}

	@PostMapping("/replaceBook/{title}")
	public ResponseEntity<Book> updateBook(@PathVariable String title, @RequestBody Book bookFromRest) {

		String responseUpdate = "";
		Book bookToUpdate = null;

		int indexBook = bookservice.findBookByTilte(title);
		if (indexBook == -1) {
			responseUpdate = responseUpdate + "book not found";
		} else {

			bookToUpdate = bookservice.getBookByIndex(indexBook);

			// we are going to compare both books:
			// bookFromRest vs bookToUpdate
			// we need to compare each field of our object
			responseUpdate += "book found";
			boolean updated = false;

			if (bookFromRest.getAuthor() != null) {
				responseUpdate += " - author name value updated: " + bookFromRest.getAuthor() + "( old value: "
						+ bookToUpdate.getAuthor() + ")";
				bookToUpdate.setAuthor(bookFromRest.getAuthor());
				updated = true;
			}
			if (bookFromRest.getISBN() != null) {
				responseUpdate += " - ISBN value updated: " + bookFromRest.getISBN() + "( old value: "
						+ bookToUpdate.getISBN() + ")";
				bookToUpdate.setISBN(bookFromRest.getISBN());
				updated = true;
			}
			if (bookFromRest.getPages() != 0) {
				responseUpdate += " - pages int value updated: " + bookFromRest.getPages() + "( old value: "
						+ bookToUpdate.getPages() + ")";
				bookToUpdate.setPages(bookFromRest.getPages());
				updated = true;
			}
			if (bookFromRest.getYear() != 0) {
				responseUpdate += " - year int value updated: " + bookFromRest.getYear() + "( old value: "
						+ bookToUpdate.getYear() + ")";
				bookToUpdate.setYear(bookFromRest.getYear());
				updated = true;
			}

			if (!updated)
				responseUpdate += " - try to update but any field updated - something wrong happened";
			else
				bookservice.replaceBook(indexBook, bookToUpdate);
		}

		var headers = new HttpHeaders();
		headers.add("ResponseUpdate", "updateBook executed");
		headers.add("version", "1.0 Api Rest Book Object");
		headers.add("Executed Output", responseUpdate);

		return ResponseEntity.accepted().headers(headers).body(bookToUpdate);

	}

}