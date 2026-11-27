# -*- coding: utf-8 -*-
import json, urllib.request, urllib.parse, time, sys

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
UID  = "94970"
TOK  = "eyJ1aWQiOjk0OTcwLCJpYXQiOjE3OTUzNjg2MjAsImV4cCI6MTc5Nzk2MDYyMCwibm9uY2UiOiJiNTQ5YzY4ZDQ3OTA3Y2M5IiwidiI6MX0.9373ed25bfd0883595f85ab8db9ee773ebf6f4a8540b582baf0d3d02732fe3bc"
DID  = "didtest94970"

def req(name, method="GET", data=None, extra=None, headers=None):
    path = "/" + name + "/appkey/" + KEY + (extra or "")
    url = API + path
    hdr = {"User-Agent": "okhttp/3.12.0", "token": TOK}
    body = None
    if data is not None:
        body = urllib.parse.urlencode(data).encode()
        hdr["Content-Type"] = "application/x-www-form-urlencoded"
    if headers: hdr.update(headers)
    r = urllib.request.Request(url, data=body, headers=hdr, method=method)
    try:
        with urllib.request.urlopen(r, timeout=20) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

def show(tag, st, body, n=420):
    print("[%s] %s %s" % (tag, st, body[:n].replace("\n", " ")))

# 1. 余额基线
show("balance-before", *req("balance", "GET", extra="/userId/" + UID))
# 2. 直接买（余额 2 / 价格 13）
show("buyVideo", *req("buy", "POST", {"videoId": 50363, "userId": UID, "did": DID}))
# 3. goldBuyVideo 形态1
show("goldBuyVideo", *req("goldBuyVideo", "POST", {"videoId": 50363, "userId": UID, "did": DID}))
# 4. updateFree
show("updateFree", *req("updateFree", "POST", {"videoId": 50363, "userId": UID}))
# 5. updateTryTime
show("updateTryTime", *req("updateTryTime", "POST", {"videoId": 50363, "userId": UID, "time": 15}))
# 6. 买完后看状态
show("detail-after", *req("detail", "POST", {"videoId": 50363, "userId": UID, "did": DID, "subId": 0, "sys": "android"}))
show("balance-after", *req("balance", "GET", extra="/userId/" + UID))
