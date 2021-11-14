import Pages.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestAll extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    final static Logger logger = Logger.getLogger(TestAll.class);

    @Test
    @Order(1)
    public void login(){
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isOnHomePage(),
                "Ana sayfada değil!");
        homePage.acceptCookies();
        homePage.gotoLoginPage();

        loginPage = new LoginPage(driver);
        loginPage.userMail("omerkocaman7@gmail.com");
        loginPage.userPassword(".sifre123");
        loginPage.login();
        Assertions.assertTrue(homePage.isOnHomePage(),"Giriş Yapılmadı!");
    }

    @Test
    @Order(2)
    public void search_product(){
        productsPage = new ProductsPage(driver);

        homePage.searchBox().search("pantolan");
    }

    @Test
    @Order(3)
    public void pageScrollDown(){
        productsPage.scrollPage();
    }

    @Test
    @Order(4)
    public void clickMoreButton(){
        productsPage.clickMore();
    }

    @Test
    @Order(5)
    public void select_a_product(){
        Random rnd = new Random();
        int number = rnd.nextInt(1,productsPage.getAllProducts().size());
        productsPage.selectProduct(number);
    }

    @Test
    @Order(6)
    public void add_product_to_cart(){

        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectSize();
        productDetailPage.selectHeight();
        productDetailPage.addToCart();
    }

    @Test
    @Order(7)
    public void check_product_price(){

        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.getPrice(By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[2]"));
        productDetailPage.getCartPrice(By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[2]/div[1]/div[4]/div/span[2]"));

        Assertions.assertEquals(productDetailPage.price,productDetailPage.cartPrice,"Fiyatlar eşit değil!");
    }

    @Test
    @Order(8)
    public void increaseQuantity(){
        cartPage = new CartPage(driver);
        cartPage.increaseQuantity(2);
    }

    @Test
    @Order(9)
    public void getQuantity(){
        cartPage = new CartPage(driver);
        cartPage.getQuantity();
        Assertions.assertEquals(2,cartPage.getQuantity());
        logger.info("Artırma sonrası ürün miktarı: " + cartPage.getQuantity());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @Order(10)
    public void deleteItem(){
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        cartPage.deleteItem();
        logger.info("Ürün sepetten silindi");
    }

    @Test
    @Order(11)
    public void isCartNullCheck(){
        cartPage = new CartPage(driver);
        Assertions.assertEquals(cartPage.isCartNull(),"ALIŞVERİŞE BAŞLA","Sepet Boş Değil!");
    }

}
