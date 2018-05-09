package com.yusuf.spring.exception;

public class AdvertException extends Exception {
public AdvertException(String message) {
super(message);
}
public AdvertException(String message, Throwable cause) {
super(message,cause);
}
}