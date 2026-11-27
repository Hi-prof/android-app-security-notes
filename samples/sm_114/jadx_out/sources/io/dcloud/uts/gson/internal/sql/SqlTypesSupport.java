package io.dcloud.uts.gson.internal.sql;

/* JADX INFO: loaded from: classes2.dex */
public final class SqlTypesSupport {
    public static final io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<? extends java.util.Date> DATE_DATE_TYPE;
    public static final io.dcloud.uts.gson.TypeAdapterFactory DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<? extends java.util.Date> TIMESTAMP_DATE_TYPE;
    public static final io.dcloud.uts.gson.TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final io.dcloud.uts.gson.TypeAdapterFactory TIME_FACTORY;

    static {
        boolean z;
        try {
            java.lang.Class.forName("java.sql.Date");
            z = true;
        } catch (java.lang.ClassNotFoundException unused) {
            z = false;
        }
        SUPPORTS_SQL_TYPES = z;
        if (z) {
            DATE_DATE_TYPE = new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<java.sql.Date>(java.sql.Date.class) { // from class: io.dcloud.uts.gson.internal.sql.SqlTypesSupport.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType
                public java.sql.Date deserialize(java.util.Date date) {
                    return new java.sql.Date(date.getTime());
                }
            };
            TIMESTAMP_DATE_TYPE = new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<java.sql.Timestamp>(java.sql.Timestamp.class) { // from class: io.dcloud.uts.gson.internal.sql.SqlTypesSupport.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType
                public java.sql.Timestamp deserialize(java.util.Date date) {
                    return new java.sql.Timestamp(date.getTime());
                }
            };
            DATE_FACTORY = io.dcloud.uts.gson.internal.sql.SqlDateTypeAdapter.FACTORY;
            TIME_FACTORY = io.dcloud.uts.gson.internal.sql.SqlTimeTypeAdapter.FACTORY;
            TIMESTAMP_FACTORY = io.dcloud.uts.gson.internal.sql.SqlTimestampTypeAdapter.FACTORY;
            return;
        }
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
    }

    private SqlTypesSupport() {
    }
}
