package com.taobao.weex.appfram.pickers;

/* JADX INFO: loaded from: classes.dex */
public class DatePickerImpl {
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private static java.text.SimpleDateFormat dateFormatter;
    private static java.text.SimpleDateFormat timeFormatter;

    public interface OnPickListener {
        void onPick(boolean z, java.lang.String str);
    }

    public static void pickDate(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, final com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener onPickListener, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(parseDate(str));
        android.app.DatePickerDialog datePickerDialog = new android.app.DatePickerDialog(context, new android.app.DatePickerDialog.OnDateSetListener() { // from class: com.taobao.weex.appfram.pickers.DatePickerImpl.1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(android.widget.DatePicker datePicker, int i, int i2, int i3) {
                java.lang.String strValueOf;
                java.lang.String strValueOf2;
                int i4 = i2 + 1;
                if (i4 < 10) {
                    strValueOf = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + i4;
                } else {
                    strValueOf = java.lang.String.valueOf(i4);
                }
                if (i3 < 10) {
                    strValueOf2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + i3;
                } else {
                    strValueOf2 = java.lang.String.valueOf(i3);
                }
                onPickListener.onPick(true, i + com.taobao.weex.el.parse.Operators.SUB + strValueOf + com.taobao.weex.el.parse.Operators.SUB + strValueOf2);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5));
        android.widget.DatePicker datePicker = datePickerDialog.getDatePicker();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance(java.util.Locale.getDefault());
        java.util.Calendar calendar3 = java.util.Calendar.getInstance(java.util.Locale.getDefault());
        calendar2.set(DEFAULT_START_YEAR, 0, 1);
        calendar3.set(DEFAULT_END_YEAR, 11, 31);
        if (!android.text.TextUtils.isEmpty(str3)) {
            if (datePicker.getMaxDate() >= parseDate(str3).getTime()) {
                datePicker.setMinDate(parseDate(str3).getTime());
            } else {
                datePicker.setMinDate(calendar2.getTimeInMillis());
                datePicker.setMaxDate(calendar3.getTimeInMillis());
            }
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            if (datePicker.getMinDate() <= parseDate(str2).getTime()) {
                datePicker.setMaxDate(parseDate(str2).getTime());
            } else {
                datePicker.setMinDate(calendar2.getTimeInMillis());
                datePicker.setMaxDate(calendar3.getTimeInMillis());
            }
        }
        datePickerDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.taobao.weex.appfram.pickers.DatePickerImpl.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
                onPickListener.onPick(false, null);
            }
        });
        setButtonText(datePickerDialog, -2, java.lang.String.valueOf(map != null ? map.get(com.taobao.weex.ui.module.WXModalUIModule.CANCEL_TITLE) : null));
        setButtonText(datePickerDialog, -1, java.lang.String.valueOf(map != null ? map.get("confirmTitle") : null));
        datePickerDialog.show();
    }

    public static void pickTime(android.content.Context context, java.lang.String str, final com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener onPickListener, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(parseTime(str));
        android.app.TimePickerDialog timePickerDialog = new android.app.TimePickerDialog(context, new android.app.TimePickerDialog.OnTimeSetListener() { // from class: com.taobao.weex.appfram.pickers.DatePickerImpl.3
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(android.widget.TimePicker timePicker, int i, int i2) {
                java.lang.String strValueOf;
                java.lang.String strValueOf2;
                if (i < 10) {
                    strValueOf = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + i;
                } else {
                    strValueOf = java.lang.String.valueOf(i);
                }
                if (i2 < 10) {
                    strValueOf2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + i2;
                } else {
                    strValueOf2 = java.lang.String.valueOf(i2);
                }
                onPickListener.onPick(true, strValueOf + ":" + strValueOf2);
            }
        }, calendar.get(11), calendar.get(12), false);
        timePickerDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: com.taobao.weex.appfram.pickers.DatePickerImpl.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
                onPickListener.onPick(false, null);
            }
        });
        setButtonText(timePickerDialog, -2, java.lang.String.valueOf(map != null ? map.get(com.taobao.weex.ui.module.WXModalUIModule.CANCEL_TITLE) : null));
        setButtonText(timePickerDialog, -1, java.lang.String.valueOf(map != null ? map.get("confirmTitle") : null));
        timePickerDialog.show();
    }

    private static java.util.Date parseDate(java.lang.String str) {
        if (dateFormatter == null) {
            dateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());
        }
        try {
            return dateFormatter.parse(str);
        } catch (java.text.ParseException e) {
            com.taobao.weex.utils.WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new java.util.Date();
        }
    }

    private static java.util.Date parseTime(java.lang.String str) {
        if (timeFormatter == null) {
            timeFormatter = new java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault());
        }
        try {
            return timeFormatter.parse(str);
        } catch (java.text.ParseException e) {
            com.taobao.weex.utils.WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new java.util.Date();
        }
    }

    private static void setButtonText(final android.app.AlertDialog alertDialog, final int i, final java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.isEmpty(charSequence) || "null".equals(charSequence)) {
            return;
        }
        try {
            alertDialog.getWindow().getDecorView().post(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.pickers.DatePickerImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    android.widget.Button button = alertDialog.getButton(i);
                    if (button != null) {
                        button.setAllCaps(false);
                        button.setText(charSequence);
                    }
                }
            }));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
