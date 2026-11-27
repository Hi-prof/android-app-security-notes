# -*- coding: utf-8 -*-
"""v3 补丁：从备份恢复 -> 注入 VIP uid 取流 + UI 会员态"""
import os, re, shutil, sys

ROOT = r"D:\AAA_RE\secret\samples\sm_114"
WWW  = os.path.join(ROOT, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
BAK  = os.path.join(ROOT, "www_backup")
VIP_UID = 94965

def restore():
    for rel in ("app-service.js", os.path.join("pages", "video", "play.js")):
        s = os.path.join(BAK, rel)
        d = os.path.join(WWW, rel)
        shutil.copy2(s, d)
        print("restored", rel, os.path.getsize(d))

def sub(path, old, new, label):
    p = os.path.join(WWW, path)
    with open(p, "r", encoding="utf-8") as f:
        t = f.read()
    n = t.count(old)
    print("[%s] hits=%d" % (label, n))
    if n != 1:
        print("  !! expected 1 hit, abort this substitution")
        return 0
    t = t.replace(old, new)
    with open(p, "w", encoding="utf-8") as f:
        f.write(t)
    print("  ok ->", os.path.getsize(p))
    return 1

restore()
ok = 0

# 1) 播放流改用 VIP uid（token 服务端不校验，原样保留）
ok += sub("pages/video/play.js",
          "{video_id:i,uid:A,",
          "{video_id:i,uid:%d," % VIP_UID,
          "stream uid -> VIP")

# 2) detail 回调：会员态/已购态置真
ok += sub("pages/video/play.js",
          "n.info=e.Data,n.videoline=e.Data.videoInfo.videoline",
          "n.info=e.Data,n.info.isVip=!0,n.info.is_permanent=1,n.info.alreadyBuy=1,"
          "n.info.member&&(n.info.member.isVip=!0,n.info.member.is_permanent=1),"
          "n.videoline=e.Data.videoInfo.videoline",
          "detail vip state")

# 3) 播放页本地判定函数恒真
ok += sub("pages/video/play.js",
          "isVipUser:function(){return g.default.isVipUser(this.info)}",
          "isVipUser:function(){return!0}",
          "isVipUser()")

# 4) 会员中心/个人页/充值页展示态
p = os.path.join(WWW, "app-service.js")
with open(p, "r", encoding="utf-8") as f:
    t = f.read()
t2, n = re.subn(r"(\w+)\.userInfo=t\.data\.Data,",
                r"\1.userInfo=t.data.Data,\1.userInfo.isVip=!0,\1.userInfo.is_permanent=1,", t)
print("[app-service userInfo] hits=%d" % n)
if n:
    with open(p, "w", encoding="utf-8") as f:
        f.write(t2)
    print("  ok ->", os.path.getsize(p))
    ok += 1

print("SUBS OK =", ok)
