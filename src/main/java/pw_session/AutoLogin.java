package pw_session;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AutoLogin {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setStorageStatePath(Paths.get("applogin.json"))); //sends for credentials from storage json
        Page page = context.newPage();

        page.navigate("http://www.automationpractice.pl/");


        page.waitForTimeout(30000);
        page.close();
        playwright.close();
    }
}
