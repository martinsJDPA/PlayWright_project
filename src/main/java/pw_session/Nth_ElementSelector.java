package pw_session;
/*
Nth selectorsa re useful; for targeting a particluar index of ordered/unordered series of elements
using nth selection:
"button >> nth=-1" i.e. last button
"button >> nth=0" i.e. first button
 */


import com.microsoft.playwright.*;

public class Nth_ElementSelector {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.bigbasket.com/");

        Locator firstEle = page.locator("div.pr-4 li a >> nth=0");
        String f1_ele = firstEle.textContent();
        System.out.println("First element is: " + f1_ele);

        Locator fourthEle = page.locator("div.pr-4 li a >> nth=4");
        String f4_ele = fourthEle.textContent();
        System.out.println("Fourth element is: " + f4_ele);

        Locator lastEle = page.locator("div.pr-4 li a >> nth=-1");
        String last_ele = lastEle.textContent();
        System.out.println("Last element is: " + last_ele);
        lastEle.click();

    }
}