# -*- coding: utf-8 -*-
"""打印 uiautomator dump 里带文本/可点击节点的 bounds"""
import re, sys, os

p = os.path.join(os.path.dirname(os.path.abspath(__file__)), "ui.xml")
t = open(p, encoding="utf-8").read()
for m in re.finditer(r"<node[^>]*>", t):
    s = m.group(0)
    text = re.search(r'text="([^"]*)"', s)
    desc = re.search(r'content-desc="([^"]*)"', s)
    bounds = re.search(r'bounds="([^"]*)"', s)
    click = re.search(r'clickable="([^"]*)"', s)
    tx = (text.group(1) if text else "") or (desc.group(1) if desc else "")
    if not tx:
        continue
    print("%-24s %-22s click=%s" % (tx[:24], bounds.group(1) if bounds else "?", click.group(1) if click else "?"))
