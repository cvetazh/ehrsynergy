package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateNotePage {

    private WebDriver driver;
    public CreateNotePage(WebDriver driver) {
        this.driver = driver;
    }

    public int quantityItem = 1;



    @FindBy(xpath = "//div[@class = \"_1W16E\"]/div")
    private WebElement select;

    @FindBy(xpath = "//div[contains(@class,'_1mLHc')]//div[@class = \"_3qz2C\"]//span[@class = \"_2eHy9\"]")
    private List<WebElement> element;

    @FindBy(xpath = "//div[@class=\"_3XDtT Kpywn\"]//span")
    private WebElement subelement;

    @FindBy(xpath = "//div[@class=\"_3XDtT Kpywn\"]")
    private WebElement modalWindow;

    @FindBy(name = "_385T-")
    private WebElement btnNext;

    @FindBy(xpath = "//span[text()='All systems']")
    private WebElement btnAll;

    @FindBy(xpath = "//div[@class=\"_1v7-C\"]//a[2]")
    private WebElement btnRVandHXRV;

    @FindBy(xpath = "//div[@class=\"_1v7-C\"]//a[4]")
    private WebElement btnRos;

    @FindBy(xpath = "//div[@class=\"_1v7-C\"]//a[5]")
    private WebElement btnPe;

    @FindBy(xpath = "//div[@class=\"_1v7-C\"]//a[6]")
    private WebElement btnA;

    @FindBy(xpath = "//div[@class=\"_1v7-C\"]//a[7]")
    private WebElement btnPlan;

    @FindBy(xpath = "//div[@class=\"_1v7-C\"]//a[8]")
    private WebElement btnPqrs;

    public boolean visibilityCheck() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"_3XDtT Kpywn\"]"));
        if (list.size() > 0) {
            String cssValue = driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]")).getCssValue("visibility");
            String expectedValue = new String("visible");
            if (cssValue.equals(expectedValue)) {
                return true;
            }
        }
        return false;
    }

    public void selectionElements() {
        Actions action = new Actions(driver);
        for (WebElement element : createRandomEl()) {
            action.moveToElement(element).click().build().perform();
            while (visibilityCheck()) {
                WebElement subElement = driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]//span"));
                action.moveToElement(subElement).click().build().perform();
            }
        }
    }

    // создаем список с рандомными значениями и возвращает этот список
    public List<WebElement> createRandomEl() {
        List<WebElement> elementsList = driver.findElements(By.xpath("//div[contains(@class,'_1mLHc')]//div[@class = \"_3qz2C\"]//span[@class = \"_2eHy9\"]"));
        int size = elementsList.size();
        if (size <= quantityItem) {
            quantityItem = size;
        }
        Collections.shuffle(elementsList);
        List<WebElement> randomElements = elementsList.subList(0, quantityItem);
        return randomElements;
    }

    public void selectionElementsWithFields(){
        Actions action = new Actions(driver);
        for (WebElement element : createRandomEl()){
            action.moveToElement(element).click().build().perform();
        }
        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-")); // находим первый элемент с полем
        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
        for (WebElement element: elWithField){
            selectionElements();
            checkButton();
        }
    }

    public void checkButton(){
        Actions action = new Actions(driver);
        List<WebElement> checkButtonNext = driver.findElements(By.className("_385T-"));
            if (checkButtonNext.size() > 0) {
                WebElement next = driver.findElement(By.className("_385T-"));
                action.moveToElement(next).click().build().perform();
            } else
                action.moveToElement(btnAll).click().build().perform();
    }


    public void testRVandHXRV(){
        selectionElementsWithFields();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnRVandHXRV.click();
        selectionElementsWithFields();

    }

    public void testRos(){
        Actions action = new Actions(driver);
        btnRos.click();
        List<WebElement> elementsList = driver.findElements(By.cssSelector(".\\_3qz2C .\\_2eHy9"));
        int size = elementsList.size();
        if (size <= quantityItem) {
            quantityItem = size;
        }
        Collections.shuffle(elementsList);
        List<WebElement> randomElements = elementsList.subList(0, quantityItem);
        for (WebElement element :randomElements){
            (element).click();
        }
        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-")); // находим первый элемент с полем
        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
        for (WebElement element: elWithField){
            List<WebElement> p = driver.findElements(By.xpath("//div[@class=\"_3qz2C\"]//button[@class=\"_1GBPH\"]"));
            for (WebElement l:p){
                WebElement subElement = driver.findElement(By.xpath("//div[@class=\"_3qz2C\"]//button[@class=\"_1GBPH\"]"));
                action.moveToElement(subElement).click().build().perform();
                checkButton();}
        }
    }

    public void testPE(){
        btnPe.click();
        selectionElementsWithFields();
    }


    public void testA(){
        Actions action = new Actions(driver);
        btnA.click();
        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
        selectionElements();
        checkButton();
        if (visibilityCheck()){
            action.moveToElement(driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]//button[text()='Add']"))).click().build().perform();
        }
        selectionElements();
    }


    public void testPlan(){
        btnPlan.click();
        selectionElementsWithFields();
    }

    public void testPQRS(){
        btnPqrs.click();
        selectionElementsWithFields();
    }
public CreateNotePage element(){
        testRVandHXRV();
        testRos();
        testPE();
        testA();
        testPlan();
        testPQRS();
        return new CreateNotePage(driver);
}

}
