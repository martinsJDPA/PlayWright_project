package pw_session;
/*
Shadow Root is quite similar to iframes; it is a hierarchical structure. To target an element inside a
shadow root, the root must be set to Open.
 */

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class ShadowDOms {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //Page -- DOM --> Shadow DOM --> elements
        //Page -- DOM --> iFrame --> Shadow DOM  --< element
        Page page = browser.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        String textIput = "Lord of the Rings";
        page.locator("book-app[apptitle='BOOKS'] #input").fill(textIput);
//        String Output = page.locator("book-app[apptitle='BOOKS'] #input").textContent();
//        assertThat(page.locator("book-app[apptitle='BOOKS'] #input")).hasValue(textIput);

        //Shadowroot + frame
//        BrowserContext context = browser.newContext();
//        Page shadowPage = context.newPage();

    }
}


