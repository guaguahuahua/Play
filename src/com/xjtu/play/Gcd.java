package com.xjtu.play;

/**
 * 
 * �������������Լ��
 * @author 22847
 *
 */
public class Gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=24;
		int y=16;
		int r=gcd(x,y);
		System.out.println(r);
	}
	//ֱ���ô�ͳ�ķ�����⣬���������漰�˳�����ȡ�����㣬ϵͳ�Ŀ����Ƚϴ�
	public static int gcd_1(int x,int y){
		int tmp=x%y;
		while(tmp!=0){
			x=y;
			y=tmp;
			tmp=x%y;
		}
		return y;
	}
	//����ͨ������ʵ��
	public static int gcd(int x,int y){
		if(x==0 || y==0){
			return x==0 ? y:x;
		}
		while(x!=0 && y!=0){
			if(x<y){
				int tmp=x;
				x=y;
				y=tmp;
			}
			int tmp=y;
			y=x-tmp;
			x=tmp;
		}
		return x==0 ? y:x;
	}
}
