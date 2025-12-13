package com.handball.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/admin", // tes features admin
        glue = "com.handball.stepDefinitions.admin",
        dryRun = true,      // ⚠ NE LANCE PAS LE NAVIGATEUR – génère juste les steps manquants
        monochrome = true,
        plugin = {"pretty"},
        tags ="@actions"    // 🔥 ici tu changes selon A/B/C
)
public class RunGenerateSteps {
}
