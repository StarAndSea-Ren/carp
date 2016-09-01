package ren.yueh.crap;

import android.view.View;

/**
 * Created by changshi on 2016/9/1.
 * 定义了原生元素的一些属性.
 */

public class NativeViewItem<T extends View> {

    private T mView;

    public NativeViewItem(T view) {
        this.mView = view;
    }

    public T getNativeView() {
        return mView;
    }
}
