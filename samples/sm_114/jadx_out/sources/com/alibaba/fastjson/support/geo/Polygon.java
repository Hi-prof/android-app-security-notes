package com.alibaba.fastjson.support.geo;

/* JADX INFO: loaded from: classes.dex */
@com.alibaba.fastjson.annotation.JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "Polygon")
public class Polygon extends com.alibaba.fastjson.support.geo.Geometry {
    private double[][][] coordinates;

    public Polygon() {
        super("Polygon");
    }

    public double[][][] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(double[][][] dArr) {
        this.coordinates = dArr;
    }
}
