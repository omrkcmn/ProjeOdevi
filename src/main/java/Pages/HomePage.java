package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    SearchBox searchBox;
    //private By cartCountLocator = By.id("nav-cart-count");
    private By loginPageLocator =  By.xpath("//*[@id='header-user-section']/i");
    private By cartContainerLocator = By.id("nav-cart-count-container");
    private By cartCountLocator = By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[2]/div[1]/div[1]/div/h1");
    private By cookiesLocator = By.xpath("//*[@id='footer__container']/div[2]/div/p[3]/button");

    //private By cookiesLocator = By.id("sp-cc-accept");


    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    public boolean isProductCount(){
        return getCartCount() > 0;
    }
    public SearchBox searchBox() {
        return this.searchBox;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void acceptCookies(){
        if(isDisplayed(cookiesLocator)){
            click(cookiesLocator);
        }
    }

    public boolean isOnHomePage() {
        return true;
    }

    public void gotoLoginPage() {
        driver.navigate().to("https://www.lcwaikiki.com/tr-TR/TR/giris");
    }
}
