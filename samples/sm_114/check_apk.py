# -*- coding: utf-8 -*-
"""核对 patched APK 内实际内容"""
import zipfile, sys

APK = r"D:\AAA_RE\secret\samples\sm_114\sm_114.patched.apk"
P = "assets/apps/__UNI__GF0182AE/www/pages/svod/player.js"
V = "assets/apps/__UNI__GF0182AE/www/pages/video/play.js"

z = zipfile.ZipFile(APK)
for name in (P, V):
    d = z.read(name).decode("utf-8", "replace")
    print("%s len=%d" % (name.split("/")[-1], len(d)))
    for probe in ("!1&&(parseInt(this.user.free)", "uid:94965", "isVip:!0,freeTot", "isVipUser:function(){return!0}"):
        print("   %-34s %s" % (probe, "FOUND" if probe in d else "-"))
