# -*- coding: utf-8 -*-
import os, re, sys, json

ROOT = r'D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www'

def scan(path, patterns, ctx=180, limit=60):
    txt = open(path, encoding='utf-8', errors='ignore').read()
    print('='*100)
    print('FILE', path, 'len', len(txt))
    for pat in patterns:
        ms = list(re.finditer(pat, txt))
        print('-'*80)
        print('PATTERN', pat, 'hits', len(ms))
        for m in ms[:limit]:
            s = max(0, m.start()-ctx); e = min(len(txt), m.end()+ctx)
            frag = txt[s:e].replace('\n', ' ')
            print(f'[{m.start()}] ...{frag}...')

if __name__ == '__main__':
    which = sys.argv[1] if len(sys.argv) > 1 else 'app-service.js'
    pats = sys.argv[2].split('||') if len(sys.argv) > 2 else [r'is_vip', r'isVip', r'vip_level', r'svip']
    scan(os.path.join(ROOT, which), pats)
