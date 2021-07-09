package com.yoonstore.yoonshop.domains.item.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(String message) {
        super(message);
    }

}
