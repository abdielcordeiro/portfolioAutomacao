package br.com.abdiel.mobile.stepDefinitions;

import br.com.abdiel.mobile.core.cucumberTest.TestContext;
import br.com.abdiel.mobile.core.managers.Enum.DeviceType;
import br.com.abdiel.mobile.pageFactory.PageBusca;
import br.com.abdiel.mobile.pageFactory.PageHome;
import io.cucumber.java.pt.*;

import static org.testng.AssertJUnit.assertTrue;


public class BuscaLupaStep {

    private PageBusca busca;
    private PageHome home;
    private TestContext testContext;

    public BuscaLupaStep(TestContext context) {
        testContext = context;
        busca = new PageBusca(testContext.getDriverManager().createDriver(DeviceType.EMULADOR_ANDROID));
        home = new PageHome(testContext.getDriverManager().createDriver(DeviceType.EMULADOR_ANDROID));
    }

    @Dado("^que o usuario esteja na tela principal$")
    public void que_o_usuario_esteja_na_tela_principal() {
    }

    @Quando("^clica no botao da lupa$")
    public void clica_no_botao_da_lupa() {
        home.clickMagnifyingGlass();
    }

    @E("^digita nome do produto \"([^\"]*)\"$")
    public void digita_nome_do_produto(String produto) {
        home.insertSearch(produto);
    }

    @Quando("^clica na lupa para buscar$")
    public void clica_na_lupa_para_buscar() {
        home.clickMagnifyingGlass();
    }

    @Entao("^busca realizada com sucesso pelo produto \"([^\"]*)\" encontrado$")
    public void busca_realizada_com_sucesso_pelo_produto_encontrado(String produto) {
        assertTrue("Produto encontrado com sucesso", busca.validSearch(produto));
    }

    @Entao("^valida mensagem de produto não encontrado$")
    public void valida_mensagem_de_produto_não_encontrado() {
        assertTrue("Produto não encontrado", busca.productNotFound());
    }

}
