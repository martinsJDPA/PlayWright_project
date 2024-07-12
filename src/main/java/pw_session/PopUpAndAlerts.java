package pw_session;
/*Dealing with Java prompts, alerts and confirmation pop ups

 */

import com.microsoft.playwright.*;

public class PopUpAndAlerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();

        //Pop ups; PW has inbuilt features that auto clicks pop ups
        Page page1 = context.newPage();
        page1.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page1.waitForTimeout(2000);
        page1.click("//button[text()='Click for JS Alert']");
        //PW has inbuilt features that auto clicks pop ups, so you will see it disappear with effort
        String result = page1.textContent("#result");
        System.out.println(result+"\n");

        //on Dialog listener: alert(), confirm(), prompt() dialogs can listen for JS prompts/Confirm Prompts
        // and auto dismiss/accept them
        page1.reload();
        page1.onDialog(dialog -> {
            String txt = dialog.message();
            System.out.println(txt);
            dialog.accept();
        });
        page1.click("//button[text()='Click for JS Confirm']");
        page1.waitForTimeout(2000);


        //For JS Prompts
        Page page2 = context.newPage();
        page2.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page2.onDialog(dialog -> {
            String txt = dialog.message();
            System.out.println(txt);
            dialog.accept("I confirm this JS Prompt \n");
        });
        page2.click("//button[text()='Click for JS Prompt']");


/* Without onDialog, PW can still dismiss prompts

 */
        page2.waitForTimeout(10000);
//        page1.close();
        browser.close();
        playwright.close();
    }
}
