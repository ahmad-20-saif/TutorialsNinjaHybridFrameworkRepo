 package com.tutorialninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerPage;
	AccountSuccessPage accountSucessPage;
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	 
	 @BeforeMethod
	 public void setUp() {
		 
		    
		 	driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
			HomePage homePage = new HomePage(driver);
			registerPage = homePage.naviagtToRegisterPage();
		 
	 }
	 
	 
	 
	 @AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

	@Test(priority=1)
	public void VerifyRegisteringAnAccountWithMandatoryFeilds() {
		
		accountSucessPage  = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastNmae"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
	
	    Assert.assertEquals(accountSucessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("AccountSuccesfullyCreatedHeading"), "Account Sucess page is not displayed");
 
    }
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		accountSucessPage  = registerPage.registerWithAllMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastNmae"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		

	    Assert.assertEquals(accountSucessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("AccountSuccesfullyCreatedHeading"), "Account Sucess page is not displayed");
	    
	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		
		registerPage.registerWithAllMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastNmae"), prop.getProperty("validEmail") , dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
	    Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")), "Warning message regarding duplicate email address is  not displayed");
	    
	    
	}
	
	
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
	
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.retrievePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not displayed");
		 
		Assert.assertEquals(registerPage.retriveFirstNameWarning(), dataProp.getProperty("firstNameWarning"), "First Name Warning message is not displayed ");
		
		Assert.assertEquals(registerPage.retrieveLastNameWarning(), dataProp.getProperty("lastNameWarning"), "Last Name Warning message is not displayed ");
		
		Assert.assertEquals(registerPage.retrieveEmailWarning(), dataProp.getProperty("emailWarning"), "Email Address Warning message is not displayed ");
	
		Assert.assertEquals(registerPage.retrieveTelephoneWarning() , dataProp.getProperty("telephoneWarning"), "Telephone Warning message is not displayed ");

		Assert.assertEquals(registerPage.retrievePasswordWarning(), dataProp.getProperty("passwordWarning"), "Password Warning message is not displayed ");
		
		
	}
	
	
}
