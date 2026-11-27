package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AddressBookParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String[] addressTypes;
    private final java.lang.String[] addresses;
    private final java.lang.String birthday;
    private final java.lang.String[] emailTypes;
    private final java.lang.String[] emails;
    private final java.lang.String[] geo;
    private final java.lang.String instantMessenger;
    private final java.lang.String[] names;
    private final java.lang.String[] nicknames;
    private final java.lang.String note;

    /* JADX INFO: renamed from: org, reason: collision with root package name */
    private final java.lang.String f6org;
    private final java.lang.String[] phoneNumbers;
    private final java.lang.String[] phoneTypes;
    private final java.lang.String pronunciation;
    private final java.lang.String title;
    private final java.lang.String[] urls;

    public AddressBookParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String[] strArr4, java.lang.String[] strArr5, java.lang.String[] strArr6, java.lang.String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    public java.lang.String[] getAddressTypes() {
        return this.addressTypes;
    }

    public java.lang.String[] getAddresses() {
        return this.addresses;
    }

    public java.lang.String getBirthday() {
        return this.birthday;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.names, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.nicknames, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.pronunciation, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.title, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.f6org, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.addresses, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.phoneNumbers, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.emails, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.instantMessenger, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.urls, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.birthday, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.geo, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.note, sb);
        return sb.toString();
    }

    public java.lang.String[] getEmailTypes() {
        return this.emailTypes;
    }

    public java.lang.String[] getEmails() {
        return this.emails;
    }

    public java.lang.String[] getGeo() {
        return this.geo;
    }

    public java.lang.String getInstantMessenger() {
        return this.instantMessenger;
    }

    public java.lang.String[] getNames() {
        return this.names;
    }

    public java.lang.String[] getNicknames() {
        return this.nicknames;
    }

    public java.lang.String getNote() {
        return this.note;
    }

    public java.lang.String getOrg() {
        return this.f6org;
    }

    public java.lang.String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public java.lang.String[] getPhoneTypes() {
        return this.phoneTypes;
    }

    public java.lang.String getPronunciation() {
        return this.pronunciation;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String[] getURLs() {
        return this.urls;
    }

    public AddressBookParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str, java.lang.String[] strArr3, java.lang.String[] strArr4, java.lang.String[] strArr5, java.lang.String[] strArr6, java.lang.String str2, java.lang.String str3, java.lang.String[] strArr7, java.lang.String[] strArr8, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String[] strArr9, java.lang.String[] strArr10) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.ADDRESSBOOK);
        this.names = strArr;
        this.nicknames = strArr2;
        this.pronunciation = str;
        this.phoneNumbers = strArr3;
        this.phoneTypes = strArr4;
        this.emails = strArr5;
        this.emailTypes = strArr6;
        this.instantMessenger = str2;
        this.note = str3;
        this.addresses = strArr7;
        this.addressTypes = strArr8;
        this.f6org = str4;
        this.birthday = str5;
        this.title = str6;
        this.urls = strArr9;
        this.geo = strArr10;
    }
}
