package com.dlex.OOC.Week7.HTML;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Link link = new Link();
        WebLink facebook = new WebLink("www.facebook.com");
        WebLink google = new WebLink("www.google.com");
        List<WebLink> links = new ArrayList<>();
        links.add(facebook);
        links.add(google);
        link.insertLink(links);
    }
}
