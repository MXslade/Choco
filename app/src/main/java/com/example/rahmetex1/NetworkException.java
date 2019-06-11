package com.example.rahmetex1;

public class NetworkException extends Exception {
    int id;

    public NetworkException(int id) {
        this.id = id;
    }

    public String toString() {
        return "Network Exception";
    }
}
