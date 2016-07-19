package ren.yueh.crap;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by yueh on 2016/7/16.
 * 解析的上下文
 */
public class CarpContext {

    private static Context context = null;

    private HtmlItem rootHtmlItem = null;

    /**需要解析出的元素集合
     * 包含HTML标签，属性与对应控件类型以及一些控件的布局属性
     */
    private Templet templet = null;

    /**根布局
     * eg. LinearLayout,RelativeLayout ...
     */
    private ViewGroup rootLayout;

    public CarpContext(Context ctx){
        context = ctx;
        this.templet = new TempletImageTextLink();
        this.rootLayout = new LinearLayout(ctx);
        templet.customizeItems();
    }

    public CarpContext(Context ctx,ViewGroup rootLayout){
        context = ctx;
        this.templet = new TempletImageTextLink();
        this.rootLayout = rootLayout ;
        templet.customizeItems();
    }

    public CarpContext(Context ctx,Templet templet, ViewGroup rootLayout){
        context = ctx;
        this.templet = templet;
        this.rootLayout = rootLayout;
        templet.customizeItems();
    }

    public CarpContext(Context ctx,Templet templet, ViewGroup rootLayout,HtmlItem rootHtmlItem){
        context = ctx;
        this.templet = templet;
        this.rootLayout = rootLayout;
        this.rootHtmlItem = rootHtmlItem;
        templet.customizeItems();
    }

    public HtmlItem getRootHtmlItem() {
        return rootHtmlItem;
    }

    public void setRootHtmlItem(HtmlItem rootHtmlItem) {
        this.rootHtmlItem = rootHtmlItem;
    }

    public Templet getTemplet() {
        return templet;
    }

    public void setTemplet(Templet templet) {
        this.templet = templet;
    }

    public ViewGroup getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(ViewGroup rootLayout) {
        this.rootLayout = rootLayout;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        CarpContext.context = context;
    }
}
