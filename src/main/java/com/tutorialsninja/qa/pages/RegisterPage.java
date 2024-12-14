package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressField ; 
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField ; 
	
	@FindBy(id = "input-password")
	private WebElement passwordField; 
	
	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmFiled ; 
	
	@FindBy(name = "agree")
	private WebElement  privacyPolicyField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton ;
	
	@FindBy(xpath= "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//div[contains (@class, 'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath= "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath= "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath= "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath= "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String retrievePrivacyPolicyWarning() {
	 String privacyPolicyWarningText =	privacyPolicyWarning.getText();
	return privacyPolicyWarningText;
	}
	
	public String retriveFirstNameWarning() {
	 String firstNameWarningText =	firstNameWarning.getText();	
     return 	firstNameWarningText;	
	}
	
	public String retrieveLastNameWarning() {
	 String lastNameWarningText =	lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveEmailWarning() {
	String emailWarningText = 	emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrieveTelephoneWarning() {
	String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrievePasswordWarning() {
	String passwordWarningText =	passwordWarning.getText();
	return passwordWarningText;
	}
	
	
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String LastNameText) {
		lastNameField.sendKeys(LastNameText);
	}
	
	public void enterEmailAddress(String EmailText) {
		emailAddressField.sendKeys(EmailText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		passwordConfirmFiled.sendKeys(passwordText);
	}
	
	public void selectPrivacyPolicy() {
		
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsletterOption() {
		yesNewsletterOption.click();
	}
	
	public String retrieveDuplicateEmailAddressWarning() {
		
		String dupliacteEmailWarningText = duplicateEmailAddressWarning.getText();
		return dupliacteEmailWarningText;
	}
	
	public AccountSuccessPage registerWithMandatoryFields(String firstNameText, String LastNameText, String EmailText, String telephoneText, String passwordText ) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(LastNameText);
		emailAddressField.sendKeys(EmailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmFiled.sendKeys(passwordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	
	}
	
	public AccountSuccessPage registerWithAllMandatoryFields(String firstNameText, String LastNameText, String EmailText, String telephoneText, String passwordText ) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(LastNameText);
		emailAddressField.sendKeys(EmailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmFiled.sendKeys(passwordText);
		yesNewsletterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	
	}
	
}
