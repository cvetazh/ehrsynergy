package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class EncounterNotesPage {

    private WebDriver driver;

    public EncounterNotesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int amount = 2;

    public int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

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

    //@FindBy(xpath = "//span[text()='All systems']")
    @FindBy(className = "_2pExd")
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

    @FindBy(xpath = "//span[text()='Encounter Note Toggle']")
    private WebElement btnToggle;


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
        if (size <= amount) {
            amount = size;
        }
        Collections.shuffle(elementsList);
        List<WebElement> randomElements = elementsList.subList(0, amount);
        return randomElements;
    }

    public void selectionElementsWithFields() {
        Actions action = new Actions(driver);
        for (WebElement element : createRandomEl()) {
            action.moveToElement(element).click().build().perform();
        }
        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-")); // находим первый элемент с полем
        if (elWithField.size() > 0) {
            action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
            System.out.print(elWithField.size());
            for (WebElement element : elWithField) {
                selectionElements();
                checkButton();
            }
        }
    }

    public void checkButton() {
        Actions action = new Actions(driver);
        List<WebElement> checkButtonNext = driver.findElements(By.xpath("//div[@class=\"_2nJei\"]//button[2]"));
        if (checkButtonNext.size() > 0) {
            WebElement next = driver.findElement(By.xpath("//div[@class=\"_2nJei\"]//button[2]"));
            action.moveToElement(next).click().build().perform();
        } else {
            WebElement allSystems = driver.findElement(By.xpath("//div[@class=\"_2nJei\"]//button[1]"));
            action.moveToElement(allSystems).click().build().perform();
        }
    }


    public EncounterNotesPage createRv() {
        selectionElementsWithFields();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createHxRv() {
        btnRVandHXRV.click();
        selectionElementsWithFields();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createRos() {
        Actions action = new Actions(driver);
        btnRos.click();
        List<WebElement> elementsList = driver.findElements(By.cssSelector(".\\_3qz2C .\\_2eHy9"));
        int size = elementsList.size();
        if (size <= amount) {
            amount = size;
        }
        Collections.shuffle(elementsList);
        List<WebElement> randomElements = elementsList.subList(0, amount);
        for (WebElement element :randomElements){
            (element).click();
        }
        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-")); // находим первый элемент с полем
        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
        List<WebElement> p = driver.findElements(By.xpath("//div[@class=\"_3qz2C\"]//button[@class=\"_1GBPH\"]"));
        int sizep = p.size();
        if (sizep <= amount) {
            amount = size;
        }
        Collections.shuffle(p);
        List<WebElement> rElements = elementsList.subList(0, amount);
        for (WebElement rEl:rElements){
            WebElement subElement = driver.findElement(By.xpath("//div[@class=\"_3qz2C\"]//button[@class=\"_1GBPH\"]"));
            action.moveToElement(subElement).click().build().perform();
            checkButton();
        }

            return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createPe() {
        btnPe.click();
        selectionElementsWithFields();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createA() {
        Actions action = new Actions(driver);
        btnA.click();
        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
        selectionElements();
        checkButton();
        if (visibilityCheck()) {
            action.moveToElement(driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]//button[text()='Add']"))).click().build().perform();
        }
        selectionElements();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createPlan() {
        btnPlan.click();
        selectionElementsWithFields();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createPqrs() {
        btnPqrs.click();
        selectionElementsWithFields();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage toggle() {
        btnToggle.click();
        return new EncounterNotesPage(driver);
    }

    public EncounterNotesPage createEn() {
        createRv();
        createHxRv();
        createPe();
        createRos();
        createA();
        createPqrs();
        createPlan();
        return new EncounterNotesPage(driver);
    }


//    public void chooseFields(){
//    Actions action = new Actions(driver);
//    List<WebElement> fields = driver.findElements(By.xpath("//div[contains(@class,'_1mLHc')]//div[@class = \"_3qz2C\"]//span[@class = \"_2eHy9\"]"));
//    int size = fields.size();
//    if (size <= amount){
//        amount = size;
//    }
//        Collections.shuffle(fields);
//        List<WebElement> randomFields = fields.subList(0, amount);
//
//        if (size != 0 ){
//            for (WebElement field : randomFields){
//                action.moveToElement(field).click().build().perform();
//            }
//        }
//    }
//
//    public void chooseFirstField(){
//        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-"));
//    }
}
