package com.xjtu.play;

public class MyString {
	private String str="6";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		((MyString)null).method();

//		int x=3;
//		int y=4;
//		System.out.println("pre:"+"x="+x+","+"y="+y);
//		swap(x,y);
//		System.out.println("post:"+"x="+x+","+"y="+y);
		
//		MyString ms=new MyString();
//		System.out.println(ms.str);
//		ms.change(ms.str);
//		System.out.println(ms.str);
		
		matrix();
	}
	public void method(){
		System.out.println("i am a dynamic method,can not be invoked by static method");
	}
	
	public static void swap(int a,int b){
		int tmp=a;
		a=b;
		b=a;
	}
	public static String change(String str){
		str="10";
		return str;
	}
	
	public static void matrix(){
		int [][]matrix=new int[3][3];
		int var=100;
		for(int row=0;row<matrix.length;row++){
			for(int col=0;col<matrix[row].length;col++){
				matrix[row][col]=var++;
			}
		}
		//output test
		for(int row=0;row<matrix.length;row++){
			for(int col=0;col<matrix[row].length;col++){
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}
		//diag()
		int sum=0;
		for(int i=0;i<matrix.length;i++){
			sum+=matrix[i][i];
		}
		System.out.println(sum);
	}
}
