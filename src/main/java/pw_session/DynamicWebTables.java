package pw_session;
/*
PW has the inbuilt ":scope" method that allows you to capture contents of a
webtable at once rather than one after another.
This way you can specify rows and columns collectively or individually without
using parent/siblings nth selectors.
 */
import com.microsoft.playwright.*;

public class DynamicWebTables {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
//        page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
//
//        //Capture and print the whole table
//        Locator row = page.locator("table#example tr"); //assign all table rows to "row"
//        //now loop through all rows
//        row.locator(":scope").allInnerTexts().forEach(System.out::println);
//
//
//        //check box for a single row for record named "Ashton COx"
//        page.waitForTimeout(3000);
//        page.reload();
//        row.locator(":scope",new Locator.LocatorOptions()
//                .setHasText("Ashton Cox"))
//                .locator(".dt-select-checkbox")
//                .click();

        page.navigate("https://www.primefaces.org/showcase/ui/data/dataexporter/treetable.xhtml");
        Locator newRow = page.locator("tbody#form\\:tbl_data");
        newRow.locator(":scope").allInnerTexts().forEach(System.out::println);

        newRow.locator(":scope", new Locator.LocatorOptions()
                .setHasText("Desktop"))
                .locator(".ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-hover")
                .click();

    }

}
