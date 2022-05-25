package com.deosite.tests.model.register;

public class RegisterForm implements Register {

    private final String password;
    private final String name;
    private final String lastName;

    public RegisterForm(
            String password,
            String name,
            String lastName
    ){
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
