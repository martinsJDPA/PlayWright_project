package pw_session;
/*
Opening a trace
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
 */

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class TraceView_session {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
            Page page = context.newPage();
            page.navigate("https://www.google.ca/");
            page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
            page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("naveen automation academy");
            page.keyboard().press("Enter");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("NaveenAutomationLabs Naveen AutomationLabs https://academy.naveenautomationlabs.com").setExact(true)).click();
//            page.wait(3000);
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("user admin");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("user@admin@gmail.com");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("123456a.B");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+1 (555) 444-7898");
            page.frameLocator("#microfe-popup-login").getByText("Log in").click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }


    }
}