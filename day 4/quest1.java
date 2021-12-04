package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] numbers_tempo;
        int[] numbers_lottery = null;
        int numberOfMatrices = 100;
        int indexOfNumbers = 0;
        int lastNumber = 0;
        Matrix winner = new Matrix();
        Matrix[] numbers = new Matrix[numberOfMatrices];
        int result = 0;
        try {
            File file = new File("C:\\Users\\polac\\IdeaProjects\\quest1\\src\\com\\company\\data.txt");
            Scanner sc = new Scanner(file);
            String tmp = sc.nextLine();
            numbers_tempo = tmp.split(",");
            numbers_lottery = new int[numbers_tempo.length];
            int iter = 0;
            for (String number : numbers_tempo) {
                numbers_lottery[iter] = Integer.parseInt(number);
                iter++;
            }
            while (sc.hasNextLine()) {
                iter = 0;
                // int lastNumber = 0;
                numbers[indexOfNumbers] = new Matrix();
                numbers[indexOfNumbers].fillMatrix(sc);
                indexOfNumbers++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int num : numbers_lottery) {
            for (Matrix matrix : numbers) {
                for (int row = 0; row < matrix.getSize(); row++) {
                    for (int column = 0; column < matrix.getSize(); column++) {
                        matrix.checkInLottery(row, column, num);
                    }
                }
                if (!matrix.checkIfWin().equals("NoF")) {
//                    for (int row = 0; row < matrix.getSize(); row++) {
//                        for (int column = 0; column < matrix.getSize(); column++) {
//                            winner.setNumberValue(row, column, matrix.getNumberValue(row, column));
//                            winner.setInLotery(row, column,
//                                    matrix.checkInLottery(row, column, matrix.getNumberValue(row, column)));
//                        }
//                    }
                    result = matrix.calcWin(matrix.checkIfWin(), num);
                    System.out.println(result);
                    //lastNumber = num;
                    break;
                }
            }
//            if (!winner.checkIfWin().equals("NoF")) {
//                break;
//            }
//            result = winner.calcWin(winner.checkIfWin(), lastNumber);
//            System.out.println(result);

        }
    }

    public static class Number {
        protected int value;
        protected boolean isInLottery;

        public Number(int Value) {
            this.value = Value;
            this.isInLottery = false;
        }

        public int getValue() {
            return value;
        }

        public boolean getIsInLoterry() {
            return isInLottery;
        }

        public void setInLotery(boolean isInLotery) {
            this.isInLottery = isInLotery;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class Matrix {
        int size;
        Number[][] numbers;

        public Matrix() {
            this.size = 5;
            this.numbers = new Number[this.size][this.size];
        }

        public int getSize() {
            return size;
        }

        public void fillMatrix(Scanner sc) {
            for (int row = 0; row < getSize(); row++) {
                for (int column = 0; column < getSize(); column++) {
                    this.numbers[row][column] = new Number(sc.nextInt());
                    // System.out.println(column);
                }
            }
        }

        // public void fillMatrixZeros() {
        // for (int row = 0; row < getSize(); row++) {
        // for (int column = 0; column < getSize(); column++) {
        // this.numbers[row][column] = new Number(0);
        // // System.out.println(column);
        // }
        // }
        // }

        public int getNumberValue(int row, int column) {
            return this.numbers[row][column].getValue();
        }

        public void setNumberValue(int row, int column, int value) {
            this.numbers[row][column].setValue(value);
        }

        public void setInLotery(int row, int column, boolean b) {
            this.numbers[row][column].setInLotery(b);
        }

        //

//        public void printNumbers() {
//            for (Number[] numbers2 : numbers) {
//                for (Number number : numbers2) {
//                    System.out.print(number.getValue() + "\t");
//                }
//                System.out.print("\n");
//            }
//        }

        public boolean checkInLottery(int row, int column, int value) {
            if (this.numbers[row][column].getValue() == value) {
                this.numbers[row][column].setInLotery(true);
                return true;
            }
            return false;
        }

        public String checkIfWin() {
            for (int row = 0; row < getSize(); row++) {
                int ifInRow = 0;
                for (int column = 0; column < getSize(); column++) {
                    if (numbers[row][column].getIsInLoterry())
                        ifInRow++;
                }
                if (ifInRow == 5)
                    return "row";
            }
            for (int column = 0; column < getSize(); column++) {
                int ifInColumn = 0;
                for (int row = 0; row < getSize(); row++) {
                    if (numbers[row][column].getIsInLoterry())
                        ifInColumn++;
                }
                if (ifInColumn == 5)
                    return "column";
            }
            return "NoF";
        }

        public int calcWin(String s, int lastNumber) {
            int sum = 0;
            if (s.equals("Nof"))
                return 0;
            if (s.equals("row")) {
                // int indexOfWonRow = 0;
                for (int row = 0; row < getSize(); row++) {
                    for (int column = 0; column < getSize(); column++) {
                        if (!numbers[row][column].getIsInLoterry())
                            sum += numbers[row][column].getValue();
                    }
                }
            } else if (s.equals("column")) {
                // int indexOfWonColumn = 0;
                for (int column = 0; column < getSize(); column++) {
                    for (int row = 0; row < getSize(); row++) {
                        if (!numbers[row][column].getIsInLoterry())
                            sum += numbers[row][column].getValue();
                    }
                }
            }

            return sum * lastNumber;
        }

    }
}
