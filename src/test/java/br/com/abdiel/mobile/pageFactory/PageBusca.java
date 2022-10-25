package br.com.abdiel.mobile.pageFactory;


import br.com.abdiel.mobile.core.actions.Action;
import br.com.abdiel.mobile.core.actions.Log;
import br.com.abdiel.mobile.core.managers.FileReaderManager;
import br.com.abdiel.mobile.core.models.DadaMass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class PageBusca extends PageFactory {

    private AppiumDriver<MobileElement> driver;
    private DadaMass dadaMass;

    public PageBusca(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        dadaMass = FileReaderManager.getInstance().getConfigReaderJson().getJson();
    }

    @FindBy(id = "com.Advantage.aShopping:id/imageViewProduct")
    private MobileElement selectProduct;

    @FindBy(id = "com.Advantage.aShopping:id/textViewProductName")
    private MobileElement nomeProduto;
    @FindBy(id = "com.Advantage.aShopping:id/textViewNoProductsToShow")
    private MobileElement productListName;

    @FindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"Laptops\"]/android.widget.LinearLayout/android.widget.LinearLayout")
    private MobileElement bnt_filtro;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout")
    private MobileElement bnt_funcionalidade;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout")
    private MobileElement bnt_dfuncionalidade;


    @FindBy(id = "com.Advantage.aShopping:id/textViewNoProductsToShow")
    private MobileElement txt_noFound;


    public void selectProduct() {
        selectProduct.click();
    }


    public String returnProductName(String nome) {
        Action.isVisibleElement(nomeProduto, 5);
        return nomeProduto.getText();
    }

    public String errorMessage() {
        return productListName.getText();
    }

    public void selectType(String tipo) {
        MobileElement el2 =
                driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + tipo + "')]");

        Action.isVisibleElement(el2, 5);
        el2.click();
    }

    public boolean searchProduct(String produto) {
        AtomicBoolean test = new AtomicBoolean(false);
        switch (produto.toLowerCase(Locale.ROOT)) {
            case "mice":
                dadaMass.getProductsList().getMice().forEach(x -> {
                    MobileElement el1 = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + x + "')]");
                    if (Action.isVisibleElement(el1, 5)) {
                        test.set(true);
                        el1.click();
                    }
                });
                break;
            case "laptops":
                dadaMass.getProductsList().getLaptops().forEach(x -> {
                    MobileElement el1 = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + x + "')]");
                    if (Action.isVisibleElement(el1, 5)) {
                        test.set(true);
                        el1.click();
                    }
                });
                break;
            case "tablets":
                dadaMass.getProductsList().getTablets().forEach(x -> {
                    MobileElement el1 = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + x + "')]");
                    if (Action.isVisibleElement(el1, 5)) {
                        test.set(true);
                        el1.click();
                    }
                });
                break;
            case "headphones":
                dadaMass.getProductsList().getHeadphones().forEach(x -> {
                    MobileElement el1 = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + x + "')]");
                    if (Action.isVisibleElement(el1, 5)) {
                        test.set(true);
                        el1.click();
                    }
                });
                break;
            case "speakers":
                dadaMass.getProductsList().getSpeadkers().forEach(x -> {
                    MobileElement el1 = driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '" + x + "')]");
                    if (Action.isVisibleElement(el1, 5)) {
                        test.set(true);
                        el1.click();
                    }
                });
                break;
            default:
                Log.setLog("ERROR", "Produto não cadastrado na lista");
        }
        return test.get();
    }

    public void clickFilterButton() {
        bnt_filtro.click();
    }

    public void buttonFunction() {
        bnt_funcionalidade.click();
        bnt_dfuncionalidade.click();
        bnt_funcionalidade.click();
    }

    public boolean validSearch(String produto) {
        switch (produto.toLowerCase(Locale.ROOT)) {
            case "mice":
                for (String m : dadaMass.getProductsList().getMice()) {
                    if (produto.equals(m))
                        return true;
                }
                break;
            case "laptops":
                for (String l : dadaMass.getProductsList().getLaptops()) {
                    if (produto.equals(l))
                        return true;
                }
                break;
            case "tablets":
                for (String t : dadaMass.getProductsList().getTablets()) {
                    if (produto.equals(t))
                        return true;
                }
                break;
            case "headphones":
                for (String h : dadaMass.getProductsList().getHeadphones()) {
                    if (produto.equals(h))
                        return true;
                }
                break;
            case "speakers":
                for (String s : dadaMass.getProductsList().getSpeadkers()) {
                    if (produto.equals(s))
                        return true;
                }
                break;
            default:
                Log.setLog("ERROR", "Produto divergente do apresentado em tela");
        }
        return false;
    }

    public boolean productNotFound() {
        for (String e : dadaMass.getProductsList().getError()) {
            if (txt_noFound.getText().equals("- No results for \"" + e + "\" -"))
                return true;
        }
        return false;
    }

    private WebElement bntResolucao() {
        WebElement el1 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout");
        return el1;
    }

    private WebElement escolheResolucao() {
        WebElement el2 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout");
        return el2;
    }

    public void botaoResolucao() {
        bntResolucao().click();
        escolheResolucao().click();
        bntResolucao().click();
    }

    private WebElement bntMemoria() {
        WebElement el1 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout");
        return el1;
    }

    private WebElement escolhaMemoria() {
        WebElement el2 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[7]/android.widget.LinearLayout");
        return el2;
    }

    public void botaoMemoria() {
        bntMemoria().click();
        escolhaMemoria().click();
        bntMemoria().click();
    }

    private WebElement bntAplicar() {
        WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/textViewApply");
        return el1;
    }

    public void botaoAplicar() {
        bntAplicar().click();
    }

    private WebElement validaMensagemErroClique() {
        WebElement el1 = driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
        return el1;
    }

    public String mensagemProdutoClique() {
        return validaMensagemErroClique().getText();
    }

}