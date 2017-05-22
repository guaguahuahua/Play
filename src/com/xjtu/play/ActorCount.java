package com.xjtu.play;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ActorCount {

	/**
	 * ͳ�����Ժ�Ů����Ա�и��������ȶ���ߵ���Ա
	 */
	public static void count(){
		
		String path="D:/Temp/eclipseTemp/actor.txt";
		String hotF="";
		String hotM="";
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			String line="";
			while((line=bf.readLine())!=null){
				String []infor=line.split("\\s+");//0������		1���Ա�		2:������Ŀ				
				if(infor[1].equals("female")){//�����Ů�ԣ���ô�͵�ǰ����ֵ���бȽ�
					String []female=hotF.split("\\s+");
					if(hotF.equals("")){
						hotF=line;
					}else{
						if(Integer.parseInt(female[2])<Integer.parseInt(infor[2])){
							hotF=line;
						}
					}
				}else{//��������ԣ���ô��Ҫ�����Ե�ǰ�����ֵ���бȽ�
					String []male=line.split("\\s+");
					if(hotM.equals("")){
						hotM=line;
					}else{
						if(Integer.parseInt(male[2])<Integer.parseInt(infor[2])){
							hotM=line;
						}
					}

				}
			}
			bf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hotF);
		System.out.println(hotM);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count();
	}

}
