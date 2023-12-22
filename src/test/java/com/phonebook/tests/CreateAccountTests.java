package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

  //precondition: user should be log out
  //if login link not present
  //click on login link

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void registerExistedUserNegativeTest() {
    //click on login link
    app.getUser().clickOnLoginLink();
    //enter email
    //email -> By.name
    app.getUser().fillLoginRegisterForm(new User()
        .setEmail("laurin@gmail.com")
        .setPassword("Laurin1234$"));
    //click on the Registration button
    app.getUser().clickOnRegisterButton();
    //assert sign out button is present
    Assert.assertTrue(app.getUser().isAlertAppears());
  }

}