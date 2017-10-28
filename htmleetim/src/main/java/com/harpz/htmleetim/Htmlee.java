package com.harpz.htmleetim;

import com.harpz.htmleetim.reflection.PickAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Htmlee {


    public <T>T fromHtml(String html, Class<T> classOfT) {

        return fromHtml(html,classOfT.getName());
    }


    public <T>T fromHtml(String html, String classOfTName) {
            if(html.isEmpty()) return null;
        return fromHtml(Jsoup.parse(html),classOfTName);
    }

    private <T>T fromHtml(Element element, String classOfName) {

        PickAdapter<T> pickAdapter = new PickAdapter<>();
         return pickAdapter.read(element,classOfName);
    }


}
