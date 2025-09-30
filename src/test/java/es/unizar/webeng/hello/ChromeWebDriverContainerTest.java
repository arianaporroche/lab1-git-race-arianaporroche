package es.unizar.webeng.hello;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;


public class ChromeWebDriverContainerTest extends BaseWebDriverContainerTest {

    private ChromeOptions chromeOptions = new ChromeOptions()
            .addArguments("--headless")
            .addArguments("--no-sandbox")
            .addArguments("--disable-dev-shm-usage");


    // junitRule {
    public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
        .withCapabilities(chromeOptions)
        // }
        .withNetwork(NETWORK);

    @BeforeEach
    public void checkBrowserIsIndeedChrome() {
        chrome.start();
        assertBrowserNameIs(chrome, "chrome", chromeOptions);
    }

    @AfterEach
    public void stopChrome() {
        chrome.close();
    }


    @Test
    public void simpleExploreTest() {
        doSimpleExplore(chrome, chromeOptions);
    }
}
