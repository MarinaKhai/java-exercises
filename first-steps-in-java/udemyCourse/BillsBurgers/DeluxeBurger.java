package com.company;

public class DeluxeBurger extends Burger{
    private int chips;
    private int drinks;
    private int finalPrice;
    private int basePrice;

    public DeluxeBurger(String rollType, String meat) {
        super(rollType, meat);
        this.chips = 60;
        this.drinks = 80;
        if (meat.equalsIgnoreCase("beef")) {
            this.basePrice = 150;
        }
        if (meat.equalsIgnoreCase("chicken")) {
            this.basePrice = 100;
        }
        this.finalPrice = chips + drinks + basePrice;
    }

    @Override
    public int add(int addition) {
        System.out.println("No extra additions allowed for deluxe burger. Final price is " + finalPrice);
        return this.finalPrice;
    }

    @Override
    public int getFinalPrice() {
        System.out.println("Final price for " + getClass().getSimpleName() + " is " + finalPrice);
        return finalPrice;
    }

    @Override
    public void orderInfo() {
        System.out.println("The base price for " + getClass().getSimpleName() + ": " + basePrice +
                ". Deluxe burger is a set which includes burger with 4 basic addings + chips and drinks.");
        System.out.println("You can't change this set. The final price is " + finalPrice);
    }
}
