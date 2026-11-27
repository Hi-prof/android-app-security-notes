package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class CalendarParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String[] attendees;
    private final java.lang.String description;
    private final java.util.Date end;
    private final boolean endAllDay;
    private final double latitude;
    private final java.lang.String location;
    private final double longitude;
    private final java.lang.String organizer;
    private final java.util.Date start;
    private final boolean startAllDay;
    private final java.lang.String summary;
    private static final java.util.regex.Pattern RFC2445_DURATION = java.util.regex.Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] RFC2445_DURATION_FIELD_UNITS = {604800000, 86400000, 3600000, 60000, 1000};
    private static final java.util.regex.Pattern DATE_TIME = java.util.regex.Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    public CalendarParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String[] strArr, java.lang.String str7, double d, double d2) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.CALENDAR);
        this.summary = str;
        try {
            java.util.Date date = parseDate(str2);
            this.start = date;
            if (str3 == null) {
                long durationMS = parseDurationMS(str4);
                this.end = durationMS < 0 ? null : new java.util.Date(date.getTime() + durationMS);
            } else {
                try {
                    this.end = parseDate(str3);
                } catch (java.text.ParseException e) {
                    throw new java.lang.IllegalArgumentException(e.toString());
                }
            }
            this.startAllDay = str2.length() == 8;
            this.endAllDay = str3 != null && str3.length() == 8;
            this.location = str5;
            this.organizer = str6;
            this.attendees = strArr;
            this.description = str7;
            this.latitude = d;
            this.longitude = d2;
        } catch (java.text.ParseException e2) {
            throw new java.lang.IllegalArgumentException(e2.toString());
        }
    }

    private static java.text.DateFormat buildDateFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(io.dcloud.common.adapter.util.Logger.TIMESTAMP_YYYY_MM_DD, java.util.Locale.ENGLISH);
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static java.text.DateFormat buildDateTimeFormat() {
        return new java.text.SimpleDateFormat("yyyyMMdd'T'HHmmss", java.util.Locale.ENGLISH);
    }

    private static java.lang.String format(boolean z, java.util.Date date) {
        if (date == null) {
            return null;
        }
        return (z ? java.text.DateFormat.getDateInstance(2) : java.text.DateFormat.getDateTimeInstance(2, 2)).format(date);
    }

    private static java.util.Date parseDate(java.lang.String str) throws java.text.ParseException {
        if (!DATE_TIME.matcher(str).matches()) {
            throw new java.text.ParseException(str, 0);
        }
        if (str.length() == 8) {
            return buildDateFormat().parse(str);
        }
        if (str.length() != 16 || str.charAt(15) != 'Z') {
            return buildDateTimeFormat().parse(str);
        }
        java.util.Date date = buildDateTimeFormat().parse(str.substring(0, 15));
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
        long time = date.getTime() + ((long) gregorianCalendar.get(15));
        gregorianCalendar.setTime(new java.util.Date(time));
        return new java.util.Date(time + ((long) gregorianCalendar.get(16)));
    }

    private static long parseDurationMS(java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        java.util.regex.Matcher matcher = RFC2445_DURATION.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j = 0;
        int i = 0;
        while (true) {
            long[] jArr = RFC2445_DURATION_FIELD_UNITS;
            if (i >= jArr.length) {
                return j;
            }
            int i2 = i + 1;
            java.lang.String strGroup = matcher.group(i2);
            if (strGroup != null) {
                j += jArr[i] * ((long) java.lang.Integer.parseInt(strGroup));
            }
            i = i2;
        }
    }

    public java.lang.String[] getAttendees() {
        return this.attendees;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.summary, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(format(this.startAllDay, this.start), sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(format(this.endAllDay, this.end), sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.location, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.organizer, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.attendees, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.description, sb);
        return sb.toString();
    }

    public java.util.Date getEnd() {
        return this.end;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public java.lang.String getLocation() {
        return this.location;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public java.lang.String getOrganizer() {
        return this.organizer;
    }

    public java.util.Date getStart() {
        return this.start;
    }

    public java.lang.String getSummary() {
        return this.summary;
    }

    public boolean isEndAllDay() {
        return this.endAllDay;
    }

    public boolean isStartAllDay() {
        return this.startAllDay;
    }
}
