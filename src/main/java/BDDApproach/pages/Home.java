package BDDApproach.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;

@DefaultUrl("http://pn.com.ua")
public class Home extends PageObject {

    public void search(String product) {
        find(id("edit-name-1")).sendKeys(product);
        find(id("edit-submit-1")).click();
    }

    public void goToCategory(String category) {
        find(linkText(category)).click();
    }
}
