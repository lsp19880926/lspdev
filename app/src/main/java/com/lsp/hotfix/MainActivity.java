package com.lsp.hotfix;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//import cn.jiajixin.nuwa.Nuwa;

public class MainActivity extends AppCompatActivity {

    private static final String PATHCH_PATH = "";
    private TextView tv_loadpatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_loadpatch = (TextView) findViewById(R.id.tv_loadpatch);
        tv_loadpatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Nuwa.loadPatch(MainActivity.this, PATHCH_PATH);
            }
        });
        TextView tv=new TextView(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
//        Nuwa.init(this);
    }
}
