package com.SBI.SCO.steps;


import com.SBI.SCO.pages.LoginPage;
import com.SBI.SCO.utils.DriverManager;
import com.SBI.SCO.utils.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver = DriverManager.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("WebsiteOpened");
        System.out.println("WebsiteOpened");
        System.out.println("WebsiteOpened");
    }

    @When("I enter credentials from Excel sheet")
    public void iEnterCredentialsFromExcelSheet() {
        try {
            ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
            String username = excelReader.getCellValue("LoginData", 1, 0);
            String password = excelReader.getCellValue("LoginData", 1, 1);
            excelReader.close();
            loginPage.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}