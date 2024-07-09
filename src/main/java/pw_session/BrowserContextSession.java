package pw_session;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextSession {
    public static void main(String[] args){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext brcxt1 = browser.newContext();
        Page p1 = brcxt1.newPage();
        p1.navigate("http://www.automationpractice.pl/index.php");
        p1.fill("#search_query_top", "dress shoe");
        System.out.println(p1.title());

        BrowserContext brcxt2 = browser.newContext();
        Page p2 = brcxt2.newPage();
        p2.navigate("https://naveenautomationlabs.com/opencart/");
        p2.getByPlaceholder("Search").fill("shoes");
        p2.keyboard().press("Enter");
        System.out.println(p2.title());
    }
}
