package model;

public class Node {

    public static int[] trainNetwork(Person[] trainingArray) {
        int[] weight = new int[3];
        int[] values = new int[3];

        initializeWeight(weight);
        initializeValues(weight);

        // Start a loop to fix the weight value for all the data in the training array
        for (int index = 0; index < trainingArray.length; index++) {
            Person person = trainingArray[index];
            for (int j = 0; j < 3; j++) {
                values[j] = person.getValues()[j] * weight[j];
            }
            int classification = transform(sum(values));

            if (classification > person.getClassification()) {
                weight = subtractWeight(person.getValues(), weight);
                index = -1;
            } else if (classification < person.getClassification()) {
                weight = addWeight(person.getValues(), weight);
                index = -1;
            }
        }
        return weight;
    }

    public static int classify(Person person, int[] weight) {
        int[] values = new int[3];
        for (int j = 0; j < 3; j++) {
            values[j] = person.getValues()[j] * weight[j];
        }
        return transform(sum(values));
    }

    private static int[] addWeight(int[] personValues, int[] weight) {
        int[] newWeight = new int[3];
        for (int index = 0; index < 3; index++) {
            newWeight[index] = personValues[index] + weight[index];
        }
        return newWeight;
    }

    private static int[] subtractWeight(int[] personValues, int[] weight) {
        int[] newWeight = new int[3];
        for (int index = 0; index < 3; index++) {
            newWeight[index] = weight[index] - personValues[index];
        }
        return newWeight;
    }

    private static void initializeValues(int[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = 0;
        }
    }

    private static void initializeWeight(int[] weight) {
        for (int i = 0; i < weight.length; i++) {
            weight[i] = 0;
        }
    }

    private static int sum(int[] args) {
        int totalValue = 0;
        for (int value : args) {
            totalValue += value;
        }
        return totalValue;
    }

    private static int transform(int weight) {
        return weight > 0 ? 1 : 0;
    }


}
