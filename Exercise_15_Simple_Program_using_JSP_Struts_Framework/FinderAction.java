package com.tutorialfinder.action;

import com.tutorialfinder.service.DataFinder;

// Struts Action class to handle logic and pass result to JSP
public class FinderAction {
    private String tutorialsite;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTutorialsite() {
        return tutorialsite;
    }

    public void setTutorialsite(String tutorialsite) {
        this.tutorialsite = tutorialsite;
    }

    public String execute() {
        DataFinder datafinder = new DataFinder();
        setTutorialsite(datafinder.getTutorials(getLanguage()));
        return "success";
    }
}
