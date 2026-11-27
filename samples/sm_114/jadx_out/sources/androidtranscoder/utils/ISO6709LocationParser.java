package androidtranscoder.utils;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ISO6709LocationParser {
    private final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("([+\\-][0-9.]+)([+\\-][0-9.]+)");

    public float[] parse(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.regex.Matcher matcher = this.pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 2) {
            try {
                return new float[]{java.lang.Float.parseFloat(matcher.group(1)), java.lang.Float.parseFloat(matcher.group(2))};
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return null;
    }
}
