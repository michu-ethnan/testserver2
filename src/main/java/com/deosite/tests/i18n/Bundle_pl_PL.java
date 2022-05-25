package com.deosite.tests.i18n;

import com.deosite.tests.model.account.NewAddressForm;
import com.deosite.tests.model.login.LoginForm;
import com.deosite.tests.model.login.DifferentLoginForm;
import com.deosite.tests.model.order.Personal;
import com.deosite.tests.model.order.Company;
import com.deosite.tests.model.order.WithoutEmailAddress;
import com.deosite.tests.model.register.RegisterForm;

import java.util.ListResourceBundle;

public class Bundle_pl_PL extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                // Labels
                {"capacity (l) label", "pojemność (l)"},
                {"capacity (ml) label", "pojemność (ml)"},

                // Products
                {"mug", "Kubek"},
                {"configurable product", "kubek palette"},

                // Number of products in the cart
                {"greater", "Twój koszyk (2)"},
                {"smaller", "Twój koszyk (1)"},

                // Categories

                //Headers
                {"account header", "Konto"},

                // Alerts
                {"added to cart", "Produkt został dodany do koszyka"},
                {"address saved", "Adres zapisany"},
                {"address deleted", "Adres usunięty"},

                // Messages
                {"success order message", "Dziękujemy, Twoje zamówienie zostało złożone!"},
                {"additional success info", "Zamówienie jest kompletowane, o wysyłce poinformujemy drogą mailową."},
                {"the cart is empty message", "Nie masz produktów w koszyku."},
                {"login button text", "Logowanie"},
                // Objects
                {"person", new Personal(
                        "test@test.pl",
                        "Test",
                        "Test-Test",
                        "Testowa 1",
                        "Testowo",
                        "11-111",
                        "123456789"

                )},
                {"personFromPortugal", new Personal(
                        "test@test.pl",
                        "Test",
                        "Test-Test",
                        "Test 1",
                        "Test",
                        "00-000",
                        "0000000000"

                )},
                {"personFromIreland", new Personal(
                        "test@test.pl",
                        "Test",
                        "Test-Test",
                        "Test 1",
                        "Test",
                        "00-000",
                        "0000000000"

                )},
                {"company", new Company(
                        "test@test.pl",
                        "Test",
                        "Test-Test",
                        "Testowa 1",
                        "Testowo",
                        "11-111",
                        "123456789",
                        "Testowa sp. z o.o",
                        "1234567891"

                )},
                {"withoutEmailAddress", new WithoutEmailAddress(
                        "Test",
                        "Test-Test",
                        "Test 1",
                        "Test",
                        "00-000",
                        "0000000000"
                )},
                {"login", new LoginForm(
                        "tester-email-tester@yandex.com",
                        "Test12345!"
                )},
                {"login to order_1", new LoginForm(
                        "abisimeon22@yandex.com",
                        "Test12345!"
                )},
                {"login to order_2", new LoginForm(
                        "abisimeon222@yandex.com",
                        "Test12345!"
                )},
                {"login to order_3", new LoginForm(
                        "abisimeon223@yandex.com",
                        "Test12345!"
                )},
                {"login and submit order", new LoginForm(
                        "abisimeon2234@yandex.com",
                        "Test12345!"
                )},
                {"differentEmail", new DifferentLoginForm(
                        "tester-tester-terster@yandex.com",
                        "Test12345!"
                )
                },
                {"newAddress", new NewAddressForm(
                        "Salomea",
                        "Kowalska",
                        "Testowa 1",
                        "Testowo",
                        "00-000",
                        "0000000000"
                )},
                {"register", new RegisterForm(
                        "Test12345!",
                        "Test",
                        "Test-Test"
                )}
        };
    }
}
