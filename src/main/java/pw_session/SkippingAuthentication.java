package pw_session;
/*
Sometimes you want to avoid repeating login process on the same website during testing.
PlayWright has functionality (storageState) to help you sign in once and then skip it in subsequent steps
or repeat actions.
This type of file is usually a one-time activity
 */

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class SkippingAuthentication {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brContxt = browser.newContext();
        Page page = brContxt.newPage();

        page.navigate("https://www.automationpractice.pl/");
        page.click("a:text('Sign in')");
//        page.fill("#email", "<username>"); //uncomment to use
        page.fill("#passwd", "Selenium@12345"); //uncomment to use
        page.click("#SubmitLogin");

        //Having signed in once, the login credentials is stored into a json storage that can be reapplied at different times
        brContxt.storageState(new BrowserContext.StorageStateOptions()
                .setPath(Paths.get("applogin.json")));

/*
We shall implement this automated credentialing in another file "autologin.java"
 */



        page.waitForTimeout(30000);
        page.close();
        playwright.close();
    }
}
