package BDDApproach.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import BDDApproach.steps.PnPagesSteps;

public class PnSteps {

  @Steps
  PnPagesSteps pnSteps;

  @Given("I am on pn.com.ua")
  public void givenIAmOnHomePage() {
    pnSteps.homepageOnPnComUa();
  }

  @When("I select category $category")
  public void whenISelectCategory(String category) {
    pnSteps.selectCategory(category);
  }

  @When("I select subcategory $category")
  public void whenISelectSubcategory(String category) {
    pnSteps.selectSubCategory(category);
  }

  @When("I select minimum price $price")
  public void whenISelectMinPrice(String price) {
    pnSteps.selectMinPrice(price);
  }

  @When("I select maximum price $price")
  public void whenISelectMaxPrice(String price) {
    pnSteps.selectMaxPrice(price);
  }

  @Then("search result prices is between $min and $max")
  public void thenSearchResultPricesBetween(Integer min, Integer max) {
    pnSteps.verifyResultsPrices(min, max);
  }

  @When("I select producer $producer")
  public void whenISelectProducer(String producer) {
    pnSteps.selectProducer(producer);
  }

  @Then("search result amount is equal to number beside producer")
  public void thenSearchResultAmountEqualToNumberBeside() {
    pnSteps.verifyProductAmount();
  }

  @Then("search result names start with $producer")
  public void thenSearchSesultNamesStartWith(String producer) {
    pnSteps.verifyProductNames(producer);
  }

  @When("I sort products by price")
  public void whenISortProductByPrice() {
    pnSteps.sortByPrice();
  }

  @When("I choose the first product in result")
  public void whenIChooseTheFirstProductInResult() {
    pnSteps.getFirstResult();
  }

  @When("I tap product name to search")
  public void whenItapProductNameToSearch() {
    pnSteps.searchProduct();
  }

  @Then("search result amount equals to $number")
  public void thenSearchAmountEqualNumber(Integer number) {
    pnSteps.verifyProductAmount(number);
  }

  @Then("search result name is equal to product name")
  public void thenResultEqualProductName() {
    pnSteps.verifyFirstProductName();
  }

}
