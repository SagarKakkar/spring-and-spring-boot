package com.oreilly.demo.entities;

import java.util.Objects;

public class Greeting {

    private String message;

    public String getMessage() {
        return message;
    }

    public Greeting() {} // This constructor will be used by the JSON parser to convert a JSON response into an instance of Greeting.

    public Greeting(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Greeting)) return false;
        Greeting gr = (Greeting) o;
        return Objects.equals(message, gr.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return message;
    }
}
