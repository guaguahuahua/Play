package com.xjtu.play;

public class HeapSort {

	/**
	 * 堆排序
	 * @param nums
	 */
	public static void heapSort(int []nums){
		init(nums);//大顶堆初始化
		for(int i=0;i<nums.length;i++){
			int tmp=nums[0];
			nums[0]=nums[nums.length-1-i];//将排好序的堆的最后一个元素和最大堆顶元素进行交换
			nums[nums.length-1-i]=tmp;
			createHeap(nums,0,nums.length-i-1);	//这块给的参数是0，原因是只有堆顶出现变化，所以只要从堆顶进行一一修正即可
		}
//		System.out.println("排序之后：");
//		show(nums);
	}
	/**
	 * 创建大顶堆，
	 * @param nums 元素数组
	 * @param position 调整的叶节点的位置。从position位置的非叶节点开始,一般的都是传递过来最小的一个非叶节点的索引
	 * @param 之所以使用长度参数主要是为了后面的堆排序最准备，因为如果进行堆排序，那么每次取大顶堆的首元素和最后的元素进行交换，
	 * 从而导致堆的长度减1，需要重建堆的时候，不能再将最后一个元素添加在其中了，所以引入长度参数保证后面排好序的元素不受影响
	 */
	public static void createHeap(int []nums,int position,int length){
		int len=length;
		int j=2*position+1;
		int tmp=nums[position];
		
		while(j<len){
			if(j+1<len && nums[j]<nums[j+1]){//主要是为了将索引指向较大的元素
				j++;
			}
			if(nums[position]>=nums[j]){
				break;
			}else{
				nums[position]=nums[j];
				nums[j]=tmp;
				position=j;		//i索引下移到j位置，这块其实已经是包含了对子树继续调整的过程
				j=2*position+1; //j索引到自己的孩子位置
			}
		}
	}
	/**
	 * 堆数组进行堆初始化
	 * @param nums 数组元素
	 */
	public static void init(int []nums){
		//初始化的过程是从第一个非叶节点到根节点的，而且在创建堆的过程中已经包含了调整的过程
		for(int i=(nums.length-1)/2;i>=0;i--){
			createHeap(nums,i,nums.length);
		}
//		show(nums);
	}
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={64,34,25,87,12,38,56,46,14,77,92,23};
//		int []nums={10,50,32,5,76,9,40,88};
//		init(nums);
		heapSort(nums);
	}

}
