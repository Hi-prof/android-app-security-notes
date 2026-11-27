# -*- coding: utf-8 -*-
"""v5：短视频 tab（真实页面 = pages/index/index.js）付费门禁去除"""
import os

ROOT = r"D:\AAA_RE\secret\samples\sm_114"
WWW  = os.path.join(ROOT, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
P    = os.path.join(WWW, "pages", "index", "index.js")

SUBS = [
    # 1) 逻辑门禁 isPlay()：VIP/gold/isBuy 判定整块跳过
    ("if(!this.userInfo.isVip&&parseInt(t.gold)>0&&!t.isBuy){",
     "if(!1){",
     "logic gate"),
    # 2) 模板：主分支条件恒真（长串优先）
    ("e.isBuy||!(e.gold>0)||t.userInfo.isVip||0!=t.userInfo.free||e.isPlay",
     "!0",
     "render main branch"),
    # 3) 模板：付费弹窗条件恒假
    ("!e.isBuy&&e.gold>0&&!t.userInfo.isVip&&0==t.userInfo.free&&!e.isPlay",
     "!1",
     "pay popup"),
    # 4) 模板：免费次数提示
    ("!e.isBuy&&e.gold>0&&!t.userInfo.isVip",
     "!1",
     "free-count hint"),
    # 5) 用户态强制 VIP + 无限免费次数
    ("t.userInfo=n.user;",
     "t.userInfo=n.user,t.userInfo.isVip=!0,t.userInfo.free=9999,t.userInfo.freeTot=9999;",
     "user vip state"),
]

t = open(P, encoding="utf-8").read()
print("before:", len(t))
for old, new, label in SUBS:
    n = t.count(old)
    print("[%s] hits=%d" % (label, n))
    if n == 1:
        t = t.replace(old, new)
    elif n > 1:
        print("  !! ambiguous, skipped")
open(P, "w", encoding="utf-8").write(t)
print("after:", len(t))
