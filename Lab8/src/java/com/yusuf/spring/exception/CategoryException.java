package com.yusuf.spring.exception;

public class CategoryException extends Exception {
public CategoryException(String message) {
super(message);
}
public CategoryException(String message, Throwable cause) {
super(message,cause);
}
}