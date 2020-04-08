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

public class PatientPage {
    private WebDriver driver;

    public PatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//ul[@class=\"lBwL7\"]//li[3]")
    private WebElement patient;

    @FindBy(xpath = "//a[@href=\"/app/patients/new\"]")
    private WebElement newPatient;

    @FindBy(xpath = "//ul[@class=\"_2BReu\"]/li[9]")
    private WebElement page;

    public PatientPage addPatient() {
        patient();
        newPatient();
        return new PatientPage(driver);
    }

    public PatientPage patient() {
        patient.click();
        return new PatientPage(driver);
    }

    public PatientPage newPatient() {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(newPatient));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return new PatientPage(driver);
    }

    public PatientPage choosePatient() {
        page.click();
        List<WebElement> patients = driver.findElements(By.xpath("//tbody/tr"));
        int rand = (int) (Math.random() * patients.size());
        driver.findElement(By.xpath("//tbody/tr[" + rand + "]")).click();
        return new PatientPage(driver);
    }


}
