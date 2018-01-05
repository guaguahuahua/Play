package com.leetcode;

public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0 || matrix[0].length==0){
    		return false;
    	}
    	int i=0;
		int last=matrix[i].length-1;//取出该行的最后一个元素
		while(i<matrix.length && target>matrix[i][last]){//一直比较，直到找到了target所在的行为止
			i++;
		}
		if(i>=matrix.length){//如果行下标已经越界了，那么直接返回false
			return false;
		}else{//如果行下标没有越界，那么就是找到了位置，所要做的就是搜索该行的数据
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==target){
					return true;
				}
			}
		}
		return false;   
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [][]matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int [][]matrix={{}};
		int target=55;
		boolean result=searchMatrix(matrix,target);
		System.out.println("查找的结果是："+result);
	}

}
