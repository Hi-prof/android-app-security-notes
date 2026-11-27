# -*- coding: utf-8 -*-
"""解析 app-config-service.js 里的 tabBar 配置"""
import json, os

p = os.path.join(os.path.dirname(os.path.abspath(__file__)), "unzip", "assets", "apps",
                 "__UNI__GF0182AE", "www", "app-config-service.js")
t = open(p, encoding="utf-8").read()
i = t.find('"tabBar":')
dec = json.JSONDecoder()
obj, end = dec.raw_decode(t[i + len('"tabBar":'):])
for it in obj.get("list", []):
    print("%-28s %s" % (it.get("pagePath"), it.get("text")))
print("midButton:", obj.get("midButton"))
