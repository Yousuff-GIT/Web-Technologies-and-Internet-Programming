package com.tutorialfinder.service;

// Business logic class to return tutorial site based on language
public class DataFinder {
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTutorials(String lang) {
        if (lang.equalsIgnoreCase("java"))
            setWebsite("www.javatpoint.com");
        else if (lang.equalsIgnoreCase("dotnet"))
            setWebsite("www.tutorialspoint.com");
        else if (lang.equalsIgnoreCase("html"))
            setWebsite("www.w3schools.com");
        else if (lang.equalsIgnoreCase("css"))
            setWebsite("www.csstricks.com");
        else
            setWebsite("Sorry! Language not supported");
        return getWebsite();
    }
}
