package webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChartPage {
    private WebDriver driver;


    public ChartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[text()='Sign']")
    private WebElement btnSign;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement btnConfirm;


    public ChartPage sign() throws InterruptedException {
        WebElement element  =(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(btnSign));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return new ChartPage(driver);
    }

    public ChartPage confirm() {
        WebElement element  =(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(btnConfirm));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return new ChartPage(driver);
    }

    public ChartPage signChart() throws InterruptedException {
        sign();
        confirm();
        return new ChartPage(driver);
    }

}
