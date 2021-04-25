package com.data;
/**
 * @author smikayilov
 */
public class Person {
private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
private String password;

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", password=" + password + ", email=" + email + '}';
    }
private String email;
}
