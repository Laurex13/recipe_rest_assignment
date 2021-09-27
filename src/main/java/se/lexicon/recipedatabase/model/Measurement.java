package se.lexicon.recipedatabase.model;

import javax.persistence.Entity;


public enum Measurement {

   GRAM(1),KILOGRAM(1000),HECTOGRAM(100), DL(0.100),
    LITRE(1);


    private double value;


    Measurement(double value) {
        this.value = value;

    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                '}';
    }
}
