package com.xjtu.play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={1,2,3,7,4,11};
		int value=9;
		int []r=twoSum(nums,value);
		System.out.println(r[0]+", "+r[1]);
		
		//3 sum
		int []num={-1,0,1,2,-1,-4};
		int v=0;
		List re=threeSum(num,v);
		for(int i=0;i<re.size();i++){
			System.out.println(re.get(i));
		}
	}
	/**
	 * ����������������������ʹ�����������ĺ��Ǹ�����sum��ÿ��Ԫ��ֻ��ʹ��һ�Σ�
	 * ֱ�ӷ���˫���forѭ��������ʱ�临�Ӷ�̫��o(n*n)��Ч�ʺܵ�
	 * ���ڲ��õ����������Ѱ�ҵķ�ʽ��ʱ�临�Ӷ�Ϊo[n*(log2(n)+1)]
	 * @param nums
	 * @param sum
	 * @return
	 */
	public static int []twoSum(int []nums,int sum){
		Arrays.sort(nums);
		int left=0,right=nums.length-1;
		while(left<right){
			if(nums[left]+nums[right]==sum){
				return new int[]{nums[left],nums[right]};
			}else if(nums[left]+nums[right]<sum){
				left++;
			}else if(nums[left]+nums[right]>sum){
				right--;
			}
		}
		return new int[]{nums[left],nums[right]};
	}
	/**
	 * ������Ԫ�صĺ͵�����
	 * �����е�û�д��������ظ����Σ�Ҳ����˵��[-1, 0, 1],[0, 1, -1]��Ϊ��һ�����Σ���Ȼ���ǵ�����������ͬ������
	 * �����һ���ģ�������Ҫ���ľ���ֱ���ں���һ����˽�������ͬԪ�ص���Ϲ��˵���
	 * @param nums
	 * @param value
	 * @return
	 */
	public static List threeSum(int []nums,int value){
		List <List> result=new ArrayList<List>();
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1]){//�����Ҫ���ų���ͬ������
				continue;
			}
			for(int j=i+1;j<nums.length-1;j++){
				if(j>i+1 && nums[j]==nums[j-1]){
					continue;
				}
				for(int k=j+1;k<nums.length;k++){
					if(k>j+1 && nums[k]==nums[k-1]){
						continue;
					}
					if(nums[i]+nums[j]+nums[k]==value){
						List inner=new ArrayList<Integer>();
						inner.add(nums[i]);
						inner.add(nums[j]);
						inner.add(nums[k]);
						result.add(inner);
					}
				}
			}
		}
		return result;
	}
}
