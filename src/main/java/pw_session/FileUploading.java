package pw_session;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploading {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.waitForTimeout(2000);
        page.setInputFiles("input#filesToUpload", Paths.get("src/main/resources/loresIpsom.txt"));
        //remove file upload
        page.waitForTimeout(2000);
        page.setInputFiles("input#filesToUpload", new Path[0]);

        //upload multiple files
        page.reload();
        page.setInputFiles("input#filesToUpload", new Path[]{
                Paths.get("src/main/resources/loresIpsom.txt"),
                Paths.get("O.png"),
                Paths.get("A.png")
        });

        //Create a file on the fly for upload i.e. runtime file upload
        page.reload();
        page.setInputFiles("input#filesToUpload", new FilePayload("marto.text",
                "text/plain",
                        "this is a newly created file for upload in PW!"
                                .getBytes(StandardCharsets.UTF_8)));


        //We can confirm if created file was properly written
        page.waitForTimeout(2000);
        Page p2 = context.newPage();
        p2.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
        p2.setInputFiles("input[name='upfile']",new FilePayload("marto.text",
                "text/plain", //google "file types mime"
                "this is a newly created file for upload in PW!"
                        .getBytes(StandardCharsets.UTF_8)));
        p2.click("input[value='Press']");


        page.waitForTimeout(20000);
        browser.close();
        playwright.close();
    }
}
