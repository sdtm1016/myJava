Java设计模式针对某一问题,专家级的解决方案

uml建模
Rational Rose是Rational公司出品的一种面向对象的统一建模语言的可视化建模工具。
用于可视化建模和公司级水平软件应用的组件构造。
Rational Rose包括了统一建模语言（UML），OOSE，以及OMT。
其中统一建模语言（UML）由Rational公司3位世界级面向对象技术专家
Grady Booch、Ivar Jacobson、和Jim Rumbaugh
通过对早期面向对象研究和设计方法的进一步扩展而得来的，它为可视化建模软件奠定了坚实的理论基础。
同时这样的渊源也使Rational Rose力挫当前市场上很多基于UML可视化建模的工具，
例如Microsoft的Visio2002、Oracle的Designer2000，
还有PlayCase 、CA BPWin、CA ERWin、Sybase PowerDesigner等等。

Rational Rose 是一个完全的、具有能满足所有建模环境（Web开发，数据建模，Visual Studio和 C++ ）灵活性需求的一套解决方案。
Rose 允许开发人员，项目经理，系统工程师和分析人员在软件开发周期内在将需求和系统的体系架构转换成代码，
消除浪费的消耗，对需求和系统的体系架构进行可视化，理解和精练。
通过在软件开发周期内使用同一种建模工具可以确保更快更好的创建满足客户需求的可扩展的、灵活的并且可靠的应用系统。

Rational Rose是基于UML的可视化建模工具。
UML全称叫Unified Modeling Language，顾名思义，UML是一种语言，一种表示法，一种交流沟通的工具，特别适用于软件密集型系统的表示。
UML的统一性（Unified）表现为以下几点：
（1）UML是人类思想和计算机代码的一个连接桥梁
我们知道，计算机能直接识别的语言就是二进制的CPU指令，早期工程师们都是直接输入这些指令让计算机直接执行的，效率不高；
后来就出现了更好理解的汇编语言，之后就出现了各种各样更加容易理解和编写，更加接近人类语言的计算机高级语言、VB、DELPHI、JAVA等。
（2）UML所定义的概念和符号可用于软件开发的分析、设计和实现的全过程，软件开发人员不必在开发过程的不同阶段进行概念和符号的转换。
（3） UML所用的语言元素基本都是图形化的，便于理解和沟通，不但开发人员之间可以用来交流，客户和开发人员之间也可以用它作为交流的工具。
目前版本的Rational Rose可以用来做以下一些工作：

	1、对业务进行建模（工作流）；
	2、建立对象模型（表达信息系统内有哪些对象，它们之间是如何协作完成系统功能的）；
	3、对数据库进行建模，并可以在对象模型和数据模型之间进行正、逆向工程，相互同步；
	4、建立构件模型（表达信息系统的物理组成，如有什么文件、进程、线程、分布如何等等）；
	5、生成目标语言的框架代码，如VB、JAVA、DELPHI等。
建模特点
	1.保证模型和代码高度一致。
	2.支持多种语言。
	3.为团队开发提供强有力的支持。
	4.支持模型的Internet发布。
	5.生成使用简单且定制灵活的文档。
	6.支持关系型数据库的建模。
 安装方法
下载到的是一个压缩文件，里面包含文件：
	[IBM软件系列].IBM.Rational.Rose.Enterprise.v7.0-TFTISO.bin和license.upd，
	使用虚拟光驱打开bin文件，然后点击其中的setup.exe文件 -> 
	进入安装界面 ->
	点击Install IBM Rational Rose Enterprise Edition->
	Desktop installation from CD image->直至完成
激活工具下载地址：http://down.sdbeta.com/soft1/license.upd

1. 安装完后，进入Rational所在目录(安装目录)下 -> Rose文件夹 -> 点击rose.exe ，由于尚未激活，会出现激活界面
2. 点击Launch License Key Administrator.
3. 点击Import a Rational License File
4. 点击Browse... ，选择压缩文件附带的license.upd -> 
点击Import ，待出现File imported successfully 提示时，表示激活文件导入成功，此时关闭激活窗口，
再点击rose.exe，恭喜你，进入rose的世界了。。

把暗转rose目录中的文件:
C:\Program Files (x86)\Rational\Common\suite objects.dll和license.dll复制到
C:\Windows\System32,如果还不行再复制到C:\Windows\SysWOW64目录下,重启在启动选择java版


















