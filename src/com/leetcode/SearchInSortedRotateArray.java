package com.leetcode;

public class SearchInSortedRotateArray {
	/**
	 * ����Ѱ���Ǹ��ָ�㣬Ȼ���ж�Ŀ��ֵ��ǰһ�λ��Ǻ�һ�Σ��ж���ǰһ�λ��Ǻ�һ��
	 * ��ôʹ�ö��ַ�
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int search(int[] nums, int target) {
    	int i;
    	for(i=1;i<nums.length;i++){
    		if(nums[i]<nums[i-1]){
    			break;
    		}
    	}
    	//�ҵ�����ת�㣬��ת����ߵĶ��ǱȽϴ�ģ��ұ߶��ǱȽ�С��
//    	System.out.println(i);
    	if(i<nums.length){//��˵������ת��
    		if(nums[i]==target){//�����ж���ת���ǲ���Ŀ��ֵ
    			return i;
    		}
    		if(nums[i]<target && nums[nums.length-1]>=target){//��ת���Ҳ࣬���ǱȽ�С�ģ����Ŀ�����Ҳ෶Χ��
    			return binSearch(nums,i,nums.length-1,target);
    		}
    		if(nums[i-1]>=target){//˵������ת�����࣬���Ҷ��ǱȽϴ��
    			return binSearch(nums,0,i-1,target);
    		}else{//Ŀ��ֵ������������ֵ�����ز�����
    			return -1;
    		}
    		
    	}else{//��˵��������û����ת�㣬����ֱ��ʹ�ö��ַ�������
    		return binSearch(nums,0,nums.length-1,target);
    	}
    }
    /**
     * ����ת���������ж��ֲ���
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binSearch(int []nums,int left,int right,int target){
    	
    	int mid=left+(right-left)/2;
    	while(left<=right){
    		if(nums[mid]==target){
    			return mid;
    		}else if(nums[mid]<target){
    			left=mid+1;
    		}else if(nums[mid]>target){
    			right=mid-1;
    		}
    		mid=left+(right-left)/2;
    	}
    	return -1;//����ɶ��û���ҵ�
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={4,5,6,7,0,1,2};
		int []nums={};
		int target=5;
		int r=search(nums,target);
		System.out.println("���ҽ����"+r);
		/*int []nums={0,1,2,4,5,6,7};
		int r=binSearch(nums,0,nums.length-1,3);
		System.out.println("���ҽ����"+r);*/
	}

}
