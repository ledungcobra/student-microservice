package com.example.gateway;

public class ObjectUtil {
    public static <T> T getOrDefault(T value, T defaultValue) {
        return value == null || "null".equals(value) ? defaultValue : value;
    }
}
