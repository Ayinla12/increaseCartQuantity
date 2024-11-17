package cartView;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class addProduct {
    WebDriver driver;
    int targetQuantity;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void launchHomepage() {
        //Section: opens homepage & verify it loaded correctly
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//button[@aria-label='Consent']")).click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");
    }

    @Test(priority = 2)
    public void viewProduct() {
        // Navigates to the second product on the homepage
        WebElement product = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div/div[1]/div[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
        // Clicks on view product
        driver.findElement(By.xpath("/html/body/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div/div[2]/ul/li/a")).click();
        WebElement quantity = driver.findElement(By.id("quantity"));
        // Adds to the product quantity
        targetQuantity = 4;
        for (int i = 1; i < targetQuantity; i++) {
            quantity.sendKeys(Keys.ARROW_UP);
        }
    }

    @Test(priority = 3)
    public void addToCart() {
        // Navigates to cart
        WebElement addCart = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
        addCart.click();
        WebElement viewCart = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
        viewCart.click();
        // Verifies that the product is displayed
        WebElement product = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[1]/a/img"));
        Assert.assertTrue(product.isDisplayed());

        // Locates the product quantity field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-2\"]/td[4]")));
        String productQuantity = quantityField.getText();
        int actualCartQuantity = Integer.parseInt(productQuantity);
        // Verifies the cart quantity
        Assert.assertEquals(targetQuantity, actualCartQuantity);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
