package com.xjtu.structure;

import java.util.Scanner;

public class Q3 {

	/**
	 * 计算13号在星期w出现的次数；
	 * 先计算90年的一年的情况
	 * @param n	距离1990年的长度 n>=1
	 * @param w 0--6 周日到周六
	 */
	public static void calculateDay(int n, int w){
        //异常检测
		if(n>400 || n<1){
            System.out.println(-1);
            return;
        }
        
        if(!(w>=0 && w<=6)){
            System.out.println(-1);
            return;
        }		
		//存放13号出现次数
		int ans=0;
		boolean isRun=false;
		//偏移量，90年1月1的偏移为0，刚好第一天就是周一
		int delta=0;
		//这是每个月最后一天出现在周几偏移量
		int delta1=0;
		//从90年到目标年份的遍历
		for(int year=1990; year<1990+n; year++){
			//判断是否为闰年
			isRun=run(year);
			
			//计算1月份13号出现在周几
			int w11=(13+delta)%7;
			if(w11==w){
				ans++;
			}
			//计算一月的最后一天出现在周几
			delta=(31+delta1)%7;
			//计算2月份
			int w21=(13+delta)%7;
			if(w21==w){
				ans++;
			}
			//二月如果在闰年是29天
			int day=(isRun==true) ? 29 : 28;
			delta=(day+delta)%7;
			
			//3月
			int w31=(13+delta)%7;
			if(w31==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//4月
			int w41=(13+delta)%7;
			if(w41==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//5月
			int w51=(13+delta)%7;
			if(w51==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//6月
			int w61=(13+delta)%7;
			if(w61==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//7月
			int w71=(13+delta)%7;
			if(w31==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//8月
			int w81=(13+delta)%7;
			if(w81==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//9月
			int w91=(13+delta)%7;
			if(w91==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//10月
			int w101=(13+delta)%7;
			if(w101==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//11月
			int w111=(13+delta)%7;
			if(w111==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//12月
			int w121=(13+delta)%7;
			if(w121==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			delta1=delta;
		}
		System.out.println(ans);
	}
	
	/**
	 * 判断90年之后的某年是否为闰年
	 * @param year
	 * @return
	 */
	public static boolean run(int year){
		int delta=year-1900;
		if(delta<0){
			return false;
		//92及之后的年份,92为闰年，之后每4年一闰
		}else{
			if(delta%4==0){
				return true;
			}else{
				return false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int year=1989;
//		boolean res=run(year);
//		System.out.println(res);
		
		int n=1;
		int w=0;
		calculateDay(n, w);
		
		
//		int n;
//		int w;
//		Scanner sc=new Scanner(System.in);
//		n=sc.nextInt();
//		w=sc.nextInt();
//		calculateDay(n, w);
		
	}

}
