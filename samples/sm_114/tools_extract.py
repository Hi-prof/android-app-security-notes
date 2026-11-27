import zipfile, os, sys

apk = r'D:\AAA_RE\secret\sm_114.apk'
out = r'D:\AAA_RE\secret\samples\sm_114\unzip'
os.makedirs(out, exist_ok=True)
z = zipfile.ZipFile(apk)
targets = [n for n in z.namelist() if n.startswith('assets/apps/')]
targets += ['AndroidManifest.xml',
            'assets/data/dcloud_control.xml',
            'assets/data/dcloud_properties.xml',
            'assets/data/dcloud_configs.json',
            'assets/apps/__UNI__GF0182AE/www/manifest.json']
for n in targets:
    if n in z.namelist():
        z.extract(n, out)
print('extracted', len(targets))

sizes = []
for root, d, f in os.walk(out):
    for x in f:
        p = os.path.join(root, x)
        if x.endswith('.js'):
            sizes.append((os.path.getsize(p), p))
sizes.sort(reverse=True)
for s, p in sizes[:25]:
    print(s, p)
