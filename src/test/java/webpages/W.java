//package com.mycompany.app;
//
//import com.github.javafaker.Faker;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.*;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class AppTest {
//    public WebDriver driver;
//    static
//    public  final String URL = "https://ehryoutst.dev.gomel.ximxim.com/app/login";
//    public int quantityItem=2;
//    String fn;
//    String mn;
//    String ln;
//    String dob;
//
//    @Factory( dataProvider = "param" )
//    public AppTest(String firstName, String middleName, String lastName, String DOB)
//    {
//        this.fn = firstName;
//        this.mn = middleName;
//        this.ln = lastName;
//        this.dob =DOB;
//
//    }
//
//    @DataProvider(name="param")
//    public static Object[][] dataProviderMethod() {
//        String firstName = faker.name().firstName() ;
//        String middleName = faker.name().lastName();
//        String lastName = faker.name().lastName();
//        String DOB = date();
//        return new Object[][] {
//                {firstName, middleName,lastName,DOB}
//        };
//    }
//
//    @BeforeMethod
//    public void setUp(){
//
//        System.out.print(Thread.currentThread().getId());
//        System.setProperty("webdriver.chrome.driver", "/chromedriver1.exe");
//       /* ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");*/
//        driver = new ChromeDriver();
//        Actions action = new Actions(driver);
//        driver.get(URL);
//        driver.manage().window().maximize();
//        //LOGIN
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).sendKeys("test@test.test");
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).sendKeys("test@test.test");
//        driver.findElement(By.className("_28Lgs")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.className("_3INdE")).isDisplayed();
//        action.moveToElement(driver.findElement(By.className("_35H9I"))).click().build().perform();
//        driver.findElement(By.cssSelector(".menu-item__patients___autotest > .\\_1EeRE")).click();
//        //ADD NEW PATIENTS
//        //action.moveToElement(driver.findElement(By.xpath("//div[@class=\"_2QK5C\"]//span[@class=\"_3qSXu\"]"))).click().build().perform();
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div[2]/div/div/div/div/div[1]/div[1]/span/a/span/span[2]")).click();
//        driver.findElement(By.id("firstName")).click();
//        driver.findElement(By.id("firstName")).sendKeys(fn);
//        driver.findElement(By.id("middleName")).click();
//        driver.findElement(By.id("middleName")).sendKeys(mn);
//        driver.findElement(By.id("lastName")).click();
//        driver.findElement(By.id("lastName")).sendKeys(ln);
//        driver.findElement(By.cssSelector(".\\_2pLo5")).click();
//        driver.findElement(By.cssSelector(".\\_2pLo5")).sendKeys(dob);
//        driver.findElement(By.xpath("//button[text() ='save']")).click();
//        //driver.findElement(By.cssSelector(".\\_2kiYz")).click();
//        driver.findElement(By.cssSelector(".Z3Y_d")).click();
//        driver.findElement(By.cssSelector(".\\_2L0Wl:nth-child(2) > .\\_22FeW > span")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        action.moveToElement(driver.findElement(By.cssSelector("button._2mcY3"))).click().build().perform();
//    }
//
//
//    public static String date(){
//        Random random = new Random(System.currentTimeMillis());
//        int min=1, maxMouse=12, maxDay=28,minYear=1930, maxYear=2018, day,mouse,year;
//        day =min +random.nextInt(maxDay-min+1);
//        mouse =min +random.nextInt(maxMouse-min+1);
//        year =minYear +random.nextInt(maxYear-minYear+1);
//        String sday = Integer.toString(day);
//        String smouse= Integer.toString(mouse);
//        String syear = Integer.toString(year);
//        String date = null;
//        String D,M;
//        int d = sday.length();
//        int m = smouse.length();
//        if (d==1) {
//            if (m != 1) {
//                D = "0" + sday;
//                date = smouse + D + syear;
//            } else {
//                D = "0" + sday;
//                M = "0" + smouse;
//                date = M + D + syear;
//            }
//        }else {
//            if (m==1){
//                M="0"+smouse;
//                date =M+sday+syear;
//            }else {
//                date = smouse+sday+syear;
//            }
//        }
//        return date;
//    }
//
//    public boolean visibilityCheck() {
//        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"_3XDtT Kpywn\"]"));
//        if (list.size() > 0) {
//            String cssValue = driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]")).getCssValue("visibility");
//            String expectedValue = new String("visible");
//            if (cssValue.equals(expectedValue)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void selectionElements() {
//        Actions action = new Actions(driver);
//        for (WebElement element : createRandomEl()) {
//            action.moveToElement(element).click().build().perform();
//            while (visibilityCheck()) {
//                WebElement subElement = driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]//span"));
//                action.moveToElement(subElement).click().build().perform();
//            }
//        }
//    }
//
//    // создаем список с рандомными значениями и возвращает этот список
//    public List<WebElement> createRandomEl() {
//        List<WebElement> elementsList = driver.findElements(By.xpath("//div[contains(@class,'_1mLHc')]//div[@class = \"_3qz2C\"]//span[@class = \"_2eHy9\"]"));
//        int size = elementsList.size();
//        if (size <= quantityItem) {
//            quantityItem = size;
//        }
//        Collections.shuffle(elementsList);
//        List<WebElement> randomElements = elementsList.subList(0, quantityItem);
//        return randomElements;
//    }
//
//    public void selectionElementsWithFields(){
//        Actions action = new Actions(driver);
//        for (WebElement element : createRandomEl()){
//            action.moveToElement(element).click().build().perform();
//        }
//        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-")); // находим первый элемент с полем
//        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
//        System.out.print(elWithField.size());
//        for (WebElement element: elWithField){
//            selectionElements();
//            checkButton();
//        }
//    }
//
//    public void checkButton(){
//        Actions action = new Actions(driver);
//        List<WebElement> checkButtonNext = driver.findElements(By.className("_385T-"));{
//            if (checkButtonNext.size() > 0) {
//                WebElement next = driver.findElement(By.className("_385T-"));
//                action.moveToElement(next).click().build().perform();
//            } else {
//                WebElement allSystems = driver.findElement(By.className("_2pExd"));
//                allSystems.click();
//            }
//        }
//    }
//
//
//    @Test
//    public void testRVandHXRV(){
//        System.out.print(Thread.currentThread().getId() +"\n");
//        selectionElementsWithFields();
//        driver.findElement(By.xpath("//div[@class=\"_1v7-C\"]//a[2]")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        selectionElementsWithFields();
//
//    }
//
//    @Test
//    public void testRos(){
//        System.out.print(Thread.currentThread().getId() +"\n");
//        Actions action = new Actions(driver);
//        driver.findElement(By.xpath("//div[@class=\"_1v7-C\"]//a[4]")).click();
//        List<WebElement> elementsList = driver.findElements(By.cssSelector(".\\_3qz2C .\\_2eHy9"));
//        int size = elementsList.size();
//        if (size <= quantityItem) {
//            quantityItem = size;
//        }
//        Collections.shuffle(elementsList);
//        List<WebElement> randomElements = elementsList.subList(0, quantityItem);
//        for (WebElement element :randomElements){
//            (element).click();
//        }
//        List<WebElement> elWithField = driver.findElements(By.className("_3w3B-")); // находим первый элемент с полем
//        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
//        System.out.print( elWithField.size());
//        for (WebElement element: elWithField){
//            List<WebElement> p = driver.findElements(By.xpath("//div[@class=\"_3qz2C\"]//button[@class=\"_1GBPH\"]"));
//            for (WebElement l:p){
//                WebElement subElement = driver.findElement(By.xpath("//div[@class=\"_3qz2C\"]//button[@class=\"_1GBPH\"]"));
//                action.moveToElement(subElement).click().build().perform();
//                checkButton();}
//        }
//    }
//
//    @Test
//    public void testPE(){
//        System.out.print(Thread.currentThread().getId() +"\n");
//        driver.findElement(By.xpath("//div[@class=\"_1v7-C\"]//a[5]")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        selectionElementsWithFields();
//    }
//
//    @Test
//    public void testA(){
//        System.out.print(Thread.currentThread().getId() +"\n");
//        Actions action = new Actions(driver);
//        driver.findElement(By.xpath("//div[@class=\"_1v7-C\"]//a[6]")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        action.moveToElement(driver.findElement(By.className("_3w3B-"))).click().build().perform();
//        selectionElements();
//        checkButton();
//        if (visibilityCheck()){
//            action.moveToElement(driver.findElement(By.xpath("//div[@class=\"_3XDtT Kpywn\"]//button[text()='Add']"))).click().build().perform();
//        }
//        selectionElements();
//    }
//
//    @Test
//    public void testPlan(){
//        System.out.print(Thread.currentThread().getId() +"\n");
//        driver.findElement(By.xpath("//div[@class=\"_1v7-C\"]//a[7]")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        selectionElementsWithFields();
//    }
//
//    @Test
//    public void testPQRS(){
//        System.out.print(Thread.currentThread().getId() +"\n");
//        driver.findElement(By.xpath("//div[@class=\"_1v7-C\"]//a[8]")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        selectionElementsWithFields();
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        Actions action = new Actions(driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.className("_1pKRB")).click();
//        action.moveToElement(driver.findElement(By.xpath("//button[text()='Sign']"))).click().build().perform();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        action.moveToElement(driver.findElement(By.xpath("//button[text()='Confirm']"))).click().build().perform();
//        driver.findElement(By.cssSelector(".\\_1d9AB > button:nth-child(2)")).click();
//        driver.quit();
//    }
//}
//
//
//
