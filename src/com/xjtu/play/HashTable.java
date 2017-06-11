package com.xjtu.play;

public class HashTable {
	/**
	 * ��hashtable��д������
	 * @param table
	 * @param value
	 */
	public static void writeTable(int []table,int value){
		int len=table.length;
		int index=value%len;
		
		while(table[index]!=0){//���Ŷ�ַ��������̽�鷨
			index++;
			index%=len;//Ϊ�˷�ֹԽ������ı߽�
		}
		if(table[index]==0){//���hashtable��λ���ǿյģ�
			table[index]=value;
		}
	}
	/**
	 * Ԫ�ص�ɾ�������Ƚ��в��ң�������ַ��ͻ������Ȼ���ҵ�λ�õ�Ԫ������Ϊ0��ɾ�����
	 * @param table
	 * @param value
	 */
	public static void deleteTable(int []table,int value){
		//ֱ�Ӹ��ݳ���������Ѱ�Ҹ�λ�õ�Ԫ��
		int index=value%table.length;
		while(table[index]!=value){//�����ǰ��λ�ò�����Ҫɾ����Ԫ�أ���ôһֱ����ƶ�Ԫ��
			index++;
			index%=table.length;
		}
		if(table[index]==value){//�ҵ��˸�Ԫ�أ�����ɾ������
			table[index]=0;
		}
	}
	/**
	 * ��hash���в���Ԫ��
	 * @param table
	 * @param value
	 * return ����ҵ��ˣ�ֱ�ӷ���1��û���ҵ�����0
	 */
	public static int findElement(int []table,int value){
		int index=value%table.length;
		int len=0;//��Ҫ��Ϊ�˿��Ʒ�ֹ��ѭ����������һ�鶼û���ҵ���ʱ�򣬿��Է�����0
		while(len<table.length && table[index]!=value){
			index++;
			index%=table.length;
			len++;
		}
		if(len==table.length){
			return 0;
		}else if(table[index]==value){
			return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����hash�������ݳ�������������hashӳ�䣬����Ԫ�صĸ�����13������ѡ���hash��ĳ�����23����������ѡ����0.6
		int []table=new int[23];
		int []nums={16,43,46,88,55,74,54,31,77,60,90,29,66};
		HashTable ht=new HashTable();
		for(int i=0;i<nums.length;i++){
			ht.writeTable(table, nums[i]);
		}
		//test para 
		for(int j=0;j<table.length;j++){
			System.out.print(table[j]+"\t");
		}
		System.out.println();
		//���Ҳ���
		int r=ht.findElement(table, 54);
		System.out.println("���ҽ��Ϊ��"+r);
		//ɾ��Ԫ�ز���
		ht.deleteTable(table, 54);
		for(int j=0;j<table.length;j++){
			System.out.print(table[j]+"\t");
		}
		System.out.println();
	}
}
