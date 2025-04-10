package com.bridgeLabz.beginnerLevel;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.METHOD)
 @interface Todo{
     String task();
     String assigned();
     String priority() default "MEDIUM";
 }
 class Features{
     @Todo(task = "Buy Groceries", assigned = "Harman",priority = "HIGH")
     public void buyGroceries(){
         System.out.println("Buying groceries");
     }
     @Todo(task = "Refuling Car",assigned = "Harshdeep")
     public void refulingCar(){
         System.out.println("Refuling Car");
     }
     @Todo(task = "Going for a Walk",assigned = "Jyoti",priority = "LOW")
     public void Walk(){
         System.out.println("Going for a walk");
     }
 }
public class TodoAnnotation {
    public static void main(String[] args) {
        Class<Features> reflectionClass = Features.class;
        for(Method method : reflectionClass.getDeclaredMethods()){
            if(method.isAnnotationPresent(Todo.class)){
                Todo task1 = method.getAnnotation(Todo.class);
                System.out.println(method.getName());
                System.out.println(task1.task());
                System.out.println(task1.assigned());
                System.out.println(task1.priority());
                System.out.println();
            }
        }
    }
}
