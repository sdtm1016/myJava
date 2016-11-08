package math.demo;

/**
 * 输入一个字符串，输出该字符串中最大对称子串的长度。
 * 例如输入字符串：“google”，该字符串中最长的子字符串是“goog”，长度为4，因而输出为4。
 */
public class Symmetric {

	public static void main(String[] args) {
		String s = new String("aaaaaaaaaaaaaaa");
		System.out.println("最大的对称字串是:" + finaMaxSubString(s));
	}

	public static int finaMaxSubString(String s) {
		int maxLength = 1;
		int length = s.length();
		int start = 0;
//    while(start<length)
//    {
//     int before = start-1;
// int behide = start+1;
// int currentLengh = 1;
// if(start!=0)
// {
//
// while(before>-1&&behide<length&&s.charAt(before)==s.charAt(behide))
// {
// before--;
// behide++;
// }
// before++;
// behide--;
// }
//
// currentLengh = behide-before+1;
// maxLength = maxLength>currentLengh?maxLength:currentLengh;
//
//    before = start;
// behide = start+1;
// while(before>-1&&behide<length&&s.charAt(before)==s.charAt(behide))
// {
// before--;
// behide++;
// }
// before++;
// behide--;
// currentLengh = behide-before+1;
// maxLength = maxLength>currentLengh?maxLength:currentLengh;
// start++;
//    }
//
		while (start < length) {
			int before = start - 1;
			int behide = start + 1;
			int currentLengh = 1;


			while (before > -1 && behide < length && s.charAt(before) == s.charAt(behide)) {
				before--;
				behide++;
			}

			currentLengh = behide - before + 1 - 2;
			maxLength = maxLength > currentLengh ? maxLength : currentLengh;

			before = start;
			behide = start + 1;
			while (before > -1 && behide < length && s.charAt(before) == s.charAt(behide)) {
				before--;
				behide++;
			}

			currentLengh = behide - before + 1 - 2;
			maxLength = maxLength > currentLengh ? maxLength : currentLengh;
			start++;
		}

		return maxLength;
	}


}