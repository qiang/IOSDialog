package com.adorkable.iosdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Author: liuqiang
 * Time: 2018-01-02 13:28
 * Description:
 */
public class AlertDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout container;
    private TextView titleTv;
    private TextView msgTv;
    private Button negBtn;
    private Button posBtn;
    private ImageView img_line;
    private Display display;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;

    public AlertDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public AlertDialog init() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(R.layout.view_alertdialog, null);

        // 获取自定义Dialog布局中的控件
        container = (LinearLayout) view.findViewById(R.id.container);
        titleTv = (TextView) view.findViewById(R.id.txt_title);
        titleTv.setVisibility(View.GONE);
        msgTv = (TextView) view.findViewById(R.id.txt_msg);
        msgTv.setVisibility(View.GONE);
        negBtn = (Button) view.findViewById(R.id.btn_neg);
        negBtn.setVisibility(View.GONE);
        posBtn = (Button) view.findViewById(R.id.btn_pos);
        posBtn.setVisibility(View.GONE);
        img_line = (ImageView) view.findViewById(R.id.img_line);
        img_line.setVisibility(View.GONE);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);

        // 调整dialog背景大小
        container.setLayoutParams(
                new FrameLayout.LayoutParams(
                        (int) (display.getWidth() * 0.85),
                        LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }

    public AlertDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            titleTv.setText("标题");
        } else {
            titleTv.setText(title);
        }
        return this;
    }

    public AlertDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            msgTv.setText("内容");
        } else {
            msgTv.setText(msg);
        }
        return this;
    }

    public AlertDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public AlertDialog setPositiveButton(String text,
                                         final View.OnClickListener listener) {
        showPosBtn = true;
        if ("".equals(text)) {
            posBtn.setText("确定");
        } else {
            posBtn.setText(text);
        }
        posBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public AlertDialog setNegativeButton(String text, final View.OnClickListener listener) {
        showNegBtn = true;
        if ("".equals(text)) {
            negBtn.setText("取消");
        } else {
            negBtn.setText(text);
        }
        negBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    private void setLayout() {
        if (!showTitle && !showMsg) {
            titleTv.setText("提示");
            titleTv.setVisibility(View.VISIBLE);
        }

        if (showTitle) {
            titleTv.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            msgTv.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn) {
            posBtn.setText("确定");
            posBtn.setVisibility(View.VISIBLE);
            posBtn.setBackgroundResource(R.drawable.alertdialog_single_selector);
            posBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        if (showPosBtn && showNegBtn) {
            posBtn.setVisibility(View.VISIBLE);
            posBtn.setBackgroundResource(R.drawable.alertdialog_right_selector);
            negBtn.setVisibility(View.VISIBLE);
            negBtn.setBackgroundResource(R.drawable.alertdialog_left_selector);
            img_line.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            posBtn.setVisibility(View.VISIBLE);
            posBtn.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (!showPosBtn && showNegBtn) {
            negBtn.setVisibility(View.VISIBLE);
            negBtn.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }
    }

    public void show() {
        setLayout();
        dialog.show();
    }
}
