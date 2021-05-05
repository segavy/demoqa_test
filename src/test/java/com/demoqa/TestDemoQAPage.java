package com.demoqa;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDemoQAPage {

    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sergey\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sergey");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Valko");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("segavy@mail.ru");

        WebElement element = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        driver.findElement(By.id("userNumber")).sendKeys("2978821750");

        driver.findElement(By.id("dateOfBirthInput")).click();

//      driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).sendKeys("1980");
        WebElement dropDownListDOB = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select clickDOB = new Select(dropDownListDOB);
        clickDOB.selectByValue("1980");


        WebElement listOfMonth = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select june = new Select(listOfMonth);
        june.selectByVisibleText("June");

        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--004']")).click();
        driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("My Subjects");


        WebElement hobbiesCheckboxSports = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
        WebElement hobbiesCheckboxReading = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
        WebElement hobbiesCheckboxMusic = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
        executor.executeScript("arguments[0].click();", hobbiesCheckboxSports);
        executor.executeScript("arguments[0].click()", hobbiesCheckboxReading);
        executor.executeScript("arguments[0].click()", hobbiesCheckboxMusic);

        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("D:\\Downloads\\DonaldDuck.png");

        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Grodno, Sovieckaya str., 13");

        driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("NCR");
        driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("Noida");




        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.quit();

    }

}
