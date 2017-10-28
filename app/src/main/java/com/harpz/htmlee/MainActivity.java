package com.harpz.htmlee;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.harpz.htmlee.model.MUser;
import com.harpz.htmleetim.Htmlee;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.harpz.890m.com/test.html").get();

            Element el = doc.body();


            mUser = new Htmlee().fromHtml(doc.body().toString(),MUser.class);



         //   Element e2 = el.getElementById("test");
         //   Element e3 = e2.getElementById("name");

         //  tv.setText(doc.select("#test").text());

            tv.setText(mUser.getuName());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
