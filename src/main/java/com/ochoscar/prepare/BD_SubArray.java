package com.ochoscar.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * We define the following:
 *
 * A subarray of an -element array is an array composed from a contiguous block of the original array's elements. For example, if , then the subarrays are , , , , , and . Something like  would not be a subarray as it's not a contiguous subsection of the original array.
 * The sum of an array is the total sum of its elements.
 * An array's sum is negative if the total sum of its elements is negative.
 * An array's sum is positive if the total sum of its elements is positive.
 * Given an array of  integers, find and print its number of negative subarrays on a new line.
 *
 * Input Format
 *
 * The first line contains a single integer, , denoting the length of array .
 * The second line contains  space-separated integers describing each respective element, , in array .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the number of subarrays of  having negative sums.
 *
 * Sample Input
 *
 * 5
 * 1 -2 4 -5 1
 * Sample Output
 *
 * 9
 * Explanation
 *
 * There are nine negative subarrays of :
 *
 * Thus, we print  on a new line.
 */
public class BD_SubArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        ArrayList<Integer> array = (ArrayList<Integer>) Arrays.stream(line.split(" ")).map(Integer::new).collect(Collectors.toList());

        ArrayList<ArrayList<Integer>> allSubArray = new ArrayList<>();
        int k = 1;
        while(k <= array.size()) {
            for (int i = 0; i < array.size() - k + 1; i++) {
                // Crea el subarray
                ArrayList<Integer> newSubarray = new ArrayList<>();
                allSubArray.add(newSubarray);
                for (int j = 0; j < k; j++) {
                    newSubarray.add(array.get(i + j));
                }
            }
            k++;
        }

        int countNS = 0;
        for(ArrayList<Integer> ar : allSubArray) {
            int acum = 0;
            for(Integer it : ar) {
                acum += it;
            }
            if(acum < 0 ) countNS++;
        }

        System.out.println(countNS);
    }

}
