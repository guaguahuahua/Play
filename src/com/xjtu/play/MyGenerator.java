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
	 * ��Ԫ�ؽ������
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
		generate();//���ɲ�������
		int []re1=re;
		int []re2=re;
		int []re3=re;
		int []re4=re;
		int []re5=re;
		int []re6=re;
		//ֱ�Ӳ�������
		long insertS=System.currentTimeMillis();
		InsertSort.insertSort(re);
//		show(re);
		long insertE=System.currentTimeMillis();
		System.out.println("ֱ�Ӳ�������"+(insertE-insertS));
		//shellSort		
		long shellS=System.currentTimeMillis();
		int []distance={4,2,1};
		ShellSort.shellSort(re1, distance);
//		show(re1);
		long shellE=System.currentTimeMillis();
		System.out.println("ϣ������"+(shellE-shellS));
		//ѡ������
		long selS=System.currentTimeMillis();
		SelectSort1.selectSort(re2);
//		show(re2);
		long selE=System.currentTimeMillis();
		System.out.println("ѡ������"+(selE-selS));
		//������
		long heapS=System.currentTimeMillis();
		HeapSort.heapSort(re3);
//		show(re3);
		long heapE=System.currentTimeMillis();
		System.out.println("������"+(heapE-heapS));
		//ð������
		long bubbleS=System.currentTimeMillis();
		BubbleSort1.bubbleSort(re4);
//		show(re4);
		long bubbleE=System.currentTimeMillis();
		System.out.println("ð�����򷨣�"+(bubbleE-bubbleS));
		//��������
		long quickS=System.currentTimeMillis();
		QuickSort1.quickSort(re5, 0, re5.length-1);
//		show(re5);
//		long quickE=System.currentTimeMillis();
//		System.out.println("�����ţ�"+(quickE-quickS));
		//��������
		long raidS=System.currentTimeMillis();
		RaidSort.raidSort(re6, 5);
//		show(re6);
		long raidE=System.currentTimeMillis();
		System.out.println("��������"+(raidE-raidS));
	}

}
