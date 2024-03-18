package java.com;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UiTest {

    @Test
    void openTmSandbox() {
        open("https://www.tmsandbox.co.nz/");
    }

    @Test
    void search() {
        SelenideElement search = $(By.id("searchString"));
        search.click();
        search.sendKeys("Shoes");
        search.pressEnter();
    }

    @Test
    void numberOfResults() {
        SelenideElement numberOfResults = $(By.id("totalCount"));
        numberOfResults.shouldHave(text("40"));
    }

    @Test
    void selectFirstListing() {
        SelenideElement firstListing = $(By.id("iswatched2149604915"));
        firstListing.pressEnter();
    }

    @Test
    void validateListingDetails() {
        SelenideElement price = $(By.xpath("//a[@class=\"tm-by-now-box__price p-h1\"]"));
        price.shouldHave(text("$50.00"));

        SelenideElement condition = $(By.xpath("//a[@class=\"o-rack-item__secondary\"]"));
        condition.shouldHave(text("New"));

        SelenideElement description = $(By.xpath("//a[@class=\"tm-markdown\"]"));
        description.shouldHave(text("Nike Shoes red Nike Shoes red Nike Shoes red"));

    }
}
