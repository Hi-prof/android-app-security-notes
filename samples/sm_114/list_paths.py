# -*- coding: utf-8 -*-
import re, os
HERE = os.path.dirname(os.path.abspath(__file__))
p = os.path.join(HERE, "unzip", "assets", "apps", "__UNI__GF0182AE", "www", "pages", "index", "index.js")
s = open(p, encoding="utf-8", errors="surrogateescape").read()
paths = sorted(set(re.findall(r'"/([A-Za-z0-9_]+)/appkey/"', s)))
print("total", len(paths))
sel = [x for x in paths if any(k in x.lower() for k in ("svod", "buy", "gold", "vip", "pay", "order", "money"))]
print("selected:", sel)
open("paths_svod.txt", "w", encoding="utf-8").write("\n".join(paths))
