package es.unizar.webeng.hello;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EdgeWebDriverContainerTest extends BaseWebDriverContainerTest {

    // 1️. Configuración de Edge
    private EdgeOptions edgeOptions = new EdgeOptions()
            .addArguments("--headless")
            .addArguments("--no-sandbox")
            .addArguments("--disable-dev-shm-usage");

    // 2️. Contenedor de la app
    private GenericContainer<?> app = new GenericContainer<>(
            DockerImageName.parse("lab1-git-race-arianaporroche-modern-web-app-dev:latest"))
            .withExposedPorts(8080)
            .withNetwork(NETWORK)
            .withNetworkAliases("app")
            .waitingFor(new HttpWaitStrategy().forPort(8080).forStatusCode(200).withStartupTimeout(Duration.ofSeconds(60)));

    // 3️. Contenedor de Edge
    public BrowserWebDriverContainer<?> edge = new BrowserWebDriverContainer<>()
            .withCapabilities(edgeOptions)
            .withNetwork(NETWORK);

    // 4️. Arrancar contenedores antes de cada test
    @BeforeEach
    public void setUp() {
        app.start();
        edge.start();
        assertBrowserNameIs(edge, "MicrosoftEdge", edgeOptions);
    }

    // 5️. Detener contenedores al terminar
    @AfterEach
    public void tearDown() {
        edge.stop();
        app.stop();
    }

    // Test exploratorio
    @Test
    public void simpleExploreTest() {
        doSimpleExplore(edge, edgeOptions);
    }

    // Test que comprueba el texto de bienvenida
    @Test
    public void welcomeTextTest() {
        WebDriver driver = edge.getWebDriver();
        String appUrl = "http://app:8080";
        driver.get(appUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement texto = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome to Modern Web App')]")));

        assertNotNull(texto);
    }
}
