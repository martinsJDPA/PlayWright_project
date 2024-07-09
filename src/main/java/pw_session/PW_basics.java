package pw_session;

/*
at the first instance of launching a browser, it checks for browser binaries and
downloads them if they're missing into a local dir.
Alternatively, download binaries via CLI
see https://playwright.dev/java/docs/browsers
 */
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PW_basics {
    public static void main(String[] args) {
        //create/instantiate playwright
        Playwright playwright = Playwright.create();
        //launch a browser
//        Browser browser = playwright.chromium().launch
        //Headless by default. Activate headful mode
//        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        /* OR specify the browser
        BrowserType.LaunchOptions browserOptions = new BrowserType.LaunchOptions().setHeadless(false);
        browserOptions.setChannel("msedge");
        Browser browser = playwright.chromium().launch(browserOptions);
         */

        browser.newPage();
        //create a browser context
        Page page = browser.newPage();
        page.navigate("https://www.amazon.ca/");
//        page.navigate("https://oasis-trim-manager-qa2.qa.is.autodatacorp.org/");

        String title = page.title();
        System.out.println("Page title is:  "+ title);

        String url = page.url();
        System.out.println("Page url is:  "+ url);

        browser.close();
        playwright.close();

    }
}
