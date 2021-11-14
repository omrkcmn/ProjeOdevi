package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ProductDetailPage extends BasePage {

    public static String price=null;
    public static String cartPrice=null;

    private By _addToCart = new By.ByCssSelector("a#pd_add_to_cart.add-to-cart.button-link.add-to-cart-button");
    protected By cartButton = new By.ByCssSelector("i.header-bag-icon.bndl-shopping-bag.bndl-shopping-bag-dims");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnProductDetailPage(){
        return isDisplayed(_addToCart);
    }

    public void selectSize(){
        Random rnd = new Random();
        int number = rnd.nextInt(1,5);
        By optionsSize = By.xpath("//*[@id='option-size']/a["+number+"]");
        click(optionsSize);
    }

    public void getPrice(By locator){
        price = find(locator).getText();
    }

    public void getCartPrice(By locator){
        cartPrice = find(locator).getText();
    }

    public void selectHeight(){
        try{
            Random rnd = new Random();
            int number = rnd.nextInt(1,5);
            By optionsSize = By.xpath("//*[@id='option-height']/a["+number+"]");
            click(optionsSize);
        }catch (Exception e){}

    }

    public void addToCart() {
        click(_addToCart);
        click(cartButton);
    }



}
