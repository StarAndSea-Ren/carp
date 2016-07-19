package ren.yueh.crap;

/**
 * Created by yueh on 2016/7/16.
 */
public class TempletImageTextLink extends Templet {

    @Override
    public void customizeItems() {
        CvtText text = new CvtText();
        this.items.add(text);
    }
}
