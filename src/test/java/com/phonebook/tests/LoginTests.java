package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }
  @Test
  public void loginPositiveTest() {
    //click on login link
    app.getUser().clickOnLoginLink();
    //enter email
    //email -> By.name
    app.getUser().fillLoginRegisterForm(new User()
            .setEmail("laurin@gmail.com")
            .setPassword("Laurin1234$"));
    //click on Login button
    app.getUser().clickOnLoginButton();
    //assert Sign on button is appeared
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());

  }

  @Test
  public void loginNegativeTestWithoutEmail() {
    app.getUser().clickOnLoginLink();

    app.getUser().fillLoginRegisterForm(new User()
        .setPassword("Laurin1234$"));
    //click on Login button
    app.getUser().clickOnLoginButton();
    //assert Sign on button is appeared
    Assert.assertTrue(app.getUser().isAlertAppears());

  }

}
