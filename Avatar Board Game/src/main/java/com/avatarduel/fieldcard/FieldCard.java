package com.avatarduel.fieldcard;

/**
 * FieldCard is a class that represents card which is deployed on the field
 * @author Kelompok 9 K3
 * */
public class FieldCard {
    private int field;

    /**
     * Constructor of FieldCard, attribute field determines at which field/side of the board is the card on.the value can be 0 or 1
     * @param field field number of the FieldCard
     */
    public FieldCard(int field) {
        this.field = field;
    }

    /**
     * getter
     * @return field number of the FieldCard
     */
    public int getField() { return this.field; }
}