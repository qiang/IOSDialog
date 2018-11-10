package com.adorkable.iosdialogdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.adorkable.iosdialog.AlertDialog;
import com.adorkable.iosdialog.BottomSheetDialog;
import com.adorkable.iosdialog.BottomSheetDialog.OnSheetItemClickListener;
import com.adorkable.iosdialog.BottomSheetDialog.SheetItemColor;

public class SimpleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }

    public void showAlertDialog(View v) {
        new AlertDialog(SimpleActivity.this)
                .builder()
                .setTitle("退出当前账号")
                .setMsg("再连续登陆15天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
                .setPositiveButton("确认退出", new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setNegativeButton("取消", new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public void showBottomSheetDialog(View v) {

        new BottomSheetDialog(SimpleActivity.this)
                .builder()
                .setTitle("这个是 BottomSheetDialog 的title ")
                .setCancelable(false)    //设置手机返回按钮是否有效
                .setCanceledOnTouchOutside(false)  //设置 点击空白处是否取消 Dialog 显示
                .addSheetItem("条目一", SheetItemColor.Red,   //设置字体颜色
                        new OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(SimpleActivity.this,
                                        "item" + which, Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                .addSheetItem("条目二", SheetItemColor.Red,
                        new OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(SimpleActivity.this,
                                        "item" + which, Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                .show();

    }


    public void more(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
