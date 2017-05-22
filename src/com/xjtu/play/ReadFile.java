package com.xjtu.play;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadFile {

	public static void myReadFile(){
		String path="D:/Temp/eclipseTemp/job.txt";
		List<String> tmp=new ArrayList<String>();
		try {
			FileReader reader=new FileReader(path);
			BufferedReader bf=new BufferedReader(reader);
			String line="";
			while((line=bf.readLine())!=null){
				tmp.add(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ڵõ������� ��������    3-5�꾭��   15-30k ���������зָ�������鲢
		Map <String,String>map=new HashMap<String,String>();
		for(int i=0;i<tmp.size();i++){
			
			String []job=tmp.get(i).split("\\s+");//�õ���3-5�꾭��   15-30k
			if(map.size()==0){//��mapΪ�յ�ʱ��ֱ��д��
				map.put(job[1], job[2]);
				continue;
			}
			boolean t_pan=map.get(job[1])==null ? false : true;
			if(!t_pan){//���û�и����ôֱ�Ӵ洢��map�����У�����У���ô��value�����½�����޸�
				map.put(job[1], job[2]);
			}else{
				String salary=map.get(job[1]);//ȡ��֮ǰ�洢��value��Ҳ���ǹ��ʵķ�Χֵ����Щ����
				salary=salary.substring(0, salary.length()-1);//����Ϊ���������� �ַ���k��
				String []pre=salary.split("\\-");//���֮ǰ�Ĺ��ʷ�Χֵ
				
				salary=job[2].substring(0, job[2].length()-1);//����Ϊ���������� �ַ���k��
				String []present=salary.split("\\-");//�Ĺ��ʷ�Χֵ
				
				if(Integer.parseInt(present[0])<Integer.parseInt(pre[0])){//������ڱȵ�ǰ�������߻�ҪС�ģ���ô����һ��
					pre[0]=present[0];
				}
				if(Integer.parseInt(present[1])>Integer.parseInt(pre[1])){//�����ڱȵ�ǰ�������޻�Ҫ�ߵģ�ҲҪ����һ��
					pre[1]=present[1];
				}
				map.put(job[1],pre[0]+"-"+pre[1]+"k");
			}
		}
		
		Set key=map.keySet();
		Iterator it=key.iterator();
		while(it.hasNext()){
			String year=(String) it.next();
			String sal=map.get(year);
			System.out.println(year+"   "+sal);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myReadFile();
	}

}
