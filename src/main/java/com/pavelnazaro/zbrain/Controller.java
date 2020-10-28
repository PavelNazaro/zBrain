package com.pavelnazaro.zbrain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@RequestMapping("/post")
public class Controller {

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> saveEmail(@RequestBody Email email){
        if (email.getEmail().equals("test@testemail.com")){
            return new ResponseEntity<>("{duplicate: true}", HttpStatus.NOT_FOUND);
        } else if (email.getEmail().equals("testno@testemail.com")) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
