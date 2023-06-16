package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

//		Create a GetMapping that returns a basic "string" as a response
//		1 - Create a new endpoint "/hello" using the @GetMapping annotation. 2 - In the method, return a simple string such as "Hello World!".
	@GetMapping("/Hello")
	public String index() {
		return "Hello world!";
	}

//	Create a GetMapping that returns a ResponseEntity as a response
//1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
// 2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
// 3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".

	@GetMapping("/greeting")
	public ResponseEntity<String> greating(){
		if (new Date().getHours() > 12) {
//			return ResponseEntity.status(400).body("It's not morning");
			return ResponseEntity.badRequest().body("It's not morning");
		}

		return ResponseEntity.status(200).body("Hello everybody");
//			return ResponseEntity.ok("Hello everybody");
	}



}
