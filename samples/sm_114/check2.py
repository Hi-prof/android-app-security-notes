# -*- coding: utf-8 -*-
"""核对最终 APK 四个 entry 的大小与关键补丁串"""
import zipfile

APK = r"D:\AAA_RE\secret\samples\sm_114\sm_114.patched.apk"
BASE = "assets/apps/__UNI__GF0182AE/www/"
CHECKS = {
    "pages/video/play.js":  ["uid:94965", "isVipUser:function(){return!0}"],
    "pages/index/index.js": ["if(!1){", "t.userInfo.isVip=!0"],
    "pages/svod/player.js": ["!1&&(parseInt(this.user.free)", "isVip:!0,freeTot"],
    "app-service.js":       [".userInfo.isVip=!0,"],
}

z = zipfile.ZipFile(APK)
for rel, probes in CHECKS.items():
    name = BASE + rel
    d = z.read(name).decode("utf-8", "replace")
    print("%-24s stored=%7d" % (rel, len(d)))
    for p in probes:
        print("    %-46s %s" % (p, "OK" if p in d else "MISSING"))
