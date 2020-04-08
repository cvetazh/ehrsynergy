package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class DiagnosisListPage extends GeneralList {
    private WebDriver driver;

    public DiagnosisListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div//a[6]")
    private WebElement btnDiagnosisList;

    @FindBy(className = "Up0KQ")
    private WebElement checkBox;

    @FindBy(xpath = "//button[text()='Chronic']")
    private WebElement chronic;

    @FindBy(xpath = "//button[text()='Acute']")
    private WebElement acute;


    public DiagnosisListPage clickBtn() {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(btnDiagnosisList));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return new DiagnosisListPage(driver);
    }


    public DiagnosisListPage clickCheckBox() {
        checkBox.click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseIllnessStatus() {
        Random rand = new Random();
        int random = rand.nextInt(50);
        if (random % 2 == 0)
            chronic.click();
        else
            acute.click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage clickField() {
        driver.findElement(By.className("Select-placeholder")).click();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"Select-menu-outer\"]//div"));
        int rand = (int) (Math.random() * w.size());
        driver.findElement(By.xpath("//div[@class=\"Select-menu-outer\"]//div[" + rand + "]")).click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage diagnosisList() throws InterruptedException {
        clickBtn();
        Thread.sleep(2000);
        clickField();
        clickCheckBox();
        chooseDates();
        chooseIllnessStatus();
        chooseStatus();
        writeComment();
        clickSave();
        return new DiagnosisListPage(driver);
    }

}
