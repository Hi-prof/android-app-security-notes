package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g4 {
    private static java.lang.ref.WeakReference a = null;
    private static java.io.File b = null;
    private static final android.os.HandlerThread c;
    private static final android.os.Handler d;
    private static final android.os.Handler e;
    private static boolean f = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.p.g4.o a;

        a(io.dcloud.p.g4.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.p.g4.o a;
        final /* synthetic */ android.graphics.Bitmap b;

        b(io.dcloud.p.g4.o oVar, android.graphics.Bitmap bitmap) {
            this.a = oVar;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(null, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.p.g4.o a;

        c(io.dcloud.p.g4.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.view.PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ java.util.List a;
        final /* synthetic */ android.graphics.Bitmap b;
        final /* synthetic */ java.util.List c;
        final /* synthetic */ int d;
        final /* synthetic */ android.graphics.Bitmap e;
        final /* synthetic */ io.dcloud.p.g4.o f;

        d(java.util.List list, android.graphics.Bitmap bitmap, java.util.List list2, int i, android.graphics.Bitmap bitmap2, io.dcloud.p.g4.o oVar) {
            this.a = list;
            this.b = bitmap;
            this.c = list2;
            this.d = i;
            this.e = bitmap2;
            this.f = oVar;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i == 0) {
                this.a.add(this.b);
            } else {
                this.a.add(android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888));
            }
            io.dcloud.p.g4.b(this.c, this.d + 1, this.e, this.a, this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        final /* synthetic */ java.io.File a;

        e(java.io.File file) {
            this.a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.File[] fileArrListFiles;
            try {
                java.io.File file = this.a;
                if (file != null && file.exists() && (fileArrListFiles = this.a.listFiles()) != null) {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    for (java.io.File file2 : fileArrListFiles) {
                        if (jCurrentTimeMillis - file2.lastModified() > 604800000) {
                            io.dcloud.p.g4.c(file2);
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements io.dcloud.p.g4.o {
        final /* synthetic */ android.view.View a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ java.lang.String c;

        f(android.view.View view, android.app.Activity activity, java.lang.String str) {
            this.a = view;
            this.b = activity;
            this.c = str;
        }

        @Override // io.dcloud.p.g4.o
        public void a(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
            io.dcloud.p.g4.b("captureAndSaveAuto", bitmap, bitmap2, this.a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements io.dcloud.p.g4.o {
        final /* synthetic */ android.app.Activity a;
        final /* synthetic */ java.lang.String b;

        g(android.app.Activity activity, java.lang.String str) {
            this.a = activity;
            this.b = str;
        }

        @Override // io.dcloud.p.g4.o
        public void a(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
            io.dcloud.p.g4.b("captureTopAndSaveAuto", bitmap, bitmap2, null, this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class h implements java.lang.Runnable {
        final /* synthetic */ android.view.View a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ boolean c;
        final /* synthetic */ io.dcloud.p.g4.o d;

        h(android.view.View view, android.app.Activity activity, boolean z, io.dcloud.p.g4.o oVar) {
            this.a = view;
            this.b = activity;
            this.c = z;
            this.d = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.p.g4.b(this.a, this.b, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class i implements android.app.Application.ActivityLifecycleCallbacks {
        i() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            if (io.dcloud.p.g4.a == null || io.dcloud.p.g4.a.get() != activity) {
                return;
            }
            java.lang.ref.WeakReference unused = io.dcloud.p.g4.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            java.lang.ref.WeakReference unused = io.dcloud.p.g4.a = new java.lang.ref.WeakReference(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class j implements io.dcloud.p.g4.o {
        final /* synthetic */ android.graphics.Bitmap a;
        final /* synthetic */ android.view.View b;
        final /* synthetic */ java.util.List c;
        final /* synthetic */ int d;
        final /* synthetic */ io.dcloud.p.g4.o e;

        j(android.graphics.Bitmap bitmap, android.view.View view, java.util.List list, int i, io.dcloud.p.g4.o oVar) {
            this.a = bitmap;
            this.b = view;
            this.c = list;
            this.d = i;
            this.e = oVar;
        }

        @Override // io.dcloud.p.g4.o
        public void a(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
            if (bitmap2 != null) {
                bitmap = bitmap2;
            }
            if (bitmap != null) {
                android.graphics.Canvas canvas = new android.graphics.Canvas(this.a);
                int[] iArr = new int[2];
                this.b.getLocationOnScreen(iArr);
                canvas.drawBitmap(bitmap, iArr[0], iArr[1], (android.graphics.Paint) null);
            }
            io.dcloud.p.g4.b(this.c, this.d + 1, this.a, this.e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class k implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.p.g4.o a;

        k(io.dcloud.p.g4.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class l implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.p.g4.o a;
        final /* synthetic */ android.graphics.Bitmap b;

        l(io.dcloud.p.g4.o oVar, android.graphics.Bitmap bitmap) {
            this.a = oVar;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(null, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class m implements android.view.PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ io.dcloud.p.g4.o a;
        final /* synthetic */ android.graphics.Bitmap b;
        final /* synthetic */ android.view.View c;

        m(io.dcloud.p.g4.o oVar, android.graphics.Bitmap bitmap, android.view.View view) {
            this.a = oVar;
            this.b = bitmap;
            this.c = view;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i == 0) {
                this.a.a(null, this.b);
            } else {
                io.dcloud.p.g4.b(this.c, this.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class n implements android.view.PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ io.dcloud.p.g4.o a;
        final /* synthetic */ android.graphics.Bitmap b;
        final /* synthetic */ android.view.View c;

        n(io.dcloud.p.g4.o oVar, android.graphics.Bitmap bitmap, android.view.View view) {
            this.a = oVar;
            this.b = bitmap;
            this.c = view;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i == 0) {
                this.a.a(null, this.b);
            } else {
                io.dcloud.p.g4.b(this.c, this.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private interface o {
        void a(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2);
    }

    static {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ScreenshotWorker");
        c = handlerThread;
        handlerThread.start();
        d = new android.os.Handler(handlerThread.getLooper());
        e = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.view.View view, android.app.Activity activity, boolean z, io.dcloud.p.g4.o oVar) {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            e.post(new io.dcloud.p.g4.h(view, activity, z, oVar));
            return;
        }
        if (activity != null && view != null) {
            a(view, activity.getWindow(), oVar);
        } else if (view != null) {
            a(view, (android.view.Window) null, oVar);
        } else {
            a(activity, z, oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(java.io.File file) {
        java.io.File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (java.io.File file2 : fileArrListFiles) {
                c(file2);
            }
        }
        file.delete();
    }

    public static void a(android.view.View view, android.app.Activity activity, java.lang.String str) {
        b(view, activity, false, (io.dcloud.p.g4.o) new io.dcloud.p.g4.f(view, activity, str));
    }

    public static void a(android.app.Activity activity, boolean z, java.lang.String str) {
        b((android.view.View) null, activity, z, new io.dcloud.p.g4.g(activity, str));
    }

    public static void a(android.app.Application application) {
        if (f) {
            return;
        }
        f = true;
        java.io.File externalFilesDir = application.getExternalFilesDir("feedback");
        if (externalFilesDir != null) {
            b = externalFilesDir;
            b(externalFilesDir);
        }
        application.registerActivityLifecycleCallbacks(new io.dcloud.p.g4.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.util.List list, int i2, android.graphics.Bitmap bitmap, io.dcloud.p.g4.o oVar) {
        if (i2 >= list.size()) {
            a(list, bitmap, oVar);
        } else {
            android.view.View view = (android.view.View) list.get(i2);
            a(view, a(view), new io.dcloud.p.g4.j(bitmap, view, list, i2, oVar));
        }
    }

    private static void a(android.app.Activity activity, boolean z, io.dcloud.p.g4.o oVar) {
        java.lang.ref.WeakReference weakReference = a;
        android.app.Activity activity2 = weakReference != null ? (android.app.Activity) weakReference.get() : null;
        if (activity2 != null) {
            activity = activity2;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!z) {
            arrayList.addAll(b());
            if (arrayList.isEmpty() && activity != null) {
                arrayList.add(activity.getWindow().getDecorView());
            }
        } else if (activity != null) {
            arrayList.add(activity.getWindow().getDecorView());
        }
        if (arrayList.isEmpty()) {
            oVar.a(null, null);
            return;
        }
        android.view.View view = (android.view.View) arrayList.get(0);
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) view.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            displayMetrics = view.getResources().getDisplayMetrics();
        }
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        if (width <= 0 || height <= 0) {
            width = view.getWidth();
            height = view.getHeight();
        }
        if (width > 0 && height > 0) {
            b(arrayList, 0, android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888), oVar);
        } else {
            oVar.a(null, null);
        }
    }

    private static java.util.List b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.view.WindowManagerGlobal");
            java.lang.Object objInvoke = cls.getMethod("getInstance", null).invoke(null, null);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            java.util.List list = (java.util.List) declaredField.get(objInvoke);
            java.lang.reflect.Field declaredField2 = cls.getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            java.util.List list2 = (java.util.List) declaredField2.get(objInvoke);
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    android.view.View view = (android.view.View) list.get(i2);
                    if (view.getVisibility() == 0 && view.isShown() && view.getWidth() > 0 && view.getHeight() > 0 && (list2 == null || i2 >= list2.size() || ((android.view.WindowManager.LayoutParams) list2.get(i2)).type != 2005)) {
                        arrayList.add(view);
                    }
                }
            }
            return arrayList;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.view.View view, io.dcloud.p.g4.o oVar) {
        try {
            if (view.getWidth() > 0 && view.getHeight() > 0) {
                android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
                android.graphics.drawable.Drawable background = view.getBackground();
                if (background != null) {
                    background.draw(canvas);
                }
                view.draw(canvas);
                a(canvas, view, view);
                d.post(new io.dcloud.p.g4.b(oVar, bitmapCreateBitmap));
                return;
            }
            d.post(new io.dcloud.p.g4.a(oVar));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            d.post(new io.dcloud.p.g4.c(oVar));
        }
    }

    private static void a(android.view.View view, android.view.Window window, io.dcloud.p.g4.o oVar) {
        android.view.View decorView;
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            if (view instanceof android.view.TextureView) {
                d.post(new io.dcloud.p.g4.l(oVar, ((android.view.TextureView) view).getBitmap()));
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 24 && (view instanceof android.view.SurfaceView)) {
                android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                try {
                    android.view.PixelCopy.request((android.view.SurfaceView) view, bitmapCreateBitmap, new io.dcloud.p.g4.m(oVar, bitmapCreateBitmap, view), d);
                    return;
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                if (window == null) {
                    window = a(view);
                }
                if (window != null && (decorView = window.getDecorView()) != null && view.getWindowToken() != decorView.getWindowToken()) {
                    window = null;
                }
                if (window != null && window.getDecorView() != null) {
                    android.graphics.Bitmap bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i2 = iArr[0];
                    try {
                        android.view.PixelCopy.request(window, new android.graphics.Rect(i2, iArr[1], view.getWidth() + i2, iArr[1] + view.getHeight()), bitmapCreateBitmap2, new io.dcloud.p.g4.n(oVar, bitmapCreateBitmap2, view), d);
                        return;
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            b(view, oVar);
            return;
        }
        d.post(new io.dcloud.p.g4.k(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.util.List list, int i2, android.graphics.Bitmap bitmap, java.util.List list2, io.dcloud.p.g4.o oVar) {
        android.graphics.Bitmap bitmapCreateBitmap;
        if (i2 >= list.size()) {
            if (list2.isEmpty()) {
                bitmapCreateBitmap = null;
            } else {
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                java.util.Iterator it = list2.iterator();
                while (it.hasNext()) {
                    android.graphics.Bitmap bitmap2 = (android.graphics.Bitmap) it.next();
                    height += bitmap2.getHeight();
                    if (bitmap2.getWidth() > width) {
                        width = bitmap2.getWidth();
                    }
                }
                try {
                    bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
                    android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
                    canvas.drawColor(-16777216);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (android.graphics.Paint) null);
                    int height2 = bitmap.getHeight();
                    java.util.Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        android.graphics.Bitmap bitmap3 = (android.graphics.Bitmap) it2.next();
                        canvas.drawBitmap(bitmap3, 0.0f, height2, (android.graphics.Paint) null);
                        height2 += bitmap3.getHeight();
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    bitmapCreateBitmap = bitmap;
                }
            }
            if (!list2.isEmpty()) {
                try {
                    android.graphics.Bitmap bitmapCopy = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                    android.graphics.Canvas canvas2 = new android.graphics.Canvas(bitmapCopy);
                    android.graphics.Paint paint = new android.graphics.Paint();
                    paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
                    for (int size = list.size() - 1; size >= 0; size--) {
                        android.view.SurfaceView surfaceView = (android.view.SurfaceView) list.get(size);
                        android.graphics.Bitmap bitmap4 = (android.graphics.Bitmap) list2.get(size);
                        int[] iArr = new int[2];
                        surfaceView.getLocationOnScreen(iArr);
                        canvas2.drawBitmap(bitmap4, iArr[0], iArr[1], paint);
                    }
                    bitmap = bitmapCopy;
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            }
            oVar.a(bitmapCreateBitmap, bitmap);
            return;
        }
        android.view.SurfaceView surfaceView2 = (android.view.SurfaceView) list.get(i2);
        if (surfaceView2.getWidth() > 0 && surfaceView2.getHeight() > 0) {
            android.graphics.Bitmap bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(surfaceView2.getWidth(), surfaceView2.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            try {
                android.view.PixelCopy.request(surfaceView2, bitmapCreateBitmap2, new io.dcloud.p.g4.d(list2, bitmapCreateBitmap2, list, i2, bitmap, oVar), d);
                return;
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
                list2.add(android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888));
                b(list, i2 + 1, bitmap, list2, oVar);
                return;
            }
        }
        b(list, i2 + 1, bitmap, list2, oVar);
    }

    private static android.view.Window a(android.view.View view) {
        for (android.content.Context context = view.getContext(); context instanceof android.content.ContextWrapper; context = ((android.content.ContextWrapper) context).getBaseContext()) {
            if (context instanceof android.app.Activity) {
                return ((android.app.Activity) context).getWindow();
            }
        }
        return null;
    }

    private static void a(android.graphics.Canvas canvas, android.view.View view, android.view.View view2) {
        android.graphics.Bitmap bitmap;
        if (view2 instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                a(canvas, view, viewGroup.getChildAt(childCount));
            }
            return;
        }
        if ((view2 instanceof android.view.TextureView) && view2.getVisibility() == 0 && (bitmap = ((android.view.TextureView) view2).getBitmap()) != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            float f2 = iArr2[0] - iArr[0];
            float f3 = iArr2[1] - iArr[1];
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
            canvas.drawBitmap(bitmap, f2, f3, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void b(java.lang.String str, android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2, android.view.View view, android.app.Activity activity, java.lang.String str2) {
        java.io.File fileA;
        java.io.File fileA2;
        java.lang.ref.WeakReference weakReference;
        if (bitmap == null && bitmap2 == null) {
            android.util.Log.w("ScreenshotHelper", str + ": capture failed");
            return;
        }
        if (activity == 0 && (weakReference = a) != null) {
            activity = (android.content.Context) weakReference.get();
        }
        if (activity == 0 && view != null) {
            activity = view.getContext();
        }
        if (activity == 0 && b == null) {
            android.util.Log.w("ScreenshotHelper", str + ": no context available to save");
            return;
        }
        try {
            java.io.File externalFilesDir = b;
            if (externalFilesDir == null && activity != 0) {
                externalFilesDir = activity.getExternalFilesDir("feedback");
            }
            if (externalFilesDir == null) {
                return;
            }
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            java.lang.String str3 = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", java.util.Locale.getDefault()).format(new java.util.Date());
            if (str2 == null || str2.isEmpty()) {
                str2 = "screenshot";
            }
            java.io.File file = new java.io.File(externalFilesDir, str3 + "_" + str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (bitmap != null && (fileA2 = a(bitmap, new java.io.File(file, "appended.png"))) != null) {
                android.util.Log.i("ScreenshotHelper", str + ": appended saved at " + fileA2.getAbsolutePath());
            }
            if (bitmap2 == null || (fileA = a(bitmap2, new java.io.File(file, "layered.png"))) == null) {
                return;
            }
            android.util.Log.i("ScreenshotHelper", str + ": layered saved at " + fileA.getAbsolutePath());
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            android.util.Log.w("ScreenshotHelper", str + ": save failed " + e2.getMessage());
        }
    }

    private static void a(java.util.List list, android.graphics.Bitmap bitmap, io.dcloud.p.g4.o oVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            a((android.view.View) it.next(), arrayList);
        }
        if (arrayList.isEmpty()) {
            oVar.a(null, bitmap);
        } else {
            b(arrayList, 0, bitmap, new java.util.ArrayList(), oVar);
        }
    }

    private static void a(android.view.View view, java.util.List list) {
        if ((view instanceof android.view.SurfaceView) && view.getVisibility() == 0) {
            list.add((android.view.SurfaceView) view);
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), list);
            }
        }
    }

    private static java.io.File a(android.graphics.Bitmap bitmap, java.io.File file) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void b(java.io.File file) {
        d.post(new io.dcloud.p.g4.e(file));
    }
}
