package com.ochoscar.prepare;

/*
JAVA reflection is a very powerful tool to inspect the attributes of a class in runtime. For example, we can retrieve the list of public fields of a class using getDeclaredMethods().

In this problem, you will be given a class Solution in the editor. You have to fill in the incompleted lines so that it prints all the methods of another class called Student in alphabetical order. We will append your code with the Student class before running it. The Student class looks like this:

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }
    ......
    ......
    some more methods
    ......
}
You have to print all the methods of the student class in alphabetical order like this:

anothermethod
getName
setEmail
setId
......
......
some more methods
......
There is no sample input/output for this problem. If you press "Run Code", it will compile it, but it won't show any outputs.

Hint: See the oracle docs for more details about JAVA Reflection Methods and Fields
 */

import java.lang.reflect.*;
import java.util.*;

class StudentReflection{
    private String name;
    private String id;
    private String email;


    public void ahqym              () {}
    public void amftc              () {}
    public void anotherfunction    () {}
    public void atcks              () {}
    public void bwkbd              () {}
    public void cfwyc              () {}
    public void cmkxa              () {}
    public void dnpym              () {}
    public void dnqvo              () {}
    public void dvvwq              () {}
    public void ehjdm              () {}
    public void elyed              () {}
    public void fmyce              () {}
    public void getEmail           () {}
    public void getId              () {}
    public void getName            () {}
    public void ghtlj              () {}
    public void hluvb              () {}
    public void isqdf              () {}
    public void iwhtf              () {}
    public void jmopy              () {}
    public void jnskt              () {}
    public void kbjlt              () {}
    public void kgwku              () {}
    public void khuag              () {}
    public void levtp              () {}
    public void mcgme              () {}
    public void migyc              () {}
    public void moebl              () {}
    public void nixhb              () {}
    public void odyqp              () {}
    public void ogvdl              () {}
    public void ormim              () {}
    public void piwro              () {}
    public void plaob              () {}
    public void pnruo              () {}
    public void pqfct              () {}
    public void ptrup              () {}
    public void pvgyp              () {}
    public void qthde              () {}
    public void rmjig              () {}
    public void setEmail           () {}
    public void setId              () {}
    public void setName            () {}
    public void sumvl              () {}
    public void tkbpp              () {}
    public void tntpj              () {}
    public void toxdp              () {}
    public void twyfa              () {}
    public void uccfq              () {}
    public void ujxei              () {}
    public void vhxoi              () {}
    public void viwuu              () {}
    public void viyog              () {}
    public void whjtj              () {}
    public void ytijy              () {}



}

class CD_Relection {

    public static void main(String[] args){
        Class student = new StudentReflection().getClass();
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}


/*



 */




