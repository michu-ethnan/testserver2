package com.deosite.tests.model.login;

public class DifferentLoginForm implements LogIn {

    private final String email;
    private final String password;

    public DifferentLoginForm(
            String email,
            String password
    ) {
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
