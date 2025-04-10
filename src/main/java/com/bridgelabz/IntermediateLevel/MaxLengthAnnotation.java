package com.bridgeLabz.IntermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}

class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                field.setAccessible(true);
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                try {
                    String value = (String) field.get(this);
                    if (value != null && value.length() > maxLength.value()) {
                        throw new IllegalArgumentException("Field '" + field.getName() + "' exceeds max length of " + maxLength.value());
                    }
                } catch (IllegalAccessException e) {
                    e.getMessage();
                }
            }
        }
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User u1 = new User("Harman");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
