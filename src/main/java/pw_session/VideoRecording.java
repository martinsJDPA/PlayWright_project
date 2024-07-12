package pw_session;

/* We demosntrate how to record a test process with PW native video recorder

 */

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("myVideos/"))); //set dir for the records
        Page page = context.newPage();
        //navigate to homepage
        page.navigate("https://academy.naveenautomationlabs.com/");
        //click login button
//        page.locator("a[text='Login']").click();
        page.click("text=Login");




        page.waitForTimeout(30000);
        browser.close();
        page.close();
        playwright.close();

    }
}
