package com.xjtu.play;

import java.util.Random;

public class MyGenerator {
	public static int []re=new int[1000000];
	public static void generate(){
		Random random=new Random();
		for(int i=0;i<re.length;i++){
			re[i]=random.nextInt(100000);
		}	
	}
	/**
	 * 对元素进行输出
	 * @param nums
	 */
	public static void show(int []nums){
		for(int K:nums){
			System.out.print(K+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate();//生成测试数据
		int []re1=re;
		int []re2=re;
		int []re3=re;
		int []re4=re;
		int []re5=re;
		int []re6=re;
		//直接插入排序
		long insertS=System.currentTimeMillis();
		InsertSort.insertSort(re);
//		show(re);
		long insertE=System.currentTimeMillis();
		System.out.println("直接插入排序："+(insertE-insertS));
		//shellSort		
		long shellS=System.currentTimeMillis();
		int []distance={4,2,1};
		ShellSort.shellSort(re1, distance);
//		show(re1);
		long shellE=System.currentTimeMillis();
		System.out.println("希尔排序："+(shellE-shellS));
		//选择排序
		long selS=System.currentTimeMillis();
		SelectSort1.selectSort(re2);
//		show(re2);
		long selE=System.currentTimeMillis();
		System.out.println("选择排序："+(selE-selS));
		//堆排序
		long heapS=System.currentTimeMillis();
		HeapSort.heapSort(re3);
//		show(re3);
		long heapE=System.currentTimeMillis();
		System.out.println("堆排序："+(heapE-heapS));
		//冒泡排序法
		long bubbleS=System.currentTimeMillis();
		BubbleSort1.bubbleSort(re4);
//		show(re4);
		long bubbleE=System.currentTimeMillis();
		System.out.println("冒泡排序法："+(bubbleE-bubbleS));
		//快速排序法
		long quickS=System.currentTimeMillis();
		QuickSort1.quickSort(re5, 0, re5.length-1);
//		show(re5);
//		long quickE=System.currentTimeMillis();
//		System.out.println("快速排："+(quickE-quickS));
		//基数排序
		long raidS=System.currentTimeMillis();
		RaidSort.raidSort(re6, 5);
//		show(re6);
		long raidE=System.currentTimeMillis();
		System.out.println("基数排序："+(raidE-raidS));
	}

}
