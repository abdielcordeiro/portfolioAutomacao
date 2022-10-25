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
        glue = "br.com.abdiel.mobile.StepDefinitions",
        plugin = {"pretty","html:target/relatorioMobile/relatorio_teste","json:target/relatorioMobile/relatorio_teste.json", "junit:target/relatorioMobile/relatorio_teste.xml"},
        monochrome = true,
        publish = true,
        dryRun = false,
        tags = "@buscarProduto"
)

public class TestRunner {}
