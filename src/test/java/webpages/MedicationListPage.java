package webpages;

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

public class MedicationListPage extends GeneralList {

    private WebDriver driver;

    public MedicationListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div//a[3]")
    private WebElement btnMedicationList;

    @FindBy(xpath = "//div[text() = 'Search existing diagnoses for this patient']")
    private WebElement associatedDiagnosis;

    @FindBy(xpath = "//span[text() = 'Yes']")
    private WebElement btnYes;

    @FindBy(xpath = "//span[text() = 'No']")
    private WebElement btnNo;

    public DiagnosisListPage clickBtn() {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(btnMedicationList));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage assDiagnosis() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//div[text() = 'Search existing diagnoses for this patient']")).click();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"Select-menu-outer\"]//div"));
        for (WebElement q: w) {
            actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"Select-menu-outer\"]//div"))).click().build().perform();
            Thread.sleep(1000);
        }
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseRadioButton() {
        Random rand = new Random();
        int random = rand.nextInt(50);
        if (random % 2 == 0)
            btnYes.click();
        else
            btnNo.click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage clickField() {
        driver.findElement(By.className("Select-placeholder")).click();
        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"Select-menu-outer\"]//div"));
        int rand = (int) (Math.random() * w.size());
        driver.findElement(By.xpath("//div[@class=\"Select-menu-outer\"]//div[" + rand + "]")).click();
        return new DiagnosisListPage(driver);
    }


    public DiagnosisListPage medicationList() throws InterruptedException {
        clickBtn();
        Thread.sleep(2000);
        clickField();
        assDiagnosis();
        chooseDates();
        chooseStatus();
        chooseRadioButton();
        writeComment();
        clickSave();
        return new DiagnosisListPage(driver);
    }

}
