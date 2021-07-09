package com.yoonstore.yoonshop.domains.delivery;

import com.yoonstore.yoonshop.domains.delivery.model.DeliveryStatus;
import com.yoonstore.yoonshop.domains.member.model.Address;
import com.yoonstore.yoonshop.domains.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Delivery {
    
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
