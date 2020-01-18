package com.ch.viewpager2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBase;
    private Button btnPage;
    private Button btnFragment;
    private Button btnTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListener();
    }

    private void initView() {
        btnBase = findViewById(R.id.btnBase);
        btnPage = findViewById(R.id.btnPage);
        btnFragment = findViewById(R.id.btnFragment);
        btnTablayout = findViewById(R.id.btnTablayout);
    }


    private void addListener() {
        btnBase.setOnClickListener(this);
        btnPage.setOnClickListener(this);
        btnFragment.setOnClickListener(this);
        btnTablayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBase:
                startActivity(new Intent(this, BaseActivity.class));
                break;
            case R.id.btnPage:
                startActivity(new Intent(this, PageActivity.class));
                break;
            case R.id.btnFragment:
                startActivity(new Intent(this, FragActivity.class));
                break;
            case R.id.btnTablayout:
                startActivity(new Intent(this, TabLayoutActivity.class));
                break;

            default:
        }

    }
}
