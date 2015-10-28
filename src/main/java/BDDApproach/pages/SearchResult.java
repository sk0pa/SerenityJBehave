package BDDApproach.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.openqa.selenium.By.xpath;

public class SearchResult extends PageObject {


    public void selectMinimumPrice(String price){
        find(xpath("//a[contains(@href,'fp1="+price+"')]")).click();
    }

    public void selectMaximumPrice(String price){
        find(xpath("//a[contains(@href,'fp2="+price+"')]")).click();
    }

    public int selectProducer(String producer){
        String amount = find(By.xpath("//a[text()='" + producer + "']/following-sibling::i[1]")).getText();
        amount = amount.replaceAll("[()]", "").replace(" ","");
        int productNumber = Integer.valueOf(amount);
        find(xpath("//a[contains(@href, '?fo') and text()='"+producer+"']")).click();
        return productNumber;
    }

    public List<Integer> resultsPrices(){
      List<WebElementFacade> pricesElements = findAll(xpath("//div[@class='price']/strong"));
        List<Integer> prices = new ArrayList<Integer>();
        for(WebElementFacade element: pricesElements){
            String stPrice = element.getText().replace(" ", "").replace("грн", "");
            prices.add(Integer.valueOf(stPrice));
        }
        return prices;
    }

    public int getResultNumber(){
        return Integer.valueOf(find(xpath("//div[@class='total']/b")).getText());
    }

    public List<String> getResultsNames(){
        List<WebElementFacade> elements = findAll(xpath("//div[@class='name']/a"));
        List<String> elementsNames = new ArrayList<String>();
        for(WebElementFacade element: elements){
            elementsNames.add(element.getText());
        }
        return elementsNames;
    }

    public List<String> getProducersFromNames(){
        List<String> names = getResultsNames();
        List<String> results = new ArrayList<String>();
        for(String name: names){
            results.add(name.split("\\s+")[0]);
        }
        return results;
    }

    public void sortByPrice(){
        find(xpath("//a[contains(@href,'sort=price')]")).click();
    }

    public String getFirstResultName(){
        return find(xpath("//div[@class='name']/a")).getText();
    }
}
