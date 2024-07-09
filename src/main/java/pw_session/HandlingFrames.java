package pw_session;

/*
When handling frames/iframes, you must first specify the locator of the frame you are working in and then
the locator of the specific element.
i.e. Locator (iframe) + Locator(element)
 */

import com.microsoft.playwright.*;

public class HandlingFrames {
    public static void  main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
        String hdr = page.frameLocator("frame[name='main']").locator("h2").textContent();
        //also as
        String hdr2 = page.frame("main").locator("h2").textContent();
        System.out.println(hdr);
        System.out.println(hdr2);


        BrowserContext bwsr = browser.newContext();
        Page page2 = bwsr.newPage();
        page2.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        page2.locator("img[title= 'Vehicle-Registration-Forms-and-Examples']").scrollIntoViewIfNeeded();
        System.out.println("Scrolled Into View");
        page2.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
        page2.frameLocator("//iframe[contains(@id, 'frame-one')]").locator("#RESULT_TextField-8")
                .fill("user1 name"); //we use xpath selector here because the id may be unstable
        page2.frameLocator("//iframe[contains(@id, 'frame-one')]").locator("#RESULT_TextField-15")
                .fill("7772224546");

    }
}
