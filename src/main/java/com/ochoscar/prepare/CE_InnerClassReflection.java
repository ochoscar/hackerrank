package com.ochoscar.prepare;

/*
You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer  as input. The powerof2 in class Inner.Private checks whether a number is a power of . You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.

Constraints

Sample Input

8
Sample Output

8 is power of 2
An instance of class: Solution.Inner.Private has been created
 */

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;

public class CE_InnerClassReflection {

    public static void main(String[] args) throws Exception {
        //DoNotTerminate.forbidExit();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

            //Write your code here
            Class<?> innerClass = Inner.class.getDeclaredClasses()[0];


            Constructor<?> constructor = innerClass.getDeclaredConstructor(Inner.class);
            constructor.setAccessible(true);


            o = constructor.newInstance(new Inner());

            Method powerOf2Method = innerClass.getDeclaredMethod("powerof2", int.class);
            powerOf2Method.setAccessible(true);


            String result = (String) powerOf2Method.invoke(o, num);
            System.out.print(num + " is ");
            System.out.println(result);


            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    /*public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }*/
}
