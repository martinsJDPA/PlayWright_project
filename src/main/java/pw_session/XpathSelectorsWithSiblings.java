package pw_session;

import com.microsoft.playwright.*;

import javax.swing.*;

public class XpathSelectorsWithSiblings {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

        //Xpath: with parent and uncles locators
        page.locator("//a[text()= 'Joe.Root']/parent::td/preceding-sibling::td//input[@type='checkbox']").click();
        page.locator("//a[text()= 'Kevin.Mathews']/parent::td/preceding-sibling::td//input[@type='checkbox']").click();

        //check all the boxes on the table one after another
        page.reload();
        Locator checkAll = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
        for(int i=0; i<checkAll.count(); i++){
            checkAll.nth(i).click();
        }

        //indexing of nth selector
        page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[2]").click();
        page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
    }
    }
