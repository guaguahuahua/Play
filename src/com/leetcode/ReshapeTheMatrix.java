package com.leetcode;

public class ReshapeTheMatrix {

	/**
	 * �ı�������״����Ԫ�������б�������ʽ��ŵ��¾����У�����޷��ı���״����ôֱ�ӷ���ԭ����
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length){ //����ı���״֮��Ԫ�ظ�������ͬ��ֱ�ӷ���ԭ����
        	return nums;
        }
        int i=0,j=0;
    	int [][]res=new int[r][c];
    	for(int row=0;row<nums.length;row++){ //����ԭ�������е�������ȡ���µľ�����
    		for(int col=0;col<nums[0].length;col++){
    			if(j<c){
    				res[i][j++]=nums[row][col];
    			}else{
    				i++;
    				j=0;
    				res[i][j++]=nums[row][col];
    			}
    		}
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]nums={{1,2,3},{3,4,6}};
		int r=3,c=2;
		int[][]res=matrixReshape(nums,r,c);
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
}
