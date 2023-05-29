package com.ochoscar.prepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given a  2D array. An hourglass in an array is a portion shaped like this:
 *
 * a b c
 *   d
 * e f g
 * For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:
 *
 * 1 1 1     1 1 0     1 0 0
 *   1         0         0
 * 1 1 1     1 1 0     1 0 0
 * The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.
 *
 * In this problem you have to print the largest sum among all the hourglasses in the array.
 *
 * Input Format
 *
 * There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and  inclusive.
 *
 * Output Format
 *
 * Print the answer to this problem on a single line.
 *
 * Sample Input
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 *
 * 19
 * Explanation
 *
 * The hourglass which has the largest sum is:
 *
 * 2 4 4
 *   2
 * 1 2 4
 */
public class BC_2DArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();

        // Recorrer por filas
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.size(); i++) {
            // Si se encuentar un numerro diferente de 0 puede haber un reloj
            for(int j = 0; j < arr.get(i).size(); j++) {
                if(i + 2 < arr.size() && j + 2 < arr.get(i).size() ) {

                    // Verificar las posiciones que conforman el reloj
                    int i1 = arr.get(i).get(j);
                    int i2 = arr.get(i).get(j + 1);
                    int i3 = arr.get(i).get(j + 2);
                    int i4 = arr.get(i + 1).get(j + 1);
                    int i5 = arr.get(i + 2).get(j);
                    int i6 = arr.get(i + 2).get(j + 1);
                    int i7 = arr.get(i + 2).get(j + 2);

                    int sum = i1 + i2 + i3 + i4 + i5 + i6 + i7;
                    //Boolean isClock = (i1 != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i5 != 0 && i6 != 0 && i7 != 0) || (i1 != 0 && i2 != 0 && i5 != 0 && i6 != 0) || (i1 != 0 && i5 != 0);
                    // En caso de encontrar un reloj sumar las posiciones
                    if(sum > maxSum) maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);

    }

}
