package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
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
    //click on Link add
    clickOnAddLink();
    //enter firstname
    fillAddContactForm("Karl", "Adam", "1234567890", "adam@gm.com", "Koblenz", "goalkeeper");
    //click on save button
    clickOnSaveButton();
  }

  @Test
  public void removeContactPositiveTest() {
    //get size of contacts before remove
    int sizeBefore = sizeOfContacts();
    //click on contact
    removeContact();
    pause(1000);
    //get size of contacts after remove
    int sizeAfter = sizeOfContacts();
    //assert by number of contacts
    Assert.assertEquals(sizeAfter, sizeBefore-1);

  }

}
