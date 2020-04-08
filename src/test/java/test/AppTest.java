package test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webpages.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class AppTest {
    String em;

    public AppTest(String em) {
        this.em = em;
    }

    public WebDriver driver;
    public String URL = "https://ehryoutst.dev.gomel.ximxim.com/app/login";
    public String URL1 = "https://ehrsynergy.com/app/login";
    private LogPage log;
    private PatientPage patient;
    private CreatePatientPage createPatient;
    private StartNewNotePage startNewNote;
    private EncounterNotesPage encounterNotes;
    private ChartPage chart;
    private DiagnosisListPage diagnosisList;
    private MedicationListPage medicationList;
    private AllergyListPage allergyList;


    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL1);
        log = new LogPage(driver);
        patient = new PatientPage(driver);
        createPatient = new CreatePatientPage(driver);
        startNewNote = new StartNewNotePage(driver);
        encounterNotes = new EncounterNotesPage(driver);
        chart = new ChartPage(driver);
        diagnosisList = new DiagnosisListPage(driver);
        medicationList = new MedicationListPage(driver);
        allergyList = new AllergyListPage(driver);
    }


//    @Parameterized.Parameters
//    public static Iterable<? extends Object> data() {
//        return Arrays.asList(
//                "sdfsdf",
//                "sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf"
//                // "sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf","sdfsdf"
//        );
//    }

    @Parameterized.Parameters
    public static Iterable<? extends Object> data() {
        String[] myArray;
        myArray = new String[1];
        return Arrays.asList(myArray);
    }

//
//    @Test
//    public void method_1() throws InterruptedException {
//        log.signin("a1019mailcom@gmail.com", "a1019mailcom@gmail.com");
//        //login.chooseClinic("SV");
//        patient.addPatient();
//        createPatient.createPatient();
//        startNewNote.startNewNote();
//        encounterNotes.createEn();
//        encounterNotes.toggle();
//        chart.signChart();
//        log.logout();
//    }

//    @Test
//    public void method_2() throws InterruptedException {
//        log.signin("a1019mailcom@gmail.com", "a1019mailcom@gmail.com");
//        for (int i=0; i<1; i++) {
//            patient.addPatient();
//            createPatient.createPatient();
//            startNewNote.startNewNote();
//            encounterNotes.createEn();
//          //  encounterNotes.toggle();
//            chart.signChart();
//        }
//    }
//
//    @Test
//    public void method_3() throws InterruptedException {
//        log.signin("a1019mailcom@gmail.com", "a1019mailcom@gmail.com");
//        patient.addPatient();
//        createPatient.createPatient();
//        for (int i=0; i<2; i++) {
//            startNewNote.startNewNote();
//            encounterNotes.createEn();
//            //encounterNotes.toggle();
//            chart.signChart();
//        }
//    }


    @Test
    public void method_4() throws InterruptedException {
        log.signin("a1019mailcom@gmail.com", "a1019mailcom@gmail.com");
//        patient.patient();
       Thread.sleep(10000);
//        patient.choosePatient();
//        diagnosisList.diagnosisList();
//        Thread.sleep(2000);
//        medicationList.medicationList();
//        Thread.sleep(2000);
//        allergyList.allergyList();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
// mvn clean test -Dtest=AppTest
// a1019mailcom@gmail.com

