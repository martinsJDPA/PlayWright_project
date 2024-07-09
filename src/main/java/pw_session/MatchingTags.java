package pw_session;
/*
Sometimes, tags change or elements are modified. It is a good practice to provide robust selectors that can
cover any of those eventualities.
1. use comma separated css list, OR
2. use xpath union
 */

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MatchingTags {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions browOpt = new BrowserType.LaunchOptions().setHeadless(false);
//        Browser browser = playwright.webkit().launch(browOpt);

        browOpt.setChannel("msedge");
        Browser browser = playwright.chromium().launch(browOpt);
        Page page = browser.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        page.locator("span:has-text('SignIn'),span:has-text('LogIn')," +
                "span:has-text('Login'), span:has-text('Signin')")
                .click(); //accommodate for any changes to text/tags
    }
}
