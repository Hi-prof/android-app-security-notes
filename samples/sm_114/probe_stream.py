# -*- coding: utf-8 -*-
"""购买后测 getSvodStream / getVideoStream 是否放行"""
import urllib.request, urllib.parse, time, subprocess

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
UID  = "94970"
TOK  = "eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc"

def get(url, headers=None):
    hdr = {"User-Agent": "okhttp/3.12.0", "token": TOK}
    if headers: hdr.update(headers)
    r = urllib.request.Request(url, headers=hdr)
    try:
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, dict(resp.headers), resp.read()
    except urllib.error.HTTPError as e:
        return e.code, dict(e.headers), e.read()
    except Exception as e:
        return -1, {}, str(e).encode()

ts = int(time.time() * 1000)

# 已购买的 svod vid=821
u1 = "%s/getSvodStream/appkey/%s/stream/index.m3u8?vid=821&uid=%s&token=%s&_t=%d" % (API, KEY, UID, TOK, ts)
st, h, body = get(u1)
print("[getSvodStream 821 bought] %s  ctype=%s len=%d" % (st, h.get("Content-Type"), len(body)))
print("  head:", body[:300])

# 未购买的付费视频 50363
u2 = "%s/getVideoStream/appkey/%s/stream/index.m3u8?video_id=50363&uid=%s&token=%s&_t=%d" % (API, KEY, UID, TOK, ts)
st, h, body = get(u2)
print("[getVideoStream 50363 unbought] %s len=%d" % (st, len(body)))
print("  body:", body[:200])

# 已购买的 svod，用 detail 的 url 再试
print("\n--- 已购买 svod 的 CDN url 再测")
import json
st, h, body = get("%s/getSvodMain/appkey/%s" % (API, KEY))
items = json.loads(body.decode("utf-8", "replace")).get("Data") or []
for it in items:
    if str(it.get("id")) == "821":
        print("  isBuy=%s" % it.get("isBuy"))
        u = it.get("url") or ""
        r = subprocess.run(["curl.exe", "-s", "-o", "NUL", "-w", "%{http_code}", "--max-time", "12", u],
                           capture_output=True, text=True)
        print("  url code:", r.stdout.strip())
        print("  url:", u[:140])
