package org.example.part4final;

import org.example.part4final.interfaces.MultiChoiceRepo;
import org.example.part4final.interfaces.TrueFalseRepo;
import org.example.part4final.interfaces.UserRepo;
import org.example.part4final.model.MultiChoice;
import org.example.part4final.model.TrueFalse;
import org.example.part4final.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    @PostMapping(path = "/addMultiChoice", consumes = "application/json")
    public @ResponseBody String addMultiChoice(@RequestBody MultiChoice multiChoice) {
        multiChoiceRepo.save(multiChoice);
        return "Added new Multiple Choice Question";
    }

    @PostMapping(path = "/addTF", consumes = "application/json")
    public @ResponseBody String addTrueFalse(@RequestBody TrueFalse trueFalse) {
        trueFalseRepo.save(trueFalse);
        return "Added new True/False Question";
    }

    //TODO Get all for each
    @GetMapping(path = "/selectAllUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping(path = "/selectAllMultiChoice")
    public @ResponseBody Iterable<MultiChoice> getAllMultiChoice() {
        return multiChoiceRepo.findAll();
    }

    @GetMapping(path = "/selectAllTrueFalse")
    public @ResponseBody Iterable<TrueFalse> getAllTrueFalse() {
        return trueFalseRepo.findAll();
    }

    //TODO Put just in case
    @PutMapping(path = "/updateUser/{id}")
    public @ResponseBody String updateUser(@PathVariable("id") long id, @RequestBody User updatedUser) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setPassword(updatedUser.getPassword());
            userRepo.save(existingUser);
            return "Updated User!";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PutMapping(path = "/updateMultiChoice/{id}")
    public @ResponseBody String updateMultiChoice(@PathVariable("id") long id, @RequestBody MultiChoice updatedMultiChoice) {
        Optional<MultiChoice> optionalMultiChoice = multiChoiceRepo.findById(id);
        if (optionalMultiChoice.isPresent()) {
            MultiChoice existingMultiChoice = optionalMultiChoice.get();
            existingMultiChoice.setA(updatedMultiChoice.getA());
            existingMultiChoice.setB(updatedMultiChoice.getB());
            existingMultiChoice.setC(updatedMultiChoice.getC());
            existingMultiChoice.setD(updatedMultiChoice.getD());
            multiChoiceRepo.save(existingMultiChoice);
            return "Updated Multiple Choice Question!";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PutMapping(path = "/updateTrueFalse/{id}")
    public @ResponseBody String updateTrueFalse(@PathVariable("id") long id, @RequestBody TrueFalse updatedTrueFalse) {
        Optional<TrueFalse> optionalTrueFalse = trueFalseRepo.findById(id);
        if (optionalTrueFalse.isPresent()) {
            TrueFalse existingTrueFalse = optionalTrueFalse.get();
            existingTrueFalse.setTrue(updatedTrueFalse.isTrue());
            existingTrueFalse.setFalse(updatedTrueFalse.isFalse());
            return "Updated True/False Question!";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    //TODO Delete just in case
    @DeleteMapping(path = "/deleteUser/{id}")
    public @ResponseBody String deleteUser(@PathVariable("id") long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepo.delete(user);
            return "User Deleted.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
    }

    @DeleteMapping(path = "/deleteMultiChoice/{id}")
    public @ResponseBody String deleteMultiChoice(@PathVariable("id") long id) {
        Optional<MultiChoice> optionalMultiChoice = multiChoiceRepo.findById(id);
        if (optionalMultiChoice.isPresent()) {
            MultiChoice multiChoice = optionalMultiChoice.get();
            multiChoiceRepo.delete(multiChoice);
            return "Multiple Choice Question Deleted.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found.");
        }
    }
        @DeleteMapping(path = "/deleteTrueFalse/{id}")
        public @ResponseBody String deleteTrueFalse (@PathVariable("id") long id){
            Optional<TrueFalse> optionalTrueFalse = trueFalseRepo.findById(id);
            if (optionalTrueFalse.isPresent()) {
                TrueFalse trueFalse = optionalTrueFalse.get();
                trueFalseRepo.delete(trueFalse);
                return "True/False Question Deleted.";
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "T/F Question not found.");
            }
        }
    }