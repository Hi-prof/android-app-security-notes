# -*- coding: utf-8 -*-
import os, re, sys
ROOT = r'D:\AAA_RE\secret\samples\sm_114\unzip\assets\apps\__UNI__GF0182AE\www'

rel = sys.argv[1]
start = int(sys.argv[2]); length = int(sys.argv[3])
p = os.path.join(ROOT, rel)
txt = open(p, encoding='utf-8', errors='ignore').read()
print(txt[start:start+length])
