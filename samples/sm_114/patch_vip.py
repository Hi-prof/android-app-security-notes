# -*- coding: utf-8 -*-
"""对 uni-app 前端 JS 打会员解锁补丁。逐处替换并报告命中次数。"""
import os, shutil, sys, json

HERE = os.path.dirname(os.path.abspath(__file__))
WWW  = os.path.join(HERE, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
BAK  = os.path.join(HERE, "www_backup")

RULES = {
    "pages/video/play.js": [
        # 1) 播放地址：detail 已下发的签名 m3u8 优先，绕开 getVideoStream 的付费校验
        (
            'i=e||this.info&&this.info.videoInfo&&this.info.videoInfo.id||C;return g.default.buildVideoStreamUrl(',
            'i=e||this.info&&this.info.videoInfo&&this.info.videoInfo.id||C;'
            'var _lu=this.info&&this.info.videoInfo&&this.info.videoInfo.url;if(_lu)return _lu;'
            'return g.default.buildVideoStreamUrl(',
        ),
        # 2) detail 回包后强制 VIP 态（放行付费拦截/跳广告/切画质/下载）
        (
            'n.info=e.Data,n.videoline=e.Data.videoInfo.videoline',
            'n.info=e.Data,n.info.isVip=!0,n.info.is_permanent=1,n.info.alreadyBuy=1,'
            'n.info.member&&(n.info.member.isVip=!0,n.info.member.is_permanent=1),'
            'n.videoline=e.Data.videoInfo.videoline',
        ),
        # 3) 组件内 isVipUser 恒真
        (
            'isVipUser:function(){return g.default.isVipUser(this.info)}',
            'isVipUser:function(){return!0}',
        ),
    ],
}

def apply(path, rules):
    p = os.path.join(WWW, path.replace("/", os.sep))
    if not os.path.exists(p):
        print("  MISS FILE", path); return False
    src = open(p, encoding="utf-8", errors="surrogateescape").read()
    b = os.path.join(BAK, path.replace("/", os.sep))
    if not os.path.exists(b):
        os.makedirs(os.path.dirname(b), exist_ok=True)
        shutil.copy2(p, b)
    changed = 0
    for old, new in rules:
        c = src.count(old)
        print("  [%d hit] %s" % (c, old[:70].replace("\n", " ")))
        if c:
            src = src.replace(old, new)
            changed += c
    if changed:
        open(p, "w", encoding="utf-8", errors="surrogateescape").write(src)
        print("  -> %s patched (%d sites)" % (path, changed))
    return changed > 0

if __name__ == "__main__":
    ok = True
    for f, r in RULES.items():
        print("== " + f)
        ok = apply(f, r) and ok
    print("RESULT", "OK" if ok else "FAIL")
