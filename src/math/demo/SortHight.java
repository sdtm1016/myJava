package math.demo;

/**
 * 12个高矮不同的人，排成两排，每排必须是从矮到高排列，
 * 而且第二排比对应的第一排的人高，
 * 问排列方式有多少种?
 */
public class SortHight {

	public static void main(String[] args) {
		InLineProblem(0, 0, 12);
		System.out.println("总共的排列数目为:" + totalNum);


	}

	static int totalNum = 0;


	//函数功能 ： 排队问题
	//函数参数 ： firstFree为第1排第1个空余位置
	//            secondFree为第2排第1个空余位置
	//            num为排队人数
	//返回值 ：   无
	static void InLineProblem(int firstFree, int secondFree, int num) {
		if (firstFree == num / 2 || secondFree == num / 2) //其中一排无剩余位置
		{
			totalNum++;
			return;
		}
		if (firstFree == secondFree) //第1排人数与第2排人数一样
		{
			InLineProblem(firstFree + 1, secondFree, num); //只能排在第1排
		} else {
			InLineProblem(firstFree + 1, secondFree, num); //排在第1排
			InLineProblem(firstFree, secondFree + 1, num); //排在第2排
		}
	}
}
