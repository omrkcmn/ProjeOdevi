package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {
    private By searchBoxLocator = By.id("search_input");
    private By searchButton = new By.ByCssSelector("button.searchButton");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        click(searchBoxLocator);
        type(searchBoxLocator,text);
        click(searchButton);
    }
}
