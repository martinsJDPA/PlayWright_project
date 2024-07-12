package pw_session;
/*
How to download with PW.
 */

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadingFile {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=2.0/");

        Download download = page.waitForDownload(()->{
            page.click("a:text('chromedriver_mac32.zip')");
        });
        System.out.println(download.url());
//        System.out.println(download.page().title());
        //Show the doanload path
        String path = download.path().toString();
        System.out.println("download path: " + path);

        //We want to save the download to a permanent dir in the project
        download.saveAs(Paths.get("PWdownload.zip"));







        page.waitForTimeout(50000);
        page.close();
        browser.close();
        playwright.close();


    }
}
