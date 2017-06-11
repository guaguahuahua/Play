package com.xjtuse.rebuildHuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����Ƕ��ı�ɨ����Ϣ��һ���Ĵ����ᴿ���Ժ�����ṩ���ı���ص���Ϣ
 * @author 22847
 */
public class Extract {
	/**
	 * ������ȡ�ı��ַ���Ϣ��
	 * @param hash
	 */
	public static List extractInfor(int []hash){

		//ʹ��map���й��ˣ��ı���ӵĹ���Ϊ��ascIIֵ�ͳ���Ƶ��
		Map <Character,Integer>map=new HashMap<Character,Integer>();
		for(int i=0;i<hash.length;i++){
			if(hash[i]!=0){	//���ַ����ı��г��ֹ�
				map.put((char)i,hash[i]);
			}
		}
		System.out.println();
		System.out.println("map size="+map.size());
		char []ch=new char[map.size()];
		int  []weight=new int[map.size()];
		
		//��map�н�Ԫ�ذ�����ȡ����
		Set key=map.keySet();
		Iterator it=key.iterator();
		int count=0;
		while(it.hasNext()){
			char tmp=(char) it.next();
			ch[count]=tmp;//���ַ�ȡ��
			weight[count++]=(int)map.get(tmp);//���ַ���Ƶ��ȡ����
		}

		//�������list��װ�÷��ظ��¸����÷���
		List result=new ArrayList();
		result.add(ch);
		result.add(weight);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		Scanning scan=new Scanning();
		extractInfor(scan.scanning(filePath));
	}

}
