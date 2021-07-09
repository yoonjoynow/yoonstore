package com.yoonstore.yoonshop.domains.item.model;

import com.yoonstore.yoonshop.domains.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter
@DiscriminatorValue("A")
@Entity
public class Album extends Item {

    private String artist;
    private String etc;

}
