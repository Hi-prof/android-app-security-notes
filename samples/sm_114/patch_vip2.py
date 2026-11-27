# -*- coding: utf-8 -*-
"""第二层补丁：会员中心 / 个人页展示层 VIP 态"""
import os, re, shutil

HERE = os.path.dirname(os.path.abspath(__file__))
WWW  = os.path.join(HERE, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
BAK  = os.path.join(HERE, "www_backup")

def patch(path, pattern, repl, flags=0):
    p = os.path.join(WWW, path.replace("/", os.sep))
    src = open(p, encoding="utf-8", errors="surrogateescape").read()
    b = os.path.join(BAK, path.replace("/", os.sep))
    if not os.path.exists(b):
        os.makedirs(os.path.dirname(b), exist_ok=True)
        shutil.copy2(p, b)
    new, n = re.subn(pattern, repl, src, flags=flags)
    if n:
        open(p, "w", encoding="utf-8", errors="surrogateescape").write(new)
    print("  [%d] %s :: %s" % (n, path, pattern[:60]))
    return n

print("== app-service.js")
n = patch("app-service.js",
          r'(?<![.\w])(\w+)\.userInfo=t\.data\.Data,(?!\1\.userInfo\.isVip)',
          r'\1.userInfo=t.data.Data,\1.userInfo.isVip=!0,\1.userInfo.is_permanent=1,')
print("TOTAL", n)
