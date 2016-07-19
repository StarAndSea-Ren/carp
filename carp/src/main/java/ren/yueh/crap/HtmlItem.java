package ren.yueh.crap;

/**
 * Created by yueh on 2016/7/17.
 */
public class HtmlItem {
    /**
     * HTML 标签
     */
    private String tag;

    /**
     * HTML 属性名
     */
    private String attrKey;

    /**
     * HTML 属性值
     */
    private String attrValue;

    public HtmlItem(String tag) {
        this.tag = tag;
        this.attrKey = "";
        this.attrValue = "";
    }

    public HtmlItem(String tag, String attrKey) {
        this.tag = tag;
        this.attrKey = attrKey;
        this.attrValue = "";
    }

    public HtmlItem(String tag, String attrKey, String attrValue) {
        this.tag = tag;
        this.attrKey = attrKey;
        this.attrValue = attrValue;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAttrKey() {
        return attrKey;
    }

    public void setAttrKey(String attrKey) {
        this.attrKey = attrKey;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    @Override
    public String toString() {
        return "HtmlItem{" +
                "tag='" + tag + '\'' +
                ", attrKey='" + attrKey + '\'' +
                ", attrValue='" + attrValue + '\'' +
                '}';
    }
}
