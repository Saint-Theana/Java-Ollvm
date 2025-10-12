# JarGuard Pro - 专业的 Java/Jar 代码混淆工具

[![官方网站](https://img.shields.io/badge/官方网站-jarguardpro.cn-blue)](https://www.jarguardpro.cn/)
[![使用文档](https://img.shields.io/badge/使用文档-可用-green)](https://www.jarguardpro.cn/doc.html)

## ⚠️ 警告
在Jvm中，Class和Method有大小限制，混淆会让Method的体积膨胀，有可能导致Class或者Method体积过大，在混淆日志中可查看，提示某个方法Method Too Large。请在混淆规则中忽略掉这个方法，或者降低混淆复杂度。



## 🔐 产品概述

JarGuard Pro 是一款专业的 Java 字节码混淆工具，通过先进的代码转换技术为 Java 应用程序提供高级保护。它能够保护您的知识产权和商业机密，让编译后的字节码极难被反编译和理解。

**🌐 官方网站：** [https://www.jarguardpro.cn/](https://www.jarguardpro.cn/)

**📖 完整文档：** [https://www.jarguardpro.cn/doc.html](https://www.jarguardpro.cn/doc.html)

## ✨ 核心特性

### 🛡️ 高级保护机制

- **控制流扁平化**（类似 OLLVM）- 使用分发器机制垂直打乱指令逻辑
- **虚假指令插入** - 插入不会执行的虚假指令来迷惑逆向工程
- **字符串加密** - 将字符串转换为字节数组，使用 `new String()` 直接调用，比传统方法更难解密
- **指令替换** - 将简单的数学运算转换为复杂的等价公式
- **Switch 分支膨胀** - 插入无法到达的分支和虚假代码来增加复杂度

### 🚀 选择 JarGuard Pro 的理由

- **防止逆向工程** - 保护核心算法和业务逻辑
- **提升性能** - 混淆后的代码通常执行效率更高
- **防恶意篡改** - 防止恶意代码注入和修改
- **简单易用** - 一键保护，无需复杂配置
- **专业级别** - 受到数千名开发者信赖

## 🎯 适用场景

完美适用于保护：
- 核心业务算法
- 专有软件解决方案
- 商业 Java 应用程序
- 安全敏感的代码模块
- 知识产权资产

## ⚙️ 配置选项

### 全局配置模式

```bash
# 混淆特定类
com.somepackage.SomeClass

# 混淆包下所有类（不包括子包）
com.somepackage.*

# 混淆包下所有类（包括子包）
com.somepackage.**

# 黑名单模式（不混淆特定类）
!com.somepackage.SomeClass

# 不混淆特定类的某个方法
!com.somepackage.SomeClass.SomeMethod()
```

### 基于注解的配置

使用 `@ObfuscationConfig` 注解覆盖全局设置：

```java
package com.test;
import com.obfuscator.ObfuscationConfig;

// 类级别注解
@ObfuscationConfig(isEnabled=true, isEnableFlattening=true, isEnableSplit=true)
public class Main {
    
    // 方法级别注解 - 禁用混淆
    @ObfuscationConfig(isEnabled=false)
    public static void main(String[] args) {
        // 此方法不会被混淆
    }
    
    // 方法级别注解 - 自定义设置
    @ObfuscationConfig(
        isEnableFlattening=true,
        isEnableReference=true,
        isEnableSplit=true
    )
    public static void processData() {
        // 此方法使用自定义混淆设置
    }
}
```

## 📋 配置参数

| 参数 | 类型 | 默认值 | 说明 |
|------|------|--------|------|
| `isEnabled` | boolean | true | 启用/禁用混淆（类级别禁用会禁用整个类） |
| `isEnableFlattening` | boolean | false | 开启控制流扁平化 |
| `isEnableBogusControlFlow` | boolean | false | 插入虚假控制流指令 |
| `isEnableStringObfusecat` | boolean | false | 开启字符串混淆 |
| `isEnableSubstitution` | boolean | false | 用复杂等价指令替换简单指令 |
| `isEnableSwitch2If` | boolean | false | 将 Switch 语句转换为 IF 语句 |
| `bogusProbability` | int | 30 | 虚假指令插入概率（1-100） |
| `bogusLoop` | int | 1 | 虚假指令循环次数 |
| `maxStringLength` | int | 100 | 字符串混淆最大长度 |
| `isEnableExpanseControlFlow` | boolean | false | 开启 Switch Case 膨胀 |
| `expansePercentage` | int | 100 | Switch Case 膨胀百分比（100 = 1倍膨胀） |
| `isEnableReference` | boolean | false | 开启跨类引用 |
| `isEnableSplit` | boolean | false | 分裂基础块以增强混淆 |
| `isEnableNoMerge` | boolean | false | 防止语句合并（增加代码体积） |

## 🔧 使用说明

### 前置要求

为了在 Java 9+ 中实现最佳字符串混淆效果，请添加以下 javac 参数：
```bash
-XDstringConcat=inline
```

### 基本使用

1. 使用全局模式或注解配置混淆目标
2. 设置所需的混淆参数
3. 运行混淆处理流程
4. 部署受保护的 JAR 文件

## 🏗️ 混淆处理流程

JarGuard Pro 遵循系统化的处理方式：

1. **分析阶段** - 扫描字节码并识别混淆目标
2. **转换阶段** - 应用选定的混淆技术
3. **优化阶段** - 确保代码完整性和性能
4. **输出阶段** - 生成受保护的 JAR 文件

## 📚 相关资源

- **🌐 官方网站**: [https://www.jarguardpro.cn/](https://www.jarguardpro.cn/)
- **📖 使用文档**: [https://www.jarguardpro.cn/doc.html](https://www.jarguardpro.cn/doc.html)
- **💬 技术支持**: 通过官方网站联系

## 🤝 开发者社区

加入信赖 JarGuard Pro 保护 Java 应用程序的数千名开发者行列。我们的专业级混淆技术提供您所需的安全性，同时保持代码性能和可靠性。

---

**⚡ 立即开始！** 访问 [jarguardpro.cn](https://www.jarguardpro.cn/) 使用业界领先的混淆技术保护您的 Java 应用程序。
