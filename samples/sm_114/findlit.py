# -*- coding: utf-8 -*-
import os, re, sys

ROOT = r'D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www'

def main(literal, ctx=700):
    for root, d, fs in os.walk(ROOT):
        for f in fs:
            if not f.endswith('.js'):
                continue
            p = os.path.join(root, f)
            txt = open(p, encoding='utf-8', errors='ignore').read()
            idx = 0
            n = 0
            while True:
                i = txt.find(literal, idx)
                if i < 0:
                    break
                n += 1
                s = max(0, i - ctx); e = min(len(txt), i + len(literal) + ctx)
                print('###', os.path.relpath(p, ROOT), '@', i)
                print(txt[s:e].replace('\n', ' '))
                print()
                idx = i + len(literal)
                if n > 12:
                    break

if __name__ == '__main__':
    main(sys.argv[1], int(sys.argv[2]) if len(sys.argv) > 2 else 700)
