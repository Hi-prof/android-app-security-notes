package com.facebook.fresco.vito.renderer;

/* JADX INFO: compiled from: ImageRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0005*\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010\u0014J2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0005*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\b¢\u0006\u0002\u0010\u0016J>\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u0005*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010\u0018J8\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\b¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010H\u0086\b¨\u0006!"}, d2 = {"Lcom/facebook/fresco/vito/renderer/ImageRenderer;", "", "<init>", "()V", "createImageDataModelRenderCommand", "Lcom/facebook/fresco/vito/renderer/RenderCommand;", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "model", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "shape", "Lcom/facebook/fresco/vito/renderer/Shape;", "paint", "Landroid/graphics/Paint;", "imageTransformation", "Landroid/graphics/Matrix;", "(Lcom/facebook/fresco/vito/renderer/ImageDataModel;Lcom/facebook/fresco/vito/renderer/Shape;Landroid/graphics/Paint;Landroid/graphics/Matrix;)Lkotlin/jvm/functions/Function1;", "createRenderCommand", "Lcom/facebook/fresco/vito/renderer/BitmapImageDataModel;", "(Lcom/facebook/fresco/vito/renderer/BitmapImageDataModel;Lcom/facebook/fresco/vito/renderer/Shape;Landroid/graphics/Paint;Landroid/graphics/Matrix;)Lkotlin/jvm/functions/Function1;", "Lcom/facebook/fresco/vito/renderer/ColorIntImageDataModel;", "(Lcom/facebook/fresco/vito/renderer/ColorIntImageDataModel;Lcom/facebook/fresco/vito/renderer/Shape;Landroid/graphics/Paint;)Lkotlin/jvm/functions/Function1;", "Lcom/facebook/fresco/vito/renderer/DrawableImageDataModel;", "(Lcom/facebook/fresco/vito/renderer/DrawableImageDataModel;Lcom/facebook/fresco/vito/renderer/Shape;Landroid/graphics/Paint;Landroid/graphics/Matrix;)Lkotlin/jvm/functions/Function1;", "bitmapRenderCommand", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Paint;Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)Lkotlin/jvm/functions/Function1;", "paintRenderCommand", "(Lcom/facebook/fresco/vito/renderer/Shape;Landroid/graphics/Paint;)Lkotlin/jvm/functions/Function1;", "setBitmap", "shaderTransformation", "renderer_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageRenderer {
    public static final com.facebook.fresco.vito.renderer.ImageRenderer INSTANCE = new com.facebook.fresco.vito.renderer.ImageRenderer();

    private ImageRenderer() {
    }

    public static /* synthetic */ kotlin.jvm.functions.Function1 createImageDataModelRenderCommand$default(com.facebook.fresco.vito.renderer.ImageRenderer imageRenderer, com.facebook.fresco.vito.renderer.ImageDataModel imageDataModel, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint, android.graphics.Matrix matrix, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            matrix = null;
        }
        return imageRenderer.createImageDataModelRenderCommand(imageDataModel, shape, paint, matrix);
    }

    public final kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> createImageDataModelRenderCommand(com.facebook.fresco.vito.renderer.ImageDataModel model, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint, android.graphics.Matrix imageTransformation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(model, "model");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(model instanceof com.facebook.fresco.vito.renderer.BitmapImageDataModel)) {
            if (!(model instanceof com.facebook.fresco.vito.renderer.ColorIntImageDataModel)) {
                if (!(model instanceof com.facebook.fresco.vito.renderer.DrawableImageDataModel)) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                com.facebook.fresco.vito.renderer.DrawableImageDataModel drawableImageDataModel = (com.facebook.fresco.vito.renderer.DrawableImageDataModel) model;
                return shape instanceof com.facebook.fresco.vito.renderer.RectShape ? new com.facebook.fresco.vito.renderer.ImageRenderer.C01011(drawableImageDataModel, imageTransformation, shape, paint) : new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass2(drawableImageDataModel, paint, imageTransformation, shape);
            }
            paint.setColor(com.facebook.fresco.vito.renderer.util.ColorUtils.INSTANCE.multiplyColorAlpha(((com.facebook.fresco.vito.renderer.ColorIntImageDataModel) model).getColorInt(), paint.getAlpha()));
            return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
        }
        com.facebook.fresco.vito.renderer.BitmapImageDataModel bitmapImageDataModel = (com.facebook.fresco.vito.renderer.BitmapImageDataModel) model;
        if (shape instanceof com.facebook.fresco.vito.renderer.RectShape) {
            return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(imageTransformation, bitmapImageDataModel.getBitmap(), paint);
        }
        if (shape instanceof com.facebook.fresco.vito.renderer.CircleShape) {
            if (!bitmapImageDataModel.getIsBitmapCircular()) {
                paint.setShader(new android.graphics.BitmapShader(bitmapImageDataModel.getBitmap(), android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
                paint.getShader().setLocalMatrix(imageTransformation);
                return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
            }
            return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(imageTransformation, bitmapImageDataModel.getBitmap(), paint);
        }
        paint.setShader(new android.graphics.BitmapShader(bitmapImageDataModel.getBitmap(), android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
        paint.getShader().setLocalMatrix(imageTransformation);
        return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
    }

    public static /* synthetic */ kotlin.jvm.functions.Function1 createRenderCommand$default(com.facebook.fresco.vito.renderer.ImageRenderer imageRenderer, com.facebook.fresco.vito.renderer.BitmapImageDataModel bitmapImageDataModel, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint, android.graphics.Matrix matrix, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            matrix = null;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapImageDataModel, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(shape instanceof com.facebook.fresco.vito.renderer.RectShape)) {
            if (shape instanceof com.facebook.fresco.vito.renderer.CircleShape) {
                if (!bitmapImageDataModel.getIsBitmapCircular()) {
                    paint.setShader(new android.graphics.BitmapShader(bitmapImageDataModel.getBitmap(), android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
                    paint.getShader().setLocalMatrix(matrix);
                    return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
                }
                return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
            }
            paint.setShader(new android.graphics.BitmapShader(bitmapImageDataModel.getBitmap(), android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
            paint.getShader().setLocalMatrix(matrix);
            return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
        }
        return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
    }

    public final kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> createRenderCommand(com.facebook.fresco.vito.renderer.BitmapImageDataModel bitmapImageDataModel, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint, android.graphics.Matrix matrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapImageDataModel, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(shape instanceof com.facebook.fresco.vito.renderer.RectShape)) {
            if (shape instanceof com.facebook.fresco.vito.renderer.CircleShape) {
                if (!bitmapImageDataModel.getIsBitmapCircular()) {
                    paint.setShader(new android.graphics.BitmapShader(bitmapImageDataModel.getBitmap(), android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
                    paint.getShader().setLocalMatrix(matrix);
                    return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
                }
                return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
            }
            paint.setShader(new android.graphics.BitmapShader(bitmapImageDataModel.getBitmap(), android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
            paint.getShader().setLocalMatrix(matrix);
            return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
        }
        return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
    }

    public final kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> createRenderCommand(com.facebook.fresco.vito.renderer.ColorIntImageDataModel colorIntImageDataModel, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(colorIntImageDataModel, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setColor(com.facebook.fresco.vito.renderer.util.ColorUtils.INSTANCE.multiplyColorAlpha(colorIntImageDataModel.getColorInt(), paint.getAlpha()));
        return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
    }

    public static /* synthetic */ kotlin.jvm.functions.Function1 createRenderCommand$default(com.facebook.fresco.vito.renderer.ImageRenderer imageRenderer, com.facebook.fresco.vito.renderer.DrawableImageDataModel drawableImageDataModel, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint, android.graphics.Matrix matrix, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            matrix = null;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawableImageDataModel, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        return shape instanceof com.facebook.fresco.vito.renderer.RectShape ? new com.facebook.fresco.vito.renderer.ImageRenderer.C01011(drawableImageDataModel, matrix, shape, paint) : new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass2(drawableImageDataModel, paint, matrix, shape);
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$createRenderCommand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ImageRenderer.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01011 implements kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> {
        final /* synthetic */ android.graphics.Matrix $imageTransformation;
        final /* synthetic */ android.graphics.Paint $paint;
        final /* synthetic */ com.facebook.fresco.vito.renderer.Shape $shape;
        final /* synthetic */ com.facebook.fresco.vito.renderer.DrawableImageDataModel $this_createRenderCommand;

        public C01011(com.facebook.fresco.vito.renderer.DrawableImageDataModel drawableImageDataModel, android.graphics.Matrix matrix, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint) {
            this.$this_createRenderCommand = drawableImageDataModel;
            this.$imageTransformation = matrix;
            this.$shape = shape;
            this.$paint = paint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.graphics.Canvas canvas) {
            invoke2(canvas);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(android.graphics.Canvas canvas) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.$this_createRenderCommand.getWidth() > 0 && this.$this_createRenderCommand.getHeight() > 0) {
                this.$this_createRenderCommand.getDrawable().setBounds(0, 0, this.$this_createRenderCommand.getWidth(), this.$this_createRenderCommand.getHeight());
                canvas.concat(this.$imageTransformation);
            } else {
                this.$this_createRenderCommand.getDrawable().setBounds((int) ((com.facebook.fresco.vito.renderer.RectShape) this.$shape).getRect().left, (int) ((com.facebook.fresco.vito.renderer.RectShape) this.$shape).getRect().top, (int) ((com.facebook.fresco.vito.renderer.RectShape) this.$shape).getRect().right, (int) ((com.facebook.fresco.vito.renderer.RectShape) this.$shape).getRect().bottom);
            }
            this.$this_createRenderCommand.getDrawable().setColorFilter(this.$paint.getColorFilter());
            this.$this_createRenderCommand.getDrawable().setAlpha(this.$paint.getAlpha());
            this.$this_createRenderCommand.getDrawable().draw(canvas);
        }
    }

    public final kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> createRenderCommand(com.facebook.fresco.vito.renderer.DrawableImageDataModel drawableImageDataModel, com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint, android.graphics.Matrix matrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawableImageDataModel, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        return shape instanceof com.facebook.fresco.vito.renderer.RectShape ? new com.facebook.fresco.vito.renderer.ImageRenderer.C01011(drawableImageDataModel, matrix, shape, paint) : new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass2(drawableImageDataModel, paint, matrix, shape);
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$createRenderCommand$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageRenderer.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2 implements kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> {
        final /* synthetic */ android.graphics.Matrix $imageTransformation;
        final /* synthetic */ android.graphics.Paint $paint;
        final /* synthetic */ com.facebook.fresco.vito.renderer.Shape $shape;
        final /* synthetic */ com.facebook.fresco.vito.renderer.DrawableImageDataModel $this_createRenderCommand;

        public AnonymousClass2(com.facebook.fresco.vito.renderer.DrawableImageDataModel drawableImageDataModel, android.graphics.Paint paint, android.graphics.Matrix matrix, com.facebook.fresco.vito.renderer.Shape shape) {
            this.$this_createRenderCommand = drawableImageDataModel;
            this.$paint = paint;
            this.$imageTransformation = matrix;
            this.$shape = shape;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.graphics.Canvas canvas) {
            invoke2(canvas);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(android.graphics.Canvas canvas) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.$this_createRenderCommand.getDrawable().setBounds(0, 0, this.$this_createRenderCommand.getWidth(), this.$this_createRenderCommand.getHeight());
            this.$this_createRenderCommand.getDrawable().setColorFilter(null);
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(this.$this_createRenderCommand.getWidth(), this.$this_createRenderCommand.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            this.$this_createRenderCommand.getDrawable().draw(new android.graphics.Canvas(bitmapCreateBitmap));
            com.facebook.fresco.vito.renderer.ImageRenderer imageRenderer = com.facebook.fresco.vito.renderer.ImageRenderer.INSTANCE;
            android.graphics.Paint paint = this.$paint;
            android.graphics.Matrix matrix = this.$imageTransformation;
            paint.setShader(new android.graphics.BitmapShader(bitmapCreateBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
            paint.getShader().setLocalMatrix(matrix);
            this.$shape.draw(canvas, this.$paint);
        }
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$bitmapRenderCommand$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageRenderer.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass1 implements kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> {
        final /* synthetic */ android.graphics.Bitmap $bitmap;
        final /* synthetic */ android.graphics.Matrix $imageTransformation;
        final /* synthetic */ android.graphics.Paint $paint;

        public AnonymousClass1(android.graphics.Matrix matrix, android.graphics.Bitmap bitmap, android.graphics.Paint paint) {
            this.$imageTransformation = matrix;
            this.$bitmap = bitmap;
            this.$paint = paint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.graphics.Canvas canvas) {
            invoke2(canvas);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(android.graphics.Canvas canvas) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.concat(this.$imageTransformation);
            canvas.drawBitmap(this.$bitmap, 0.0f, 0.0f, this.$paint);
        }
    }

    public final kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> bitmapRenderCommand(android.graphics.Paint paint, android.graphics.Bitmap bitmap, android.graphics.Matrix imageTransformation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new com.facebook.fresco.vito.renderer.ImageRenderer.AnonymousClass1(imageTransformation, bitmap, paint);
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$paintRenderCommand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ImageRenderer.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01021 implements kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> {
        final /* synthetic */ android.graphics.Paint $paint;
        final /* synthetic */ com.facebook.fresco.vito.renderer.Shape $shape;

        public C01021(com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint) {
            this.$shape = shape;
            this.$paint = paint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.graphics.Canvas canvas) {
            invoke2(canvas);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(android.graphics.Canvas canvas) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.$shape.draw(canvas, this.$paint);
        }
    }

    public final kotlin.jvm.functions.Function1<android.graphics.Canvas, kotlin.Unit> paintRenderCommand(com.facebook.fresco.vito.renderer.Shape shape, android.graphics.Paint paint) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shape, "shape");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "paint");
        return new com.facebook.fresco.vito.renderer.ImageRenderer.C01021(shape, paint);
    }

    public static /* synthetic */ android.graphics.Paint setBitmap$default(com.facebook.fresco.vito.renderer.ImageRenderer imageRenderer, android.graphics.Paint paint, android.graphics.Bitmap bitmap, android.graphics.Matrix matrix, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            matrix = null;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        paint.setShader(new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
        paint.getShader().setLocalMatrix(matrix);
        return paint;
    }

    public final android.graphics.Paint setBitmap(android.graphics.Paint paint, android.graphics.Bitmap bitmap, android.graphics.Matrix matrix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paint, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        paint.setShader(new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
        paint.getShader().setLocalMatrix(matrix);
        return paint;
    }
}
