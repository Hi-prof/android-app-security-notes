# -*- coding: utf-8 -*-
import json, re, os, urllib.request, urllib.parse, uuid, io, sys, time

BASE = "https://heootjfch5.842644.xyz"
KEY  = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
API  = BASE + "/appapi"
WWW  = os.path.join(os.path.dirname(os.path.abspath(__file__)), "unzip", "assets", "apps", "__UNI__GF0182AE", "www")

def req(path, method="GET", data=None, headers=None, timeout=20):
    url = path if path.startswith("http") else API + path
    hdr = {"User-Agent": "okhttp/3.12.0"}
    body = None
    if data is not None:
        body = urllib.parse.urlencode(data).encode()
        hdr["Content-Type"] = "application/x-www-form-urlencoded"
    if headers:
        hdr.update(headers)
    r = urllib.request.Request(url, data=body, headers=hdr, method=method)
    try:
        with urllib.request.urlopen(r, timeout=timeout) as resp:
            return resp.status, resp.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return -1, "EXC %s" % e

def ep(name, **kw):
    q = "/" + name + "/appkey/" + KEY
    return q

# ---------- 1. 全量端点表 ----------
def dump_endpoints():
    src = open(os.path.join(WWW, "pages", "index", "index.js"), encoding="utf-8", errors="replace").read()
    i = src.find('apiData')
    if i < 0:
        print("apiData not found"); return {}
    seg = src[i:i+30000]
    # 形如 name:A+"/"+B+"/path/appkey/"+h
    pat = re.compile(r'([A-Za-z_][A-Za-z0-9_]*)\s*:\s*[A-Za-z_$]\s*\+\s*"/"\s*\+\s*[A-Za-z_$]\s*\+\s*"/([^"]+)')
    out = {}
    for m in pat.finditer(seg):
        out[m.group(1)] = m.group(2)
    print("[endpoints] count=%d" % len(out))
    with open("endpoints.txt", "w", encoding="utf-8") as f:
        for k, v in sorted(out.items()):
            f.write("%s\t%s\n" % (k, v))
    return out

# ---------- 2. 注册 ----------
def register():
    did = "did" + uuid.uuid4().hex[:12]
    acc = "u" + uuid.uuid4().hex[:10]
    pwd = "abc123456"
    st, body = req(ep("register"), "POST", {
        "account": acc, "mobileCode": "", "pwd": pwd, "pid": 0,
        "did": did, "device": "{}", "cid": "", "sys": "android"
    })
    print("[register] %s %s" % (st, body[:400]))
    try:
        d = json.loads(body)
    except Exception:
        return None, None, None
    if d.get("Code") != 200:
        return None, None, None
    D = d.get("Data") or {}
    uid = D.get("member_id") or D.get("user_id") or D.get("id")
    tok = D.get("token") or (D.get("auth") or {}).get("token")
    print("[register] uid=%s token=%s" % (uid, (tok or "")[:24]))
    return uid, tok, did

# ---------- 3. 播放鉴权测试 ----------
def test_stream(uid, tok, did):
    ts = int(time.time() * 1000)
    cases = [
        ("no-token-preview", "?video_id=50363&uid=%s&_t=%d&preview=1" % (uid, ts), {}),
        ("token-preview",    "?video_id=50363&uid=%s&token=%s&_t=%d&preview=1" % (uid, tok, ts), {"token": tok}),
        ("token-nopreview",  "?video_id=50363&uid=%s&token=%s&_t=%d" % (uid, tok, ts), {"token": tok}),
    ]
    for name, q, hdr in cases:
        st, body = req("/getVideoStream/appkey/%s/stream/index.m3u8%s" % (KEY, q), "GET", headers=hdr)
        print("[stream:%s] %s %s" % (name, st, body[:300].replace("\n", " | ")))

# ---------- 4. detail with token ----------
def detail(uid, tok):
    st, body = req(ep("detail"), "POST", {
        "videoId": 50363, "userId": uid, "did": "testdid123", "subId": 0, "sys": "android"
    }, headers={"token": tok or ""})
    print("[detail] %s" % st)
    try:
        D = json.loads(body)["Data"]
        print("  isVip=%s alreadyBuy=%s gold=%s lookAtOn=%s feeLook=%s price=%s" % (
            D.get("isVip"), D.get("alreadyBuy"), D["videoInfo"].get("gold"),
            D.get("lookAtOn"), D.get("feeLook"), D.get("price")))
        print("  member=%s" % json.dumps(D.get("member"), ensure_ascii=False)[:300])
        u = D["videoInfo"].get("url")
        print("  url=%s" % (u[:160] if u else None))
        open("detail_tok.json", "w", encoding="utf-8").write(body)
    except Exception as e:
        print("  parse fail %s :: %s" % (e, body[:300]))

if __name__ == "__main__":
    eps = dump_endpoints()
    uid, tok, did = register()
    if uid:
        st, body = req("/getUserInfo/appkey/%s/userId/%s" % (KEY, uid), "GET", headers={"token": tok})
        print("[getUserInfo] %s %s" % (st, body[:500]))
        test_stream(uid, tok, did)
        detail(uid, tok)
