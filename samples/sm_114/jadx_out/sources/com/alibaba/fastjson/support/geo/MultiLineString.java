package com.alibaba.fastjson.support.geo;

/* JADX INFO: loaded from: classes.dex */
@com.alibaba.fastjson.annotation.JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "MultiLineString")
public class MultiLineString extends com.alibaba.fastjson.support.geo.Geometry {
    private double[][][] coordinates;

    public MultiLineString() {
        super("MultiLineString");
    }

    public double[][][] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(double[][][] dArr) {
        this.coordinates = dArr;
    }
}
