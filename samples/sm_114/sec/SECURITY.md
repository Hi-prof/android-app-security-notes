# SM社 (sm_114.apk) 安全性评估报告

- 样本：`sm_114.original.apk`，42,741,410 B，SHA-256 `D1FCB49665862C800E2E57739BA19165AA47F0D58D0EC8933534F4A7A93D8B63`
- 包名 `uni.app.UNIGF0182AE`，versionName 1.1.4 (versionCode 114)
- 框架：DCloud uni-app（5+ Runtime / weex / ijkplayer），业务逻辑全在前端 JS，Java 层基本是 DCloud 标准壳
- 评估日期：2026-11-23
- 设备实测环境：Android 真机 `1444be27`，安装并运行过原版与改造版

---

## 一、结论速览

| 问题 | 结论 |
|---|---|
| 是不是病毒 / 木马 | **不是**。无命令执行、无 root 提权、无动态下发 dex、无隐藏 payload、无已知恶意 SDK |
| 会不会偷通讯录 / 短信 | **不会**。APK 未申请 READ_CONTACTS / READ_SMS / RECEIVE_SMS / CALL_LOG，代码里也没有读取这些数据的实现 |
| 会不会偷照片 / 文件 | **不会主动扫描**。只有 READ_EXTERNAL_STORAGE（运行时未授予），且仅用于用户主动选图/缓存/保存视频 |
| 会不会偷定位 | **权限申请了但业务没用**。前端 0 次调用 `uni.getLocation` / `chooseLocation`；运行时定位权限 `granted=false` |
| 会不会偷录音 / 偷拍 | 权限声明了（DCloud 默认全家桶），但无后台调用点；运行时 CAMERA / RECORD_AUDIO 未授予 |
| 会不会偷剪贴板 | 仅在 WebView 里提供"复制当前网页链接"能力，无后台轮询 |
| 真正的风险是什么 | ①**服务端下发的升级包不做签名/哈希校验**（供应链风险）；②**明文 HTTP 允许**（`usesCleartextTraffic=true`）；③targetSdk 28 过旧、27 项冗余高危权限；④内容本身涉盗版影视 |

一句话：**这个 App 不是一个会偷你数据的木马，但它是一套"服务端完全掌控客户端"的灰色影视应用 —— 它不需要偷你的通讯录，它自己就是靠卖会员和拉人头赚钱的。真正该担心的是它随时能把任意 APK 推到你手机上安装。**

---

## 二、权限与组件审计

### 2.1 权限（27 项，全部来自 DCloud 默认模板）

高危但业务未使用：`READ_PHONE_STATE`、`ACCESS_FINE_LOCATION`、`ACCESS_COARSE_LOCATION`、`CALL_PHONE`、`RECORD_AUDIO`、`CAMERA`、`READ_LOGS`、`WRITE_SETTINGS`、`MOUNT_UNMOUNT_FILESYSTEMS`、`INSTALL_PACKAGES`、`REQUEST_INSTALL_PACKAGES`（重复声明两次）。

**未申请**（这点很关键，说明它不是窃密木马）：
`READ_CONTACTS`、`WRITE_CONTACTS`、`READ_SMS`、`RECEIVE_SMS`、`SEND_SMS`、`READ_CALL_LOG`、`PROCESS_OUTGOING_CALLS`、`GET_ACCOUNTS`、`SYSTEM_ALERT_WINDOW`、`BIND_ACCESSIBILITY_SERVICE`、`BIND_DEVICE_ADMIN`、`QUERY_ALL_PACKAGES`、`BODY_SENSORS`、`MANAGE_EXTERNAL_STORAGE`。

真机 `dumpsys package` 实测授予状态：

```
granted=true : INTERNET, ACCESS_NETWORK_STATE, ACCESS_WIFI_STATE,
               CHANGE_NETWORK_STATE, CHANGE_WIFI_STATE, FLASHLIGHT, VIBRATE, WAKE_LOCK
granted=false: ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION,
               READ_PHONE_STATE, READ_EXTERNAL_STORAGE
```

即：唯一授予的高危权限是 `READ_PHONE_STATE`（用于拿 IMEI/IMSI 拼设备指纹），**但实测为 false**，所以当前连设备码都拿不到。

### 2.2 组件暴露面

- 导出的 Activity 只有 `io.dcloud.PandoraEntry`（LAUNCHER + `VIEW` scheme `v5msvodx`），其余全部 `exported=false`。
- 导出的 Receiver 只有 `androidx.profileinstaller.ProfileInstallReceiver`（受 `DUMP` 签名权限保护，无害）。
- `DownloadService`、两个 `FileProvider` 均不导出。
- **无** DeviceAdminReceiver、**无** AccessibilityService 实现、**无** 常驻 native service、**无** 悬浮窗。

---

## 三、代码层取证（jadx 7455 个 .java + native so）

### 3.1 明确"没有"的行为

