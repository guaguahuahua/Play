package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

public class RaidSort {
	/**
	 * ���������㷨��
	 * @param nums	Ԫ������
	 * @param length ����Ԫ�������е����Ԫ�صĳ���
	 */
	public static void raidSort(int []nums,int length){
		List<Integer> []raid=new ArrayList[10];//�������ÿ�εķ��������
		for(int i=0;i<10;i++){//��ʼ�����ݽṹ�����ڴ��
			raid[i]=new ArrayList<Integer>();
		}
		int factor=1;
		for(int times=0;times<length;times++){//������������ѭ���Ĵ���
			//����
			for(int i=0;i<nums.length;i++){
				
				int tmp=nums[i];
				if(times>0){
					tmp=nums[i]/factor;
				}
				tmp=tmp%10;//��ø�λԪ��
				raid[tmp].add(nums[i]);//����Ԫ�طŵ����ʵ�Ͱ
			}
			//�ռ�
			int index=0;
			for(int i=0;i<raid.length;i++){
				for(int j=0;j<raid[i].size();j++){
					nums[index++]=raid[i].get(j);
				}
				raid[i].clear();
			}
			factor*=10;
		}
//		System.out.println("after");
//		show(nums);
	}
	/**
	 * �������
	 * @param nums
	 */
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={710,342,45,686,6,41,429,134,68,264};
		System.out.println("before");
		show(nums);
		raidSort(nums,3);
	}

}
