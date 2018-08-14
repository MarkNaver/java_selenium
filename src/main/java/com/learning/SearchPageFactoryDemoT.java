package com.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageFactoryDemoT {
    WebDriver driver;

    @FindBy(id = "tab-flight-tab")
    WebElement getFightTab;

    @FindBy(id = "flight-type-one-way-label")
    WebElement fightTab;

    @FindBy(id = "flight-type-roundtrip-label")
    WebElement roundTrip;

    @FindBy(id = "flight-type-multi-dest-label")
    WebElement multipleDestination;

    @FindBy(id = "flight-origin")
    WebElement origin;

    @FindBy(id = "flight-destination")
    WebElement destination;

    @FindBy(id = "flight-departing")
    WebElement departure;

    @FindBy(xpath = "//button/span[@class='icon icon-close']")
    WebElement closeIcon;

    @FindBy(id = "search-button")
    WebElement searchButton;

    @FindBy(xpath = "//button[@class='datepicker-close-btn close btn-text']")
    WebElement closeCalIcon;

    public SearchPageFactoryDemoT(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTab() {
        getFightTab.click();
    }

    /***
     * Click Fight Tab
     */
    public void clickFightTab() {
        fightTab.click();
    }

    /***
     * Click Round Trip
     */
    public void clickRoundTrip() {
        roundTrip.click();
    }

    /***
     * Click Multiple Destination
     */
    public void clickMultipleDestination() {
        multipleDestination.click();
    }

    /***
     * Click Close Icon
     */
    public void clickCloseIcon() {
        closeIcon.click();
    }

    /***
     * Set Origin City
     *
     * @param originCity
     */
    public void setOriginCity(String originCity) {
        origin.sendKeys(originCity);
    }

    /***
     * Set Destination City
     *
     * @param destinationCity
     */
    public void setDestinationCity(String destinationCity) {
        destination.sendKeys(destinationCity);
    }

    /***
     * Set Departure Date
     *
     * @param departureDate
     */
    public void setDeaprtureDate(String departureDate) {
        departure.sendKeys(departureDate);
    }

    /***
     * Click Search Button
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /***
     * Click Calendar Menu close icon
     */
    public void clickCalendar() {
        closeCalIcon.click();
    }
}
