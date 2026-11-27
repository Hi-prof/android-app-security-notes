# -*- coding: utf-8 -*-
"""把打过补丁的 www 资源写回 APK（保留其余条目原样），输出 *.patched.unsigned.apk"""
import os, shutil, zipfile, sys

HERE = os.path.dirname(os.path.abspath(__file__))
SRC  = os.path.join(HERE, "sm_114.original.apk")
OUT  = os.path.join(HERE, "sm_114.patched.unsigned.apk")
WWW  = os.path.join(HERE, "unzip", "assets", "apps", "__UNI__GF0182AE", "www")

TARGETS = [
    "assets/apps/__UNI__GF0182AE/www/pages/video/play.js",
    "assets/apps/__UNI__GF0182AE/www/pages/svod/player.js",
    "assets/apps/__UNI__GF0182AE/www/pages/index/index.js",
    "assets/apps/__UNI__GF0182AE/www/app-service.js",
]

def main():
    if os.path.exists(OUT):
        os.remove(OUT)
    zin = zipfile.ZipFile(SRC, "r")
    zout = zipfile.ZipFile(OUT, "w", zipfile.ZIP_DEFLATED)
    replaced = set()
    for item in zin.infolist():
        name = item.filename
        if name in TARGETS:
            local = os.path.join(WWW, *name.split("/")[4:])  # 去掉 assets/apps/<appid>/ 前缀
            if not os.path.exists(local):
                print("MISS", local); continue
            data = open(local, "rb").read()
            zi = zipfile.ZipInfo(name, date_time=item.date_time)
            zi.compress_type = zipfile.ZIP_DEFLATED
            zi.external_attr = item.external_attr
            zout.writestr(zi, data)
            replaced.add(name)
            print("REPLACED %-60s %d bytes" % (name, len(data)))
        else:
            zout.writestr(item, zin.read(name))
    zin.close(); zout.close()
    print("done. replaced=%d/%d -> %s" % (len(replaced), len(TARGETS), OUT))

if __name__ == "__main__":
    main()
