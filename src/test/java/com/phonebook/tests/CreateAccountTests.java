package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

  //precondition: user should be log out
  //if login link not present
  //click on login link

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
  }

  @Test
  public void registerExistedUserNegativeTest() {
    //click on login link
    clickOnLoginLink();
    //enter email
    //email -> By.name
    fillLoginRegisterForm("laurin@gmail.com", "Laurin1234$");
    //click on the Registration button
    clickOnRegisterButton();
    //assert sign out button is present
    Assert.assertTrue(isAlertAppears());
  }

}