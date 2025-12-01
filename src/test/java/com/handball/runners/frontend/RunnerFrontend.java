package com.handball.runners.frontend;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",   // ✔️ lire tout le projet
        glue = {
                "com.handball.stepDefinitions",      // ✔️ lit toutes les steps
                "com.handball.hooks"
        },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber-frontend.json",
                "html:target/cucumber-reports/frontend-report.html"
        },
        monochrome = true,
        dryRun = false,

        tags = "@entraineur_email_existant"
        // ✔️ exécute uniquement ta feature
)
public class RunnerFrontend {

}
