package com.example.foyerrouamnissi.RestControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HelloController {


    @GetMapping("/api/hello")
    public String helo(){

        return  "Hello from authorized API Request ";
    }
}
