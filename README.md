# JarGuard Pro - Professional Java/Jar Code Obfuscation Tool

[![Website](https://img.shields.io/badge/Website-jarguardpro.cn-blue)](https://en.jarguardpro.cn/)
[![Documentation](https://img.shields.io/badge/Documentation-Available-green)](https://en.jarguardpro.cn/doc.html)


Read this in other languages: [English](README.md), [简体中文](README_CN.md), [日本語](README_JP.md).


## 🔐 Overview

JarGuard Pro is a professional Java bytecode obfuscation tool that provides advanced protection for Java applications through sophisticated code transformation techniques. It helps protect your intellectual property and business secrets by making compiled bytecode extremely difficult to decompile and understand.

**🌐 Official Website:** [https://en.jarguardpro.cn/](https://en.jarguardpro.cn/)

**📖 Complete Documentation:** [https://en.jarguardpro.cn/doc.html](https://en.jarguardpro.cn/doc.html)

## ✨ Key Features

### 🛡️ Advanced Protection Mechanisms

- **Control Flow Flattening** (Similar to OLLVM) - Disrupts instruction logic vertically using dispatcher-based execution
- **Bogus Instructions** - Inserts fake instructions that won't execute to confuse reverse engineering attempts  
- **String Encryption** - Converts strings to byte arrays with direct `new String()` calls, harder to decrypt than traditional methods
- **Instruction Substitution** - Transforms simple mathematical operations into complex equivalent formulas
- **Switch Case Expansion** - Inserts unreachable branches with fake or duplicated code to increase complexity

### 🚀 Why Choose JarGuard Pro?

- **Prevent Reverse Engineering** - Protect core algorithms and business logic
- **Enhanced Performance** - Obfuscated code often runs more efficiently
- **Anti-Tampering** - Prevents malicious code injection and modification
- **Easy to Use** - One-click protection without complex configuration
- **Professional Grade** - Trusted by thousands of developers worldwide

## 🎯 Target Scenarios

Perfect for protecting:
- Core business algorithms
- Proprietary software solutions
- Commercial Java applications
- Security-sensitive code modules
- Intellectual property assets

## ⚙️ Configuration Options

### Global Configuration Patterns

```bash
# Obfuscate specific classes
com.somepackage.SomeClass

# Obfuscate all classes in package (excluding subpackages)
com.somepackage.*

# Obfuscate all classes in package (including subpackages)  
com.somepackage.**

# Blacklist mode (exclude specific classes)
!com.somepackage.SomeClass

# Exclude specific methods from obfuscation
!com.somepackage.SomeClass.SomeMethod()
```

### Annotation-Based Configuration

Use the `@ObfuscationConfig` annotation to override global settings:

```java
package com.test;
import com.obfuscator.ObfuscationConfig;

// Class-level annotation
@ObfuscationConfig(isEnabled=true, isEnableFlattening=true, isEnableSplit=true)
public class Main {
    
    // Method-level annotation - disable obfuscation
    @ObfuscationConfig(isEnabled=false)
    public static void main(String[] args) {
        // This method won't be obfuscated
    }
    
    // Method-level annotation - custom settings
    @ObfuscationConfig(
        isEnableFlattening=true,
        isEnableReference=true,
        isEnableSplit=true
    )
    public static void processData() {
        // Custom obfuscation settings for this method
    }
}
```

## 📋 Configuration Parameters
## 📋 Add [ObfuscationConfig.java](https://github.com/Saint-Theana/Java-Ollvm/blob/main/ObfuscationConfig.java) to your application to use Configuration.
| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `isEnabled` | boolean | true | Enable/disable obfuscation (class-level disables entire class) |
| `isEnableFlattening` | boolean | false | Enable control flow flattening |
| `isEnableBogusControlFlow` | boolean | false | Insert bogus control flow instructions |
| `isEnableStringObfusecat` | boolean | false | Enable string obfuscation |
| `isEnableSubstitution` | boolean | false | Replace simple instructions with complex equivalents |
| `isEnableSwitch2If` | boolean | false | Convert Switch statements to IF statements |
| `bogusProbability` | int | 30 | Probability of bogus instruction insertion (1-100) |
| `bogusLoop` | int | 1 | Number of bogus instruction loops |
| `maxStringLength` | int | 100 | Maximum length for string obfuscation |
| `isEnableExpanseControlFlow` | boolean | false | Enable Switch Case expansion |
| `expansePercentage` | int | 100 | Switch Case expansion percentage (100 = 1x expansion) |
| `isEnableReference` | boolean | false | Enable cross-class references |
| `isEnableSplit` | boolean | false | Split basic blocks for enhanced obfuscation |
| `isEnableNoMerge` | boolean | false | Prevent statement merging (increases code size) |

## 🔧 Usage Instructions

### Prerequisites

For optimal string obfuscation with Java 9+ string concatenation, add this javac parameter:
```bash
-XDstringConcat=inline
```

### Basic Usage

1. Configure your obfuscation targets using global patterns or annotations
2. Set desired obfuscation parameters
3. Run the obfuscation process
4. Deploy your protected JAR files

## 🏗️ Obfuscation Process Flow

JarGuard Pro follows a systematic approach:

1. **Analysis Phase** - Scans bytecode and identifies obfuscation targets
2. **Transformation Phase** - Applies selected obfuscation techniques
3. **Optimization Phase** - Ensures code integrity and performance  
4. **Output Phase** - Generates protected JAR files

## 📚 Resources

- **🌐 Main Website**: [https://www.jarguardpro.cn/](https://www.jarguardpro.cn/)
- **📖 Documentation**: [https://www.jarguardpro.cn/doc.html](https://www.jarguardpro.cn/doc.html/)
- **💬 Support**: Contact through official website

## 🤝 Community

Join thousands of developers who trust JarGuard Pro to protect their Java applications. Our professional-grade obfuscation technology provides the security you need while maintaining code performance and reliability.

---

**⚡ Get Started Today!** Visit [jarguardpro.cn](https://www.jarguardpro.cn/) to protect your Java applications with industry-leading obfuscation technology.
