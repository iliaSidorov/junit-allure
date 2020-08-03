package ru.appline.junitAllure.managers;

public class PageManager {

    private static PageManager pageManager;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
}
