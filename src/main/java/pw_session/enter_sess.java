package pw_session;

import com.microsoft.playwright.*;

import java.io.DataInput;
import java.lang.String;
import java.nio.file.Paths;

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

//        page.keyboard().press("Shift+KeyA");
//// or
//        page.keyboard().press("Shift+A");

//        page.keyboard().type("Hello World!");
//        page.keyboard().press("ArrowLeft");
//        page.keyboard().down("Shift");
//        for (int i = 0; i < " World".length(); i++)
//            page.keyboard().press("ArrowLeft");
//        page.keyboard().up("Shift");
//        page.keyboard().press("Backspace");


//        page.navigate("https://keycode.info");
//        page.keyboard().press("A");
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("A.png")));
//        page.keyboard().press("ArrowLeft");
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ArrowLeft.png")));
//        page.keyboard().press("Shift+O");
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("O.png")));
//        page.waitForTimeout(2000);
//        page.close();


    }
}
