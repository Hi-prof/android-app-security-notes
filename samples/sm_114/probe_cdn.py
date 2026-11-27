# -*- coding: utf-8 -*-
import json, subprocess, itertools, os

u = json.load(open("detail_tok.json", encoding="utf-8-sig"))["Data"]["videoInfo"]["url"]
base = u.split("?")[0]

UAS = [
    "stagefright/1.2 (Linux;Android 13)",
    "ExoPlayerLib/2.18.1",
    "Lavf/58.29.100",
    "Dalvik/2.1.0 (Linux; U; Android 13; SM-G991B Build/TP1A.220624.014)",
    "okhttp/3.12.0",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0 Safari/537.36",
]
REFS = [None, "https://jda.smsscdn.com/", "https://heootjfch5.842644.xyz/"]

def hit(url, ua, ref, extra=None):
    cmd = ["curl.exe", "-s", "-o", "NUL", "-w", "%{http_code}", "--max-time", "12",
           "-A", ua]
    if ref: cmd += ["-e", ref]
    if extra: cmd += extra
    cmd.append(url)
    try:
        r = subprocess.run(cmd, capture_output=True, text=True, timeout=20)
        return r.stdout.strip()
    except Exception as e:
        return "ERR"

print("url:", u[:100])
found = []
for ua in UAS:
    for ref in REFS:
        code = hit(u, ua, ref)
        tag = "ua=%-28s ref=%s" % (ua[:28], (ref or "-")[:28])
        print(" ", tag, code)
        if code.startswith("2"):
            found.append((ua, ref))
print("HITS(2xx):", found)

# HTTP/1.1 与 TLS 版本
for opt, name in ((["--http1.1"], "http1.1"), (["--tlsv1.2"], "tls1.2"), (["--tls-max", "1.2"], "tlsmax1.2")):
    print(" ", name, hit(u, UAS[1], None, opt))
