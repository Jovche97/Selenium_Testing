package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class test1 {
    WebDriver driver;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void stop(){
        driver.quit();
    }

    @Test
    public void select() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/select-elements/#Serialize");
        Thread.sleep(30000);
        driver.switchTo().frame(4);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();
        WebElement item1 = driver.findElement(By.xpath("/html/body/ol/li[1]"));
        WebElement item2 = driver.findElement(By.xpath("/html/body/ol/li[3]"));
        WebElement item3 = driver.findElement(By.xpath("/html/body/ol/li[6]"));
        action.keyUp(Keys.CONTROL).build().perform();

        boolean item1selected = item1.isSelected();
        boolean item2selected = item2.isSelected();
        boolean item3selected = item3.isSelected();

        int noP=0;

        if (!item1selected){
            item1.click();
            System.out.println("Item 1 was selected");
            noP++;
        }
        else {
            System.out.println("Item 1 was not selected");
        }
        if (!item2selected){
            item2.click();
            System.out.println("Item 2 was selected");
            noP++;
        }
        else {
            System.out.println("Item 2 was not selected");
        }
        if (!item3selected){
            item3.click();
            System.out.println("Item 3 was selected");
            noP++;
        }
        else {
            System.out.println("Item 3 was not selected");
        }

        System.out.println("Number of selected items is: " + noP);
    }


    @SuppressWarnings("deprecation")
    @Test
    public void test2() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.cssSelector(".panel:nth-child(6) .btn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Please enter your name"));
        {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("Jovan Milenkovc");
            alert.accept();
        }
        WebElement name = driver.findElement(By.id("prompt-demo"));
        String name1 = name.getText();
        if (name1.contains("Jovan Milenkovc")){
            System.out.println("Expected text is obtained");
        }
        else{
            System.out.println("Expected text is not obtained");
        }
    }
    @Test
    public void test3() {
        driver.get("https://www.globalsqa.com/samplepagetest/");
        WebElement upload_file = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/form/p/span/input"));
        WebElement name = driver.findElement(By.id("g2599-name"));
        WebElement mail = driver.findElement(By.id("g2599-email"));
        WebElement web = driver.findElement(By.id("g2599-website"));
        WebElement exp = driver.findElement(By.id("g2599-experienceinyears"));
        WebElement che1 = driver.findElement(By.cssSelector(".grunion-checkbox-multiple-label:nth-child(4) > .checkbox-multiple"));
        WebElement che2 = driver.findElement(By.cssSelector(".grunion-checkbox-multiple-label:nth-child(6) > .checkbox-multiple"));
        WebElement edu = driver.findElement(By.cssSelector(".grunion-radio-label:nth-child(6) > .radio"));
        WebElement com = driver.findElement(By.id("contact-form-comment-g2599-comment"));

        boolean upSel = upload_file.isSelected();
        boolean nameSel = name.isSelected();
        boolean mailSel = mail.isSelected();
        boolean webSel = web.isSelected();
        boolean expSel = exp.isSelected();
        boolean che1Sel = che1.isSelected();
        boolean che2Sel = che2.isSelected();
        boolean eduSel = edu.isSelected();
        boolean comSel = com.isSelected();

        if (!upSel){
            upload_file.sendKeys("G:/JavaSele/resources/Jovan_Milenkovic_CV.pdf");
            System.out.println("PDF uploaded");
        }
        else {
            System.out.println("PDF not uploaded");
        }
        if (!nameSel){
            name.sendKeys("Jovan Milenkovic");
            System.out.println("Name was entered");
        }
        else {
            System.out.println("Name wasn't entered");
        }
        if (!mailSel){
            mail.sendKeys("jovan.milenkovic35@gmail.com");
            System.out.println("E-mail was entered");
        }
        else {
            System.out.println("E-mail wasn't entered");
        }
        if (!webSel){
            mail.sendKeys("http://www.linkedin.com/in/jovche97/");
            System.out.println("Web address was entered");
        }
        else {
            System.out.println("Web address wasn't entered");
        }
        if (!expSel){
            exp.click();
            exp.click();
            System.out.println("Experience was added");
        }
        else {
            System.out.println("Experience wasn't added");
        }
        if (!che1Sel){
            che1.click();
            System.out.println("Expertise was added");
        }
        else {
            System.out.println("Expertise wasn't added");
        }
        if (!che2Sel){
            che2.click();
            System.out.println("Expertise was added");
        }
        else {
            System.out.println("Expertise wasn't added");
        }
        if (!eduSel){
            edu.click();
            System.out.println("Education was added");
        }
        else {
            System.out.println("Education wasn't added");
        }
        if (!comSel){
            com.sendKeys("test");
            System.out.println("Comment was added");
        }
        else {
            System.out.println("Comment wasn't added");
        }

    }
    @Test
    public void test4() throws InterruptedException {
        String TestFile = "C:/Users/Jovan Milenkovic/Downloads/easyinfo.txt";

        driver.get("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");
        driver.findElement(By.id("textbox")).click();
        driver.findElement(By.id("textbox")).sendKeys("Jovan Milenkovic, Staro Laniste bb, Jagodina");
        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("link-to-download")).click();

        Thread.sleep(30000);
        try {
            File myObj = new File(TestFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("Jovan Milenkovic, Staro Laniste bb, Jagodina")){
                    System.out.println("Data matches");
                }
                else {
                    System.out.println("data doesn't match");
                }
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("error");
        }
    }
}


/*
public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.globalsqa.com/demo-site/select-elements/#Serialize");
            Thread.sleep(30000);
            int size = driver.findElements(By.tagName("iframe")).size();

            for(int i=0; i<=size; i++){
                driver.switchTo().frame(i);
                int total=driver.findElements(By.id("selectable")).size();
                System.out.println(total);
                driver.switchTo().defaultContent();}}}

*/