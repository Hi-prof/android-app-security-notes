package org.mozilla.universalchardet;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UniversalDetector {
    public static final float MINIMUM_THRESHOLD = 0.2f;
    public static final float SHORTCUT_THRESHOLD = 0.95f;
    private java.lang.String detectedCharset;
    private boolean done;
    private org.mozilla.universalchardet.prober.CharsetProber escCharsetProber;
    private boolean gotData;
    private org.mozilla.universalchardet.UniversalDetector.InputState inputState;
    private byte lastChar;
    private org.mozilla.universalchardet.CharsetListener listener;
    private org.mozilla.universalchardet.prober.CharsetProber[] probers;
    private boolean start;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector() {
        this(null);
    }

    public static java.lang.String detectCharset(java.io.File file) throws java.io.IOException {
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            byte[] bArr = new byte[4096];
            org.mozilla.universalchardet.UniversalDetector universalDetector = new org.mozilla.universalchardet.UniversalDetector(null);
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0 || universalDetector.isDone()) {
                    break;
                }
                universalDetector.handleData(bArr, 0, i);
            }
            universalDetector.dataEnd();
            java.lang.String detectedCharset = universalDetector.getDetectedCharset();
            universalDetector.reset();
            fileInputStream.close();
            return detectedCharset;
        } catch (java.lang.Throwable th) {
            try {
                fileInputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void dataEnd() {
        org.mozilla.universalchardet.prober.CharsetProber[] charsetProberArr;
        if (this.gotData) {
            java.lang.String str = this.detectedCharset;
            if (str != null) {
                this.done = true;
                org.mozilla.universalchardet.CharsetListener charsetListener = this.listener;
                if (charsetListener != null) {
                    charsetListener.report(str);
                    return;
                }
                return;
            }
            if (this.inputState == org.mozilla.universalchardet.UniversalDetector.InputState.HIGHBYTE) {
                int i = 0;
                int i2 = 0;
                float f = 0.0f;
                while (true) {
                    charsetProberArr = this.probers;
                    if (i >= charsetProberArr.length) {
                        break;
                    }
                    float confidence = charsetProberArr[i].getConfidence();
                    if (confidence > f) {
                        i2 = i;
                        f = confidence;
                    }
                    i++;
                }
                if (f > 0.2f) {
                    java.lang.String charSetName = charsetProberArr[i2].getCharSetName();
                    this.detectedCharset = charSetName;
                    org.mozilla.universalchardet.CharsetListener charsetListener2 = this.listener;
                    if (charsetListener2 != null) {
                        charsetListener2.report(charSetName);
                    }
                }
            }
        }
    }

    public java.lang.String getDetectedCharset() {
        return this.detectedCharset;
    }

    public org.mozilla.universalchardet.CharsetListener getListener() {
        return this.listener;
    }

    public void handleData(byte[] bArr) {
        handleData(bArr, 0, bArr.length);
    }

    public boolean isDone() {
        return this.done;
    }

    public void reset() {
        int i = 0;
        this.done = false;
        this.start = true;
        this.detectedCharset = null;
        this.gotData = false;
        this.inputState = org.mozilla.universalchardet.UniversalDetector.InputState.PURE_ASCII;
        this.lastChar = (byte) 0;
        org.mozilla.universalchardet.prober.CharsetProber charsetProber = this.escCharsetProber;
        if (charsetProber != null) {
            charsetProber.reset();
        }
        while (true) {
            org.mozilla.universalchardet.prober.CharsetProber[] charsetProberArr = this.probers;
            if (i >= charsetProberArr.length) {
                return;
            }
            org.mozilla.universalchardet.prober.CharsetProber charsetProber2 = charsetProberArr[i];
            if (charsetProber2 != null) {
                charsetProber2.reset();
            }
            i++;
        }
    }

    public void setListener(org.mozilla.universalchardet.CharsetListener charsetListener) {
        this.listener = charsetListener;
    }

    public UniversalDetector(org.mozilla.universalchardet.CharsetListener charsetListener) {
        this.listener = charsetListener;
        this.escCharsetProber = null;
        this.probers = new org.mozilla.universalchardet.prober.CharsetProber[1];
        reset();
    }

    public void handleData(byte[] bArr, int i, int i2) {
        if (this.done) {
            return;
        }
        if (i2 > 0) {
            this.gotData = true;
        }
        int i3 = 0;
        if (this.start) {
            this.start = false;
            if (i2 > 3) {
                int i4 = bArr[i] & 255;
                int i5 = bArr[i + 1] & 255;
                int i6 = bArr[i + 2] & 255;
                int i7 = bArr[i + 3] & 255;
                if (i4 != 0) {
                    if (i4 != 239) {
                        if (i4 != 254) {
                            if (i4 == 255) {
                                if (i5 == 254 && i6 == 0 && i7 == 0) {
                                    this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_UTF_32LE;
                                } else if (i5 == 254) {
                                    this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_UTF_16LE;
                                }
                            }
                        } else if (i5 == 255 && i6 == 0 && i7 == 0) {
                            this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_X_ISO_10646_UCS_4_3412;
                        } else if (i5 == 255) {
                            this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_UTF_16BE;
                        }
                    } else if (i5 == 187 && i6 == 191) {
                        this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_UTF_8;
                    }
                } else if (i5 == 0 && i6 == 254 && i7 == 255) {
                    this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_UTF_32BE;
                } else if (i5 == 0 && i6 == 255 && i7 == 254) {
                    this.detectedCharset = org.mozilla.universalchardet.Constants.CHARSET_X_ISO_10646_UCS_4_2143;
                }
                if (this.detectedCharset != null) {
                    this.done = true;
                    return;
                }
            }
        }
        int i8 = i + i2;
        for (int i9 = i; i9 < i8; i9++) {
            byte b = bArr[i9];
            int i10 = b & 255;
            if ((b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) == 0 || i10 == 160) {
                if (this.inputState == org.mozilla.universalchardet.UniversalDetector.InputState.PURE_ASCII && (i10 == 27 || (i10 == 123 && this.lastChar == 126))) {
                    this.inputState = org.mozilla.universalchardet.UniversalDetector.InputState.ESC_ASCII;
                }
                this.lastChar = b;
            } else {
                org.mozilla.universalchardet.UniversalDetector.InputState inputState = this.inputState;
                org.mozilla.universalchardet.UniversalDetector.InputState inputState2 = org.mozilla.universalchardet.UniversalDetector.InputState.HIGHBYTE;
                if (inputState != inputState2) {
                    this.inputState = inputState2;
                    if (this.escCharsetProber != null) {
                        this.escCharsetProber = null;
                    }
                    org.mozilla.universalchardet.prober.CharsetProber[] charsetProberArr = this.probers;
                    if (charsetProberArr[0] == null) {
                        charsetProberArr[0] = new org.mozilla.universalchardet.prober.MBCSGroupProber();
                    }
                }
            }
        }
        org.mozilla.universalchardet.UniversalDetector.InputState inputState3 = this.inputState;
        if (inputState3 == org.mozilla.universalchardet.UniversalDetector.InputState.ESC_ASCII) {
            if (this.escCharsetProber == null) {
                this.escCharsetProber = new org.mozilla.universalchardet.prober.EscCharsetProber();
            }
            if (this.escCharsetProber.handleData(bArr, i, i2) == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT) {
                this.done = true;
                this.detectedCharset = this.escCharsetProber.getCharSetName();
                return;
            }
            return;
        }
        if (inputState3 != org.mozilla.universalchardet.UniversalDetector.InputState.HIGHBYTE) {
            return;
        }
        while (true) {
            org.mozilla.universalchardet.prober.CharsetProber[] charsetProberArr2 = this.probers;
            if (i3 >= charsetProberArr2.length) {
                return;
            }
            if (charsetProberArr2[i3].handleData(bArr, i, i2) == org.mozilla.universalchardet.prober.CharsetProber.ProbingState.FOUND_IT) {
                this.done = true;
                this.detectedCharset = this.probers[i3].getCharSetName();
                return;
            }
            i3++;
        }
    }
}
