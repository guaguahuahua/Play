package com.xjtu.play;

public class HeapSort {

	/**
	 * ������
	 * @param nums
	 */
	public static void heapSort(int []nums){
		init(nums);//�󶥶ѳ�ʼ��
		for(int i=0;i<nums.length;i++){
			int tmp=nums[0];
			nums[0]=nums[nums.length-1-i];//���ź���Ķѵ����һ��Ԫ�غ����Ѷ�Ԫ�ؽ��н���
			nums[nums.length-1-i]=tmp;
			createHeap(nums,0,nums.length-i-1);	//�����Ĳ�����0��ԭ����ֻ�жѶ����ֱ仯������ֻҪ�ӶѶ�����һһ��������
		}
//		System.out.println("����֮��");
//		show(nums);
	}
	/**
	 * �����󶥶ѣ�
	 * @param nums Ԫ������
	 * @param position ������Ҷ�ڵ��λ�á���positionλ�õķ�Ҷ�ڵ㿪ʼ,һ��Ķ��Ǵ��ݹ�����С��һ����Ҷ�ڵ������
	 * @param ֮����ʹ�ó��Ȳ�����Ҫ��Ϊ�˺���Ķ�������׼������Ϊ������ж�������ôÿ��ȡ�󶥶ѵ���Ԫ�غ�����Ԫ�ؽ��н�����
	 * �Ӷ����¶ѵĳ��ȼ�1����Ҫ�ؽ��ѵ�ʱ�򣬲����ٽ����һ��Ԫ������������ˣ��������볤�Ȳ�����֤�����ź����Ԫ�ز���Ӱ��
	 */
	public static void createHeap(int []nums,int position,int length){
		int len=length;
		int j=2*position+1;
		int tmp=nums[position];
		
		while(j<len){
			if(j+1<len && nums[j]<nums[j+1]){//��Ҫ��Ϊ�˽�����ָ��ϴ��Ԫ��
				j++;
			}
			if(nums[position]>=nums[j]){
				break;
			}else{
				nums[position]=nums[j];
				nums[j]=tmp;
				position=j;		//i�������Ƶ�jλ�ã������ʵ�Ѿ��ǰ����˶��������������Ĺ���
				j=2*position+1; //j�������Լ��ĺ���λ��
			}
		}
	}
	/**
	 * ��������жѳ�ʼ��
	 * @param nums ����Ԫ��
	 */
	public static void init(int []nums){
		//��ʼ���Ĺ����Ǵӵ�һ����Ҷ�ڵ㵽���ڵ�ģ������ڴ����ѵĹ������Ѿ������˵����Ĺ���
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
