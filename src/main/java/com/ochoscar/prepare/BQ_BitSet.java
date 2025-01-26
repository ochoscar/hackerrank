package com.ochoscar.prepare;

import java.io.*;
import java.util.*;

public class BQ_BitSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String integers = sc.nextLine();
        String[] integersArray = integers.split(" ");
        Integer N = Integer.parseInt(integersArray[0]);
        Integer M = Integer.parseInt(integersArray[1]);

        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        Integer i = 0;
        while(i < M) {
            String nextOp = sc.nextLine();
            String[] nextOpValues = nextOp.split(" ");
            String op = nextOpValues[0];
            Integer p1 = Integer.parseInt(nextOpValues[1]);
            Integer p2 = Integer.parseInt(nextOpValues[2]);

            if(op.equalsIgnoreCase("AND")) {
                if(p1 == 1) {
                    B1.and(B2);
                } else {
                    B2.and(B1);
                }
            } else if(op.equalsIgnoreCase("OR")) {
                if(p1 == 1) {
                    B1.or(B2);
                } else {
                    B2.or(B1);
                }
            } else if(op.equalsIgnoreCase("XOR")) {
                if(p1 == 1) {
                    B1.xor(B2);
                } else {
                    B2.xor(B1);
                }
            } else if(op.equalsIgnoreCase("FLIP")) {
                if(p1 == 1) {
                    B1.flip(p2);
                } else {
                    B2.flip(p2);
                }
            } else if(op.equalsIgnoreCase("SET")) {
                if(p1 == 1) {
                    B1.set(p2);
                } else {
                    B2.set(p2);
                }
            }
            System.out.println(B1.cardinality() + " " + B2.cardinality());
            i++;
        }

        sc.close();
    }
}