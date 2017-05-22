package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

public class Merger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []left= {1,4,6};
//		int []right={2,8,9};
		int []left= {2,1,3};
		int []right={3,2,9};
		merger(left,right);
	}
	/**
	 * �ϲ����������������ϲ��ɣ������ܼ����������
	 * ���ݽ�������������һ�����������߽磬һ����������ұ߽�
	 * �㷨ȱ�㣺��Ҫ����������Ѿ�������Ĳſ��ã��������������ģ���ô�㷨����Ч�ġ����Ҫʹ�ã���ô��Ҫ��ǰ��������
	 * @param left  
	 * @param right
	 */
	public static void merger(int []left,int []right){
		List result=new ArrayList();
		int l=left[0],r=right[0];
		for(int i=1;i<left.length;i++){
			if(left[i-1]<left[i] && right[i-1]>left[i]){        //��Ҫ��Ϊ��˵����ǰ�������߽�λ���ϸ������м�
				l=left[i-1];
				r=right[i];
			}else if(left[i-1]<right[i] && right[i]<right[i-1]){//����Ҫ��˵����ǰ������ұ߽�λ���ϸ�������
				l=left[i];
				r=right[i-1];
			}else{												//��Ҫ˵���˵�����������֮��û�н���
				result.add("["+l+","+r+"]");
			}
		}
		result.add("["+l+","+r+"]");//�����Ҫ��Ϊ�˽��ѭ������ʱ���ϲ���������
		//test para
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+"\t");
		}
	}

}
