package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class authorservice {
		
	static List<author>  author = new ArrayList<author>(); 
	static {
		//int id, String name, String country, int dob, int qtyBooks, Boolean alive
		author author1 = new author (1, "Juan","Barcelona", 1896, 2564, true );
		author author2 = new author (2, "Juan","Barcelona", 1896, 2564, true );
		author author3 = new author (3, "Juan","Barcelona", 1896, 2564, true );

		
		author.add(author3);
		author.add(author2);
		author.add(author1);
	}
	
	public static List<author> queryauthor() {
		return author;
	}


}