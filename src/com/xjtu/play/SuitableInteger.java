package com.xjtu.play;

public class SuitableInteger {

	/**
	 * ����һ��������n������һ����С�������� mʹ��n*m�����ս����ֻ����0����1
	 * ����m�Ǵ�1��ʼһֱ�ۼӣ����������_wrong�����������������
	 * @param num
	 * @return
	 */
	public static int suitableInteger_wrong(int num){
		
		int pre=Integer.MAX_VALUE;
		for(int m=num;m>1;m--){
			int tmp=num*m;
			String t=tmp+"";
			boolean flag=true;
			for(int i=0;i<t.length();i++){
				if(t.charAt(i)=='1' || t.charAt(i)=='0'){
					continue;
				}else{
					flag=false;
					break;
				}
			}
			if(flag){
				pre=m>pre?pre:m;
			}else{
				continue;
			}
		}
		System.out.println(pre);
		return pre;
	}
	
	/**
	 * �㷨ȱ�㣬��������n�Ƚϴ��ʱ����ô�ͻ��������Ϊʹ���˳˷����㣬��������λ���׶ξͻᷢ�����
	 * ���У�ʹ�����ַ�����ת����Ч�ʻή��
	 * @param num
	 * @return
	 */
	public static int suitableInteger_String(int num){
		
		for(int m=2;;m++){
			boolean flag=true;
			String t=num*m+"";
			for(int i=0;i<t.length();i++){
				if(!(t.charAt(i)=='1' || t.charAt(i)=='0')){
					flag=false;
					break;
				}else{
					continue;
				}
			}
			if(flag){
				return m;
			}else{
				continue;
			}
		}
	}
	
	public static int suitableInteger(int num){
		
		for(int m=2;;m++){
			long tmp=m*num;
			boolean flag=true;
			while(tmp!=0){//�жϳ˻��ǲ�����01����
				long locate=tmp % 10;
				if(!(locate==1 || locate==0)){//����õ��ĸ�λ�Ȳ���0Ҳ����1����ôֱ���˳��������жϺ����λ��
					flag=false;
					break;
				}
				tmp/=10;
			}
			if(flag){
				return m;
			}else{
				continue;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		int r=suitableInteger(n);
		System.out.println(r);
	}
}
