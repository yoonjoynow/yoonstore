package com.yoonstore.yoonshop.domains.item.model;

import com.yoonstore.yoonshop.domains.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter
@DiscriminatorValue("M")
@Entity
public class Movie extends Item {

    private String director;
    private String actor;

}
