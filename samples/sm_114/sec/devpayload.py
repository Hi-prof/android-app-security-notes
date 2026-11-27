# -*- coding: utf-8 -*-
"""分析前端上报字段：找 device/did 组装处，看采集了哪些系统信息。"""
import io, os, re, sys

WWW = r"D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www"
NEEDLES = [
    "getSystemInfo", "getSystemInfoSync", "deviceId", "imei", "androidId",
    "device:{", "device:{", "did:", "JSON.stringify", "screenWidth",
    "brand", "model", "osName", "uuid", "getDeviceInfo",
]
TARGETS = ["app-service.js", "pages/index/index.js", "pages/video/play.js"]

def show(path, needle, pre=260, post=420, limit=4):
    with io.open(path, encoding="utf-8", errors="ignore") as f:
        s = f.read()
    n = 0
    i = s.find(needle)
    while i != -1 and n < limit:
        seg = s[max(0, i - pre): i + len(needle) + post]
        print("\n--- %s @%d [%s] ---" % (os.path.basename(path), i, needle))
        print(seg.replace("\n", "\\n"))
        n += 1
        i = s.find(needle, i + 1)

for t in TARGETS:
    p = os.path.join(WWW, t)
    if not os.path.exists(p):
        continue
    print("\n\n========== %s ==========" % t)
    for nd in ["device:{", "getSystemInfoSync", "osName:", "deviceId"]:
        show(p, nd)
