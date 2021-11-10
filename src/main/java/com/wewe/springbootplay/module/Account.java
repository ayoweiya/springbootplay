package com.wewe.springbootplay.module;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private CustomerVIP customeVIP;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

}
