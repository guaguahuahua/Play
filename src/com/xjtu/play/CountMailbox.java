package com.xjtu.play;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountMailbox {

	public static void countMailbox(){
		String path="D:/Temp/eclipseTemp/mail.txt";
		List<String> result=new ArrayList<String>();
		try {
			FileReader reader=new FileReader(path);
			BufferedReader bf=new BufferedReader(reader);//�ļ�����֮�������Ƿ��ڻ������ġ�
			String line="";
			//�����������ļ�����
			while((line=bf.readLine())!=null){
				///�������ַ�����и����ȡ����������
				int index=line.indexOf('@');
				line=line.substring(index+1);
				index=line.indexOf('.');
				line=line.substring(0, index);
				
				if(result.size()==0){
					result.add(line);
					continue;
				}else{
					if(result.contains(line)){//��������˸���������ô ����
						continue;
					}else{//���֮ǰû�и�������ֱ�����
						result.add(line);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String K:result){
			System.out.println(K);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countMailbox();
	}

}
