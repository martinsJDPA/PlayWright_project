package pw_session;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocator3 {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://service.london.ca/service-requests/report-forestry-issue/");

        page.getByLabel("Tree Issue").selectOption("845280001");

        page.locator("input[id='adoxio_firstname']:below(:text('First Name'))").first().fill("my firstname");
        page.locator("input[id='adoxio_lastname']:below(:text('Last Name'))").first().fill("my lastname");
        page.locator("input[id='adoxio_phonenumber']:below(:text('Phone Number'))").first().fill("888454256");
        page.locator("input[id='adoxio_emailaddress']:below(:text('Email Address'))").first().fill("mea@london.ca");

    }
}
