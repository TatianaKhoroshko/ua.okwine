package ua.okwine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
   @BeforeEach
   void openPage(){
       open("https://okwine.ua/");
   }

    @Test
    void searchProductAndAddToTheBin(){
       var productName = "Карамель з маракуйєю, Spell, 220г";
        $(byXpath("//*[@id='__next']/footer/div[1]/div/div[1]/a[1]/button")).click();
        $(byXpath("//*[@id='__next']/header/div/div/div[2]/div[1]")).click();
        $("[type='text']").val(productName).pressEnter();
        $(byXpath("//*[@id='__next']/div[3]/div/div/div/div/a[2]")).shouldHave(text(productName));
        $(byXpath("//*[@id='__next']/div[3]/div/div")).hover();
        $(byXpath("//*[@id='__next']/div[3]/div/div/div/div/div[3]/div/button")).click();
        $("[href='/ua/cart']").click();
        $$(byXpath("//*[@id='__next']/div[3]/div/div[1]/div[2]/ul")).shouldHave(size(1));
        $(byXpath("//*[@id='__next']//ul//li//a")).shouldHave(text(productName));
    }
}
