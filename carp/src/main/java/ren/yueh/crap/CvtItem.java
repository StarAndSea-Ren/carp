package ren.yueh.crap;

import android.view.View;

import org.jsoup.nodes.Element;

/**
 * Created by yueh on 2016/7/16.
 * 定义一个待解析项
 */
public abstract class CvtItem {

    /**
     * Html项，包括标签，属性名，属性值
     */
   protected HtmlItem htmlItem;

    /**
     * 构造函数
     */
    public CvtItem() {
        setHtmlItem();
    }

    /**
     * 此处设置待解析HTML项的属性
     */
    protected abstract void setHtmlItem();

    /**
     * 自定义HTML元素与android view的关系.
     *
     * @param element 元素
     * @return android view
     */
    public abstract View Transform(Element element);

    public HtmlItem getHtmlItem() {
        return htmlItem;
    }

}
