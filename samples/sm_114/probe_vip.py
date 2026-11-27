# -*- coding: utf-8 -*-
"""用 VIP uid 拿任意视频 m3u8，验证 TS 可下载，并测试多条视频普适性"""
import json, urllib.request, re, subprocess, time

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
VIP  = 94965

def get(url, tok="x.y.z"):
    r = urllib.request.Request(url, headers={"User-Agent": "okhttp/3.12.0", "token": tok})
    try:
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, str(e)

def stream(vid, uid=VIP):
    u = "%s/appapi/getVideoStream/appkey/%s/stream/index.m3u8?video_id=%d&uid=%d&token=x.y.z&_t=%d" % (
        BASE, KEY, vid, uid, int(time.time() * 1000))
    return get(u)

def code(u):
    p = subprocess.run(["curl.exe", "-s", "-o", "NUL", "-w", "%{http_code}", "--max-time", "20", u],
                       capture_output=True, text=True)
    return p.stdout.strip()

st, body = stream(50363)
print("[50363] %s len=%d" % (st, len(body)))
open("vip50363.m3u8", "w", encoding="utf-8").write(body)
keym = re.search(r'URI="([^"]+)"', body)
segs = [l.strip() for l in body.splitlines() if l.strip() and not l.startswith("#")]
print("  segments=%d" % len(segs))
if keym: print("  key ->", code(keym.group(1)))
if segs:
    print("  seg0 ->", code(segs[0]))
    print("  segN ->", code(segs[-1]))

# 其他视频普适性
for vid in (50362, 50364, 50000, 1):
    st, b = stream(vid)
    ok = b.startswith("#EXTM3U")
    print("[vid=%d] %s %s" % (vid, st, "M3U8 %dB" % len(b) if ok else b[:90]))

# 对照：普通 uid
st, b = stream(50363, 94970)
print("[50363 with normal uid 94970] %s %s" % (st, b[:90]))
