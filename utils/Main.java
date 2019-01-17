package com.daniel.datastructures.utils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/test", words1);
        System.out.println(words1.size());
    }
}
