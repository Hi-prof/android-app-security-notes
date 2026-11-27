# -*- coding: utf-8 -*-
import io, os
W = r"D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www"
files = ["app-service.js", "app-view.js", "pages/index/index.js"]
for f in files:
    p = os.path.join(W, f)
    if not os.path.exists(p):
        continue
    s = io.open(p, encoding="utf-8", errors="ignore").read()
    for nd in ["smapp.cc", "smshe.net", "tawk", "cfverify"]:
        i = s.find(nd)
        if i != -1:
            print("\n--- %s [%s] @%d ---" % (f, nd, i))
            print(s[max(0, i-500): i+500])
