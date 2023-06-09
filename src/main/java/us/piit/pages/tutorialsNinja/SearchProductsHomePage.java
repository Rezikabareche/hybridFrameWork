package us.piit.pages.tutorialsNinja;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import us.piit.base.CommonAPI;

import java.util.List;

public class SearchProductsHomePage  extends CommonAPI {


    Logger log = LogManager.getLogger(SearchProductsHomePage.class.getName());
    public SearchProductsHomePage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#content h1")
    WebElement searchResultsTitle;
    @FindBy(css = ".product-layout .product-thumb")
    List<WebElement> productItems;

    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement dropDownElement;
    @FindBy(xpath = "//select[@id='input-limit']")
    public WebElement displayCountDropdown;
    @FindBy(css = ".product-layout .product-thumb h4 a")
    List<WebElement> productTitles;


    public boolean isSearchResultsPageDisplayed() {

        return searchResultsTitle.isDisplayed();
    }

    public boolean areSearchResultsDisplayed() {
        boolean searchResultsDisplayed = productItems.size() > 0;
        log.info("the user is able to see the search results ");
        log.info("the search displays many products");

        return searchResultsDisplayed;
    }


    public void sortProductsByPriceDescending() {
        clickOn(dropDownElement);
        Select select = new Select(dropDownElement);
        select.selectByVisibleText("Price (High > Low)");
    }



    public void clickOnDisplayCountDropdown() {

        clickOn(displayCountDropdown);
    }

    public int getDisplayedProductCount() {

        return productTitles.size();
    }



}


