# -*- coding: utf-8 -*-
"""scan native libs in the APK for sensitive capability strings"""
import zipfile, re, os, sys

APK = r"D:\AAA_RE\secret\samples\sm_114\sm_114.original.apk"
OUT = r"D:\AAA_RE\secret\samples\sm_114\sec"
os.makedirs(OUT, exist_ok=True)

NEEDLES = [
    b"/system/bin/su", b"/system/xbin/su", b"magisk", b"superuser",
    b"content://sms", b"content://contacts", b"content://call_log",
    b"ContactsContract", b"TelephonyManager", b"getDeviceId",
    b"getSubscriberId", b"getLastKnownLocation", b"ACCESS_FINE_LOCATION",
    b"android.permission.", b"pm install", b"installPackage",
    b"keylogger", b"screenrecord", b"MediaProjection",
    b"/proc/self/maps", b"ptrace", b"frida", b"xposed",
]

z = zipfile.ZipFile(APK)
rows = []
for n in z.namelist():
    if not n.endswith(".so"):
        continue
    data = z.read(n)
    hits = []
    for nd in NEEDLES:
        c = data.count(nd)
        if c:
            hits.append("%s x%d" % (nd.decode(), c))
    rows.append((n, len(data), hits))

lines = []
for n, sz, hits in sorted(rows, key=lambda r: -r[1]):
    lines.append("=== %s  (%d bytes)" % (n, sz))
    if hits:
        for h in hits:
            lines.append("    " + h)
    else:
        lines.append("    (no sensitive needle)")

# suspicious permission strings anywhere in so
open(os.path.join(OUT, "so_scan.txt"), "w", encoding="utf-8").write("\n".join(lines))
print("\n".join(lines))
