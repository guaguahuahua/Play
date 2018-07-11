package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J2 {

	public static void seperate(List<Integer> list){
		
		for(int i=0; i<list.size(); i++){
			int n=list.get(i);
			int left=0, right=Integer.MAX_VALUE;
			for(int x=1; x<=n; x++){
				int temp=n % x;
				
				//如果能整除
				if(temp==0){
					int y=n/x;
					//判断是否为一个奇数和偶数组合
					if(x%2==1 && y%2==0){
						//如果是，那么判断是否要更新
						if(y<right){
							left=x;
							right=y;
							
						}
					}
				}
			}
			if(right!=Integer.MAX_VALUE){
				System.out.println(left+" "+right);	
			}else{
				System.out.println("no");
			}		
		}
		
	}
	
	public static boolean isMici(int n){
		int count=0;
		while(n!=0){
			int temp=n&1;
			if(temp==1){
				count++;
			}
			n=n>>1;
		}
		if(count==1){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int rows=sc.nextInt();
		List <Integer>list=new ArrayList();
		//将输入的数字添加到list当中
		for(int r=0; r<rows; r++){
			int t=sc.nextInt();
			if(!isMici(t)){
				list.add(sc.nextInt());	
			}
//			list.add(sc.nextInt());
			
		}		
		seperate(list);
		
//		boolean res=isMici(10);
//		System.out.println(res);
	}

}
