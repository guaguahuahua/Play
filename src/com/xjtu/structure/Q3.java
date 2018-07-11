package com.xjtu.structure;

import java.util.Scanner;

public class Q3 {

	/**
	 * ����13��������w���ֵĴ�����
	 * �ȼ���90���һ������
	 * @param n	����1990��ĳ��� n>=1
	 * @param w 0--6 ���յ�����
	 */
	public static void calculateDay(int n, int w){
        //�쳣���
		if(n>400 || n<1){
            System.out.println(-1);
            return;
        }
        
        if(!(w>=0 && w<=6)){
            System.out.println(-1);
            return;
        }		
		//���13�ų��ִ���
		int ans=0;
		boolean isRun=false;
		//ƫ������90��1��1��ƫ��Ϊ0���պõ�һ�������һ
		int delta=0;
		//����ÿ�������һ��������ܼ�ƫ����
		int delta1=0;
		//��90�굽Ŀ����ݵı���
		for(int year=1990; year<1990+n; year++){
			//�ж��Ƿ�Ϊ����
			isRun=run(year);
			
			//����1�·�13�ų������ܼ�
			int w11=(13+delta)%7;
			if(w11==w){
				ans++;
			}
			//����һ�µ����һ��������ܼ�
			delta=(31+delta1)%7;
			//����2�·�
			int w21=(13+delta)%7;
			if(w21==w){
				ans++;
			}
			//���������������29��
			int day=(isRun==true) ? 29 : 28;
			delta=(day+delta)%7;
			
			//3��
			int w31=(13+delta)%7;
			if(w31==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//4��
			int w41=(13+delta)%7;
			if(w41==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//5��
			int w51=(13+delta)%7;
			if(w51==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//6��
			int w61=(13+delta)%7;
			if(w61==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//7��
			int w71=(13+delta)%7;
			if(w31==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//8��
			int w81=(13+delta)%7;
			if(w81==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//9��
			int w91=(13+delta)%7;
			if(w91==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//10��
			int w101=(13+delta)%7;
			if(w101==w){
				ans++;
			}
			delta=(31+delta)%7;
			
			//11��
			int w111=(13+delta)%7;
			if(w111==w){
				ans++;
			}
			delta=(30+delta)%7;
			
			//12��
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
	 * �ж�90��֮���ĳ���Ƿ�Ϊ����
	 * @param year
	 * @return
	 */
	public static boolean run(int year){
		int delta=year-1900;
		if(delta<0){
			return false;
		//92��֮������,92Ϊ���֮꣬��ÿ4��һ��
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
