package pw_session;
/*
Relative locators (e.g. below, above, left-of, right-of, near) can be used to specify elements that are close to each other i.e.
use the relatove locations of one element to specify another.This is especially
useful when the location of an element is unstable

 */

import com.microsoft.playwright.*;

import java.util.List;

public class RelativeLocator1 {
    static Page page;

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

        page.locator("table[id='resultTable']").scrollIntoViewIfNeeded();
//        page.locator("input[type='checkbox']:left-of(:text-is('Joe.Root'))")
//                .first().click(); //OR
//        page.locator("input[id='ohrmList_chkSelectRecord_21']:left-of(:text('Joe.Root'))").click();

        //above of
        String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
        System.out.println("User above current user is: " + aboveUser);

        //Below of
        String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
        System.out.println("User below current user  is: " + belowUser);

        //Near to  ...uses pixels count
        Locator nearElements = page.locator("td:near(:text('Joe.Root'), 400)");
        //append all possible td elements near the pry text element
        List<String> nearEleText =  nearElements.allInnerTexts();
        System.out.println("\n=======NEAR ELEMENTS========");
        for(String element : nearEleText) {
            System.out.println(element);
        }
        System.out.println("=======END=========\n");



        //Call in the methods that check boxes for multiple users get their roles
//        selectUser("Joe.Root");
//        selectUser("John.Smith");
//        System.out.println("Joe Root's user role is "+ getUserRole("Joe.Root"));
//        System.out.println("John Smith's user role is "+ getUserRole("John.Smith"));

        }

        // Create methods that check multiple boxes for different usernames and also check their roles
        public static void selectUser(String userName){
        page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))")
                .first().click();
    }

        public static String getUserRole(String userName){
            return page.locator("td:right-of(:text('"+userName+"'))").first().textContent();
        }


}
