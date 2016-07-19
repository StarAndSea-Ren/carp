package ren.yueh.crap;

import android.view.View;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

/**
 * Created by yueh on 2016/7/16.
 * 根据读取的HTML元素与待解析模板生成View集合
 */
public class Parser {

    private ArrayList<View> views;
    private Scanner scanner;
    private Document doc;
    private CarpContext carpContext;
    private ArrayList<CvtItem> items;

    public Parser(CarpContext carpContext, Document doc) {
        this.doc = doc;
        this.carpContext = carpContext;
        items = carpContext.getTemplet().getTransformItems();
        scanner = new Scanner(carpContext, doc);
    }

    public ArrayList<View> parse() {
        Element element;
        views = new ArrayList<>();
        while ((element = scanner.nextElement()) != null) {
            for (int i = 0; i < items.size(); i++) {
                CvtItem item = items.get(i);
                HtmlItem htmlItem = item.getHtmlItem();
                if (!htmlItem.getAttrValue().isEmpty()) {
                    if (element.hasAttr(htmlItem.getAttrKey())
                            && element.attr(htmlItem.getAttrKey()).equals(htmlItem.getAttrValue())
                            && element.tagName().equals(htmlItem.getTag())) {
                        views.add(item.Transform(element));
                    }
                } else if (!item.getHtmlItem().getAttrKey().isEmpty()) {
                    if (element.hasAttr(htmlItem.getAttrKey())
                            && element.tagName().equals(htmlItem.getTag())) {
                        views.add(item.Transform(element));
                    }
                } else {
                    if (element.tagName().equals(htmlItem.getTag())) {
                        views.add(item.Transform(element));
                    }
                }

            }
        }
        return views;
    }

}