package es.unizar.webeng.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class FirefoxWebDriverContainerTest extends BaseWebDriverContainerTest {

    private FirefoxOptions firefoxOptions = new FirefoxOptions()
            .addArguments("--headless")
            .addArguments("--no-sandbox")
            .addArguments("--disable-dev-shm-usage");

    // junitRule {
    public BrowserWebDriverContainer<?> firefox = new BrowserWebDriverContainer<>()
            .withCapabilities(firefoxOptions)
            // }
            .withNetwork(NETWORK);

    @BeforeEach
    public void checkBrowserIsIndeedFirefox() {
        firefox.start();
        assertBrowserNameIs(firefox, "firefox", firefoxOptions);
    }

    @Test
    public void simpleExploreTest() {
        doSimpleExplore(firefox, firefoxOptions);
    }
}
