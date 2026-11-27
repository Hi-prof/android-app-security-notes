# -*- coding: utf-8 -*-
"""纯字面量查找，打印上下文。用法: findsub.py <相对路径> <needle> [pre] [post]"""
import sys, os

def main():
    which  = sys.argv[1]
    needle = sys.argv[2]
    pre    = int(sys.argv[3]) if len(sys.argv) > 3 else 400
    post   = int(sys.argv[4]) if len(sys.argv) > 4 else 200
    root = os.path.join(os.path.dirname(os.path.abspath(__file__)),
                        "unzip", "assets", "apps", "__UNI__GF0182AE", "www")
    p = os.path.join(root, which)
    t = open(p, encoding="utf-8").read()
    i, n = t.find(needle), 0
    while i >= 0 and n < 6:
        print("\n== @%d" % i)
        print(t[max(0, i - pre):i + post])
        n += 1
        i = t.find(needle, i + 1)
    print("\nhits=%d" % n)

main()
