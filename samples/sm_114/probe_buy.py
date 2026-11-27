# -*- coding: utf-8 -*-
"""关键对照实验：用 2 金币买一条 gold=1 的 svod 短视频，比较购买前后的 URL 是否可播。"""
import json, urllib.request, urllib.parse, subprocess, time

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
UID  = "94970"
TOK  = "eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc"

def call(name, method="GET", data=None, extra="", tok=True):
    url = API + "/" + name + "/appkey/" + KEY + extra
    hdr = {"User-Agent": "okhttp/3.12.0", "Content-Type": "application/x-www-form-urlencoded"}
    if tok: hdr["token"] = TOK
    body = urllib.parse.urlencode(data).encode() if data is not None else None
    r = urllib.request.Request(url, data=body, headers=hdr, method=method)
    try:
        with urllib.request.urlopen(r, timeout=25) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

def http_code(u):
    try:
        r = subprocess.run(["curl.exe", "-s", "-o", "NUL", "-w", "%{http_code}", "--max-time", "12",
                            "-A", "stagefright/1.2 (Linux;Android 13)", u],
                           capture_output=True, text=True, timeout=20)
        return r.stdout.strip()
    except Exception as e:
        return "ERR"

st, b = call("getSvodMain", "GET")
print("[getSvodMain]", st)
d = json.loads(b)
L = d.get("Data")
if isinstance(L, dict):
    L = L.get("list") or L.get("data") or []
print("  n=", len(L))
for it in L[:6]:
    print("   vid=%s gold=%s isBuy=%s  %s" % (it.get("id"), it.get("gold"), it.get("isBuy"), (it.get("title") or "")[:26]))
    print("      url=%s" % (it.get("url") or "")[:110])

target = None
for it in L:
    if int(it.get("gold") or 0) <= 1 and not it.get("isBuy") in (True, 1, "1"):
        target = it; break
if not target:
    target = L[0]
print("\n>>> target vid=%s gold=%s" % (target["id"], target.get("gold")))
print("before: url code =", http_code(target.get("url") or ""))

# 购买
st, b = call("goldBuyVideo", "POST", {"uid": UID, "vid": target["id"]})
print("[goldBuyVideo]", st, b[:200])

# 购买后重新取
st, b = call("getSvodMain", "GET")
d = json.loads(b); L2 = d.get("Data")
if isinstance(L2, dict): L2 = L2.get("list") or L2.get("data") or []
after = [x for x in L2 if str(x.get("id")) == str(target["id"])]
print("[after] found=%d" % len(after))
if after:
    a = after[0]
    print("  isBuy=%s url=%s" % (a.get("isBuy"), (a.get("url") or "")[:110]))
    print("after: url code =", http_code(a.get("url") or ""))

# playSvodVideo
st, b = call("playSvodVideo", "POST", {"uid": UID, "vid": target["id"]})
print("[playSvodVideo]", st, b[:400])
try:
    dd = json.loads(b).get("Data") or {}
    u = dd.get("url") or (dd.get("info") or {}).get("url")
    if u:
        print("  play url code =", http_code(u))
except Exception:
    pass

st, b = call("getUserInfo", "GET", extra="/userId/" + UID)
print("[userInfo]", b[:300])
