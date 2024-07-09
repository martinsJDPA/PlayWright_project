package pw_session;
/*
Using locators types in PW
 */


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class locators {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();
        //Single locator context
//        Page page = context.newPage();
//        page.navigate("https://academy.naveenautomationlabs.com/");
//        Locator loginBtn = page.locator("text = Login");       //locator class
//        System.out.println(loginBtn.count());  ///count the number of specified elements on the page
//        loginBtn.hover();
//        loginBtn.click();

        Page page2 = context.newPage();
        page2.navigate("https://orangehrmlive.com/en/30-day-free-trial");
        //multiple locator context
        Locator countryOptions = page2.locator("select#Form_getForm_Country");
        System.out.println(countryOptions.count());
        countryOptions.click();

        for(int i=0; i<countryOptions.count(); i++){
            String text = countryOptions.nth(i).textContent();
            System.out.println(text);
        }
                  //OR
       List<String> OptionTextList = countryOptions.allTextContents();
       OptionTextList.size();
       for(String t : OptionTextList){
            System.out.println(t);
        }
               //OR
        OptionTextList.forEach(element -> System.out.println(element));

        //Another multiple locator selector
//        Page page3 = context.newPage();
//        page3.navigate("https://www.facebook.com/");
//        page3.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create new account")).click();
//        page3.getByPlaceholder("First name").fill("Audu");
//        Locator monthSelector = page3.locator("select#month"); //choose month dropdown
//        monthSelector.click();
//        for(int m=0; m<monthSelector.count(); m++){
//            String text = monthSelector.nth(m).textContent();
//            System.out.println(text + '\n'); //print out each month
//        }

//        page.close();
//        playwright.close();

    }
}