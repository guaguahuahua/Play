package com.leetcode;

public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0 || matrix[0].length==0){
    		return false;
    	}
    	int i=0;
		int last=matrix[i].length-1;//ȡ�����е����һ��Ԫ��
		while(i<matrix.length && target>matrix[i][last]){//һֱ�Ƚϣ�ֱ���ҵ���target���ڵ���Ϊֹ
			i++;
		}
		if(i>=matrix.length){//������±��Ѿ�Խ���ˣ���ôֱ�ӷ���false
			return false;
		}else{//������±�û��Խ�磬��ô�����ҵ���λ�ã���Ҫ���ľ����������е�����
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
		System.out.println("���ҵĽ���ǣ�"+result);
	}

}
