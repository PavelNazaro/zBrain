package com.pavelnazaro.zbrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/post")
public class Controller {
    private UsersService usersService;

    @Autowired
    public Controller(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<String> saveEmail(@RequestBody Email email){
        List<Users> users = usersService.findByEmail(email.getEmail());

        if (users.size() != 0){
            return new ResponseEntity<>("{duplicate: true}", HttpStatus.BAD_REQUEST);
        }

        usersService.save(new Users(email.getEmail()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
