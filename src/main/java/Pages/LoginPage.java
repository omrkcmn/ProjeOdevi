package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By _email = By.id("LoginEmail");
    private By _password = By.id("Password");
    private By _loginButton = By.xpath("//*[@id='loginLink']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void userMail(String mail) {
        type(_email,mail);
    }

    public void userPassword(String password) {
        type(_password,password);
    }

    public void login() {
        click(_loginButton);
    }
}
