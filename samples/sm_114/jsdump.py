# -*- coding: utf-8 -*-
import os, re, sys

ROOT = r'D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www'

def dump(path, pat, ctx=600, limit=10, start=0):
    txt = open(path, encoding='utf-8', errors='ignore').read()
    ms = list(re.finditer(pat, txt))
    print('FILE', path, 'pattern', pat, 'hits', len(ms))
    for m in ms[start:start+limit]:
        s = max(0, m.start()-ctx); e = min(len(txt), m.end()+ctx)
        print('-'*90)
        print('@', m.start())
        print(txt[s:e])

if __name__ == '__main__':
    path = os.path.join(ROOT, sys.argv[1])
    dump(path, sys.argv[2], int(sys.argv[3]) if len(sys.argv) > 3 else 600,
         int(sys.argv[4]) if len(sys.argv) > 4 else 10,
         int(sys.argv[5]) if len(sys.argv) > 5 else 0)
