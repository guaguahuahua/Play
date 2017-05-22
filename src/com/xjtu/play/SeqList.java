package com.xjtu.play;

import java.util.Random;

/**
 * ���룬ɾ��������ĳ���ض�Ԫ�أ���ʼ������ǰԪ�ظ���
 * @author 22847
 */
public class SeqList {
	private int MAX=11;
	class seqlist{
		int []nums=new int[MAX];
		int size;
	}
	/**
	 * ��˳����ĳ��λ�ò���һ��Ԫ��
	 * @param seqlist  �������˳���
	 * @param location ����Ԫ�ص�λ��
	 * @param value  ����Ԫ�ص�ֵ
	 * @return
	 */
	public boolean insert(seqlist seqlist,int location,int value){
		//����Խ���������������
		if(location<0 || location>=MAX){
			System.out.println("����Խ��");
			return false;
		}
		if(seqlist.size==MAX){
			System.out.println("��������");
			return false;
		}
		for(int i=seqlist.size-1;i>location;i--){//�ƶ�Ԫ�أ�������λ���ڳ���
			seqlist.nums[i-1]=seqlist.nums[i];
		}
		seqlist.nums[location]=value;
		seqlist.size++;
		return true;
	}
	/**
	 * 
	 * @param seqlist
	 * @param location
	 * @return
	 */
	public int delete(seqlist seqlist,int location,int delNum){
		if(location<0 || location>MAX){
			System.out.println("λ��Խ��");
		}
		if(seqlist.size==0){
			System.out.println("�����ѿ�");
		}
		delNum=seqlist.nums[location];//�Ƚ�Ҫɾ������ȡ����
		for(int i=location+1;i<=seqlist.size;i++){///�ƶ�Ԫ�أ�����ԭ����λ��
			seqlist.nums[i-1]=seqlist.nums[i];
		}
		seqlist.size--;
		return delNum;
	}
	/**
	 * ���������������ض�ֵ
	 * @param seqlist
	 * @param location
	 * @return
	 */
	public int getElement(seqlist seqlist,int location){
		if(location<0 || location>MAX ){
			System.out.println("λ��Խ��");
		}
		if(seqlist.size==0){
			System.out.println("�ѿգ�û��Ԫ�ؿ���ȡ");
		}
		return seqlist.nums[location];
	} 
	/**
	 * �������Ա�ĳ���
	 * @param seqlist
	 * @return
	 */
	public int getSize(seqlist seqlist){
		
		return seqlist.size;
	}
	/**
	 * ���ݸ�����Ԫ�أ�����ɾ���Ĺ���
	 * @param seqlist
	 * @param element
	 * @return
	 */
	public boolean deleteSpeciElement(seqlist seqlist,int element){
		boolean flag=false;
		for(int i=0;i<seqlist.size;i++){
			if(element==seqlist.nums[i]){
				for(int j=i+1;j<seqlist.size;j++){
					seqlist.nums[j-1]=seqlist.nums[j];
				}
				flag=true;
			}
		}
		if(!flag){//���ִ�е��⣬˵��û���ҵ�Ԫ��
			return false;
		}
		return true ;
	}
	/**
	 * ��˳�������ͬ��Ԫ��ȫ��ɾ����
	 * ��Ϊû�ҵ�һ����ͬ��Ԫ�ؾ�ɾ��һ�Σ��Ƿǳ���Ч�ģ�����ÿ�ҵ�һ����ͬ��Ԫ�ؾ���������Ԫ��������
	 * ������ĩβ��Ԫ����д����ͬԪ�صĵط�
	 * @param seqlist
	 * @param element
	 * @return
	 */
	public boolean deleteSameElement(seqlist seqlist,int element){
		boolean flag=false;
		for(int i=0;i<seqlist.size;i++){
			if(seqlist.nums[i]==element){
				for(int j=i+1;j<=seqlist.size;j++){
					seqlist.nums[j-1]=seqlist.nums[j];
				}
				flag=true;
			}
		}
		if(!flag){
			System.out.println("δ�ҵ����Ԫ��");
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���Բ���
		SeqList cluss=new SeqList();
		seqlist s=cluss.new seqlist();
		int []random={15, 5 ,23 ,23 ,14 ,25 ,25 ,31 ,28 ,22 };
		for(int i=0;i<10;i++){
//			Random random=new Random();
			cluss.insert(s, i, random[i]);
		}
		for(int K:s.nums){
			System.out.print(K+" ");
		}
//		cluss.insert(s, 0, 12);

		//����ɾ��
		System.out.println("�����С��"+s.size);
		int delNum=0;
		int r=cluss.delete(s, 3, delNum);
		System.out.println("r="+r);
		
		for(int K:s.nums){
			System.out.print(K+" ");
		}
		System.out.println("�����С��"+s.size);
		//����ȡԪ�غ���
		int r1= cluss.getElement(s, 3);
		System.out.println("ȡ���ĵ�����Ԫ�أ�"+r1);
		//�������еĵ�ǰ����
		int r2=cluss.getSize(s);
		System.out.println("size:"+r2);
		//ɾ���ض���Ԫ��
		boolean r3=cluss.deleteSpeciElement(s, 23);
		System.out.println("deleteSpeciElement:"+r3);
		for(int K:s.nums){
			System.out.print(K+" ");
		}
		System.out.println();
		//����ɾ��������ͬԪ��
		boolean r4=cluss.deleteSameElement(s, 22);
		System.out.println(r4);
		for(int K:s.nums){
			System.out.print(K+" ");
		}
		System.out.println();
	}

}
