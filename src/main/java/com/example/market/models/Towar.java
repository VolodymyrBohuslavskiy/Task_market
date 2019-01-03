package com.example.market.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Towar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String titel, description;
    @NonNull
    int price;

    public Towar(String titel, String description, int price) {
        this.titel = titel;
        this.description = description;
        this.price = price;
    }
}
