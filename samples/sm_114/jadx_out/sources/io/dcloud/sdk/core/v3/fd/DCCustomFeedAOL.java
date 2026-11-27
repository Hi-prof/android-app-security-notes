package io.dcloud.sdk.core.v3.fd;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCCustomFeedAOL {
    private final io.dcloud.sdk.core.v3.fd.DCFeedAOL a;
    private final android.app.Activity b;
    private android.os.CountDownTimer c;
    private java.lang.Runnable g;
    private android.widget.TextView i;
    private android.widget.FrameLayout j;
    private long d = io.dcloud.WebAppActivity.SPLASH_SECOND;
    private boolean e = false;
    private boolean h = false;
    private final android.os.Handler f = new android.os.Handler();

    /* JADX INFO: renamed from: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class AnonymousClass8 extends android.os.CountDownTimer {
        final /* synthetic */ android.widget.TextView a;
        final /* synthetic */ android.widget.FrameLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(long j, long j2, android.widget.TextView textView, android.widget.FrameLayout frameLayout) {
            super(j, j2);
            this.a = textView;
            this.b = frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(android.widget.TextView textView, int i) {
            if (textView != null) {
                textView.setText(i + "s");
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.e = false;
            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.d = 0L;
            if (io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.h) {
                return;
            }
            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c(this.a, this.b);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.d = j;
            final int iMax = java.lang.Math.max(0, java.lang.Math.round(j / 1000.0f));
            android.app.Activity activity = io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b;
            final android.widget.TextView textView = this.a;
            activity.runOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL$8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.AnonymousClass8.a(textView, iMax);
                }
            });
        }
    }

    public DCCustomFeedAOL(io.dcloud.sdk.core.v3.fd.DCFeedAOL dCFeedAOL, android.app.Activity activity) {
        this.a = dCFeedAOL;
        this.b = activity;
    }

    public android.view.View getFeedAOLView() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOL dCFeedAOL = this.a;
        if (dCFeedAOL != null) {
            if (dCFeedAOL.isExpressAd()) {
                return this.a.getFeedAOLView(this.b);
            }
            final android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) android.view.LayoutInflater.from(this.b).inflate(io.dcloud.base.R.layout.dcloud_ad_custom_feed_ad, (android.view.ViewGroup) null);
            if (this.a.getMaterialType() == 1) {
                long videoDuration = (long) (this.a.getVideoDuration() * 1000.0d);
                this.d = videoDuration;
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) frameLayout.findViewById(io.dcloud.base.R.id.videoContainer);
                android.view.View videoView = this.a.getVideoView(this.b);
                if (videoView != null) {
                    viewGroup.addView(videoView, new android.view.ViewGroup.LayoutParams(-1, -1));
                    android.widget.TextView textView = (android.widget.TextView) frameLayout.findViewById(io.dcloud.base.R.id.privacyInfo);
                    if (this.a.getInteractionType() == 1) {
                        final io.dcloud.sdk.core.interfaces.AOLLoader.AppInfo appInfo = this.a.getAppInfo();
                        android.text.SpannableString spannableString = new android.text.SpannableString(java.lang.String.format(java.util.Locale.ENGLISH, "应用名称：%s|开发者：%s|应用版本：%s|隐私协议|权限详情|简介", appInfo.getAppName(), appInfo.getDeveloperName(), appInfo.getAppVersion()));
                        android.text.style.ClickableSpan clickableSpan = new android.text.style.ClickableSpan() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(android.view.View view) {
                                android.content.Intent intent = new android.content.Intent(io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b, (java.lang.Class<?>) io.dcloud.sdk.activity.WebViewActivity.class);
                                intent.putExtra("url", appInfo.getPrivacyUrl());
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b.startActivity(intent);
                            }
                        };
                        android.text.style.ClickableSpan clickableSpan2 = new android.text.style.ClickableSpan() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.2
                            @Override // android.text.style.ClickableSpan
                            public void onClick(android.view.View view) {
                                android.content.Intent intent = new android.content.Intent(io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b, (java.lang.Class<?>) io.dcloud.sdk.activity.WebViewActivity.class);
                                intent.putExtra("url", appInfo.getPermissionInfoUrl());
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b.startActivity(intent);
                            }
                        };
                        android.text.style.ClickableSpan clickableSpan3 = new android.text.style.ClickableSpan() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.3
                            @Override // android.text.style.ClickableSpan
                            public void onClick(android.view.View view) {
                                android.content.Intent intent = new android.content.Intent(io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b, (java.lang.Class<?>) io.dcloud.sdk.activity.WebViewActivity.class);
                                intent.putExtra("url", appInfo.getFunctionDescUrl());
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b.startActivity(intent);
                            }
                        };
                        spannableString.setSpan(clickableSpan, spannableString.toString().indexOf("隐私协议"), spannableString.toString().indexOf("隐私协议") + 4, 33);
                        spannableString.setSpan(clickableSpan2, spannableString.toString().indexOf("权限详情"), spannableString.toString().indexOf("权限详情") + 4, 33);
                        spannableString.setSpan(clickableSpan3, spannableString.toString().indexOf("简介"), spannableString.toString().indexOf("简介") + 2, 33);
                        textView.setText(spannableString);
                        textView.setVisibility(0);
                        textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
                    } else {
                        textView.setVisibility(8);
                    }
                    final android.widget.TextView textView2 = (android.widget.TextView) frameLayout.findViewById(io.dcloud.base.R.id.skipView);
                    textView2.setText(java.lang.Math.max(0, java.lang.Math.round(videoDuration / 1000.0f)) + "s");
                    this.i = textView2;
                    this.j = frameLayout;
                    textView2.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(android.view.View view) {
                            if (io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.e) {
                                return;
                            }
                            if (io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.g != null) {
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.f.removeCallbacks(io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.g);
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.h = false;
                            }
                            if (frameLayout.getParent() instanceof android.view.ViewGroup) {
                                ((android.view.ViewGroup) frameLayout.getParent()).removeView(frameLayout);
                            }
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.a.onClosed("");
                        }
                    });
                    this.a.setVideoAdListener(new io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.5
                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onProgressUpdate(long j, long j2) {
                        }

                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onVideoAdComplete() {
                            if (io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c != null) {
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c.cancel();
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c = null;
                            }
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.e = false;
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.d = 0L;
                            if (io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.h) {
                                return;
                            }
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c(textView2, frameLayout);
                        }

                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onVideoAdPaused() {
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.a();
                        }

                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onVideoAdResume() {
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b();
                        }

                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onVideoAdStartPlay() {
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c();
                        }

                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onVideoError(int i, java.lang.String str) {
                            if (io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c != null) {
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c.cancel();
                                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c = null;
                            }
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.e = false;
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.c(textView2, frameLayout);
                        }

                        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VideoAdListener
                        public void onVideoLoad() {
                            io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.b(textView2, frameLayout);
                        }
                    });
                    this.a.registerViewForInteraction(this.b, frameLayout, new java.util.ArrayList<android.view.View>(videoView) { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.6
                        final /* synthetic */ android.view.View a;

                        {
                            this.a = videoView;
                            add(videoView);
                        }
                    }, null, null);
                    return frameLayout;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final android.widget.TextView textView, final android.widget.FrameLayout frameLayout) {
        if (this.h) {
            return;
        }
        android.os.CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.c = null;
        }
        this.e = false;
        this.d = 0L;
        this.b.runOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(textView, frameLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.widget.TextView textView, android.widget.FrameLayout frameLayout) {
        android.os.CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.c = null;
        }
        if (this.d <= 0) {
            this.d = 1000L;
        }
        this.c = new io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.AnonymousClass8(this.d, 1000L, textView, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(android.widget.TextView textView, final android.widget.FrameLayout frameLayout) {
        if (textView != null) {
            textView.setText("关闭");
        }
        java.lang.Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
        this.g = new java.lang.Runnable() { // from class: io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.7
            @Override // java.lang.Runnable
            public void run() {
                android.widget.FrameLayout frameLayout2 = frameLayout;
                if (frameLayout2 != null && (frameLayout2.getParent() instanceof android.view.ViewGroup)) {
                    ((android.view.ViewGroup) frameLayout.getParent()).removeView(frameLayout);
                }
                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.h = false;
                io.dcloud.sdk.core.v3.fd.DCCustomFeedAOL.this.a.onClosed("");
            }
        };
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        android.widget.TextView textView;
        android.widget.FrameLayout frameLayout;
        if (this.e || this.d <= 0 || (textView = this.i) == null || (frameLayout = this.j) == null) {
            return;
        }
        b(textView, frameLayout);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        android.os.CountDownTimer countDownTimer = this.c;
        if (countDownTimer == null || this.e) {
            return;
        }
        this.e = true;
        countDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        android.os.CountDownTimer countDownTimer = this.c;
        if (countDownTimer == null || !this.e) {
            return;
        }
        countDownTimer.cancel();
        this.c = null;
        this.e = false;
    }
}
