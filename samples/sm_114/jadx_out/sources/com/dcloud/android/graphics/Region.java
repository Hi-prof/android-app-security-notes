package com.dcloud.android.graphics;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Region extends android.graphics.Region {
    private int HOLD_SCREEN_COUNT;
    int fillScreenCounter;

    public Region() {
        this(1);
    }

    public void count() {
        this.fillScreenCounter++;
    }

    public boolean fillWholeScreen() {
        return this.fillScreenCounter >= this.HOLD_SCREEN_COUNT;
    }

    public int getFillScreenCounter() {
        return this.fillScreenCounter;
    }

    public Region(int i) {
        this.fillScreenCounter = 1;
        this.HOLD_SCREEN_COUNT = i;
    }
}
