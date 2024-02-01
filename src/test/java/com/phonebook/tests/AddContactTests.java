package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

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
  }

  @Test
  public void addContactPositiveTest() {
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
    //assert by name of contact
    Assert.assertTrue(app.getContact().isContactCreatedByText("Karl"));
  }
  @AfterMethod
  public void postCondition()  {
    app.getContact().removeContact();
  }


  @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderTest(String name, String surname, String phone, String email, String adress, String desc) {
    //click on Link add
    app.getContact().clickOnAddLink();
    //enter firstname
    app.getContact().fillAddContactForm(
        new Contact()
            .setName(name)
            .setLastname(surname)
            .setPhone(phone)
            .setEmail(email)
            .setAddress(adress)
            .setDescription(desc));
    //click on save button
    app.getContact().clickOnSaveButton();
    //assert by name of contact
    Assert.assertTrue(app.getContact().isContactCreatedByText(name));
  }


  @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
  public void addContactPositiveFromDataProviderWithCSVTest(Contact contact) {
    //click on Link add
    app.getContact().clickOnAddLink();
    //enter firstname
    app.getContact().fillAddContactForm(contact);
    //click on save button
    app.getContact().clickOnSaveButton();
    Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));
  }
}


