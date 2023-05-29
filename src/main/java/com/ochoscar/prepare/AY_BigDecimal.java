package com.ochoscar.prepare;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!
 *
 * Given an array, , of  real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as it was read from stdin, meaning that  is printed as , and  is printed as . If two numbers represent numerically equivalent values (e.g., ), then they must be listed in the same order as they were received as input).
 *
 * Complete the code in the unlocked section of the editor below. You must rearrange array 's elements according to the instructions above.
 *
 * Input Format
 *
 * The first line consists of a single integer, , denoting the number of integer strings.
 * Each line  of the  subsequent lines contains a real number denoting the value of .
 *
 * Constraints
 *
 * Each  has at most  digits.
 * Output Format
 *
 * Locked stub code in the editor will print the contents of array  to stdout. You are only responsible for reordering the array's elements.
 *
 * Sample Input
 *
 * 9
 * -100
 * 50
 * 0
 * 56.6
 * 90
 * 0.12
 * .12
 * 02.34
 * 000.000
 * Sample Output
 *
 * 90
 * 56.6
 * 50
 * 02.34
 * 0.12
 * .12
 * 0
 * 000.000
 * -100
 */
public class AY_BigDecimal {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();


        BigDecimal[] bda = new BigDecimal[s.length - 2];
        for(int i = 0; i < s.length - 2; i++) {
            bda[i] = new BigDecimal(s[i]);
        }

        for(int j = 0; j < s.length - 3; j++) {
            for(int k = 0; k < s.length - 3; k++) {

                if(bda[k].compareTo(bda[k + 1]) < 0) {
                    BigDecimal bdTemp = bda[k];
                    bda[k] = bda[k + 1];
                    bda[k + 1] = bdTemp;

                    String strTemp = s[k];
                    s[k] = s[k + 1];
                    s[k + 1] = strTemp;
                }

            }
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}
