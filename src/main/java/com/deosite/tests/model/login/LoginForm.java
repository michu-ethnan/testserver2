package com.deosite.tests.model.login;

public class LoginForm implements LogIn {

    private final String email;
    private final String password;

    public LoginForm(
            String email,
            String password
    ){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