| 行为 | 取证 |
|---|---|
| 命令执行 | `Runtime.getRuntime().exec` / `ProcessBuilder` **0 命中** |
| root 提权 | `/system/bin/su` 在 Java 层 0 命中；仅在 `lib39285EFA.so` 里作为**检测**字符串存在（见 3.3） |
| 动态加载 dex | 无 `DexClassLoader` / `InMemoryDexClassLoader` / 网络下载 dex；只有 `androidx.multidex` 与 `facebook.soloader` 的标准用法 |
| 读通讯录 | `ContactsContract` 仅 3 处，全是 Glide / Fresco **加载联系人头像图片**用的 URI 解析（`StreamLocalUriFetcher.java:48/56`、`LocalContentUriFetchProducer.java:46`、`UriUtil.java:9`） |
| 读短信/通话 | `SmsManager` / `content://sms` / `content://call_log` / `CallLog.Calls` **0 命中** |
| 录屏 | `MediaProjection` 只出现在 androidx 的类名映射表，无实际使用 |
| 无障碍监听 | 仅 `uts\sdk\modules\DCloudUniGetAccessibilityInfo\IndexKt.java:26-34` 读取"已启用无障碍服务列表"（uni 标准 API），**没有**自建无障碍服务 |

### 3.2 实际会读的设备信息（标准设备指纹，非窃密）

- `io.dcloud.common.util.TelephonyUtil.java:180-182` —— 反射 `getDeviceId`
- `io.dcloud.p.y1.java:140-143` —— `getDeviceId()` / `getDeviceId(1)`；`:36`、`:203-206` —— `getSubscriberId`
- `io.dcloud.p.n4.java:175` —— `getNetworkOperator`
- `io.dcloud.p.b3.java:28-31` —— `getLastKnownLocation`（定位模块，前端未调用）

前端自己拼的指纹（`pages/index/index.js@30718`、`pages/video/play.js@30717`）：

```js
[ did, platform, brand||deviceBrand, model||deviceModel, system||version,
  screenWidth+'x'+screenHeight+'x'+pixelRatio,
  navigator.language, new Date().getTimezoneOffset(), navigator.userAgent ].join('|') → hash
```

这就是行业标准的"设备唯一化"套路，用来防刷号和绑定会员，**不上传通讯录、不上传应用列表、不上传位置**。

### 3.3 native 层扫描（66 个 .so）

| so | 命中 | 判定 |
|---|---|---|
| `lib39285EFA.so`（DCloud 启动器，83–154 KB） | `/system/bin/su`、`/system/xbin/su`、`xposed`、`/proc/self/maps` | **反 root / 反 Xposed 检测**，是保护壳的正常行为，不是提权 |
| `libweexcore.so` / `libweexjss.so` | `getDeviceId`、`/proc/self/maps`、`xposed` | weex JS 引擎的 JIT/调试支持 + 指纹读取 |
| `libijkffmpeg.so` / `libijkplayer.so` / `libbreakpad-core.so` / `libuts-runtime.so` 等 | 无 | 标准播放器/崩溃上报/uts 运行时 |

**没有任何 so 包含短信/通讯录/键盘记录/录屏/frida 注入相关字符串。**

### 3.4 域名面（259 项去重后的人工筛）

真实业务域：`ff3zvkbv.842641.xyz`（API 兜底）、`h9a228t.842610.xyz`（域名池）、`jda.smsscdn.com`（视频 CDN）、`smtucdn.419243.xyz`（图片 CDN）。
基础设施：jsdelivr / gitlab / bitbucket / gitgud / codeberg / disroot / gitea（存放 `domains.txt` 域名池）、`ask.dcloud.net.cn`、`at.alicdn.com`（图标）、`tawk.to`（第三方在线客服）。
官网：`smshe.cc`、`smshe.net`、`smshe.xyz`、`smapp.cc`，邮箱 `smskefu@gmail.com`。

**未发现任何广告/统计/推送 SDK**：无友盟、无极光、无 Bugly、无 AppsFlyer / Adjust / Facebook Ads / 穿山甲 / 快手 / Sigmob。

---

## 四、真正的风险点（按严重度排序）

### R1｜应用内升级不做任何校验 —— 高危

`app-service.js@427131` 附近（设置页）：

```
getNewApp() → uni.request(apiData.getVersion)
            → 取 Data.android.versionCode / Data.android.downUrl
            → 与本地 versionCode 比对
downApp()   → uni.downloadFile(downUrl) → uni.saveFile → storage['newAppApk']
installApk()→ plus.runtime.install(path, {}, plus.runtime.restart, fail)
```

`downUrl` **完全由服务端下发，客户端不校验签名、不校验哈希**，只依赖 Android 安装器本身的签名一致性检查。

含义：一旦该域名被劫持、或运营方本身想换壳，就能把任意 APK 推给全部用户（且因为 `INSTALL_PACKAGES` + `REQUEST_INSTALL_PACKAGES` 都在，安装引导很顺）。这是这类"域名池 + 频繁换域名"的应用最典型的供应链攻击面。

