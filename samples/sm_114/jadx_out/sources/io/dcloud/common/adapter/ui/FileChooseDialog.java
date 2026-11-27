package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class FileChooseDialog extends android.app.Dialog {
    private android.app.Activity activity;
    private int onedp;
    private int onesp;
    public java.util.List<java.io.File> uris;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class GridAdapter extends android.widget.BaseAdapter {
        private android.content.Context context;
        private java.util.List<io.dcloud.common.adapter.ui.FileChooseDialog.Item> items;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        private class ViewHolder {
            android.widget.ImageView iv;

            /* JADX INFO: renamed from: tv, reason: collision with root package name */
            android.widget.TextView f7tv;

            private ViewHolder() {
            }
        }

        GridAdapter(android.content.Context context, java.util.List<io.dcloud.common.adapter.ui.FileChooseDialog.Item> list) {
            this.context = context;
            this.items = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.items.size();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            return this.items.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            io.dcloud.common.adapter.ui.FileChooseDialog.GridAdapter.ViewHolder viewHolder;
            if (view == null) {
                view = io.dcloud.common.adapter.ui.FileChooseDialog.this.createView(this.context, this.items.get(i));
                viewHolder = new io.dcloud.common.adapter.ui.FileChooseDialog.GridAdapter.ViewHolder();
                android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) view;
                viewHolder.iv = (android.widget.ImageView) viewGroup2.getChildAt(0);
                viewHolder.f7tv = (android.widget.TextView) viewGroup2.getChildAt(1);
                view.setTag(viewHolder);
            } else {
                viewHolder = (io.dcloud.common.adapter.ui.FileChooseDialog.GridAdapter.ViewHolder) view.getTag();
            }
            viewHolder.iv.setImageDrawable(this.items.get(i).icon);
            viewHolder.f7tv.setText(this.items.get(i).name);
            return view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class Item {
        android.content.Intent i;
        android.graphics.drawable.Drawable icon;
        java.lang.String name;

        Item(java.lang.String str, android.graphics.drawable.Drawable drawable, android.content.Intent intent) {
            this.name = str;
            this.icon = drawable;
            this.i = intent;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x01d9 A[LOOP:1: B:21:0x01d3->B:23:0x01d9, LOOP_END] */
    public FileChooseDialog(android.content.Context context, android.app.Activity activity, android.content.Intent intent) {
        android.content.Intent intent2;
        java.lang.String str;
        android.content.pm.PackageManager packageManager;
        android.widget.GridView gridView;
        android.content.pm.PackageManager packageManager2;
        super(context);
        requestWindowFeature(1);
        this.activity = activity;
        this.uris = new java.util.ArrayList();
        this.onedp = io.dcloud.common.util.PdrUtil.pxFromDp(1.0f, getContext().getApplicationContext().getResources().getDisplayMetrics());
        this.onesp = io.dcloud.common.util.PdrUtil.pxFromSp(1.0f, getContext().getApplicationContext().getResources().getDisplayMetrics());
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setOrientation(1);
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(io.dcloud.base.R.string.dcloud_choose_an_action);
        textView.setTextSize(this.onesp * 5);
        textView.setTextColor(-16777216);
        textView.getPaint().setFakeBoldText(true);
        textView.setGravity(17);
        linearLayout.addView(textView, new android.widget.LinearLayout.LayoutParams(-1, -2));
        android.widget.GridView gridView2 = new android.widget.GridView(context);
        gridView2.setHorizontalSpacing(this.onedp * 10);
        gridView2.setVerticalSpacing(this.onedp * 10);
        gridView2.setNumColumns(4);
        int i = this.onedp * 20;
        gridView2.setPadding(0, i, 0, i);
        linearLayout.addView(gridView2, new android.widget.LinearLayout.LayoutParams(-1, -2));
        android.view.View view = new android.view.View(context);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new android.view.ViewGroup.LayoutParams(-1, this.onedp));
        android.widget.Button button = new android.widget.Button(context);
        button.setPadding(button.getPaddingLeft(), this.onedp * 15, button.getPaddingRight(), this.onedp * 15);
        button.setBackground(null);
        button.setText(android.R.string.cancel);
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.common.adapter.ui.FileChooseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                io.dcloud.common.adapter.ui.FileChooseDialog.this.cancel();
            }
        });
        button.setGravity(17);
        linearLayout.addView(button, new android.widget.LinearLayout.LayoutParams(-1, -2));
        setContentView(linearLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
        if (intent.getType().startsWith("video/")) {
            intent2 = new android.content.Intent("android.media.action.VIDEO_CAPTURE");
            str = ".mp4";
        } else {
            intent2 = new android.content.Intent("android.media.action.IMAGE_CAPTURE");
            str = ".jpg";
        }
        android.content.pm.PackageManager packageManager3 = activity.getPackageManager();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            for (android.content.pm.ResolveInfo resolveInfo : packageManager3.queryIntentActivities(intent2, 0)) {
                java.lang.String string = resolveInfo.loadLabel(packageManager3).toString();
                android.graphics.drawable.Drawable applicationIcon = packageManager3.getApplicationIcon(resolveInfo.activityInfo.applicationInfo);
                android.content.Intent intent3 = new android.content.Intent(intent2);
                java.lang.String str2 = io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/DCIM/captured_image/";
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                packageManager = packageManager3;
                gridView = gridView2;
                try {
                    sb.append(java.lang.System.currentTimeMillis());
                    sb.append(str);
                    java.io.File file = new java.io.File(str2, sb.toString());
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(activity, activity.getPackageName() + ".dc.fileprovider", file);
                    this.uris.add(file);
                    intent3.putExtra("output", uriForFile);
                    android.content.pm.ActivityInfo activityInfo = resolveInfo.activityInfo;
                    intent3.setClassName(activityInfo.packageName, activityInfo.name);
                    arrayList.add(new io.dcloud.common.adapter.ui.FileChooseDialog.Item(string, applicationIcon, intent3));
                    packageManager3 = packageManager;
                    gridView2 = gridView;
                } catch (java.lang.Exception unused) {
                    packageManager2 = packageManager;
                    for (android.content.pm.ResolveInfo resolveInfo2 : packageManager2.queryIntentActivities(intent, 0)) {
                        java.lang.String string2 = resolveInfo2.loadLabel(packageManager2).toString();
                        android.graphics.drawable.Drawable applicationIcon2 = packageManager2.getApplicationIcon(resolveInfo2.activityInfo.applicationInfo);
                        android.content.Intent intent4 = new android.content.Intent(intent);
                        android.content.pm.ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                        intent4.setClassName(activityInfo2.packageName, activityInfo2.name);
                        arrayList.add(new io.dcloud.common.adapter.ui.FileChooseDialog.Item(string2, applicationIcon2, intent4));
                    }
                    gridView.setAdapter((android.widget.ListAdapter) new io.dcloud.common.adapter.ui.FileChooseDialog.GridAdapter(activity, arrayList));
                }
            }
            gridView = gridView2;
            packageManager2 = packageManager3;
        } catch (java.lang.Exception unused2) {
            packageManager = packageManager3;
            gridView = gridView2;
        }
        while (r4.hasNext()) {
            java.lang.String string3 = resolveInfo2.loadLabel(packageManager2).toString();
            android.graphics.drawable.Drawable applicationIcon3 = packageManager2.getApplicationIcon(resolveInfo2.activityInfo.applicationInfo);
            android.content.Intent intent5 = new android.content.Intent(intent);
            android.content.pm.ActivityInfo activityInfo3 = resolveInfo2.activityInfo;
            intent5.setClassName(activityInfo3.packageName, activityInfo3.name);
            arrayList.add(new io.dcloud.common.adapter.ui.FileChooseDialog.Item(string3, applicationIcon3, intent5));
        }
        gridView.setAdapter((android.widget.ListAdapter) new io.dcloud.common.adapter.ui.FileChooseDialog.GridAdapter(activity, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.View createView(android.content.Context context, final io.dcloud.common.adapter.ui.FileChooseDialog.Item item) {
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        imageView.setImageDrawable(item.icon);
        imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        int i = this.onedp * 50;
        linearLayout.addView(imageView, new android.widget.LinearLayout.LayoutParams(i, i));
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(item.name);
        textView.setTextSize(this.onesp * 4);
        textView.setGravity(17);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.onedp * 10;
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.common.adapter.ui.FileChooseDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (item.i.getAction() == null || !(item.i.getAction().equals("android.media.action.IMAGE_CAPTURE") || item.i.getAction().equals("android.media.action.VIDEO_CAPTURE"))) {
                    io.dcloud.common.adapter.ui.FileChooseDialog.this.activity.startActivityForResult(item.i, 1);
                } else {
                    io.dcloud.common.adapter.util.PermissionUtil.requestSystemPermissions(io.dcloud.common.adapter.ui.FileChooseDialog.this.activity, new java.lang.String[]{com.hjq.permissions.Permission.CAMERA}, io.dcloud.common.adapter.util.PermissionUtil.getRequestCode(), new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.common.adapter.ui.FileChooseDialog.2.1
                        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                        public void onDenied(java.lang.String str) {
                        }

                        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                        public void onGranted(java.lang.String str) {
                            io.dcloud.common.adapter.ui.FileChooseDialog.this.activity.startActivityForResult(item.i, 2);
                        }
                    });
                }
            }
        });
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        android.view.View decorView = getWindow().getDecorView();
        int i = this.onedp;
        decorView.setPadding(0, i * 20, 0, i * 10);
        getWindow().getDecorView().setBackgroundColor(-1);
        getWindow().setAttributes(attributes);
    }
}
