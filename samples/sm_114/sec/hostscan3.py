# -*- coding: utf-8 -*-
"""第三轮：只取真正的 URL（http/ws 开头），dex 额外取"独立字符串"形式的域名。
dex 字符串是 MUTF-8 + 长度前缀，域名前后会紧跟 NUL 或非标识符字节。"""
import io, re, zipfile, collections

APK = r"D:\AAA_RE\secret\samples\sm_114\sm_114.original.apk"
OUT = r"D:\AAA_RE\secret\samples\sm_114\sec\hosts_url.txt"

url_re = re.compile(rb"(?:https?|wss?)://([A-Za-z0-9._-]{3,120})")
dex_dom_re = re.compile(rb"\x00((?:[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\.)+[a-z]{2,6})\x00")
NOISE_TAIL = {"style", "media", "name", "info", "top", "page", "gold", "tools", "video",
              "live", "cc", "date", "money", "one", "new", "space", "safearea", "plus", "io"}

def main():
    z = zipfile.ZipFile(APK)
    total = collections.Counter()
    per = collections.OrderedDict()
    for n in z.namelist():
        low = n.lower()
        if not low.endswith((".dex", ".so", ".js", ".json")):
            continue
        data = z.read(n)
        hits = collections.Counter()
        for m in url_re.finditer(data):
            hits[m.group(1).decode("ascii", "ignore").lower()] += 1
        if low.endswith((".dex", ".so")):
            for m in dex_dom_re.finditer(data):
                h = m.group(1).decode("ascii", "ignore").lower()
                if h.split(".")[-1] in NOISE_TAIL:
                    continue
                hits[h] += 1
        if hits:
            per[n] = hits
            total.update(hits)
    with io.open(OUT, "w", encoding="utf-8") as f:
        f.write("===== GLOBAL %d =====\n" % len(total))
        for h, c in total.most_common():
            f.write("%-50s %d\n" % (h, c))
        for n, h in per.items():
            f.write("\n##### %s (%d)\n" % (n, len(h)))
            for k, v in h.most_common():
                f.write("   %-46s %d\n" % (k, v))
    print("unique:", len(total))
    for h, c in total.most_common(200):
        print("%-50s %d" % (h, c))

main()