**缓解**：在设置里关掉自动更新提示；不要点"立即升级"；只从自己确认过的渠道装包。

### R2｜允许明文 HTTP + targetSdk 28 —— 中高

`usesCleartextTraffic=true`，`requestLegacyExternalStorage=true`，`targetSdkVersion=28`。意味着 API 通信可能走 http、可读写公共存储、且不受 Android 10+ 的分区存储与后台限制约束。

**缓解**：不要在公共 WiFi 下登录/充值；不要在这 App 里存敏感文件。

### R3｜27 项权限里 10 项业务用不到 —— 中

`CALL_PHONE`、`RECORD_AUDIO`、`CAMERA`、`READ_LOGS`、`WRITE_SETTINGS`、`MOUNT_UNMOUNT_FILESYSTEMS`、`READ_PHONE_STATE`、`ACCESS_FINE_LOCATION`、`INSTALL_LOCATION_PROVIDER` 等全部来自 DCloud 模板，与"看视频"毫无关系。虽然当前代码没有调用，但它们在包里就代表"随时可以调用"。

**缓解**：系统设置里逐项拒绝（定位、麦克风、相机、电话、存储全关掉，不影响看视频）。

### R4｜服务端鉴权存在三处严重缺陷（本次破解所利用）

1. **token 完全不验签** —— 任意字符串（甚至 `x.y.z`）都能通过；
2. **`getUserInfo` 无鉴权** —— 可枚举全站用户，读出 `isVip` / `vipEndTime` / `corn`；
3. **`getVideoStream` / `getSvodStream` 的 VIP 与购买判定只认 query 里的 `uid`** —— 传别人的 VIP uid 就免费看全站。

含义：**你在这个 App 里充的钱，对服务端来说没有任何密码学保护**；反过来，任何人也都能拿别人的 uid 白嫖。这类站点的会员价值基本是 0，充值是纯自愿打赏。

### R5｜内容与合规风险 —— 高（但非技术层面）

应用内是盗版影视聚合（长视频 + 短视频 feed），官网文案明写"发送任意内容到官方邮箱，即可获得最新访问地址"，属于典型的规避封禁运营手法。域名池放 GitHub/GitLab/Bitbucket/Codeberg 等多家境外代码托管做容灾，也是同一套逻辑。

**含义**：这类站点随时关停、随时换域名、随时跑路，充值的会员没有保障。

### R6｜第三方客服组件 tawk.to —— 低

`static/html/tawk-loader.html` 加载 `https://tawk.to/chat/68947873ea5b0a192691230e/1j21vd0ps`，是正规 SaaS 客服，只在你主动点"客服"时才加载，会上报 UA / 页面 URL / 你的聊天内容。风险等同于任何网页客服挂件。

---

## 五、给使用者的处置建议

**如果你只是看视频：**
1. 系统设置 → 应用 → SM社 → 权限，把 **位置、麦克风、相机、电话、存储、读取电话状态** 全部关掉（只留网络）。实测关掉这些后播放完全正常。
2. 不要充值。已知服务端鉴权可被任意绕过，充值没有任何技术保障，且站点随时可能跑路。
3. 不要点应用内弹出的"发现新版本，立即升级"。要升级就从你自己确认过的来源拿包。

**如果你在意隐私：**
4. 这 App 拿不到你的通讯录/短信/照片/位置（权限没给 + 代码没写），但它能拿到：设备型号、系统版本、屏幕参数、语言、时区、UA、以及（若授予 `READ_PHONE_STATE`）IMEI/IMSI。这是标准指纹，不是窃密。
5. 卸载时清数据：`adb shell pm clear uni.app.UNIGF0182AE` 或系统设置里"清除数据"。

**如果你要继续做逆向：**
6. 真正值得盯的是 `getVersion` 下发链（R1）—— 这是唯一能在这台设备上执行任意代码的路径。
7. 服务端缺陷 1/2/3 已在 `REPORT.md` 记录并给出了 PoC（`get_vip_stream.py`），可用于继续评估该站点的鉴权模型。

---

## 六、证据文件索引

| 文件 | 内容 |
|---|---|
| `sec\badging.txt` | aapt2 dump badging 原始输出 |
| `sec\manifest_tree.txt` | AndroidManifest.xml 完整 XML 树（273 行） |
| `sec\so_scan.txt` | 66 个 .so 的敏感字符串扫描结果 |
| `sec\hostscan3.py` / `hidhost.py` | 域名与隐藏常量提取脚本 |
| `sec\devpayload.py` | 设备指纹字段抽取 |
| `sec\upgrade.py` / `upd2.py` | 应用内升级链还原 |
| `REPORT.md` | 会员破解技术报告（服务端三缺陷 + 12 处补丁锚点） |
| `get_vip_stream.py` | 纯 API 取流 PoC |
| `shot1.png` – `shot19.png` | 真机运行取证截图 |

---

*本报告仅用于对所持有样本的技术分析与本地设备安全评估。*
