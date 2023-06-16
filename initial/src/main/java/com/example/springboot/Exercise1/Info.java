package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Info {
    //	Create a new class with a GetMapping that returns a ResponseEntity a
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/info" using the @GetMapping annotation.
// 3 - In the method, return a ResponseEntity with 200 OK

    @GetMapping("/info")
    public ResponseEntity info(){
//        return ResponseEntity.status(200).body("200 OK");
			return ResponseEntity.ok("200 OK");
    }

//    Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/random" using the @GetMapping annotation.
// 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()

    @GetMapping("/random")
    public ResponseEntity random(){
        Boolean random = new Random().nextBoolean();
        if (random){// if (Random().nextBoolean()){dskqfgvlabv}
            return ResponseEntity.ok("200 OK");
//            return ResponseEntity.status(200).body("200 OK");
        }
        return ResponseEntity.badRequest().body("400 Bad Request");
//        return ResponseEntity.status(400).body("400 Bad Request");
    }
}
