package com.bridgeLabz.IntermediateLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{

}
class taskData{
    @LogExecutionTime
    public void shortTask(){
        System.out.println("This is Short Task");
    }
    @LogExecutionTime
    public void longTask() throws Exception{
        Thread.sleep(3000);
        System.out.println("This is a long Task");
    }
}
public class LoggingAnnotation {
    public static void main(String[] args) throws Exception {
        taskData task1 = new taskData();
        Class<taskData> reflectionClass = taskData.class;
        for(Method method : reflectionClass.getDeclaredMethods()){
            if(method.isAnnotationPresent(LogExecutionTime.class)){
                long StartTime = System.nanoTime();
                method.invoke(task1);
                long EndTime = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " +(EndTime - StartTime) / 1000000 + " ms\n");
            }
        }
    }
}
