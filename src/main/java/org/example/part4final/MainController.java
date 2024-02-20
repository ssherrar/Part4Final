package org.example.part4final;

import org.example.part4final.interfaces.MultiChoiceRepo;
import org.example.part4final.interfaces.TrueFalseRepo;
import org.example.part4final.interfaces.UserRepo;
import org.example.part4final.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    MultiChoiceRepo multiChoiceRepo;
    @Autowired
    TrueFalseRepo trueFalseRepo;

    //TODO Post Add Each Repo
    @PostMapping(path = "/addUser", consumes = "application/json")
    public @ResponseBody String addNewUser(@RequestBody User user) {
        userRepo.save(user);
        return "Added New User!";
    }
    //TODO Get all for each

    //TODO Put just in case

    //TODO Delete just in case
}
