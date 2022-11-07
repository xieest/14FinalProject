package com.example.demo.controllers;

import com.example.demo.entities.CreateCreditCardRequest;
import com.example.demo.entities.CreditCard;
import com.example.demo.services.CreditCardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/creditCard")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @ApiOperation(value = "save new credit card to the database")
    @PostMapping(value = {"", "/create"}, consumes = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> createCreditCard(@RequestBody CreateCreditCardRequest request) {
        if(creditCardService.createCreditCard(request.getCardNumber(), request.getUserName())){
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "return a user given a username")
    @GetMapping("/fetch/{username}")
    public ResponseEntity<List<CreditCard>> findUserByUsername(@PathVariable String username){
       return creditCardService.listCreditCardsForUser(username)
               .map(creditCards ->{
                   System.out.println("We are returning the object");
                   ResponseEntity<List<CreditCard>> response = ResponseEntity.ok(creditCards);
                   System.out.println("We created the response");
                   return response;
               } )
               .orElse(ResponseEntity.notFound().build());
    }
}