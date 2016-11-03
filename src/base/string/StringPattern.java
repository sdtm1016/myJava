package base.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 详解Pattern类和Matcher类
 */
public class StringPattern {

	public static void main(String[] args) {

		/**
		 * Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,
		 * 但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式,
		 */
		Pattern p = Pattern.compile("\\w+");

		//pattern() 返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数
		System.out.println("pattern: " + p.pattern());
		System.out.println("pattern: " + Pattern.compile("[(.+)]").pattern());
		System.out.println("pattern: " + Pattern.compile("\\[(.+)\\]").pattern());


		/**
		 * Pattern.matcher(String regex,CharSequence input)是一个静态方法,
		 * 用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
		 */
		System.out.println(Pattern.matches("\\d+", "2223"));//返回true
		//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
		System.out.println(Pattern.matches("\\d+", "2223aa"));


		/**
		 * Pattern.matcher(CharSequence input)返回一个Matcher对象.
		 * Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
		 * Pattern类只能做一些简单的匹配操作,要想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作.
		 * Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
		 */
		p = Pattern.compile("\\d+");
		Matcher m = p.matcher("22bb23");
		//返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的
		System.out.println(m.pattern());


		/**
		 * Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,
		 * 当匹配到时返回true,没匹配到则返回false
		 * Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
		 */

		/**
		 * 1.matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
		 * Pattern.matcher(String regex,CharSequence input)等价于:
		 * Pattern.compile(regex).matcher(input).matches()
		 */
		p = Pattern.compile("\\d+");
		m = Pattern.compile("\\d+").matcher("22bb23");
		System.out.println(m.matches());//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
		m = p.matcher("2223");
		System.out.println(m.matches());//返回true,因为\d+匹配到了整个字符串

		/**
		 * lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
		 */
		m = p.matcher("22bb23");
		System.out.println(m.lookingAt());//返回true,因为\d+匹配到了前面的22
		m = p.matcher("aa2223");
		System.out.println(m.lookingAt());//返回false,因为\d+不能匹配前面的aa

		/**
		 * find()对字符串进行匹配,匹配到的字符串可以在任何位置.
		 */
		m = p.matcher("22bb23");
		System.out.println(m.find());//true
		m = p.matcher("aabb");
		System.out.println(m.find());//false


		/**
		 * Mathcer.start()/ Matcher.end()/ Matcher.group()
		 * 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.
		 * start()返回匹配到的子字符串在字符串中的索引位置.
		 * end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
		 * group()返回匹配到的子字符串
		 *
		 * 注意:只有当匹配操作成功,才可以使用start(),end(),group()三个方法,否则会抛出java.lang.IllegalStateException,
		 * 也就是当matches(),lookingAt(),find()其中任意一个方法返回true时,才可以使用.
		 */
		m = p.matcher("aaa2223bb");

		if (m.find()) {//find任何位置.
			// 一下三个操作必须在find/lookingAt/matches任意一种方法后才能使用
			System.out.println("start Index:" + m.start() + ",end Index:" + m.end() + ",group:" + m.group());
		}

		m = p.matcher("2223bb");
		if (m.lookingAt()) {
			//由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
			System.out.println("start Index:" + m.start() + ",end Index:" + m.end() + ",group:" + m.group());
		}

		m = p.matcher("2223");
		if (m.matches()) {//匹配整个字符串
			// start永远为0,end永远为字符串长度,原因同上
			System.out.println("start Index:" + m.start() + ",end Index:" + m.end() + ",group:" + m.group());
		}

		/**
		 * start(),end(),group()均有一个重载方法
		 * 它们是start(int i),end(int i),group(int i)
		 * 专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.
		 *
		 * 在这里先理解捕获组的概念
		 * 捕获组可以通过从左到右计算其开括号来编号，编号是从1 开始的。
		 * 例如，在表达式 ((A)(B(C)))中，存在四个这样的组：
		 *      ((A)(B(C)))
		 *    	(A)
		 *  	(B(C))
		 *      (C)
		 * 组零始终代表整个表达式。 以 (?) 开头的组是纯的非捕获组，它不捕获文本，也不针对组合计进行计数。
		 * 与组关联的捕获输入始终是与组最近匹配的子序列。
		 * 如果由于量化的缘故再次计算了组，则在第二次计算失败时将保留其以前捕获的值（如果有的话）
		 * 例如，将字符串"aba" 与表达式(a(b)?)+ 相匹配，会将第二组设置为 "b"。在每个匹配的开头，所有捕获的输入都会被丢弃。
		 */
		p = Pattern.compile("([a-z]+)(\\d+)");
		m = p.matcher("aaa2223bb");
		if (m.find()) {
			System.out.println("groupCount: " + m.groupCount());//返回2,因为有2组
			System.out.println("start(1): " + m.start(1));//返回0 返回第一组匹配到的子字符串在字符串中的索引号
			System.out.println("start(2): " + m.start(2));//返回3
			System.out.println("end(1): " + m.end(1));//返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
			System.out.println("end(2): " + m.end(2));//返回7
			System.out.println("group(1): " + m.group(1));//返回aaa,返回第一组匹配到的子字符串
			System.out.println("group(2): " + m.group(2)); //返回2223,返回第二组匹配到的子字符串
		}


		/**
		 * 现在我们使用一下稍微高级点的正则匹配操作,
		 * 例如有一段文本,里面有很多数字,而且这些数字是分开的,
		 * 我们现在要将文本中所有数字都取出来,利用java的正则操作
		 */
		p = Pattern.compile("\\d+");
		m = p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
		while (m.find()) {
			System.out.println(m.group());
			System.out.println("start:" + m.start() + " end:" + m.end());
		}
		/**
		 * 现在大家应该知道,每次执行匹配操作后start(),end(),group()三个方法的值都会改变,
		 * 改变成匹配到的子字符串的信息,以及它们的重载方法,也会改变成相应的信息.
		 */
	}
}
