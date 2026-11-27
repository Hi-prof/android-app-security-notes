# -*- coding: utf-8 -*-
import os, re, sys
ROOT = r'D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www'

files = [os.path.join(dp, f) for dp, dn, fn in os.walk(ROOT) for f in fn if f.endswith('.js')]
seen = set()
for p in files:
    txt = open(p, encoding='utf-8', errors='ignore').read()
    for m in re.finditer(r'appkey\s*[:=]\s*["\']?([A-Za-z0-9_\-]{4,40})', txt):
        key = m.group(1)
        if key in seen: continue
        seen.add(key)
        print(os.path.relpath(p, ROOT), '@', m.start(), '->', key)
        print('   ctx:', txt[max(0,m.start()-200):m.end()+200].replace('\n',' '))
print('--- total distinct:', len(seen))
