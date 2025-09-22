// Dark Light Mode Script
document.addEventListener('DOMContentLoaded', function() {
    const body = document.body;
    const darkLightModeBtn = document.getElementById('darkLightModeBtn');
    const modeIcon = document.getElementById('modeIcon');

    // Save the mode
    if (localStorage.getItem("theme") === "dark") {
        body.classList.add("dark-mode");
        modeIcon.classList.replace("bi-moon-fill", "bi-sun-fill");
    }

    // Change the dark/light mode when click
    darkLightModeBtn.addEventListener('click', async function() {
        body.classList.toggle("dark-mode");

        if (body.classList.contains("dark-mode")) {
            modeIcon.classList.replace("bi-moon-fill", "bi-sun-fill");
            localStorage.setItem("theme", "dark");
        } else {
            modeIcon.classList.replace("bi-sun-fill", "bi-moon-fill");
            localStorage.setItem("theme", "light");
        }
    });
});