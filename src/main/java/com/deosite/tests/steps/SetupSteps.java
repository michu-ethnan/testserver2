package com.deosite.tests.steps;

import com.deosite.tests.abilities.Load;
import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetupSteps {

    private EnvironmentVariables ev;

    @Before
    public void set_the_stage() {
        String language = EnvironmentSpecificConfiguration.from(ev).getProperty("web.locale");

        ResourceBundle i18n = ResourceBundle.getBundle(
                "com.deosite.tests.i18n.Bundle",
                Locale.forLanguageTag(language)
        );

        OnStage.setTheStage(OnlineCast.whereEveryoneCan(Load.bundle(i18n)));
    }
}
