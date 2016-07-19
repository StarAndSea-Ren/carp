package ren.yueh.crap;

import java.util.ArrayList;

/**
 * Created by yueh on 2016/7/16.
 * 待解析项集合，自定义待解析项时则继承实现此父类
 */
public abstract class Templet {

    /**待解析项集合
     */
    protected ArrayList<CvtItem> items = new ArrayList<>();

    /**
     * 定制待解析的集合
     */
    public abstract void customizeItems();

    /**
     * 获取待解析集合
     * @return 待解析集合
     */
    public ArrayList<CvtItem> getTransformItems(){
        return items;
    }
}
