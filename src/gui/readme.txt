java的强项不在于gui(graphic user interface)图形用户接口
	用图形的方式,显示计算机操作的界面,方便直观
	这里简单示范,主要体现一个面向对象思想
	对于java的gui,非常繁琐,界面也非常难看,所以很少人使用java gui

与其相对的概念:CLI:command line user interface(命令行用户接口)
	就是简单的Dos命令行操作
	需要记忆一些常用命令,操作不直观
	例子:创建文件夹,删除文件夹mkdir,rm -rf xx
	而GUI可以使用鼠标在窗口中点击模块实现

Java为GUI提供的对象都在Java.Awt和javax.Swing两个包中
	AWT(Abstract Window Toolkit)：抽象窗口工具包，早期编写图形界面应用程序的包。
	Swing:为解决 AWT 存在的问题而新开发的图形界面包。Swing是对AWT的改良和扩展。
AWT和Swing的实现原理不同：
	AWT的图形函数与操作系统提供的图形函数有着一一对应的关系。
		也就是说，当我们利用 AWT构件图形用户界面的时候，实际上是在利用操作系统的图形库。
		不同的操作系统其图形库的功能可能不一样，在一个平台上存在的功能在另外一个平台上则可能不存在。
		为了实现Java语言所宣称的"一次编译，到处运行"的概念，AWT不得不通过牺牲功能来实现平台无关性。
		因此，AWT 的图形功能是各操作系统图形功能的“交集”。
		因为AWT是依靠本地方法来实现功能的，所以AWT控件称为“重量级控件”。 
	而Swing,不仅提供了AWT的所有功能，还用纯粹的Java代码对AWT的功能进行了大幅度的扩充。
		例如：并不是所有的操作系统都提供了对树形控件的支持，
		 Swing则利用了AWT中所提供的基本作图方法模拟了一个树形控件。
		由于 Swing是用纯粹的Java代码来实现的，因此Swing控件在各平台通用。
		因为Swing不使用本地方法，故Swing控件称为“轻量级控件”。 
	AWT和Swing之间的区别：
		1)AWT 是基于本地方法的C/C++程序，其运行速度比较快；
		Swing是基于AWT的Java程序，其运行速度比较慢。
		2)AWT的控件在不同的平台可能表现不同，而Swing在所有平台表现一致。
	在实际应用中，应该使用AWT还是Swing取决于应用程序所部署的平台类型。例如：
		1)对于一个嵌入式应用，目标平台的硬件资源往往非常有限，而应用程序的运行速度又是项目中至关重要的因素。
		在这种矛盾的情况下，简单而高效的AWT当然成了嵌入式Java的第一选择。
		2)在普通的基于PC或者是工作站的标准Java应用中，硬件资源对应用程序所造成的限制往往不是项目中的关键因素。
		所以在标准版的Java中则提倡使用Swing， 也就是通过牺牲速度来实现应用程序的功能。
一些常用概念:
	Label(标签),Checkbox/RadioBox,Menu(菜单)/MenuItem菜单项
	ToolBar工具栏/StatusBar状态栏/TitleBar标题栏/ScrollBar标题栏/TaskBar任务栏
	active(激活)/deactive(钝化) TextField(文本框单行)/TextArea(文本域多行)
	password(密码框)
	

在java中，AWT包的名称是java.awt，Swing包的名称是javax.swing。
Swing组件按功能可分为如下几类:
	1、顶层容器:JFrame, JApplet, JDialog和JWindow。
	2、中间容器:JPanel, JScrollPane, JSplitPane, JTooIBar等。
	3、特殊容器:
		在用户界面上具有特殊作用的中间容器，如JlnternalFrame、JRootPane、JLayeredPane和JDestopPane等。
	4、基本组件:
		实现人机交互的组件，如Button、 JComboBox、Just, Menu、Mider等。
	5、不可编辑信息的显示组件:
		向用户显示不可编辑信息的组件，如JLabel、JProgressBar和JTooITip等。
	6、可编辑信息的显示组件:
		向用户显示能被编辑的格式化信息的组件，如JTable、JTextArea和JTextField等。
	7、特殊对话框组件:
		可以直接产生特殊对话框的组件，如JColorChoosor和JFileChooser等。

Swing的4个顶层容器类直接继承了AWT组件，而不是从JComponent派生出来的，
	它们分别是：JFrame、JDialog、JApplet和JWindow。
	顶层容器类并不是轻量级组件，而是重量级组件(需要部分委托给运行平台上GUI组件的对等体)。
顶层容器中：
	1.JApplet可作为java小应用程序的窗体，但通常使用java.applet.Applet类来创建小应用程序。
	2.JFrame集成自AWTFrame类，通常作为主窗体使用。
	3.JDialog用于创建对话框的窗体。
	4.JWindow与AWT中的Window相似，但几乎不用，因为没有太大的实用价值。

Swing组件的类名和对应AWT组件的类名基本一致，只要在原来的AWT组件类名前添加“J”即可，但有如下几个例外：
	1、JComboBox:对应于AWT里的Choice组件，但比Choice组件功能更丰富。
	2、JFileChooser:对位于AWT里的FileDialog组件。
	3、JSrcoIIBar:对应AWT里的Scrollbar。注意两个组件类名中b字母的大小写差别。
	4、JCheckBox:对应于AWT里的Checkbox。注意两个组件类名中b字母的大小写差别。
	5、JCheckBoxMenuItem:对应于AWT里的CheckboxMenuItem，注意两个组件类名中b字母的大小写差别。
上面JCheckBox和JCheckBoxMenuItem与Checkbox和CheckboxMenuItem字母B的大小写差别，
主要是因为早期Java命名不太规范造成的。
http://blog.csdn.net/iamluole/article/details/8142257