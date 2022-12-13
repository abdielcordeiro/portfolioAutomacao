package br.com.abdiel.mobile.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Configurações do Cucumber
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:FeatureMobile",
        glue = "src/test/java/br/com/abdiel/mobile/stepDefinitions",
        plugin = {"pretty","html:target/relatorioMobile/relatorio_teste","json:target/relatorioMobile/relatorio_teste.json", "junit:target/relatorioMobile/relatorio_teste.xml"},
        monochrome = true,
        publish = true,
        dryRun = false,
        tags = "@buscarProduto"
)

public class TestRunner {}
