package es.unizar.webeng.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class EdgeWebDriverContainerTest extends BaseWebDriverContainerTest {

    // junitRule {
    public BrowserWebDriverContainer<?> edge = new BrowserWebDriverContainer<>()
        .withCapabilities(new EdgeOptions())
        // }
        .withNetwork(NETWORK);

    @BeforeEach
    public void checkBrowserIsIndeedMSEdge() {
        edge.start();
        assertBrowserNameIs(edge, "MicrosoftEdge", new EdgeOptions());
    }

    @Test
    public void simpleExploreTest() {
        doSimpleExplore(edge, new EdgeOptions());
    }
}
