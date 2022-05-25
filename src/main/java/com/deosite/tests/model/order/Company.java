package com.deosite.tests.model.order;

public class Company extends Basic implements Order {

    private final String companyName;
    private final String nip;

    public Company(
            String email,
            String name,
            String surname,
            String street,
            String city,
            String postCode,
            String number,
            String companyName,
            String nip
    ) {
        super(email, name, surname, street, city, postCode, number);
        this.companyName = companyName;
        this.nip = nip;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getNip() {
        return nip;
    }
}
