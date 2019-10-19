import model.Node;
import model.Person;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Person[] training = new Person[4];
        Person[] classifications = new Person[4];


        training[0] = new Person("Neymar", getValues(1, 0, 0), 0);
        training[1] = new Person("Messi", getValues(1, 0, 1), 0);
        training[2] = new Person("Barrichelo", getValues(1, 1, 0), 1);
        training[3] = new Person("Massa", getValues(1, 1, 1), 1);

        classifications[0] = new Person("Felipe", getValues(0, 0, 0));
        classifications[1] = new Person("Jorge", getValues(0, 1, 1));
        classifications[2] = new Person("Aurelio", getValues(0, 1, 0));
        classifications[3] = new Person("Adriner", getValues(0, 0, 1));

        int[] weight = Node.trainNetwork(training);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The current wheight values are: ");
        stringBuilder.append(Arrays.toString(weight));
        stringBuilder.append(".");
        System.out.println(stringBuilder.toString());

        for (Person person : classifications) {
            int classification = Node.classify(person, weight);
            stringBuilder = new StringBuilder();
            stringBuilder.append("The person ");
            stringBuilder.append(person.getName());
            stringBuilder.append(" is a ");
            stringBuilder.append(classification == 0 ? "Jogador" : "Piloto");
            System.out.println(stringBuilder.toString());
        }

    }

    private static int[] getValues(int value1, int value2, int value3) {
        return new int[]{value1, value2, value3};
    }
}
