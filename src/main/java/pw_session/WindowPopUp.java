package pw_session;
/* We demonstrate how to handle new window popup that produces new tabs from hyperlinks

 */

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class WindowPopUp {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //Create browser contexts
        BrowserContext bx1 = browser.newContext();
        Page page1 = bx1.newPage();

        page1.navigate("https://opensource-demo.orangehrmlive.com/");
        //trigger a new window popup
        page1.waitForTimeout(2000);
        Page popup = page1.waitForPopup(()->{
            page1.getByRole(AriaRole.LINK).nth(3).click();
        });
        System.out.println("Pop up window url: "+popup.url());
        page1.waitForTimeout(5000);
        popup.close(); //close the new tab
        System.out.println("parent window title: "+page1.title()); //verify old page is active
        page1.waitForTimeout(2000);
        page1.close();

        //Manually create a new window/tab
        BrowserContext bx2 = browser.newContext();
        Page page2 = bx2.newPage();
        page2.navigate("https://opensource-demo.orangehrmlive.com/");
        Page popNew = page2.waitForPopup(()->{
            page2.click("a[target='_blank']"); //open a blank new tab
        });
        popNew.waitForLoadState(); //allow to fully load
        popNew.navigate("https://google.com/");
        System.out.println("New pop window title: "+popNew.title());
        popNew.waitForTimeout(4000);
        popNew.close();
        System.out.println("Parent window title: "+page2.title());
        page2.close();

        browser.close();
        playwright.close();
    }
}
