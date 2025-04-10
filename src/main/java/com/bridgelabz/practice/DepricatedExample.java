package com.bridgeLabz.practice;

class LegacyAPI{
    @Deprecated
    public void oldfeature(){
        System.out.println("old method");
    }
    public void newfeature(){
        System.out.println("new method");
    }
}
public class DepricatedExample {
    public static void main(String[] args) {
        LegacyAPI obj1=new LegacyAPI();
        obj1.oldfeature();
    }
}
