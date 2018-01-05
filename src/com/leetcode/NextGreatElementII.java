package com.leetcode;

public class NextGreatElementII {

	/**
	 * Ѱ����һ���ȵ�ǰԪ�ش��Ԫ�أ��������ҽ�������������У����û���ҵ���Ԫ�أ���ôֱ����Ϊ-1
	 * @param nums
	 * @return
	 */
    public static int[] nextGreaterElements1(int[] nums) {
        int []result=new int[nums.length];
    	for(int i=0;i<nums.length;i++){
    		int index=i;
    		boolean flag=false;
    		while(index<nums.length){
    			if(nums[i]<nums[index]){
    				flag=true;
    				break;
    			}
    			index++;
    		}
    		if(flag){//��˵��������Ѿ��ҵ������Ԫ��
    			result[i]=nums[index];
    			flag=false;
    		}else{//�����ڸ�Ԫ�ص����Ѱ��
    			index=0;
    			while(index<i){
    				if(nums[i]<nums[index]){
    					flag=true;
    					break;
    				}
    				index++;
    			}
    			if(flag){//˵��������ҵ������Ԫ��
    				result[i]=nums[index];
    				flag=false;
    			}else{
    				result[i]=-1;//��ʶΪû���ҵ�
    			}
    		}
    	}
        return result;
    }
    /**
     * ����leetcode�����ĸĽ��㷨���������Ҫ�����࣬�˼Ҳ��Ǳ�������ߺ��ұ����ַ��࣬����ʹ����ȡ���˼��
     * ��˳���ı��������������࣬ͬʱ�����˴󲿷ֵ��������
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
    	int []result=new int[nums.length];
    	for(int i=0;i<nums.length;i++){
    		boolean flag=false;
    		for(int j=0;j<nums.length;j++){
    			if(nums[(i+j)%nums.length]>nums[i]){
    				result[i]=nums[(i+j)%nums.length];
    				flag=true;
    				break;
    			}
    		}
    		if(!flag){
    			result[i]=-1;
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={1,2,1};
		int []nums={1,2,3,4};
//		int []nums={1,3,4,2};
		int []res=nextGreaterElements(nums);
		for(int K:res){
			System.out.print(K+", ");
		}
	}

}
