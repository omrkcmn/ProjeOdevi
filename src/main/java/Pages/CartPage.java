package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    By productnameLocator = By.id("a.a-link-normal span.a-size-medium");
    By deleteButton1 = new By.ByCssSelector("i.fa.fa-trash-o");
    By incraseQuantity = new By.ByCssSelector("a.oq-up");
    By deleteButton2 =  new By.ByCssSelector("a.sc-delete");
    By getItemQuantity = By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/input");
    By getCartInfo = new By.ByCssSelector("a.homepage-link");

    public String itemQuantity = null;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getProducts(){
        return findAll(productnameLocator);
    }

    public void deleteItem(){
        click(deleteButton1);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        click(deleteButton2);
    }

    public String getQuantity(){
        return find(getItemQuantity).getText();
    }

    public String isCartNull(){
        return find(getCartInfo).toString();
    }

    public void increaseQuantity(int quantity) {
        click(incraseQuantity,quantity);
    }

}
