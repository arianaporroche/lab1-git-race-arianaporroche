# Lab 1 Git Race -- Project Report

## Description of Changes
1. Dark/light mode toggle implementation (enhaced User Experience)
    - Added CSS classes in the file `styles.css` for dark and light modes
    - Updated the file `welcome.html` to include the toggle
    - Tested the new feature:
        - 1 integration test `DarkLightModeButtonTest` to verify that the home page contains de dark/light mode button
        - 1 UI acceptance test `DarkLightModeSeleniumTest` to verify that the icon changes correctly between moon (dark) and sun (light)

## Technical Decisions
1. Dark/light mode toggle implementation
    - CSS-based toggling: Created a `dark-mode` class on the `body` element to switch between dark and light themes.
    - Persistence: Stored the user's preference for dark or light mode using the browser's `localStorage`, so the choice persists across sessions without server-side storage.
    - UI Acceptance Testing: Used `Selenium` to simulate user interactions with the browser and validate dynamic UI changes, ensuring the mode toggle behaves correctly.

## Learning Outcomes
[What you learned from this assignment]

## AI Disclosure
### AI Tools Used
- [List specific AI tools used]

### AI-Assisted Work
- [Describe what was generated with AI assistance]
- [Percentage of AI-assisted vs. original work]
- [Any modifications made to AI-generated code]

### Original Work
- [Describe work done without AI assistance]
- [Your understanding and learning process]