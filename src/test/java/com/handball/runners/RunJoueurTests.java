package com.handball.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // dossier où se trouvent tes fichiers .feature

// 🔧 On indique à Cucumber où trouver les Steps et les Hooks
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.handball.stepDefinitions, com.handball.hooks"
)

// 🔧 Plugins pour les rapports HTML et JSON
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/reports/JoueurTests.html, json:target/reports/JoueurTests.json"
)

// 🔧 Format camelCase pour les snippets
@ConfigurationParameter(
        key = SNIPPET_TYPE_PROPERTY_NAME,
        value = "camelcase"
)

// 🔧 Exécute uniquement les scénarios tagués @Joueur
@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@Joueur"
)

public class RunJoueurTests {
}

