# -*- coding: utf-8 -*-
"""第二轮：只提取 dex/js/so 中的真实主机名，过滤 XML 命名空间等噪声，输出分类清单。"""
import io, re, zipfile, collections

APK = r"D:\AAA_RE\secret\samples\sm_114\sm_114.original.apk"
OUT = r"D:\AAA_RE\secret\samples\sm_114\sec\hosts_clean.txt"

NOISE = (
    "schemas.android.com", "www.w3.org", "w3.org", "apache.org", "xml.org", "json.org",
    "xmlpull.org", "ietf.org", "github.com/schema", "ns.adobe.com", "adobe.com",
    "purl.org", "developers.google.com", "goo.gl", "android.com", "kotlinlang.org",
)

host_re = re.compile(rb"(?<![A-Za-z0-9_.-])((?:[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\.)+(?:com|cn|net|org|xyz|top|vip|cc|io|me|tv|info|club|live|shop|site|online|fun|space|link|pro|app|dev|ru|hk|tw|co|ws|biz|icu|cyou|bond|rest|best|art|store|wiki|work|life|today|digital|network|host|press|cloud|stream|download|win|bid|date|men|loan|gd|to|be|is|it|de|fr|uk|jp|kr|sg|us|in|eu|asia|mobi|name|nyc|london|agency|solutions|support|services|systems|technology|media|group|team|tools|zone|plus|one|run|now|new|page|style|blue|red|kim|pink|black|gold|law|money|finance|cash|fund|codes|email|chat|video|photo|pics|rocks|science|trade|party|review|racing|men|cricket|win)" \
    rb"(?![A-Za-z0-9_-]))", re.I)
url_re = re.compile(rb"(?:https?|wss?)://([A-Za-z0-9._-]{3,120})")

def scan(blob):
    hits = collections.Counter()
    for m in url_re.finditer(blob):
        h = m.group(1).decode("ascii", "ignore").lower().strip(".-")
        if "." in h:
            hits[h] += 1
    for m in host_re.finditer(blob):
        h = m.group(1).decode("ascii", "ignore").lower().strip(".-")
        if h.startswith(("http.", "https.", "www.")):
            h = h[4:] if h.startswith("www.") else h
        hits[h] += 1
    return hits

def main():
    z = zipfile.ZipFile(APK)
    total = collections.Counter()
    per = collections.OrderedDict()
    for n in z.namelist():
        low = n.lower()
        if not (low.endswith((".dex", ".so", ".js")) or low.endswith(".json")):
            continue
        data = z.read(n)
        h = scan(data)
        h = collections.Counter({k: v for k, v in h.items() if not any(x in k for x in NOISE)})
        if h:
            per[n] = h
            total.update(h)
    with io.open(OUT, "w", encoding="utf-8") as f:
        f.write("===== 全局去重（%d）=====\n" % len(total))
        for h, c in total.most_common():
            f.write("%-50s %d\n" % (h, c))
        for n, h in per.items():
            f.write("\n##### %s (%d)\n" % (n, len(h)))
            for k, v in h.most_common():
                f.write("   %-46s %d\n" % (k, v))
    print("unique hosts:", len(total))
    for h, c in total.most_common(120):
        print("%-50s %d" % (h, c))

main()
