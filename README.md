# IOSDialogDemo
----

### 一、简介
Android 仿IOS的 Dialog，包括 BottomSheetDialog 和 AlertDialog

屏幕演示截图保存在 [images文件夹](https://github.com/niyingxunzong/IOSDialogDemo/blob/master/images)

动图演示如下：

<img src="https://github.com/niyingxunzong/IOSDialogDemo/blob/master/images/show.gif" alt="动图演示效果" width="250px">

### 二、使用方法

#### 0. 引用方法

此库并没有传到 gradle 仓库里面去，如果不想引入源码可以直接引入aar包，生成aar的方式。
双击下图中的 assemble :

<img src="https://github.com/niyingxunzong/IOSDialogDemo/blob/master/images/AEB7D9AC-556F-4B2E-AE14-6CF5E34E4069.png" alt="aar生成方式" width="250px">

然后生成的aar在 IOSDialogDemo/lib-ios-dialog/build/outputs/aar 里面

#### 1. AlertDialog

<img src="https://github.com/niyingxunzong/IOSDialogDemo/blob/master/images/device-2015-10-23-131539.png" alt="AlertDialog" width="300px">



```
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
```

#### 2. BottomSheetDialog

<img src="https://github.com/niyingxunzong/IOSDialogDemo/blob/master/images/device-2015-10-23-131524.png" alt="AlertDialog" width="300px">

```
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

```