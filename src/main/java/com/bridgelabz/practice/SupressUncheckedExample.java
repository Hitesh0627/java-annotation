package com.bridgeLabz.practice;
import java.util.*;
public class SupressUncheckedExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("Java");
        list.add(100);
        list.add(false);


        for (Object item : list) {
            System.out.println(item);
        }
    }
}
