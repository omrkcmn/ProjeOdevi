package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    SearchBox searchBox;
    private By cookiesLocator = By.xpath("//*[@id='footer__container']/div[2]/div/p[3]/button");


    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    public SearchBox searchBox() {
        return this.searchBox;
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
