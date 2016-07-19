package ren.yueh.crap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by yueh on 2016/7/16.
 * 遍历读取HTML元素
 */
public class Scanner {

    private CarpContext carpContext;

    private Elements elements;

    private int elementIndex = 0;

    public Scanner(CarpContext carpContext, Document doc) {
        this.carpContext = carpContext;
        getElements(doc);
    }

    public Element nextElement() {
        if (elements == null || elements.isEmpty() || elementIndex >= elements.size()) {
            return null;
        } else {
            return elements.get(elementIndex++);
        }
    }

    private void getElements(Document doc) {
        elements = new Elements();
        HtmlItem htmlItem = carpContext.getRootHtmlItem();
        if (htmlItem != null) {
            if (!htmlItem.getAttrValue().isEmpty()) {
                Elements tempElems = doc.getElementsByAttributeValue(htmlItem.getAttrKey(), htmlItem.getAttrValue());
                for (Element tempElem : tempElems) {
                    if (tempElem.tagName().equals(htmlItem.getTag())) {
                        tempElem.getAllElements();
                        elements.addAll(tempElem.getAllElements());
                    }
                }
            } else if (!htmlItem.getAttrKey().isEmpty()) {
                Elements tempElems = doc.getElementsByAttribute(htmlItem.getAttrKey());
                for (Element tempElem : tempElems) {
                    if (tempElem.tagName().equals(htmlItem.getTag())) {
                        tempElem.getAllElements();
                        elements.addAll(tempElem.getAllElements());
                    }
                }
            } else {
                Elements tempElems = doc.getElementsByTag(htmlItem.getTag());
                for (Element tempElem : tempElems) {
                    tempElem.getAllElements();
                    elements.addAll(tempElem.getAllElements());
                }
            }
        } else {
            elements = doc.getAllElements();
        }
    }
}
