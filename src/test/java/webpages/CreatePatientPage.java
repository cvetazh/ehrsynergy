package webpages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CreatePatientPage {
    private WebDriver driver;
    public Faker faker = new Faker();

    public CreatePatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "middleName")
    private WebElement middleName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class=\"wrapper\"]/div/input")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//button[text() ='save']")
    private WebElement save;

    @FindBy(xpath = "//div[@class='_1mB9g']/a[2]")
    private WebElement encounters;

    public CreatePatientPage firstNameInput() {
        firstName.sendKeys(faker.name().firstName());
        return new CreatePatientPage(driver);
    }

    public CreatePatientPage middleNameInput() {
        middleName.sendKeys(faker.name().lastName());
        return new CreatePatientPage(driver);
    }

    public CreatePatientPage lastNameInput() {
        lastName.sendKeys(faker.name().lastName());
        return new CreatePatientPage(driver);
    }


    public CreatePatientPage dateOfBirthInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(dateOfBirth).click().build().perform();
        dateOfBirth.sendKeys(date());
        return new CreatePatientPage(driver);
    }

    public CreatePatientPage clickEnc() {
        WebElement element1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(encounters));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);
        return new CreatePatientPage(driver);
    }

    public CreatePatientPage createPatient() throws InterruptedException {
        Actions actions = new Actions(driver);
        firstNameInput();
        middleNameInput();
        lastNameInput();
        dateOfBirthInput();
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(save));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        clickEnc();
        return new CreatePatientPage(driver);
    }


    public  String date() {
        Random random = new Random(System.currentTimeMillis());
        int min = 1, maxMouse = 12, maxDay = 28, minYear = 1930, maxYear = 2015, day, mouse, year;
        day = min + random.nextInt(maxDay - min + 1);
        mouse = min + random.nextInt(maxMouse - min + 1);
        year = minYear + random.nextInt(maxYear - minYear + 1);
        String sday = Integer.toString(day);
        String smouse = Integer.toString(mouse);
        String syear = Integer.toString(year);
        String date = null;
        String D, M;
        int d = sday.length();
        int m = smouse.length();
        if (d == 1) {
            if (m != 1) {
                D = "0" + sday;
                date = smouse + D + syear;
            } else {
                D = "0" + sday;
                M = "0" + smouse;
                date = M + D + syear;
            }
        } else {
            if (m == 1) {
                M = "0" + smouse;
                date = M + sday + syear;
            } else {
                date = smouse + sday + syear;
            }
        }
        return date;
    }


}
