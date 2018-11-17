package com.adorkable.iosdialogdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.adorkable.iosdialog.AlertDialog;
import com.adorkable.iosdialog.BottomSheetDialog;
import com.adorkable.iosdialog.BottomSheetDialog.OnSheetItemClickListener;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }

    public void showAlertDialog(View v) {
        new AlertDialog(SimpleActivity.this)
                .init()
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
                .init()
                .setTitle("这个是 BottomSheetDialog 的title ")
                .setCancelable(false)    //设置手机返回按钮是否有效
                .setCanceledOnTouchOutside(false)  //设置 点击空白处是否取消 Dialog 显示
                //如果条目样式一样，可以直接设置默认样式
                .setDefaultItemStyle(new BottomSheetDialog.SheetItemTextStyle("#000000", 16))
                .setBottomBtnStyle(new BottomSheetDialog.SheetItemTextStyle("#ff0000", 18))
                .addSheetItem("条目一",
                        //可以对一个条目单独设置字体样式
                        new BottomSheetDialog.SheetItemTextStyle("#ff00ff"),   //设置字体样式
                        new OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(SimpleActivity.this,
                                        "item" + which, Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                .addSheetItem("条目二",
                        new OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(SimpleActivity.this,
                                        "item" + which, Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                .addSheetItem("条目三",
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
