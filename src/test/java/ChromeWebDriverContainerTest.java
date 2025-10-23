// package es.unizar.webeng.hello;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class ChromeWebDriverContainerTest extends BaseWebDriverContainerTest {

    // 1️. Configuración de Chrome
    private ChromeOptions chromeOptions = new ChromeOptions()
            .addArguments("--headless")
            .addArguments("--no-sandbox")
            .addArguments("--disable-dev-shm-usage");

    // 2️. Contenedor de la aplicación
    private GenericContainer<?> app = new GenericContainer<>(
            DockerImageName.parse("lab1-git-race-arianaporroche-modern-web-app-dev:latest"))
            .withExposedPorts(8080)
            .withNetwork(NETWORK)
            .withNetworkAliases("app")
            .waitingFor(new HttpWaitStrategy().forPort(8080).forStatusCode(200).withStartupTimeout(Duration.ofSeconds(60)));

    // 3. Contenedor de Chrome
    public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
        .withCapabilities(chromeOptions)
        .withNetwork(NETWORK);

    // 4️. Arrancar contenedores antes de cada test
    @BeforeEach
    public void checkBrowserIsIndeedChrome() {
        app.start();
        chrome.start();
        assertBrowserNameIs(chrome, "chrome", chromeOptions);
    }

    // 5️. Detener contenedores al terminar
    @AfterEach
    public void stopChrome() {
        chrome.stop();
        app.stop();
    }

    // Test exploratorio simple del contendor de Chrome
    @Test
    public void simpleExploreTest() {
        doSimpleExplore(chrome, chromeOptions);
    }

    // Test que comprueba el texto de bienvenida
    @Test
    public void welcomeTextTest() {
        WebDriver driver = chrome.getWebDriver();

        // Accede a la app mediante el alias dentro de la red Docker
        String appUrl = "http://app:8080";
        driver.get(appUrl);

        // Esperar hasta que aparezca el texto
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement texto = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome to Modern Web App')]")));

        assertNotNull(texto);
    }
}
