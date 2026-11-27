package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NotificationUtil {
    private static boolean isNotificationChannel = false;
    static java.lang.String sChannelId = "DC_LOCAL_NEWS";
    static java.lang.String sGroupId = "DC_LOCAL_GROUP";

    public static void cancelNotification(android.content.Context context, int i) {
        ((android.app.NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00f1  */
    public static void createCustomNotification(android.content.Context context, java.lang.String str, android.graphics.Bitmap bitmap, java.lang.String str2, java.lang.String str3, int i, android.app.PendingIntent pendingIntent) {
        android.app.Notification.Builder builder;
        java.lang.String string;
        createNotificationChannel(context);
        android.content.Context applicationContext = context.getApplicationContext();
        io.dcloud.common.adapter.util.Logger.i("createCustomNotification content=" + str3);
        int i2 = io.dcloud.PdrR.DRAWABLE_ICON;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m485m$2();
            builder = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(applicationContext, sChannelId);
        } else {
            builder = new android.app.Notification.Builder(applicationContext);
        }
        builder.setWhen(jCurrentTimeMillis);
        builder.setSmallIcon(i2);
        builder.setTicker(str);
        builder.setLargeIcon(bitmap);
        int i3 = io.dcloud.PdrR.LAYOUT_CUSTION_NOTIFICATION_DCLOUD;
        if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            i3 = io.dcloud.PdrR.getInt(applicationContext, com.taobao.weex.common.Constants.Name.LAYOUT, "dcloud_custom_notification_transparent");
        } else if (isMiuiRom(applicationContext)) {
            i3 = io.dcloud.PdrR.getInt(applicationContext, com.taobao.weex.common.Constants.Name.LAYOUT, "dcloud_custom_notification_mi");
        }
        android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(applicationContext.getPackageName(), i3);
        remoteViews.setImageViewBitmap(io.dcloud.PdrR.ID_IMAGE_NOTIFICATION_DCLOUD, bitmap);
        remoteViews.setTextViewText(io.dcloud.PdrR.ID_TITLE_NOTIFICATION_DCLOUD, str2);
        remoteViews.setTextViewText(io.dcloud.PdrR.ID_TEXT_NOTIFICATION, str3);
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.lang.String str4 = simpleDateFormat.format(new java.util.Date());
        if (isMiuiRom(applicationContext)) {
            int i4 = simpleDateFormat.getCalendar().get(11);
            if (i4 >= 0 && i4 < 1) {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_midnight);
            } else if (i4 >= 1 && i4 < 6) {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_morning);
            } else if (i4 >= 6 && i4 < 12) {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_forenoon);
            } else if (i4 >= 12 && i4 < 13) {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_noon);
            } else if (i4 >= 13 && i4 < 18) {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_afternoon);
            } else if (i4 >= 18 && i4 < 19) {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_evening);
            } else if (i4 < 19 || i4 >= 24) {
                string = "";
            } else {
                string = applicationContext.getString(io.dcloud.base.R.string.dcloud_nf_night);
            }
        } else {
            string = "";
        }
        remoteViews.setTextViewText(io.dcloud.PdrR.ID_TIME_NOTIFICATION_DCLOUD, string + str4.substring(str4.length() - 8, str4.length() - 3));
        builder.setContent(remoteViews);
        builder.setContentIntent(pendingIntent);
        android.app.Notification notificationBuild = builder.build();
        notificationBuild.flags |= 16;
        ((android.app.NotificationManager) applicationContext.getSystemService("notification")).notify(i, notificationBuild);
    }

    private static void createNotificationChannel(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 26 || isNotificationChannel) {
            return;
        }
        isNotificationChannel = true;
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService("notification");
        io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m473m();
        notificationManager.createNotificationChannelGroup(dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m(sGroupId, "local_badge"));
        io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m482m$1();
        android.app.NotificationChannel notificationChannelM = dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m(sChannelId, "Information notice", 3);
        notificationChannelM.enableLights(true);
        notificationChannelM.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannelM);
    }

    private static boolean isMiuiRom(android.content.Context context) {
        java.lang.String property = java.lang.System.getProperty("http.agent");
        return !android.text.TextUtils.isEmpty(property) && property.toLowerCase(java.util.Locale.ENGLISH).contains("miui");
    }

    public static void showNotification(android.content.Context context, java.lang.String str, java.lang.String str2, android.app.PendingIntent pendingIntent, android.graphics.Bitmap bitmap, int i) {
        android.app.Notification.Builder builder;
        createNotificationChannel(context);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService("notification");
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m485m$2();
            builder = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(context, sChannelId);
        } else {
            builder = new android.app.Notification.Builder(context);
        }
        try {
            builder.setSmallIcon(context.createPackageContext(context.getPackageName(), 2).getResources().getIdentifier(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON, android.R.drawable.class.getSimpleName(), context.getPackageName()));
        } catch (java.lang.Exception unused) {
        }
        builder.setLargeIcon(bitmap);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setDefaults(1);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        try {
            notificationManager.notify(i, builder.build());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void showNotification(android.content.Context context, java.lang.String str, java.lang.String str2, android.content.Intent intent, int i, int i2, int i3, boolean z) {
        android.app.PendingIntent broadcast;
        android.app.Notification.Builder builder;
        createNotificationChannel(context);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService("notification");
        int i4 = android.os.Build.VERSION.SDK_INT;
        int i5 = i4 >= 23 ? 1140850688 : 1073741824;
        if (z) {
            broadcast = android.app.PendingIntent.getActivity(context, i3, intent, i5);
        } else {
            broadcast = android.app.PendingIntent.getBroadcast(context, i3, intent, i5);
        }
        if (i4 >= 26) {
            io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m485m$2();
            builder = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(context, sChannelId);
        } else {
            builder = new android.app.Notification.Builder(context);
        }
        if (-1 != i) {
            builder.setSmallIcon(i);
        } else {
            builder.setSmallIcon(context.getApplicationInfo().icon);
        }
        if (-1 != i2) {
            builder.setLargeIcon(android.graphics.BitmapFactory.decodeResource(context.getResources(), i2));
        } else {
            builder.setLargeIcon(android.graphics.BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        }
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setDefaults(1);
        builder.setAutoCancel(true);
        builder.setContentIntent(broadcast);
        try {
            notificationManager.notify(i3, builder.build());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
