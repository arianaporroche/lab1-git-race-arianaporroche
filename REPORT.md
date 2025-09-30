# Lab 1 Git Race -- Project Report
**Author:** Ariana Porroche Llorén (874055)

**Date:** 24th September 2025

**Course:** Web Engineering


## Description of Changes
1. Dark/light mode toggle implementation (enhanced User Experience)
    - Added CSS classes in the file `styles.css` for dark and light modes
    - Updated the file `welcome.html` to include button and new classes
    - Added the JavaScript file `dark-light-mode.js` to handle the toggle functionality and store user preference
    - Tested the new feature:
        - 1 integration test in `IntegrationTest` to verify that the home page contains the dark/light mode button
        - 1 UI acceptance test `DarkLightModeSeleniumTest` to verify that the icon changes correctly between moon (dark) and sun (light)
2. Testcontainers Integration for Browser UI Testing
    - Added automated UI tests using Selenium WebDriver with Testcontainers for multiple browsers
    - Implemented tests for:
        - **Chrome** (`ChromeWebDriverContainerTest`)
        - **Firefox** (`FirefoxWebDriverContainerTest`)
        - **Edge** (`EdgeWebDriverContainerTest`)
    - Tests run inside Docker containers, ensuring consistency and isolation from the host environment
    - All tests validate:
        - Browser can start successfully in a container
        - Page loads correctly
        - Browser name matches expected capabilities
        - VNC URLs are accessible for visual debugging


## Technical Decisions
1. Dark/light mode toggle implementation
    - CSS-based toggling: Created a `dark-mode` class on the `body` element to switch between dark and light themes
    - Persistence: Stored the user's preference for dark or light mode using the browser's `localStorage`, so the choice persists across sessions without server-side storage
    - UI Acceptance Testing: Used `Selenium` to simulate user interactions with the browser and validate dynamic UI changes, ensuring the mode toggle behaves correctly
2. Testing and CI/CD Pipeline
    - GitHub Actions: Set up a workflow to automate testing and deployment processes, ensuring code quality and reducing manual intervention
    - Automated Testing: Integrated unit tests, integration tests, UI acceptance tests, and Testcontainers-based browser tests to catch issues early in the development process
    - Testcontainers: 
        - Containers start with headless mode for CI/CD efficiency
        - Chrome, Firefox, and Edge containers used for cross-browser testing
        - Each test starts a fresh browser container, runs assertions, and closes the container to avoid resource leaks


## User Documentation
1. Dark/Light Mode Toggle
    - Locate the toggle button on the top-right corner of the navigation bar (represented by a moon/sun icon)
    - Click the button to switch between dark and light modes
    - The selected mode will be saved and applied on future visits
2. Running UI Acceptance Tests
    - The tests are automated using Selenium WebDriver with Testcontainers
    - Run `./gradlew test` to execute all unit, integration, and UI acceptance tests, including Chrome, Firefox, and Edge containerized tests
    - Tests ensure the page loads correctly in each browser and dynamic elements like the dark/light mode toggle function as expected


## Learning Outcomes
- Learned how to implement a dark/light mode toggle using `HTML`, `CSS` and `JavaScript`
- Understood how to use `localStorage` for persisting user preferences
- Strengthened understanding of the importance of user experience
- Improved skills in writing and executing automated tests using `JUnit`
- Learned how to use `Selenium WebDriver` for UI acceptance testing
- Gained experience with Testcontainers to run browser tests in isolated Docker containers (Chrome, Firefox, Edge)
- Practiced using `Gradle tasks`, `Git Workflows` and `GitHub Actions`


## AI Disclosure
### AI Tools Used
- ChatGPT-5

### AI-Assisted Work
- Generated part of the documentation to save writing time
- Assisted in understanding how to change a Bootstrap element class in HTML (body.classList) to apply custom colors
- Assisted in writing the Selenium WebDriver test for the dark/light mode button, as Selenium was previously unfamiliar

#### Percentage of AI-Assisted vs. Original work
- Percentage of AI-assisted work: 40%
- Percentage of original work: 60%

#### Modifications made to AI-Generated code
- AI-generated suggestions were adapted and modified:
    - Modified the proposed CSS classes to fit the existing design
    - Modified the generated documentation to accurately reflect the work done
    - Added section detailing Testcontainers setup and cross-browser testing

### Original Work
- Design and implementation of the dark/light mode toggle appearance
- Integration test to verify the presence of the dark/light mode button
- CSS classes for dark and light modes
- JavaScript code to handle the toggle functionality and store user preference
- Testcontainers integration for Chrome, Firefox, and Edge browsers
#### Learning process
- Learned how to effectively use AI tools to accelerate documentation and understand new technologies such as `Selenium WebDriver` and `Testcontainers`
- Learned to critically evaluate and adapt AI-generated content to fit project requirements and maintain code quality
