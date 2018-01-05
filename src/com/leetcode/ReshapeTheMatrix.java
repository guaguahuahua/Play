package com.leetcode;

public class ReshapeTheMatrix {

	/**
	 * 改变矩阵的形状，将元数据以行遍历的形式存放到新矩阵中，如果无法改变形状，那么直接返回原矩阵
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length){ //如果改变形状之后元素个数不相同，直接返回原矩阵
        	return nums;
        }
        int i=0,j=0;
    	int [][]res=new int[r][c];
    	for(int row=0;row<nums.length;row++){ //遍历原矩阵将其中的数据提取到新的矩阵中
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
