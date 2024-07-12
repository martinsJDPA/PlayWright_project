package pw_session;

/* At this time, PW doesn't have a native browser window management method i.e. manage.maximize.
You have to specify the dimensions you want it scaled to.
 */

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ViewportSize;

import java.awt.*;

public class WindowsManagement {

    public static void main(String[] args) {
        //First let's find out the default dimension of the browser window
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Default screen size: " + scrSize);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext brContxt = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(650, 580));
        Page page = brContxt.newPage();
        page.navigate("https://www.google.com");
        //verify new dimension
        ViewportSize newSize = page.viewportSize();
        int wid = newSize.width;
        int ht = newSize.height;
        System.out.println("New Browser size: " + wid + " x " + ht);



    }


}
