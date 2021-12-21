package com.wewe.springbootplay.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private CustomerVIP customeVIP;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

}
