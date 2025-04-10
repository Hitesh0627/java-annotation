package com.bridgeLabz.beginnerLevel;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface veryimportant{
    String level() default "High";
}

class Tasks{
    @veryimportant(level="Low")
    public void taskAlpha(){
        System.out.println("doing taskAlpha");
    }
    @veryimportant(level="Medium")
    public void taskDelta(){
        System.out.println("doing taskDelta");
    }
    @veryimportant
    public void taskBeta(){
        System.out.println("doing taskBeta");
    }
}
public class ImportantExample {
    public static void main(String[] args) throws Exception{
        Class<?> cls=Tasks.class;
        Method[] methods=cls.getMethods();

        for(Method method: methods){
            if(method.isAnnotationPresent(veryimportant.class)){
                veryimportant vi=method.getAnnotation(veryimportant.class);
                if(vi.level().equals("High") || vi.level().equals("Medium")){
                    System.out.println(method.getName());
                    method.invoke(cls.getDeclaredConstructor().newInstance());
                    System.out.println(vi.level());
                    System.out.println();
                }
                else{
                    System.out.println(method.getName());
                    System.out.println("Task importance is low");
                    System.out.println();
                }
            }
        }
    }
}
