package com.avatarduel.card;

public class SkillCard extends Card {
    private int power;

    public SkillCard(String name, String description, Element element,String imagePath, int power) {
        super(name, description, element,imagePath);
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Power\t : " + this.power);
    }
}
