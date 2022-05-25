package com.deosite.tests.model.account;

public class NewAddressForm implements NewAddress {

    private final String name;
    private final String lastName;
    private final String street;
    private final String city;
    private final String postalCode;
    private final String phone;

    public NewAddressForm(
            String name,
            String lastName,
            String street,
            String city,
            String postalCode,
            String phone
    ) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }
}
