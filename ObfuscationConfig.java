package com.obfuscator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//可以作用于Class也可作用于Method
//无论是Class中注解还是Method中注解都会覆盖全局配置，Method的配置会覆盖Class的配置
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ObfuscationConfig
{
    //如果设置为否，则不会混淆
    //如果Class中的配置设置为否，整个Class都不会被混淆，所有Method都不会被混淆，Method中的配置也不会再被读取
    boolean isEnabled() default true;
    
    //是否开启控制流扁平化
	boolean isEnableFlattening() default false;

    //是否开启虚假控制流
    //插入一些虚假的判断指令
	boolean isEnableBogusControlFlow() default false;
    
    //是否开启字符串混淆
    //注意:某些字符串无法被混淆，特别是Java9中引入的字符串拼接方法，如果需要将这部分字符串混淆，请在你的javac参数中加入"-XDstringConcat=inline"
	boolean isEnableStringObfusecat() default false;
     
    //是否开启指令替换
    //将加减法以及xor替换成稍微复杂一点的指令
	boolean isEnableSubstitution() default false;

    //把Switch转换成IF
	boolean isEnableSwitch2If() default false;

    //虚假指令插入的概率，1-100，100表示每个基本块百分之百会插入
	int bogusProbability() default 30;
    
    //虚假指令循环次数
	int bogusLoop() default 1;
    
    //字符串混淆的最大长度
    int maxStringLength() default 100;
    
    //是否开启Switch Case膨胀
    //在switch中加入虚假的Case
	boolean isEnableExpanseControlFlow() default false;
    
    //Switch Case膨胀的百分比
    //100意味着1倍，也就是10个分支将会插入10个虚假分支
    int expansePercentage() default 100;
    
    //是否开启其他类引用
    //字符串和控制流扁平化的key将会引用随即生成的别的类的方法返回
    //开启将会产生大量的随机名称的类
	boolean isEnableReference() default false;

    //是否分裂基础块
    //将原有的基础块分裂，在控制流扁平化和虚假指令中效果显著
	boolean isEnableSplit() default false;
	
	//是否开启防止语句合并
	//在混淆过程中不启用语句合并来达到最大混淆效果，能让分裂基础块效果更好，同时也会增加代码体积，
	boolean isEnableNoMerge() default false;

	//是否开启方法调用隐藏
	//目前只支持静态方法以及实例方法调用隐藏
	//将大幅度减慢方法执行效率
	boolean isEnableReflection() default false;
}


