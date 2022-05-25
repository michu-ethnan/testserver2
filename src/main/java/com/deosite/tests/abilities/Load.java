package com.deosite.tests.abilities;

import com.deosite.tests.model.account.NewAddress;
import com.deosite.tests.model.account.NewAddressForm;
import com.deosite.tests.model.login.LogIn;
import com.deosite.tests.model.login.LoginForm;
import com.deosite.tests.model.login.DifferentLoginForm;
import com.deosite.tests.model.order.OrderWithoutEmailAddress;
import com.deosite.tests.model.order.Order;
import com.deosite.tests.model.order.Company;
import com.deosite.tests.model.order.Personal;
import com.deosite.tests.model.order.Basic;
import com.deosite.tests.model.register.Register;
import com.deosite.tests.model.register.RegisterForm;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.util.ResourceBundle;


public class Load implements Ability {

    private final ResourceBundle rb;

    private Load(ResourceBundle rb) {
        this.rb = rb;
    }

    public static Load bundle(ResourceBundle rb) {
        return new Load(rb);
    }

    public static Load as(Actor actor) {
        return actor.abilityTo(Load.class);
    }

    public String translate(String key) {
        return rb.getString(key);
    }

    public LogIn logIn(String key) {
        return (LoginForm) rb.getObject(key);

    }

    public DifferentLoginForm loginWithDifferentEmailAddress(String key) {
        return (DifferentLoginForm) rb.getObject(key);
    }

    public OrderWithoutEmailAddress orderWithoutEmailAddress(String key) {
        return (OrderWithoutEmailAddress) rb.getObject(key);
    }

    public Register register(String key) {
        return (RegisterForm) rb.getObject(key);
    }

    public NewAddress newAddress(String key) {
        return (NewAddressForm) rb.getObject(key);
    }

    public Order order(String key) {
        switch (key) {
            case "person":
                return (Personal) rb.getObject(key);
            case "company":
                return (Company) rb.getObject(key);
        }
        return (Basic) rb.getObject(key);
    }
}
