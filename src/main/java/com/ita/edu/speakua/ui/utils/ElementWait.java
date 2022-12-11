package com.ita.edu.speakua.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementWait {
    private final Duration TIMEOUT= Duration.ofSeconds(10);
    private WebDriver driver;
    private WebDriverWait wait;
    public ElementWait(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,TIMEOUT);
    }
    public void visibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void visibility(WebElement element,long seconds){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
       wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void visibility(WebElement element){
       visibility(element, TIMEOUT.getSeconds());
    }
}