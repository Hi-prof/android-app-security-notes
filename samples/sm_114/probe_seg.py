# -*- coding: utf-8 -*-
"""取已购买视频的 m3u8，验证 key / ts 分片能否下载"""
import urllib.request, time, subprocess, re, os

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
UID  = "94970"
TOK  = "eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc"

ts = int(time.time() * 1000)
u = "%s/getSvodStream/appkey/%s/stream/index.m3u8?vid=821&uid=%s&token=%s&_t=%d" % (API, KEY, UID, TOK, ts)
r = urllib.request.Request(u, headers={"User-Agent": "okhttp/3.12.0", "token": TOK})
with urllib.request.urlopen(r, timeout=20) as resp:
    m3u8 = resp.read().decode("utf-8", "replace")

open("svod821.m3u8", "w", encoding="utf-8").write(m3u8)
print("m3u8 len=%d" % len(m3u8))
print(m3u8[:700])
print("...")

key = re.search(r'URI="([^"]+)"', m3u8)
segs = [l.strip() for l in m3u8.splitlines() if l.strip() and not l.startswith("#")]
print("\nsegments:", len(segs))

def code(url):
    p = subprocess.run(["curl.exe", "-s", "-o", "NUL", "-w", "%{http_code}", "--max-time", "20", url],
                       capture_output=True, text=True)
    return p.stdout.strip()

if key:
    print("key code:", code(key.group(1)))
if segs:
    print("seg[0] code:", code(segs[0]))
    print("seg[-1] code:", code(segs[-1]))
