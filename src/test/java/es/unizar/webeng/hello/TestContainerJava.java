package es.unizar.webeng.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;


public class TestContainerJava extends BaseWebDriverContainerTest {

    // junitRule {
    public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
        .withCapabilities(new ChromeOptions())
        // }
        .withNetwork(NETWORK);

    @BeforeEach
    public void checkBrowserIsIndeedChrome() {
        chrome.start();
        assertBrowserNameIs(chrome, "chrome", new ChromeOptions());
    }

    @Test
    void simpleExploreTest() {
        doSimpleExplore(chrome, new ChromeOptions());
    }



    // @Test
    // void testNavegadorChrome() {
    //     assertTrue(true);




        // try (BrowserWebDriverContainer<?> chrome =
        //              new BrowserWebDriverContainer<>()
        //                      .withCapabilities(new ChromeOptions())) {

        //     chrome.start();

        //     // Aquí puedes usar chrome.getWebDriver() para abrir URLs y hacer asserts
        //     assertTrue(true);

        // } 
}
