package ren.yueh.crap;

import android.view.View;

import org.jsoup.nodes.Element;

/**
 * Created by yueh on 2016/7/16.
 */
public class CvtImage extends CvtItem {

    @Override
    protected void setHtmlItem() {
        this.htmlItem = new HtmlItem("img","src");
    }

    @Override
    public View Transform(Element element) {
        return null;
    }
}
