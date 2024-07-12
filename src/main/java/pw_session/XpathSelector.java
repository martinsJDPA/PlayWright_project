package pw_session;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class XpathSelector {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.ca");

        //using Xpath is preceded with "//"
        page.locator("//input[@id='twotabsearchtextbox']").fill("macbook");
        page.waitForTimeout(2000);

        page.keyboard().press("ArrowDown");
        page.waitForTimeout(2000);
//        page.keyboard().press("ArrowDown");
//        page.waitForTimeout(2000);
        page.keyboard().press("Enter");

        //look for all text constaining word "amazon"
        Locator allLinks = page.locator("//a[contains(text(),'Amazon')]");
        System.out.println(allLinks.count());
        allLinks.allInnerTexts().forEach(System.out::println);

    }
}