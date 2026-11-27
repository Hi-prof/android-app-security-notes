package com.facebook.fresco.vito.renderer;

/* JADX INFO: compiled from: Shape.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/vito/renderer/Shape;", "", "<init>", "()V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "Lcom/facebook/fresco/vito/renderer/CircleShape;", "Lcom/facebook/fresco/vito/renderer/PathShape;", "Lcom/facebook/fresco/vito/renderer/RectShape;", "Lcom/facebook/fresco/vito/renderer/RoundedRectShape;", "renderer_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Shape {
    public /* synthetic */ Shape(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void draw(android.graphics.Canvas canvas, android.graphics.Paint paint);

    private Shape() {
    }
}
