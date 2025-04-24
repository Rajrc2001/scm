console.log("Script loaded...");

let currentTheme = getTheme();

//change theme button and it's event listner
const changeThemeButton = document.querySelector("#theme_change_button");
changeThemeButton.addEventListener("click", (event) => {
    document.querySelector("html").classList.remove(currentTheme);
    setTheme(currentTheme == "light" ? "dark" : "light");
});

// set theme to webpage on loading from localstorage
document.addEventListener("DOMContentLoaded", () => setTheme(currentTheme));

// setting theme
function setTheme(theme) {
    // update localStorage and currentTheme variable to new theme
    console.log("Changing Theme to " + theme);
    localStorage.setItem("scmTheme", theme);
    currentTheme = getTheme();

    // set theme to web page
    document.querySelector("html").classList.add(currentTheme);
    changeThemeButton.querySelector("span").textContent =
        currentTheme == "light" ? " Dark" : " Light";
}

// get theme from localStorage
function getTheme() {
    let theme = localStorage.getItem("scmTheme");
    return theme ? theme : "light";
}
