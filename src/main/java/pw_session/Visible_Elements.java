package pw_session;

/*
verify that an element is present on a page
*/

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.util.List;

public class Visible_Elements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions browOpt = new BrowserType.LaunchOptions().setHeadless(false);
//        Browser browser = playwright.webkit().launch(browOpt);

        browOpt.setChannel("chrome");
        Browser browser = playwright.chromium().launch(browOpt);
        Page page = browser.newPage();
        page.navigate("https://naveenautomationlabs.com/");
        List<String> linktxt = page.locator("img:visible").allInnerTexts();
        for(int i=0; i<linktxt.size(); i++) {
            System.out.println(linktxt.get(i));
        }
    }

}
