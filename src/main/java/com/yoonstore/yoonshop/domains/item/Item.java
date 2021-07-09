package com.yoonstore.yoonshop.domains.item;

import com.yoonstore.yoonshop.domains.item.exception.NotEnoughStockException;
import com.yoonstore.yoonshop.domains.item.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Entity
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void reduceStock(int quantity) {
        int remainQuantity = this.stockQuantity - quantity;
        if (remainQuantity < 0) {
            throw new NotEnoughStockException("stock quantity could not be less than 0.");
        }

        this.stockQuantity = remainQuantity;
    }

}
