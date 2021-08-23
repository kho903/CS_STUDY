package com.company.design.proxy;

public class BrowserProxy implements IBrowser {
    private String url;
    private HTML html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public HTML show() {
        if (html == null) {
            this.html = new HTML(url);
            System.out.println("BrowserProxy loading html from : " + url);
        }
        System.out.println("BrowserProxy use cache html : " + url);
        return html;
    }
}
