# -*- coding: utf-8 -*-
import io, os
W = r"D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www"

def ctx(path, needle, pre=500, post=900, limit=3):
    p = os.path.join(W, path)
    s = io.open(p, encoding="utf-8", errors="ignore").read()
    i = s.find(needle); n = 0
    while i != -1 and n < limit:
        print("\n--- %s @%d ---" % (path, i))
        print(s[max(0, i-pre): i+len(needle)+post])
        n += 1
        i = s.find(needle, i+1)
    if n == 0:
        print("\n[no hit] %s in %s" % (needle, path))

ctx("app-service.js", "plus.runtime.install", 700, 1200)
print("\n\n===== uni.getLocation 实际调用 =====")
for f in ["app-service.js", "pages/index/index.js", "pages/video/play.js"]:
    p = os.path.join(W, f)
    if not os.path.exists(p):
        continue
    s = io.open(p, encoding="utf-8", errors="ignore").read()
    for nd in ["uni.getLocation(", "getLocation({", "chooseLocation("]:
        c = s.count(nd)
        print("%-28s %-20s %d" % (f, nd, c))
