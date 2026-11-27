# -*- coding: utf-8 -*-
"""按 unicode 转义字面量定位中文，打印上下文"""
import sys, os, glob

def esc(s):
    return "".join("\\u%04x" % ord(c) if ord(c) > 126 else c for c in s)

def main():
    need = sys.argv[1]
    root = os.path.join(os.path.dirname(os.path.abspath(__file__)),
                        "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
    pat = esc(need)
    print("escaped pattern:", pat)
    hits = 0
    for p in glob.glob(os.path.join(root, "**", "*.js"), recursive=True):
        try:
            t = open(p, encoding="utf-8").read()
        except Exception:
            continue
        i = t.find(pat)
        if i < 0:
            continue
        rel = os.path.relpath(p, root)
        while i >= 0 and hits < 6:
            print("\n== %s @%d" % (rel, i))
            print(t[max(0, i - 450):i + 350])
            hits += 1
            i = t.find(pat, i + 1)
    if not hits:
        print("no hit")

main()
