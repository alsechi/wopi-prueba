package com.banco.wopi.prueba.runners;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import utilidades.BeforeSuite;
import utilidades.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;


@CucumberOptions (features = "src/test/resources/features",
				  glue="com.banco.wopi.prueba",
				  tags= {"@VerDetalle"}, 
				  snippets= SnippetType.CAMELCASE)
@RunWith(RunnerPersonalizado.class)
public class RunnerCucumberData {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
			DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}
 