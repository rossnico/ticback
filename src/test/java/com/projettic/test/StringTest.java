package com.projettic.test;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class StringTest {
    public static void main(String[] args) {
        String string = "Select *               FROM EMP          ";
        string = string.replace(";","");
        String test = string.replaceAll("\\s{1,}", " ");
        test = test.toLowerCase();
        System.out.println(test);
    }
}
