//import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class quest1{
    public static void main(String[] args){
        int arrays_size = 12;
        int numbers_of_ones[] = new int[arrays_size];
        int numbers_of_zeros[] = new int[arrays_size];
        try{
            File file = new File("data.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                int size = line.length();
                //System.out.println(line.charAt(size - 1));
                for(int c = 0; c < size; c++){
                    char i = line.charAt(c);
                    if(i == '1'){
                        numbers_of_ones[c]++;
                    } else {
                        numbers_of_zeros[c]++;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String epsilon="", gamma="";
        for (int c = 0; c < arrays_size; c++){
            if (numbers_of_ones[c] < numbers_of_zeros[c]){
                epsilon+="0";
                gamma+="1";
            } else {
                gamma+="0";
                epsilon+="1";
            }
        }
        System.out.println(Integer.parseInt(epsilon,2) * Integer.parseInt(gamma,2));
    }
}