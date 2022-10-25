package br.com.abdiel.mobile.pageFactory;


import br.com.abdiel.mobile.core.actions.Action;
import br.com.abdiel.mobile.core.actions.Log;
import br.com.abdiel.mobile.core.managers.FileReaderManager;
import br.com.abdiel.mobile.core.models.DadaMass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class PageHome extends PageFactory {
    
    private DadaMass dadaMass;

    public PageHome(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        dadaMass = FileReaderManager.getInstance().getConfigReaderJson().getJson();
    }

    @FindBy(id = "com.Advantage.aShopping:id/imageViewSearch")
    private MobileElement bnt_magnifyingGlass;

    @FindBy(id = "com.Advantage.aShopping:id/editTextSearch")
    private MobileElement insert_search;

    @FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
    private MobileElement bnt_menu;

    @FindBy(id = "com.Advantage.aShopping:id/textViewMenuUse")
    private MobileElement bnt_login;

    public void clickMagnifyingGlass() {
        bnt_magnifyingGlass.click();
    }

    public void insertSearch(String busca) {
        switch (busca.toLowerCase(Locale.ROOT)) {
            case "mice":
                dadaMass.getProductsList().getMice().forEach(x -> {
                    insert_search.sendKeys(x);
                });
                break;
            case "laptops":
                dadaMass.getProductsList().getLaptops().forEach(x -> {
                    insert_search.sendKeys(x);
                });
                break;
            case "tablets":
                dadaMass.getProductsList().getTablets().forEach(x -> {
                    insert_search.sendKeys(x);
                });
                break;
            case "headphones":
                dadaMass.getProductsList().getHeadphones().forEach(x -> {
                    insert_search.sendKeys(x);
                });
                break;
            case "speakers":
                dadaMass.getProductsList().getSpeadkers().forEach(x -> {
                    insert_search.sendKeys(x);
                });
                break;
            case "error":
                dadaMass.getProductsList().getError().forEach(x -> {
                    insert_search.sendKeys(x);
                });
                break;
            default:
                Log.setLog("ERROR", "Produto não cadastrado na lista");
        }
    }

    public void clickMenu() {
        Action.isVisibleElement(bnt_menu, 5);
        bnt_menu.click();
    }

    public void clickLogin() {
        bnt_login.click();
    }

}
