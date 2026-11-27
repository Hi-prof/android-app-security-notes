package androidtranscoder.format;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MediaFormatStrategyPresets {
    public static final int AUDIO_BITRATE_AS_IS = -1;
    public static final int AUDIO_CHANNELS_AS_IS = -1;

    @java.lang.Deprecated
    public static final androidtranscoder.format.MediaFormatStrategy EXPORT_PRESET_960x540 = new androidtranscoder.format.ExportPreset960x540Strategy();

    private MediaFormatStrategyPresets() {
    }

    public static androidtranscoder.format.MediaFormatStrategy createAndroid720pStrategy(int i, double d) {
        return new androidtranscoder.format.Android720pFormatStrategy(i, d);
    }

    public static androidtranscoder.format.MediaFormatStrategy createExportPreset960x540Strategy() {
        return new androidtranscoder.format.ExportPreset960x540Strategy();
    }
}
