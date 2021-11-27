package com.company;
//This app is for the customer to choose type of burger and its additions.
//In the original course video instructor made it for the burgers' owner to help him make up the menu
public class Burger {
    private String name;
    private String rollType;
    private String meat;
    private int basePrice;
    private int finalPrice;

    private int lettuce;
    private int tomato;
    private int olives;
    private int cucumber;
    private boolean hasLettuce = false;
    private boolean hasTomato = false;
    private boolean hasOlives = false;
    private boolean hasCucumber = false;

    public Burger(String rollType, String meat) {
        this.rollType = rollType;
        this.meat = meat;
        if (meat.equalsIgnoreCase("beef")) {
            this.basePrice = 150;
        }
        if (meat.equalsIgnoreCase("chicken")) {
            this.basePrice = 100;
        }
        this.lettuce = 50;
        this.tomato = 60;
        this.olives = 40;
        this.cucumber = 20;
        this.finalPrice = this.basePrice;
    }

    public int add(int addition) {
        if (addition == lettuce) {
            hasLettuce = true;
        }
        if (addition == tomato) {
            hasTomato = true;
        }
        if (addition == olives) {
            hasOlives = true;
        }
        if (addition == cucumber) {
            hasCucumber = true;
        }
        return finalPrice += addition;
    }
    public String printAdded() {
        if (hasLettuce) {
            System.out.println("lettuce, 50 cent");
        }
        if (hasTomato) {
            System.out.println("tomato, 60 cent");
        }
        if (hasOlives) {
            System.out.println("olives, 40 cent");
        }
        if (hasCucumber) {
            System.out.println("cucumber, 20 cent");
        }
        if (!hasLettuce && !hasTomato && !hasCucumber && !hasOlives)
            return "no additions";
        return "";
    }

    public void orderInfo() {
        System.out.println("The base price for " + getClass().getSimpleName() + ": " + basePrice +
                            ", your additions are: ");
        System.out.println(printAdded() + "The final price is " + finalPrice);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        System.out.println("The burger is named "  + name);
        return name;
    }
    public int getLettuce() {
        return lettuce;
    }
    public int getTomato() {
        return tomato;
    }
    public int getOlives() {
        return olives;
    }
    public int getCucumber() {
        return cucumber;
    }
    public int getBasePrice() {
        return basePrice;
    }
    public int getFinalPrice() {
        return finalPrice;
    }
}
