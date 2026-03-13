package com.microservices.book_service.consumer;

import java.io.Serializable;

public class OrderMessage implements Serializable {

    private int bookId;

    private int quantity;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}