package pw_session;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

/*
There is an approach in which we can use CodeGen to target elements in a way that we normally can't
using locastors and selectors.

Steps:
1. codegen the url
2. On the DevTool Console, clear the contents and use the "playwright $(locators/selectors)
to locate the desired nested tag e.g playwright.$("select#Form_getForm_Country:has(option[value='India'])")
3. copy and paste the tag to your IDE
 */
public class NestedElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions browOpt = new BrowserType.LaunchOptions().setHeadless(false);
//        Browser browser = playwright.webkit().launch(browOpt);

        browOpt.setChannel("chrome");
        Browser browser = playwright.chromium().launch(browOpt);
        Page page = browser.newPage();
        page.navigate("https://orangehrmlive.com/en/30-day-free-trial");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales")).click();
        Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
        loc.allInnerTexts().forEach(e -> System.out.println(e));

        //Another browser context
        BrowserContext context = browser.newContext();
        Page page2 = context.newPage();
        page.navigate("https://www.amazon.ca/");
        Locator footerList = page.locator("div.navFooterLinkCol:has(a[href='https://associates.amazon.ca'])");
        footerList.allInnerTexts().forEach(f -> System.out.println(f));

//        page.close();
        browser.close();
        playwright.close();

    }

}
