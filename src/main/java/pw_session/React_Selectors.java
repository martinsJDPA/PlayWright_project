package pw_session;
/* Some websites are built with React framewoprk, hence Playwright has in built
tools for identifying their locators.
2. Precede REACT locators with "_react" component.
NB: You can find out which web portal are using REACT by using an add-on/extension
called "React Dev tool".
 */

import com.microsoft.playwright.*;

public class React_Selectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.netflix.com/ca/");

        page.locator("_react=UISelector[data-uia='language-picker']").click();

        Locator email = page.locator("_react=p[name='emv211'] >> input").first();
        email.click();
        email.fill("mea@gmail.com");

        Locator footer = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']");
//        footer.allInnerTexts().forEach(e -> System.out.println(e)); //OR
        footer.allInnerTexts().forEach(System.out::println);

    }
}
