# -*- coding: utf-8 -*-
import io, os
W = r"D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www"
s = io.open(os.path.join(W, "app-service.js"), encoding="utf-8", errors="ignore").read()

def ctx(needle, pre=400, post=600, limit=6):
    i = s.find(needle); n = 0
    while i != -1 and n < limit:
        print("\n--- @%d [%s] ---" % (i, needle))
        print(s[max(0, i-pre): i+len(needle)+post])
        n += 1
        i = s.find(needle, i+1)
    if n == 0:
        print("[no hit] " + needle)

for nd in ["downUrl", "newAppApk", "getAppVersion", "appVersion", "checkUpdate", "updateTig"]:
    print("\n\n########## %s ##########" % nd)
    ctx(nd, 350, 700, 3)
