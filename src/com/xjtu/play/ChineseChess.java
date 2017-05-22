package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

public class ChineseChess {
	
	public static void steps(){
		
		List Alocation=new ArrayList();
		for(int row=8;row<=10;row++){//将有9个位置可以移动，对应的帅有6个位置
			for(int col='d';col<='f';col++){
				List tmpa=new ArrayList();
				tmpa.add(row);
				tmpa.add((char)col);
				Alocation.add("A坐标：");
				Alocation.add(tmpa);
				List Blocation=new ArrayList(); 
				//下面是帅可以移动的位置
				for(int rows=1;rows<=3;rows++){
					for(int cols='d';cols<='f';cols++){
						List tmp=new ArrayList();
						if(col==cols){
							continue;
						}
						tmp.add(rows);
						tmp.add((char)cols);
						Blocation.add(tmp);
					}
					
				}
				Alocation.add(Blocation);
			}
		}
		for(int i=0;i<Alocation.size();i++){
			System.out.println(Alocation.get(i)+" ");
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		steps();
		method2();
	}
	
	public static void method2(){
		
		A a=new A();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				
				if(i%3!=j%3){
					System.out.println("i:"+i+"j:"+j);
				}
			}
		}
		
	}

}
