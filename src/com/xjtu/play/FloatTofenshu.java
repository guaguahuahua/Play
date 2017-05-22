package com.xjtu.play;

/**
 * 将无限循环的小数，或者小数转化为分数表示形式，并且要求分数表示形式是最简的形式
 * @author 22847
 */
public class FloatTofenshu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1.555555";
		String result=floatTofenshu(str);
		System.out.println(result);
	}
	/***总计两种类型，一种有限小数，一种是无限循环小数，对于无理数形式不再考虑的范围之内
	 * 对于有限小数 0.3，直接转化，
	 * 对于无限循环的小数 0.312(333),小括号中表示为循环节
	 * @param n
	 * @return
	 */
	public static String floatTofenshu(String str){
		//首先判断是不是无限循环的小数
		int fzi=0;
		int fmu=0;
		int com=0;
		if(str.charAt(str.length()-1)==')'){//无限循环小数的形式
			//找打循环小数的循环节部分
			int begin=str.indexOf('(');
			String cir=str.substring(begin+1,str.length()-1);//取出循环节部分的整数
			String []tmp=str.split("\\.");//tmp0是整数部分，tmp1是小数部分(非循环节和循环节)
			String xiao=tmp[1].substring(0,tmp[1].indexOf('('));

			fzi=(int) (Integer.parseInt(xiao)*Math.pow(10,cir.length())+Integer.parseInt(cir));
			fmu=(int) ((Math.pow(10,cir.length())-1)*Math.pow(10,xiao.length()));
			com=Gcd.gcd(fzi, fmu);
			fmu=fmu/com;
			fzi=fzi/com+Integer.parseInt(tmp[0])*fmu;
		}else{//有限小数
			String []tmp=str.split("\\.");//tmp[0]是整数部分，tmp[1]是小数部分
			fmu=(int) Math.pow(10, tmp[1].length());//分母部分直接转化为百分之形式
			fzi=Integer.parseInt(tmp[1]);//将原来的分子转化为整数形式
			com=Gcd.gcd(fzi, fmu);//求最大公约数
			fmu=fmu/com;//化简分母
			fzi=fzi/com+Integer.parseInt(tmp[0])*fmu;//化简分子，若整数部分不为0，转化为假分数形式
		}
		return fzi+"/"+fmu;//以分数的形式返回所得值
	}
}
