import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.CoreMatchers.is;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class OrangeHrm extends FindElement {

    public OrangeHrm() {
        PageFactory.initElements(Utils.getWebDriver(), this);
    }

    public void fillLoginDetails(String login, String password) {
        Utils.typeText(inputLogin, login);
        Utils.typeText(inputPassword, password);
        inputPassword.sendKeys((Keys.ENTER));
    }
    public void configuration() {
        adminModule.click();
        menu.click();
        localization.click();
    }
    public void addEmployee() {
        pimModule.click();
        addEmployee.click();
    }
    public void fillNewEmployeeData(String firstName, String lastName) {
        Utils.typeText(inputFirstName, firstName);
        Utils.typeText(inputLastName, lastName);
    }
    public void equalsCreatedEmployee(String firstName, String lastName) {
        assertThat(txtEmpFirstName.getAttribute("value"), is(firstName));
        assertThat(txtEmpLastName.getAttribute("value"), is(lastName));

    }
    public void buttonClick() {
        button.click();
    }
    public void changeLanguage(String lang) {
        languageBar.click();
        Select select = new Select(languageBar);
        select.selectByVisibleText(lang);
    }
    public void equalsMainMenuList(List list) {
        List<String> pagesTitle1 = new ArrayList<String>(list);
        List<String> pagesTitle2 = new ArrayList<String>();
        List<WebElement> firstLevelMenuOptions = mainMenu;
        for (WebElement webElement : firstLevelMenuOptions) {
            pagesTitle2.add(webElement.getText());
        }
        Assert.assertEquals(pagesTitle1, pagesTitle2);
    }

    public void spanMessage() {
        spanMessage.isDisplayed();
    }
}
