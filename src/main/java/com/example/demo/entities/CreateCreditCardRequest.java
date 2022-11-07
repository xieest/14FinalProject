package com.example.demo.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCreditCardRequest {

    private long cardNumber;

    private String userName;

}
