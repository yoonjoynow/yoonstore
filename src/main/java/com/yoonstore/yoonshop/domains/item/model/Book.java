package com.yoonstore.yoonshop.domains.item.model;

import com.yoonstore.yoonshop.domains.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter
@DiscriminatorValue("B")
@Entity
public class Book extends Item {

    private String author;
    private String isbn;

}
