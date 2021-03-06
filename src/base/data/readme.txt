数据类型是计算机语言里针对内存的一种抽象表达方式，也是语言的抽象原子概念，即语言中最基本的定义单元。
在Java语言中，数据类型分为基本类型和对象类型。


Java中的基本类型有九种，并且都有其对应的包装类。
其中void类型及其包装类java.lang.Void，我们无法直接操作。
其余八种基本类型，从类型上又可分为：布尔型、字符型和数值型；其中数值型又可分为整数和实数。如下表：

基本数据类型
byte占用1byte,字节,有符号型,范围为-128—127
char占2byte(Unicode码),字符,无符号型的,范围是0—65535

short占用2byte,短整数,-32768(-2的15此方)到32767(2的15次方-1)
int占用4byte,整数,-2147483648(-2的31次方)到2147483647(2的31次方-1)
long占用8byte,长整数,-9223372036854775808（-2的63次方）到9223372036854775807(2的63次方-1)

float占用4byte,浮点,小数,1.4E-45(2的-149次方)到3.4028235E38(2的128次方-1)
double占用8byte,双精度浮点,小数,4.9E-324(2的-1074次方)到1.7976931348623157E308(2的1024次方-1)
boolean具体不清楚,1个字节、4个字节都是有可能的
注:
int默认4个字节,计算机每个字节8bit,
也就是每个字节可以表示2的8次方256个的整数(0-255)
计算机位运算是最快的,那么我们可以根据实际情况设计自己的数据格式,
例如:将多个int值(如:8个bit中0-255之间的数)通过位运算存在在一个int的空间中
>>,<<位运算

说明：
	1． 基本类型数据本身的值直接存储在内存栈空间里，更加高效。
	2． 每种基本类型所占的存储空间大小固定，便于移植。
	3． 所有数值类型都有正负号。
	4． boolean类型所占存储空间的大小没有明确指定，仅定义为能够取字面值true或false。
	5． 从JDK5.0开始，Java基本数据类型及其对应包装类之间能实现自动装箱解箱操作。
	6． 带有“F/f”后缀的数都是float类型的；带有“D/d”后缀的数都是double类型的。
	7． 未带有字符后缀标识的整数默认为int类型；未带有字符后缀标识的浮点数默认为double类型。
	8． 如果一个整数的值超出了int类型能够表示的范围，则必须增加后缀“L/l”表示为long型。
	9． 编译期检查：编译器会在编译期对byte、short、int、long、float、double、char型变量的值进行检查，
	如果超出了它们的取值范围就会报错。
   10．自动类型转换和强制类型转换：
		A. 当一个较小类型的数据和较大类型的数据一起运算的时候，
		系统会将较小的数据类型自动转换为较大的数据类型进行运算；
		在方法调用时，如果实际参数类型较小，而函数的形参类型较大时，
			除非有匹配的方法，否则会将参数自动转换为较大类型的形式参数进行调用。
		B. 如果我们想把一个能表示更大范围或者更高精度的类型，转换为一个范围更小或者精度更低的类型时，
		就需要使用强制类型转换(Cast)了，强制类型转换可能导致精度损失。
		C. 自动类型转换图示：
			byte -> short(char) -> int -> long -> float -> double；
			反之为强制类型转换。
	11．当使用+、-、*、/、%运算符对基本类型进行运算时，遵循如下规则：
		A. 只要两个操作数中有一个是double类型的，另一个将会被转换成double类型，并且结果也是double类型；
		B. 否则，只要两个操作数中有一个是float类型的，另一个将会被转换成float类型，并且结果也是float类型；
		C. 否则，只要两个操作数中有一个是long类型的，另一个将会被转换成long类型，并且结果也是long类型；
		D. 否则，两个操作数（包括byte、short、int、char）都将会被转换成int类型，并且结果也是int类型。
	12．当使用+=、-=、*=、/=、%=、运算符对基本类型进行运算时，遵循如下规则：
		A. 运算符右边的数值将首先被强制转换成与运算符左边数值相同的类型，
			然后再执行运算，且运算结果与运算符左边数值类型相同。

2.对象类型：
对象类型继承Object类，按照存储对象的内存模型进行数据存储。对象引用存储在内存栈上，而对象本身的值存储在内存堆上。

基本数据类型,包装类
byte	Byte,
short	Short,
int		Integer,
long	Long,
float	Float,
double	Double,
boolean	Boolean,
char	Character
包装类都是final类不能继承
Integer i2 = 12;// 自动装箱
System.out.println(i2);// 自动拆箱
区别:
	包装类是对象,默认null(如Integer i;i默认null),
	而数据类型默认0(如int i;i默认0)
	基本类型可以直接参与运算
