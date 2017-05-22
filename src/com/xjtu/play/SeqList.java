package com.xjtu.play;

import java.util.Random;

/**
 * 插入，删除，返回某个特定元素，初始化，求当前元素个数
 * @author 22847
 */
public class SeqList {
	private int MAX=11;
	class seqlist{
		int []nums=new int[MAX];
		int size;
	}
	/**
	 * 向顺序表的某个位置插入一个元素
	 * @param seqlist  被插入的顺序表
	 * @param location 插入元素的位置
	 * @param value  插入元素的值
	 * @return
	 */
	public boolean insert(seqlist seqlist,int location,int value){
		//索引越界错误，数组满错误
		if(location<0 || location>=MAX){
			System.out.println("索引越界");
			return false;
		}
		if(seqlist.size==MAX){
			System.out.println("数组已满");
			return false;
		}
		for(int i=seqlist.size-1;i>location;i--){//移动元素，将插入位置腾出来
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
			System.out.println("位置越界");
		}
		if(seqlist.size==0){
			System.out.println("数组已空");
		}
		delNum=seqlist.nums[location];//先将要删除的数取出来
		for(int i=location+1;i<=seqlist.size;i++){///移动元素，覆盖原来的位置
			seqlist.nums[i-1]=seqlist.nums[i];
		}
		seqlist.size--;
		return delNum;
	}
	/**
	 * 给定索引，返回特定值
	 * @param seqlist
	 * @param location
	 * @return
	 */
	public int getElement(seqlist seqlist,int location){
		if(location<0 || location>MAX ){
			System.out.println("位置越界");
		}
		if(seqlist.size==0){
			System.out.println("已空，没有元素可以取");
		}
		return seqlist.nums[location];
	} 
	/**
	 * 返回线性表的长度
	 * @param seqlist
	 * @return
	 */
	public int getSize(seqlist seqlist){
		
		return seqlist.size;
	}
	/**
	 * 根据给定的元素，进行删除的过程
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
		if(!flag){//如果执行到这，说明没有找到元素
			return false;
		}
		return true ;
	}
	/**
	 * 将顺序表中相同的元素全部删除掉
	 * 因为没找到一个相同的元素就删除一次，是非常低效的，所以每找到一个相同的元素就用最后面的元素来覆盖
	 * 将序列末尾的元素填写在相同元素的地方
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
			System.out.println("未找到相等元素");
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//测试插入
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

		//测试删除
		System.out.println("数组大小："+s.size);
		int delNum=0;
		int r=cluss.delete(s, 3, delNum);
		System.out.println("r="+r);
		
		for(int K:s.nums){
			System.out.print(K+" ");
		}
		System.out.println("数组大小："+s.size);
		//测试取元素函数
		int r1= cluss.getElement(s, 3);
		System.out.println("取出的第三个元素："+r1);
		//返回序列的当前长度
		int r2=cluss.getSize(s);
		System.out.println("size:"+r2);
		//删除特定的元素
		boolean r3=cluss.deleteSpeciElement(s, 23);
		System.out.println("deleteSpeciElement:"+r3);
		for(int K:s.nums){
			System.out.print(K+" ");
		}
		System.out.println();
		//测试删除所有相同元素
		boolean r4=cluss.deleteSameElement(s, 22);
		System.out.println(r4);
		for(int K:s.nums){
			System.out.print(K+" ");
		}
		System.out.println();
	}

}
