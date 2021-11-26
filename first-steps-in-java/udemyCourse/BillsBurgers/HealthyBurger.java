package com.company;

public class HealthyBurger extends Burger {

    private int avocado;
    private int carrot;
    public HealthyBurger(String meat) {
        super("Brown rye bread", meat);
        this.avocado = 50;
        this.carrot = 30;
    }
    public int getAvocado() {
        System.out.println("Addition: avocado, It's price: " + this.avocado);
        return avocado;
    }
    public int getCarrots() {
        System.out.println("Addition: carrot, It's price: " + this.carrot);
        return carrot;
    }
}
