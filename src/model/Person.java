package model;

public class Person {

    private String name;
    private int[] values;
    private int classification;

    public Person(String name, int[] values, int classification) {
        this.name = name;
        this.values = values;
        this.classification = classification;
    }

    public Person(String name, int[] values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    int[] getValues() {
        return values;
    }

    int getClassification() {
        return classification;
    }
}
