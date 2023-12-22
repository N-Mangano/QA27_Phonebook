package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
    //click on login link
    app.getUser().clickOnLoginLink();
    //enter email
    //email -> By.name
    app.getUser().fillLoginRegisterForm(new User()
        .setEmail("laurin@gmail.com")
        .setPassword("Laurin1234$"));
    //click on Login button
    app.getUser().clickOnLoginButton();
    //click on Link add
    app.getContact().clickOnAddLink();
    //enter firstname
    app.getContact().fillAddContactForm(
        new Contact()
            .setName("Karl")
            .setLastname("Adam")
            .setPhone("1234567890")
            .setEmail("adam@gm.com")
            .setAddress("Koblenz")
            .setDescription("goalkeeper"));
    //click on save button
    app.getContact().clickOnSaveButton();
  }

  @Test
  public void removeContactPositiveTest() {
    //get size of contacts before remove
    int sizeBefore = app.getContact().sizeOfContacts();
    //click on contact
    app.getContact().removeContact();
    app.getContact().pause(1000);
    //get size of contacts after remove
    int sizeAfter = app.getContact().sizeOfContacts();
    //assert by number of contacts
    Assert.assertEquals(sizeAfter, sizeBefore-1);

  }

}
