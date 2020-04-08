package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPage {
    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(className = "_28Lgs")
    private WebElement btSignIn;

    @FindBy(xpath = "//div[@class=\"_35H9I\"]//div[contains(text(), 'SV')]")
    //  @FindBy(xpath = "//div[@class=\"_35H9I\"]//div")
    private WebElement clinic;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logout;


    public LogPage signin(String em, String pass){
        email.click();
        //email.sendKeys("test@test.test");
       // email.sendKeys("a1019mailcom@gmail.com");
        email.sendKeys(em);
        //password.sendKeys("test@test.test");
        //password.sendKeys("a1019mailcom@gmail.com");
        password.sendKeys(pass);
        btSignIn.click();
        clinic.click();
        return new LogPage(driver);
    }

    public ChartPage logout() {
        logout.click();
        return new ChartPage(driver);
    }

    public LogPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

}
