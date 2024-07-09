package pw_session;

import com.microsoft.playwright.*;

import java.io.DataInput;
import java.lang.String;

public class enter_sess {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions bt = new BrowserType.LaunchOptions().setHeadless(false);
        bt.setChannel("chrome");
        Browser browser = playwright.chromium().launch(bt);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.google.ca/");

        page.frameLocator("iframe[name=\"callout\"]").getByLabel("Stay signed out").click(); //clear pop alert
        page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
        page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("naveen automation academy");
        page.keyboard().press("Enter");



//        browser.close();
//        playwright.close();

    }
}
