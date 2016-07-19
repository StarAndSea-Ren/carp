package ren.yueh.crap;

import android.content.Context;
import android.view.View;

import org.jsoup.Connection;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by yueh on 2016/7/13.
 */
public class Carp {
    private Document document = null;
    private View view = null;
    private CarpContext carpCxt = null;

    public Carp(Context context) {
        carpCxt = new CarpContext(context);
    }

    public Carp(Context context, CarpContext carpCxt) {
        this.carpCxt = carpCxt;
    }

    public View convert() {
        if (document != null) {
            ren.yueh.crap.Parser parser = new ren.yueh.crap.Parser(carpCxt, document);
            ArrayList<View> views = parser.parse();
            for (View view : views) {
                carpCxt.getRootLayout().addView(view);
            }
            view = carpCxt.getRootLayout();
        }
        return view;
    }

    public void connect(String url) throws IOException {
        document = HttpConnection.connect(url).post();
    }

    public void parse(String html, String baseUri) {
        document = org.jsoup.parser.Parser.parse(html, baseUri);
    }

    public void parse(String html, String baseUri, org.jsoup.parser.Parser parser) {
        document = parser.parseInput(html, baseUri);
    }

    public void parse(String html) {
        document = org.jsoup.parser.Parser.parse(html, "");
    }

    public void parse(File in, String charsetName, String baseUri) throws IOException {
        document = DataUtil.load(in, charsetName, baseUri);
    }

    public void parse(File in, String charsetName) throws IOException {
        document = DataUtil.load(in, charsetName, in.getAbsolutePath());
    }

    public void parse(InputStream in, String charsetName, String baseUri) throws IOException {
        document = DataUtil.load(in, charsetName, baseUri);
    }

    public void parse(InputStream in, String charsetName, String baseUri, org.jsoup.parser.Parser parser) throws IOException {
        document = DataUtil.load(in, charsetName, baseUri, parser);
    }

    public void parseBodyFragment(String bodyHtml, String baseUri) {
        document = org.jsoup.parser.Parser.parseBodyFragment(bodyHtml, baseUri);
    }

    public void parseBodyFragment(String bodyHtml) {
        document = Parser.parseBodyFragment(bodyHtml, "");
    }

    public void parse(URL url, int timeoutMillis) throws IOException {
        Connection con = HttpConnection.connect(url);
        con.timeout(timeoutMillis);
        document = con.get();
    }

    public CarpContext getContext() {
        return carpCxt;
    }

    public void setContext(CarpContext carpCxt) {
        this.carpCxt = carpCxt;
    }
}
