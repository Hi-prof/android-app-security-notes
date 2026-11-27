# -*- coding: utf-8 -*-
"""v4：短视频播放页 pages/svod/player.js 付费门禁去除 + VIP 标识"""
import os

ROOT = r"D:\AAA_RE\secret\samples\sm_114"
WWW  = os.path.join(ROOT, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
P    = os.path.join(WWW, "pages", "svod", "player.js")

SUBS = [
    # 1) 付费门禁：!user.isVip && gold>0 && !isBuy -> 恒假
    ("!this.user.isVip&&parseInt(this.info.gold)>0&&!this.info.isBuy&&",
     "!1&&",
     "svod pay gate"),
    # 2) 初始用户态直接标记 VIP（渲染「尊贵VIP」）
    ('user:{isVip:!1,freeTot:0,free:0}',
     'user:{isVip:!0,freeTot:0,free:0}',
     "svod user vip flag"),
]

t = open(P, encoding="utf-8").read()
print("before:", len(t))
for old, new, label in SUBS:
    n = t.count(old)
    print("[%s] hits=%d" % (label, n))
    if n >= 1:
        t = t.replace(old, new)
open(P, "w", encoding="utf-8").write(t)
print("after:", len(t))
