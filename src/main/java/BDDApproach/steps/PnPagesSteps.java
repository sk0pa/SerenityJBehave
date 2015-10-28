package BDDApproach.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import BDDApproach.pages.Category;
import BDDApproach.pages.Home;
import BDDApproach.pages.SearchResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Anhelina_Khalii on 28.10.2015.
 */
public class PnPagesSteps extends ScenarioSteps {

  private static int productAmount;
  private static String productName;

  private Category categoryPage;
  private Home home;
  private SearchResult searchResult;

  @Step
  public void homepageOnPnComUa() {
    home.open();
  }

  @Step
  public void selectCategory(String category) {
    home.goToCategory(category);
  }

  @Step
  public void selectSubCategory(String category) {
    categoryPage.goToSubCategory(category);
  }

  @Step
  public void selectMinPrice(String price) {
    searchResult.selectMinimumPrice(price);
  }

  @Step
  public void selectMaxPrice(String price) {
    searchResult.selectMaximumPrice(price);
  }

  @Step
  public void verifyResultsPrices(Integer min, Integer max){
    List<Integer> prices = searchResult.resultsPrices();

    assertThat(prices, everyItem(greaterThan(min)));
    assertThat(prices, everyItem(lessThan(max)));
  }

  @Step
  public void selectProducer(String producer){
    productAmount = searchResult.selectProducer(producer);
  }

  @Step
  public void verifyProductAmount(){
    assertThat(searchResult.getResultNumber(), equalTo(productAmount));
  }

  @Step
  public void verifyProductNames(String producer){
    assertThat(searchResult.getProducersFromNames(), everyItem(equalTo(producer)));
  }

  @Step
  public void sortByPrice(){
    searchResult.sortByPrice();
  }

  @Step
  public void getFirstResult(){
    productName = searchResult.getFirstResultName();
  }

  @Step
  public void searchProduct(){
    home.search(productName);
  }

  @Step
  public void verifyProductAmount(Integer number){
    assertThat(searchResult.getResultNumber(), equalTo(number));
  }

  @Step
  public void verifyFirstProductName(){
    assertThat(searchResult.getFirstResultName(), equalTo(productName));
  }

}
