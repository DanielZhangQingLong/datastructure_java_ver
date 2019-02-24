package com.daniel.datastructures.hash;

public class Main1 {

    public static void main(String[] args) {
        int a = 34;
        System.out.println(((Integer)(a)).hashCode());
        int b = -34;
        System.out.println(((Integer)(b)).hashCode());
        double c = 3.4434232342;
        System.out.println(((Double)(c)).hashCode());
        String d = "daniel";
        System.out.println(d.hashCode());


    }
}
