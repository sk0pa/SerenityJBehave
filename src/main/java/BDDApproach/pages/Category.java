package BDDApproach.pages;

import net.serenitybdd.core.pages.PageObject;

import static org.openqa.selenium.By.linkText;

public class Category extends PageObject {

    public void goToSubCategory(String category) {
        find(linkText(category)).click();
    }

}
