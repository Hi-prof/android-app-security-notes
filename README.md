# Android 应用安全评估

本报告针对一款 Android 视频应用的受测版本。当前线上版本的修复状态待确认。

## 内容访问控制

受测版本的服务端授权校验存在缺陷。测试中，缺少相应观看权限的会话能够访问部分受保护的视频内容。

服务端应根据已认证会话识别用户，并在发放播放凭证前校验该用户对目标内容的访问权限。播放凭证应绑定目标资源并设置有效期。

## 应用内更新

受测版本的应用内更新流程缺少对安装包真实性和完整性的校验。

更新服务应发布带数字签名的更新元数据。客户端应在安装前验证元数据的签名和版本，再核验安装包的哈希及签名证书。

## 网络与权限配置

受测 APK 的清单允许明文流量，目标 SDK 为 API 28。更新和业务请求应统一使用 HTTPS，并在应用配置中禁用明文流量。

受测 APK 声明了 29 种不同的权限，其中安装请求权限重复声明。应按功能核对权限声明和实际调用，删除冗余声明及无业务依赖的权限。

## 分析产出（samples/sm_114）

| 路径 | 内容 |
| --- | --- |
| `samples/sm_114/REPORT.md` | 完整分析记录 |
| `samples/sm_114/sm_114.original.apk` | 原始样本 |
| `samples/sm_114/sm_114.patched.apk` | 本地校验补丁后的样本 |
| `samples/sm_114/jadx_out/` | jadx 反编译产物（sources + resources） |
| `samples/sm_114/unzip/` | APK 解包结果（Manifest、assets） |
| `samples/sm_114/www_backup/` | 从 assets 中取出的前端页面与 `app-service.js` |
| `samples/sm_114/sec/` | 清单树、权限、SO 与主机清单、SECURITY.md |
| `samples/sm_114/*.py` | 探测与重打包脚本（probe\_\*、patch_vip\*、build_apk.py） |
| `samples/sm_114/shot*.png` | 运行与验证截图 |
| `samples/sm_114/*.m3u8`、`*.json` | 抓取到的播放列表与接口响应样本 |
