package com.company;

public class HealthyBurger extends Burger {

    private int avocado;
    private int carrot;
    private boolean hasAvocado = false;
    private boolean hasCarrot = false;

    private int finalPrice;
    private int basePrice;


    public HealthyBurger(String meat) {
        super("Brown rye bread", meat);
        this.avocado = 50;
        this.carrot = 30;
        if (meat.equalsIgnoreCase("beef")) {
            this.basePrice = 150;
        }
        if (meat.equalsIgnoreCase("chicken")) {
            this.basePrice = 100;
        }
        this.finalPrice = this.basePrice;
    }
    public int getAvocado() {
        return avocado;
    }
    public int getCarrots() {
        return carrot;
    }

    @Override
    public int add(int addition) {
        if (addition == avocado) {
            hasAvocado = true;
        }
        if (addition == carrot) {
            hasCarrot = true;
        }
        return addition + this.getFinalPrice();
    }

    @Override
    public String printAdded() {
        if (hasAvocado) {
            System.out.println("avocado, 50 cent");
        }
        if (hasCarrot) {
            System.out.println("carrot , 50 cent");
        }
        if (!hasAvocado && !hasCarrot)
            return "no additions";
        return "";
    }
}
