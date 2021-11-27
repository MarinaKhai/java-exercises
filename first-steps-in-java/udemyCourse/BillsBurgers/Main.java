package com.company;

public class Main {

    public static void main(String[] args) {
        Burger plain = new Burger("whole wheat roll", "beef");
        plain.add(plain.getLettuce());
        plain.add(plain.getTomato());
        plain.orderInfo();

        HealthyBurger hb = new HealthyBurger("beef");
        hb.add(hb.getAvocado());
        hb.add(hb.getLettuce());
        hb.orderInfo();


        DeluxeBurger db = new DeluxeBurger("rye bread", "chicken");
        db.orderInfo();
    }
}
