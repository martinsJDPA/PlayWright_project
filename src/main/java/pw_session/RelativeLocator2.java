package pw_session;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocator2 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://amazon.ca/");
        page.locator("input[id='twotabsearchtextbox']").fill("Phones");
        page.keyboard().press("Enter");
        System.out.println("phones searched at this point");
        page.locator("div[id='brandsRefinements']").scrollIntoViewIfNeeded();
        System.out.println("\n scrolled Into view");

        page.locator("input[type='checkbox']:near(:text('Samsung'))")
                .first().click();

    }
}
