package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!isLoginLinkPresent()) {
      clickOnSignOutButton();
    }
  }
  @Test
  public void loginPositiveTest() {
    //click on login link
    clickOnLoginLink();
    //enter email
    //email -> By.name
    fillLoginRegisterForm("laurin@gmail.com", "Laurin1234$");
    //click on Login button
    clickOnLoginButton();
    //assert Sign on button is appeared
    Assert.assertTrue(isSignOutButtonPresent());

  }

}
