package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class VINParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final java.lang.String sequentialNumber;
    private final java.lang.String vehicleAttributes;
    private final java.lang.String vehicleDescriptorSection;
    private final java.lang.String vehicleIdentifierSection;
    private final java.lang.String vin;
    private final java.lang.String worldManufacturerID;

    public VINParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, int i, char c, java.lang.String str7) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.VIN);
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i;
        this.plantCode = c;
        this.sequentialNumber = str7;
    }

    public java.lang.String getCountryCode() {
        return this.countryCode;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
        sb.append(this.worldManufacturerID);
        sb.append(' ');
        sb.append(this.vehicleDescriptorSection);
        sb.append(' ');
        sb.append(this.vehicleIdentifierSection);
        sb.append('\n');
        java.lang.String str = this.countryCode;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.modelYear);
        sb.append(' ');
        sb.append(this.plantCode);
        sb.append(' ');
        sb.append(this.sequentialNumber);
        sb.append('\n');
        return sb.toString();
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public char getPlantCode() {
        return this.plantCode;
    }

    public java.lang.String getSequentialNumber() {
        return this.sequentialNumber;
    }

    public java.lang.String getVIN() {
        return this.vin;
    }

    public java.lang.String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public java.lang.String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public java.lang.String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public java.lang.String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }
}
