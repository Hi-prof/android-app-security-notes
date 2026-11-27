# -*- coding: utf-8 -*-
"""从 APK 各 dex / so / assets 中提取所有 URL 与域名，按来源归类统计。"""
import io, os, re, sys, zipfile, collections

APK = r"D:\AAA_RE\secret\samples\sm_114\sm_114.original.apk"
OUT = r"D:\AAA_RE\secret\samples\sm_114\sec\hosts.txt"

url_re = re.compile(rb"(?:https?|wss?)://[A-Za-z0-9._~:/?#\[\]@!$&'()*+,;=%-]{4,200}")
host_re = re.compile(rb"^[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")

def hosts_from(blob):
    out = set()
    for m in url_re.finditer(blob):
        try:
            s = m.group(0).decode("utf-8", "ignore")
        except Exception:
            continue
        h = re.sub(r"^(?:https?|wss?)://", "", s)
        h = re.split(r"[/?#:]", h, 1)[0].lower()
        if h and "." in h and " " not in h:
            out.add(h)
    # 裸域名（dex 里常以常量池存）
    for m in re.finditer(rb"[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,62})\.(?:com|cn|net|org|xyz|top|vip|cc|io|me|tv|info|club|live|shop|site|online|fun|space|link|pro|app|dev|ru|in|hk|tw|co|so|ws|biz|icu|cyou|bond|rest|best|art|store|wiki|work|life|world|today|digital|network|host|press|rocks|cloud|stream|download|racing|party|review|science|trade|webcam|win|bid|date|men|loan|gdn)\b", blob):
        d = m.group(0).decode("ascii", "ignore").lower()
        out.add(d)
    return out

def main():
    z = zipfile.ZipFile(APK)
    res = collections.OrderedDict()
    for n in z.namelist():
        low = n.lower()
        if not (low.endswith((".dex", ".so", ".js", ".json", ".xml", ".bin", ".dat", ".html", ".txt"))):
            continue
        try:
            data = z.read(n)
        except Exception:
            continue
        if len(data) > 60 * 1024 * 1024:
            continue
        hs = hosts_from(data)
        if hs:
            res[n] = sorted(hs)
    with io.open(OUT, "w", encoding="utf-8") as f:
        allh = collections.Counter()
        for n, hs in res.items():
            f.write("### %s (%d)\n" % (n, len(hs)))
            for h in hs:
                f.write("  %s\n" % h)
                allh[h] += 1
            f.write("\n")
        f.write("=== 全局去重域名 %d ===\n" % len(allh))
        for h, c in allh.most_common():
            f.write("%-55s %d\n" % (h, c))
    print("entries with hosts:", len(res), "unique hosts:", len(allh))
    for n, hs in res.items():
        print("%-60s %d" % (n, len(hs)))

main()
