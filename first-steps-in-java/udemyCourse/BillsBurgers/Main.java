package com.company;

public class Main {

    public static void main(String[] args) {
        Burger plain = new Burger("oats", "beef");
//        plain.getBasePrice();
//        plain.add(plain.getLettuce());
//        plain.add(plain.getOlives());
//        plain.add(plain.getTomato());
//        plain.orderInfo();
//
        HealthyBurger hb = new HealthyBurger("beef");
//        hb.getBasePrice();
        hb.add(hb.getAvocado());
//        hb.getFinalPrice();
        hb.orderInfo();

//        DeluxeBurger db = new DeluxeBurger("wheat", "chicken");
//        db.getBasePrice();
//        db.getFinalPrice();
//        db.orderInfo();

    }
}
