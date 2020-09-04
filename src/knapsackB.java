//package algos;
import java.math.MathContext;
import java.util.ArrayList;

class item {
    public int weight;
    public int value;
    public item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class knapsackB {

    public static void main(String[] args) {
        item[] items = {
                new item(5, 30),
                new item(6, 35),
                new item(7, 32),
                new item(8, 38),
                new item(9, 40),
                new item(10, 41),
                new item(11, 45),
                new item(12, 46),
                new item(13, 50),
                new item(15, 55),
                new item(16, 60),
                new item(20, 80),
        };

        int bag = 100;
        int[][] result = new int[items.length][bag + 1];


        for (int it = 0; it < items.length; it++) {
            for (int i = 0; i <= bag; i++) {

                if (items[it].weight <= i) {
                    if (it != 0)
                        result[it][i] = Math.max(result[it - 1][i], items[it].value + result[it - 1][i - items[it].weight]);
                    else result[it][i] = items[it].value;
                } else {
                    // use previous
                    if (it != 0)
                        result[it][i] = result[it - 1][i];
                    else result[it][i] = 0;
                }

            }
        }

        // Printing Result matrix
        for (int it = 0; it < items.length; it++) {
            for (int i = 0; i <= bag; i++) {
                System.out.print(result[it][i] + " ");
            }
            System.out.println("");
        }

        int itemIndex = items.length - 1;
        int weightIndex = bag;

        // Printing the answer
        System.out.println(result[itemIndex][weightIndex]);

        ArrayList < item > finalBag = new ArrayList < item > ();
        while (weightIndex != 0) {
            if (result[itemIndex][weightIndex] != result[itemIndex - 1][weightIndex]) {
                // include this
                finalBag.add(items[itemIndex]);
                weightIndex = weightIndex - items[itemIndex].weight;
                itemIndex--;
            } else {
                itemIndex--;
            }
        }

        // Printing the bag
        for (item i: finalBag) {
            System.out.println(i.value);
        }


    }
}
