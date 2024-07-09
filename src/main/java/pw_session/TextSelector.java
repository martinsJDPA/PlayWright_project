package pw_session;
/*
How to use page element selectors in PW
 */

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class TextSelector {
    public static void  main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //text selectors
        Page page = browser.newPage();
        page.navigate("https://orangehrmlive.com/en/30-day-free-trial");
        assertThat(page.locator("text=Book a Free Demo").last()).isVisible();
//        page.locator("text=Contact Sales").last().click(); //could also be written as below
        page.locator("'Contact Sales'").last().click();
        System.out.println(page.title());

        //header level locator
        String aboutUs = page.locator("h5:has-text('About Us')").textContent();
        assertThat(page.locator("text= About Us").last()).isVisible();
        System.out.println(aboutUs);

        //OR use a parent -child selector for more explicit reference
        String header = page.locator("div.contact-page-slider-content h1:has-text('Contact Sales')")
                .textContent();
        System.out.println(header);

//        page.locator("div.middleColumn input:has-text('FullName')").fill("My Full Name");







    }
}
