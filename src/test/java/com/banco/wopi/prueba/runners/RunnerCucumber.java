/**
 * @since 27/11/2017
 */
package com.banco.wopi.prueba.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

//@CucumberOptions(features = "src/test/resources/features",tags = {"@Todos"},snippets = SnippetType.CAMELCASE,glue = "com.pyxis.trello.prueba",plugin = {"json:target/cucumber.json"})
@CucumberOptions(features = "src/test/resources/features",tags = {"@TransacionQr"},snippets = SnippetType.CAMELCASE,glue = "com.banco.wopi.prueba",plugin = {"json:target/cucumber.json"})

@RunWith(CucumberWithSerenity.class)
public class RunnerCucumber {
}