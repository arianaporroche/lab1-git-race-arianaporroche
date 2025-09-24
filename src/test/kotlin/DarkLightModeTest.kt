package es.unizar.webeng.hello.darklightmode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_aPORT)
class DarkLightModeSeleniumTest {

    @LocalServerPort
    private var port: Int = 0

    private lateinit var driver: WebDriver

    @BeforeEach
    fun setup() {
        val options = ChromeOptions()
        options.addArguments("--headless")
        options.addArguments("--disable-gpu")
        options.addArguments("--window-size=1920,1080")

        driver = ChromeDriver(options)
        driver.get("http://localhost:$port/")
    }

    @AfterEach
    fun teardown() {
        driver.quit()
    }

    @Test
    fun `should update body class and button icon when dark light mode button is toggled`() {
        val body = driver.findElement(By.tagName("body"))
        val btn = driver.findElement(By.id("darkLightModeBtn"))
        val icon = driver.findElement(By.id("modeIcon"))

        assertThat(body.getAttribute("class")).doesNotContain("dark-mode")
        assertThat(icon.getAttribute("class")).contains("bi-moon-fill")

        btn.click()
        assertThat(body.getAttribute("class")).contains("dark-mode")
        assertThat(icon.getAttribute("class")).contains("bi-sun-fill")

        btn.click()
        assertThat(body.getAttribute("class")).doesNotContain("dark-mode")
        assertThat(icon.getAttribute("class")).contains("bi-moon-fill")
    }
}
