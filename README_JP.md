# JarGuard Pro - プロフェッショナルJava/Jarコード難読化ツール

[![公式サイト](https://img.shields.io/badge/公式サイト-jarguardpro.cn-blue)](https://www.jarguardpro.cn/)
[![ドキュメント](https://img.shields.io/badge/ドキュメント-利用可能-green)](https://www.jarguardpro.cn/doc.html)

## 🔐 概要

JarGuard Proは、高度なコード変換技術を通じてJavaアプリケーションに上級レベルの保護を提供する、プロフェッショナルなJavaバイトコード難読化ツールです。コンパイル済みバイトコードの逆コンパイルや理解を極めて困難にすることで、あなたの知的財産とビジネス機密を保護します。

**🌐 公式サイト：** [https://www.jarguardpro.cn/](https://www.jarguardpro.cn/)

**📖 完全ドキュメント：** [https://www.jarguardpro.cn/doc.html](https://www.jarguardpro.cn/doc.html)

## ✨ 主要機能

### 🛡️ 高度な保護メカニズム

- **制御フロー平坦化**（OLLVMに類似）- ディスパッチャーベースの実行で命令ロジックを垂直方向に破壊
- **偽命令挿入** - 実行されない偽の命令を挿入してリバースエンジニアリングを妨害
- **文字列暗号化** - 文字列をバイト配列に変換し、`new String()`の直接呼び出しで従来の方法より解読困難
- **命令置換** - 単純な数学演算を複雑な等価式に変換
- **Switch Case拡張** - 到達不可能なブランチと偽コードを挿入して複雑性を増加
- **メソッド呼び出しの隠蔽** - メソッド呼び出しを抽出し、リフレクション内に隠蔽します

### 🚀 JarGuard Proを選ぶ理由

- **リバースエンジニアリング防止** - コアアルゴリズムとビジネスロジックを保護
- **パフォーマンス向上** - 難読化されたコードはしばしばより効率的に実行
- **改ざん防止** - 悪意のあるコード注入と変更を防止
- **使いやすさ** - 複雑な設定なしでワンクリック保護
- **プロフェッショナルグレード** - 何千人もの開発者から信頼

## 🎯 対象シナリオ

以下の保護に最適：
- コアビジネスアルゴリズム
- 独自ソフトウェアソリューション
- 商用Javaアプリケーション
- セキュリティセンシティブなコードモジュール
- 知的財産アセット

## ⚙️ 設定オプション

### グローバル設定パターン

```bash
# 特定のクラスを難読化
com.somepackage.SomeClass

# パッケージ内の全クラスを難読化（サブパッケージ除く）
com.somepackage.*

# パッケージ内の全クラスを難読化（サブパッケージ含む）
com.somepackage.**

# ブラックリストモード（特定クラスを除外）
!com.somepackage.SomeClass

# 特定メソッドを難読化から除外
!com.somepackage.SomeClass.SomeMethod()
```

### アノテーションベース設定

`@ObfuscationConfig`アノテーションでグローバル設定を上書き：

```java
package com.test;
import com.obfuscator.ObfuscationConfig;

// クラスレベルアノテーション
@ObfuscationConfig(isEnabled=true, isEnableFlattening=true, isEnableSplit=true)
public class Main {
    
    // メソッドレベルアノテーション - 難読化無効
    @ObfuscationConfig(isEnabled=false)
    public static void main(String[] args) {
        // このメソッドは難読化されません
    }
    
    // メソッドレベルアノテーション - カスタム設定
    @ObfuscationConfig(
        isEnableFlattening=true,
        isEnableReference=true,
        isEnableSplit=true
    )
    public static void processData() {
        // このメソッドのカスタム難読化設定
    }
}
```

## 📋 設定パラメータ

| パラメータ | 型 | デフォルト | 説明 |
|-----------|-----|-----------|------|
| `isEnabled` | boolean | true | 難読化の有効/無効（クラスレベルで無効にするとクラス全体が無効） |
| `isEnableFlattening` | boolean | false | 制御フロー平坦化を有効 |
| `isEnableBogusControlFlow` | boolean | false | 偽制御フロー命令を挿入 |
| `isEnableStringObfusecat` | boolean | false | 文字列難読化を有効 |
| `isEnableSubstitution` | boolean | false | 単純命令を複雑な等価命令に置換 |
| `isEnableSwitch2If` | boolean | false | Switch文をIF文に変換 |
| `bogusProbability` | int | 30 | 偽命令挿入確率（1-100） |
| `bogusLoop` | int | 1 | 偽命令ループ回数 |
| `maxStringLength` | int | 100 | 文字列難読化の最大長 |
| `isEnableExpanseControlFlow` | boolean | false | Switch Case拡張を有効 |
| `expansePercentage` | int | 100 | Switch Case拡張パーセンテージ（100 = 1倍拡張） |
| `isEnableReference` | boolean | false | クラス間参照を有効 |
| `isEnableSplit` | boolean | false | 基本ブロック分割で難読化強化 |
| `isEnableNoMerge` | boolean | false | 文合併防止（コードサイズ増加） |
| `isEnableReflection` | boolean | false | 一部のメソッド呼び出しをリフレクションで隠蔽するが、実行効率が大幅に低下する |

## 🔧 使用手順

### 前提条件

Java 9+での最適な文字列難読化のため、このjavacパラメータを追加：
```bash
-XDstringConcat=inline
```

### 基本使用法

1. グローバルパターンまたはアノテーションで難読化対象を設定
2. 必要な難読化パラメータを設定
3. 難読化プロセスを実行
4. 保護されたJARファイルをデプロイ

## 🏗️ 難読化プロセスフロー

JarGuard Proは体系的なアプローチに従います：

1. **分析段階** - バイトコードをスキャンし難読化対象を識別
2. **変換段階** - 選択された難読化技術を適用
3. **最適化段階** - コードの整合性とパフォーマンスを確保
4. **出力段階** - 保護されたJARファイルを生成

## 📚 リソース

- **🌐 公式サイト**: [https://www.jarguardpro.cn/](https://www.jarguardpro.cn/)
- **📖 ドキュメント**: [https://www.jarguardpro.cn/doc.html](https://www.jarguardpro.cn/doc.html/)
- **💬 サポート**: 公式サイトからお問い合わせ

## 🤝 コミュニティ

JarGuard ProでJavaアプリケーションを保護することを信頼する何千人もの開発者の仲間に加わりましょう。当社のプロフェッショナルグレードの難読化技術は、コードのパフォーマンスと信頼性を維持しながら、必要なセキュリティを提供します。

---

**⚡ 今すぐ始めましょう！** [jarguardpro.cn](https://www.jarguardpro.cn/)にアクセスして、業界をリードする難読化技術でJavaアプリケーションを保護してください。
