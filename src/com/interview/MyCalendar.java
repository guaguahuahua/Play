package com.interview;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

	//��Ҫ�����ֹʱ�䣬��ʼ���Ĺ��̾��ǳ�ʼ����ż��ϣ��жϹ��̾��ǲ��ϵıȶԺͼ����е�Ԫ���Ƿ��г�ͻ
//	private List<String> schedual;
	//���Ƚ϶�Ŀһ�£���Ϊ����list���������������ΪԪ�أ���������һЩ�������Ի��������������ζ��ǱȽϺõĽ������
	private List<int[]> schedual;
	
    public MyCalendar() {
        schedual=new ArrayList<int[]>();
    }
    
    /**
     * ��������㷨���ջᵼ�²��������������⣬�޷���ȫͨ��
     * @param start
     * @param end
     * @return
     */
/*    public boolean book_1(int start, int end) {
    	//�����ǰ�ļ���Ϊ�գ���ôֱ�ӽ���Ҫ��ӵ�Ԫ����ӵ������У�������Ϊtrue
    	if(schedual.size()==0){
    		schedual.add(start+" "+end);
    		return true;
    	//����Լ����е�Ԫ�ذ�������һ���ж�	
    	}else{
    		for(int i=0; i<schedual.size(); i++){
        		String temp=schedual.get(i);
        		String[]times=temp.split("\\s+");
        		int s=Integer.parseInt(times[0]);
        		int e=Integer.parseInt(times[1]);
        		if((s<=start && start<e) || (s<end && end<=e)){
        			return false;
        		}
        	}
    		//�жϵ��������̶�û���˳�˵���Ǻ���ģ���ӵ��ճ̱�������true
    		schedual.add(start+" "+end);
    		return true;
    	}    	        
    }*/
	
    public boolean book(int start, int end) {
    	//���������ǿյģ�ֱ�ӽ��ճ���ӽ�ȥ����return true
    	if(schedual.size()==0){
    		schedual.add(new int[]{start, end});
    		return true;

    	//����������Ϊ�գ���ô�����е�Ԫ�غ�Ҫ�½����ճ̽��бȽϣ��ȽϹ��������������ͻ����ô��ӽ��룬���򷵻�false	
    	}else{
    		for(int i=0; i<schedual.size(); i++){
    			int []time=schedual.get(i);
    			int s=time[0];
    			int e=time[1];
    			//����ͻ�����Σ�����ճ�û�����κ�֮��
    			if(end<=s || start>=e){
    				continue;
    			}
    			return false;
    		}
    		schedual.add(new int[]{start, end});
    		return true;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalendar obj=new MyCalendar();
		
		boolean res1=obj.book(47, 50);
		boolean res2=obj.book(33, 41);
		boolean res3=obj.book(39, 45);
		boolean res4=obj.book(33, 42);
		boolean res5=obj.book(25, 32);		
		boolean res6=obj.book(26, 35);
		boolean res7=obj.book(19, 25);
		boolean res8=obj.book(3, 8);
		boolean res9=obj.book(8, 13);
		boolean res10=obj.book(18, 27);
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
		System.out.println(res5);
		System.out.println(res6);
		System.out.println(res7);
		System.out.println(res8);
		System.out.println(res9);
		System.out.println(res10);
		
	}

}
