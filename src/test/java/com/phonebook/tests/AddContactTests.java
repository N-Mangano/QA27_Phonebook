package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
    //click on login link
    clickOnLoginLink();
    //enter email
    //email -> By.name
    fillLoginRegisterForm("laurin@gmail.com", "Laurin1234$");
    //click on Login button
    clickOnLoginButton();
  }

  @Test
  public void addContactPositiveTest() {
    //click on Link add
    clickOnAddLink();
    //enter firstname
    fillAddContactForm("Karl", "Adam", "1234567890", "adam@gm.com", "Koblenz", "goalkeeper");
    //click on save button
    clickOnSaveButton();
    //assert by name of contact
    Assert.assertTrue(isContactCreatedByText("Karl"));
  }

}
