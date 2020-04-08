package webpages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class AllergyListPage extends GeneralList {
    private WebDriver driver;

    public AllergyListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div//a[4]")
    private WebElement btnAllergyList;

    @FindBy(xpath = "//button[text() = 'Drug']")
    private WebElement btnDrug;

    @FindBy(xpath = "//button[text() = 'Environment']")
    private WebElement btnEnvironment;


    public DiagnosisListPage clickBtn() {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(btnAllergyList));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage clickField() {
        driver.findElement(By.className("Select-placeholder")).click();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"Select-menu-outer\"]//div"));
        int rand = (int) (Math.random() * w.size());
        driver.findElement(By.xpath("//div[@class=\"Select-menu-outer\"]//div[" + rand + "]")).click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseDrug() {
        Random rand = new Random();
        int random = rand.nextInt(50);
        if (random % 2 == 0)
            btnDrug.click();
        else
            btnEnvironment.click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseSeverity() {
        Actions actions = new Actions(driver);
        Random rand = new Random();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"pA9Hs\"][3]//button"));
        int random = rand.nextInt(w.size());
        System.out.print("заебали" + w.size()+" "+random);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"pA9Hs\"][3]//button[" + random + "]"))).click().build().perform();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseReaction() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//div[text() = 'Search for allergy reaction for this patient']")).click();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"Select-menu-outer\"]//div"));
        for (WebElement q: w) {
            actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"Select-menu-outer\"]//div"))).click().build().perform();
            Thread.sleep(1000);
        }
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseOnset() {
        Random rand = new Random();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"pA9Hs\"][5]//button"));
        int random = rand.nextInt(w.size());
        driver.findElement(By.xpath("//div[@class=\"pA9Hs\"][5]//button[" + random + "]")).click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage allergyList() throws InterruptedException {
        clickBtn();
        Thread.sleep(2000);
        chooseDrug();
        clickField();
        chooseSeverity();
        chooseReaction();
        chooseOnset();
        chooseStatus();
        writeComment();
        clickSave();
        return new DiagnosisListPage(driver);
    }


}
