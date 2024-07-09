package pw_session;
/*
This script is generated via CodeGen
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen <url>"

 */

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByText("Sign up").click();

            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("ade");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("ade@ademail.com");

            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("hsdddudhd76sgfs%");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+1 (222) 555-11145");
//            page.pause();

        }
    }
}
