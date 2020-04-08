package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class GeneralList {

    private WebDriver driver;

    @FindBy(xpath = "//div//a[6]")
    private WebElement btnDiagnosisList;

    @FindBy(className = "Select-placeholder")
    private WebElement field;

    @FindBy(className = "Up0KQ")
    private WebElement checkBox;

    @FindBy(xpath = "//div[@class=\"wrapper\"]/div/input")
    private WebElement startDate;

    @FindBy(xpath = "//div[@class=\"_3KVm1\"][2]/div/div/div/input")
    private WebElement endDate;

    @FindBy(xpath = "//button[text()='Chronic']")
    private WebElement chronic;

    @FindBy(xpath = "//button[text()='Acute']")
    private WebElement acute;

    @FindBy(xpath = "//button[text()='Active']")
    private WebElement active;

    @FindBy(xpath = "//button[text()='Inactive']")
    private WebElement inactive;

    @FindBy(className = "_2zR7h")
    private WebElement comment;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement save;


//    public DiagnosisListPage clickField() {
//        driver.findElement(By.className("Select-placeholder")).click();
//        List<WebElement> w = driver.findElements(By.xpath("//div[@class=\"Select-menu-outer\"]//div"));
//        System.out.print(w.size() + ";");
//        int rand = (int) (Math.random() * w.size());
//        driver.findElement(By.xpath("//div[@class=\"Select-menu-outer\"]//div[" + rand + "]")).click();
//        System.out.print(rand + ";");
//        return new DiagnosisListPage(driver);
//    }

//
//    public DiagnosisListPage selectPlaceholder() {
//        select.click();
//        return new DiagnosisListPage(driver);
//    }
//

    public DiagnosisListPage chooseDates() {
        startDate.click();
        startDate.sendKeys("06102016");
        endDate.click();
        endDate.sendKeys("10052018");
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage chooseStatus() {
        Random rand = new Random();
        int random = rand.nextInt(50);
        if (random % 2 == 0)
            active.click();
        else
            inactive.click();
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage writeComment() {
        comment.click();
        comment.sendKeys("No comment");
        return new DiagnosisListPage(driver);
    }

    public DiagnosisListPage clickSave() {
        save.click();
        return new DiagnosisListPage(driver);
    }

}
