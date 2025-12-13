package com.handball.runners.admin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/admin",
        glue = {
                "com.handball.stepDefinitions.admin",
                "com.handball.helper"
        },
        tags="@actions"
        ,



plugin = {
                "pretty",
                "html:target/cucumber-reports/admin-report.html",
                "json:target/cucumber-reports/admin-report.json"
        },
        monochrome = true
)
public class RunAdminTest {
}
