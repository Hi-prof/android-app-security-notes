# -*- coding: utf-8 -*-
"""金币获取面测试：签到 / 新手任务 / 奖励重复领取"""
import json, urllib.request, urllib.parse, time, random, string

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
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

def corn():
    st, b = call("getUserInfo", "GET", extra="/userId/" + UID)
    try:
        d = json.loads(b)["Data"]
        return d.get("corn"), d.get("isVip"), d.get("is_permanent")
    except Exception:
        return None, None, None

print("baseline corn=%s isVip=%s perm=%s" % corn())

st, b = call("userSign", "GET", extra="/userId/" + UID)
print("[userSign]", st, b[:200])
print("after sign corn=%s" % (corn()[0],))

did = "did" + "".join(random.choices(string.hexdigits.lower(), k=12))
for tag, data in [
    ("empty-token", {"uid": UID, "cf_token": "", "did": did, "device": '{"ua":"android"}'}),
    ("fake-token",  {"uid": UID, "cf_token": "abc123", "did": did, "device": '{"ua":"android"}'}),
    ("no-token",    {"uid": UID, "did": did, "device": '{"ua":"android"}'}),
]:
    st, b = call("completeNewbieTask", "POST", data)
    print("[newbie:%s] %s %s" % (tag, st, b[:220]))
    print("   corn=%s" % (corn()[0],))

# 重复签到
for i in range(2):
    st, b = call("userSign", "GET", extra="/userId/" + UID)
    print("[userSign repeat %d] %s %s" % (i, st, b[:160]))
print("final corn=%s" % (corn()[0],))
