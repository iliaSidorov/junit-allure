package ru.appline.junitAllure.managers;

import ru.appline.junitAllure.pages.ContributionPage;
import ru.appline.junitAllure.pages.ServiceMenuPage;

public class PageManager {

    private static PageManager pageManager;

    private ServiceMenuPage serviceMenuPage;
    private ContributionPage contributionPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public ServiceMenuPage getServiceMenuPage() {
        if (serviceMenuPage == null) {
            serviceMenuPage = new ServiceMenuPage();
        }
        return serviceMenuPage;
    }

    public ContributionPage getContributionPage() {
        if (contributionPage == null) {
            contributionPage = new ContributionPage();
        }
        return contributionPage;
    }
}
