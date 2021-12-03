import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quest2 {
    public static int oxygenGeneratorRating(String[] numbers) {
        int current_index = 0, biggestChunkus=1;
        char currentDigit = '1';
        String n[];
        do {
            int number_of_ones = 0, number_of_zeros = 0;
            for (String number : numbers) {
                if (number.charAt(current_index) == '1') {
                    number_of_ones++;
                } else {
                    number_of_zeros++;
                }
            }
            if (number_of_ones == number_of_zeros){
                currentDigit = '1';
                biggestChunkus = number_of_ones;
            }else if (number_of_ones > number_of_zeros){
                currentDigit = '1';
                biggestChunkus = number_of_ones;
            }else if (number_of_ones < number_of_zeros){
                currentDigit = '0';
                biggestChunkus = number_of_zeros;
            }
            n = new String[biggestChunkus];
            int index = 0;
            for (String number : numbers) {
               if (number.charAt(current_index) == currentDigit) {
                   n[index] = number;
                   index++;
               }
            }
            numbers = n;
            current_index++;
            //System.out.println(numbers.length);
        } while (numbers.length != 1);
        return Integer.parseInt(numbers[0],2);
    }

    public static int co2scrubberRating(String[] numbers) {
        int current_index1 = 0, biggestChunkus=1;
        char currentDigit = '1';
        String n[];
        do {
            int number_of_ones = 0, number_of_zeros = 0;
            for (String number : numbers) {
                //System.out.println(number);
                if (number.charAt(current_index1) == '1') {
                    number_of_ones++;
                } else {
                    number_of_zeros++;
                }
            }
            if (number_of_ones == number_of_zeros){
                currentDigit = '0';
                biggestChunkus = number_of_zeros;
            }else if (number_of_ones > number_of_zeros){
                currentDigit = '0';
                biggestChunkus = number_of_zeros;
            }else if (number_of_ones < number_of_zeros){
                currentDigit = '1';
                biggestChunkus = number_of_ones;
            }
            n = new String[biggestChunkus];
            int index = 0;
            for (String number : numbers) {
               if (number.charAt(current_index1) == currentDigit) {
                   n[index++] = number;
                //    index++;
               }
            }
            numbers = n;
            current_index1++;
            //System.out.println(numbers.length);
        } while (numbers.length != 1);
        return Integer.parseInt(numbers[0],2);
    }

    public static void main(String[] args) {
        String numbers[] = new String[1000];
        File file = new File("data.txt");
        try {
            Scanner sc = new Scanner(file);
            int iter1 = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                numbers[iter1] = line;
                iter1++;
            }
            // System.out.println(iter);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String numbers2[] = new String[1000];
        for(int c = 0; c < 1000; c++){
            numbers2[c] = numbers[c];
        } 
        
        int a = oxygenGeneratorRating(numbers);
        int b = co2scrubberRating(numbers2);
        System.out.println(a*b);
    }
}