package com.avatarduel.fieldcard;

public class FieldCard {
    private int field; //Determine which field is the fieldCard on, field=1 means this FieldCard is on p1's field

    public FieldCard(int field) {
        this.field = field;
    }

    public int getField() { return this.field; }
}