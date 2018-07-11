package com.xjtu.structure;

import java.util.Scanner;

public class Q2 {

	public static int calculateDay(int y, int m, int d){
		
		if(m==1 || m==2){
			m+=12;
			y--;
		}
		int iWeek=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
		switch(iWeek){
		case 0:return 0;
		case 1:return 1;
		case 2:return 2;
		case 3:return 3;
		case 4:return 4;
		case 5:return 5;
		case 6:return 6;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=1990, day=13;
		int y, w;
		Scanner sc=new Scanner(System.in);
		y=sc.nextInt();
		w=sc.nextInt();
		if(w<0 || w>6 || y>400){
			System.out.println(-1);
		}
		int ans=0; 
		for(int year1=1990; year1<1990+y; year1++){
			for(int month=1; month<=12; month++){
				if(calculateDay(year1, month, 13)==w){
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
