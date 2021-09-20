package se.lexicon.recipedatabase.data;

public enum Measurement {

    measurement1(1,2),measurement2(2,4), measurement3(3,5)
    ,measurement4(4,6),measurement5(5,8);
    ;


    private int grams;
    private int tbs;

    Measurement(int grams,int tbs) {
        this.grams = grams;
        this.tbs = tbs;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "grams=" + grams +
                ", tbs=" + tbs +
                '}';
    }
}
