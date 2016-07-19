package ren.yueh.crap;

import android.view.View;
import android.widget.TextView;

import org.jsoup.nodes.Element;

/**
 * Created by yueh on 2016/7/16.
 */
public class CvtText extends CvtItem {

    @Override
    protected void setHtmlItem() {
        this.htmlItem = new HtmlItem("div", "class", "MsoNormal");
    }

    @Override
    public View Transform(Element element) {
        String text = element.text();
        if (!text.isEmpty()) {
            TextView textView = new TextView(CarpContext.getContext());
            textView.setText(text);
            return textView;
        } else {
            return null;
        }
    }
}
