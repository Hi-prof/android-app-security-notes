package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public enum FieldNamingPolicy implements io.dcloud.uts.gson.FieldNamingStrategy {
    IDENTITY { // from class: io.dcloud.uts.gson.FieldNamingPolicy.1
        @Override // io.dcloud.uts.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: io.dcloud.uts.gson.FieldNamingPolicy.2
        @Override // io.dcloud.uts.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: io.dcloud.uts.gson.FieldNamingPolicy.3
        @Override // io.dcloud.uts.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return upperCaseFirstLetter(separateCamelCase(field.getName(), com.taobao.weex.el.parse.Operators.SPACE_STR));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: io.dcloud.uts.gson.FieldNamingPolicy.4
        @Override // io.dcloud.uts.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return separateCamelCase(field.getName(), "_").toLowerCase(java.util.Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: io.dcloud.uts.gson.FieldNamingPolicy.5
        @Override // io.dcloud.uts.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return separateCamelCase(field.getName(), com.taobao.weex.el.parse.Operators.SUB).toLowerCase(java.util.Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: io.dcloud.uts.gson.FieldNamingPolicy.6
        @Override // io.dcloud.uts.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return separateCamelCase(field.getName(), com.taobao.weex.el.parse.Operators.DOT_STR).toLowerCase(java.util.Locale.ENGLISH);
        }
    };

    static java.lang.String separateCamelCase(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (java.lang.Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static java.lang.String upperCaseFirstLetter(java.lang.String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!java.lang.Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char cCharAt = str.charAt(i);
        if (java.lang.Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = java.lang.Character.toUpperCase(cCharAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }
}
