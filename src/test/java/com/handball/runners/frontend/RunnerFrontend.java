package com.handball.runners.frontend;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/frontend",
        glue = {
                "com.handball.stepDefinitions.frontend",
                "com.handball.hooks"
        },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber-frontend.json",
                "html:target/cucumber-reports/frontend-report.html"
        },
        monochrome = true,
        dryRun = false,

        // 🎯 IMPORTANT : Exécuter seulement navigation_login.feature
        tags ="@navigationLogin"


        )
public class RunnerFrontend {

}

