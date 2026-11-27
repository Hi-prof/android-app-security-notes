package androidtranscoder.format;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ExportPreset960x540Strategy implements androidtranscoder.format.MediaFormatStrategy {
    private static final java.lang.String TAG = "ExportPreset960x540Strategy";

    ExportPreset960x540Strategy() {
    }

    @Override // androidtranscoder.format.MediaFormatStrategy
    public android.media.MediaFormat createAudioOutputFormat(android.media.MediaFormat mediaFormat) {
        return null;
    }

    @Override // androidtranscoder.format.MediaFormatStrategy
    public android.media.MediaFormat createVideoOutputFormat(android.media.MediaFormat mediaFormat) {
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        android.media.MediaFormat exportPreset960x540 = androidtranscoder.format.MediaFormatPresets.getExportPreset960x540(integer, integer2);
        android.util.Log.d(TAG, io.dcloud.common.util.StringUtil.format("inputFormat: %dx%d => outputFormat: %dx%d", java.lang.Integer.valueOf(integer), java.lang.Integer.valueOf(integer2), java.lang.Integer.valueOf(exportPreset960x540.getInteger("width")), java.lang.Integer.valueOf(exportPreset960x540.getInteger("height"))));
        return exportPreset960x540;
    }
}
