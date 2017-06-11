package com.xjtu.play;

public class HashTable {
	/**
	 * 向hashtable中写入数据
	 * @param table
	 * @param value
	 */
	public static void writeTable(int []table,int value){
		int len=table.length;
		int index=value%len;
		
		while(table[index]!=0){//开放定址法的线性探查法
			index++;
			index%=len;//为了防止越过数组的边界
		}
		if(table[index]==0){//如果hashtable该位置是空的，
			table[index]=value;
		}
	}
	/**
	 * 元素的删除，首先进行查找，跳过地址冲突的区域，然后将找到位置的元素重置为0，删除完成
	 * @param table
	 * @param value
	 */
	public static void deleteTable(int []table,int value){
		//直接根据除留余数法寻找该位置的元素
		int index=value%table.length;
		while(table[index]!=value){//如果当前的位置不是所要删除的元素，那么一直向后移动元素
			index++;
			index%=table.length;
		}
		if(table[index]==value){//找到了该元素，进行删除操作
			table[index]=0;
		}
	}
	/**
	 * 在hash表中查找元素
	 * @param table
	 * @param value
	 * return 如果找到了，直接返回1，没有找到返回0
	 */
	public static int findElement(int []table,int value){
		int index=value%table.length;
		int len=0;//主要是为了控制防止死循环，当找了一遍都没有找到的时候，可以返回了0
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
		//构造hash表，并根据除留余数法进行hash映射，这里元素的个数是13，所以选择的hash表的长度是23，其中因子选择是0.6
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
		//查找测试
		int r=ht.findElement(table, 54);
		System.out.println("查找结果为："+r);
		//删除元素测试
		ht.deleteTable(table, 54);
		for(int j=0;j<table.length;j++){
			System.out.print(table[j]+"\t");
		}
		System.out.println();
	}
}
