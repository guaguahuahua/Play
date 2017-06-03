package com.xjtu.play;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.xjtu.structure.Code;
import com.xjtu.structure.HuffNode;

public class CountNum {
	public static StringBuilder sb=new StringBuilder();
	public List count(){
		//�����ļ�
		String path="D:/Temp/eclipseTemp/huffman.txt";
		File file=new File(path);
//		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String line="";
			while((line=bf.readLine())!=null){
				sb.append(line);
			}
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb);
		//���ļ���ͳ�Ƹ����ַ��ĳ���Ƶ�ʣ�ʹ�ù�ϣ��ķ�ʽ
		int [][]table=new int[128][2];//�����ֵ��ַ���������ʽ��ʾ������ʹ�õ�ʱ��ת��Ϊchar����
		
		for(int i=0;i<sb.length();i++){//ͳ�����е�Ԫ��,����Ҫͳ������ʹ�ù���Ԫ����������������ĳ���
			++table[sb.charAt(i)][1];//���ʹ����128*2�����飬ǰ�����ű�ʾ�ַ����ǵ�ASCII�룬�����ʾ���ַ����ֵĴ���
		}
		int length=0;
		for(int i=0;i<128;i++){//ͳ�ƹ�ϣ����ʹ�ù��ַ��ĸ���
			if(table[i][1]!=0){
				length++;
			}
		}
		System.out.println("length="+length);
		//����length�õ�����ֵ������������һ��ȷ��������Ȩֵ��
		int []weight=new int[length];
		char[]word=new char[length];
		for(int i=0,j=0;i<table.length;i++){
			if(table[i][1]!=0){
				word[j]=(char)i;//����ַ�
				weight[j++]=table[i][1];//���Ȩֵ
			}
		}
		List result=new ArrayList();
		result.add(word);
		result.add(weight);		
/*		//test para:success
		for(int i=0;i<word.length;i++){
			System.out.println(word[i]+"\t"+weight[i]);
			
		}
		
		//test para
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[i].length;j++){
				System.out.print(table[i][j]);
			}
			System.out.println();
		}*/
		return result;
	}
	/**
	 * �������ƵĴ�ת��Ϊʮ���Ƶ�ASCII��Ȼ���ţ���Ϊ����һ����8λ��ʹ�õ�ֻ��7λ
	 * ���λλ0�����Դ��ݲ�����ʱ��Ӧ��ע�����7λ�����ǵ�һ���Զ���0
	 * @param s
	 * @return
	 */
	public static int binaryToDec(String s){
		int sum=0;
		for(int i=1;i<s.length();i++){
			sum+=(s.charAt(i)-'0')*Math.pow(2,s.length()-1-i);
		}
		return sum;
	}
	/**
	 *����ԭ����ASCII�ַ�������huffman������ʽת�����������д���ı� 
	 */
	public static void writeFile(char []word,Code[] code){
		String writePath="D:/Temp/eclipseTemp/write.txt"; 	
		File file=new File(writePath);
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<sb.length();i++){//���е�ASCII�ַ�ȫ������������Ҫ��������
			
			for(int j=0;j<word.length;j++){//��Ե�ǰ�ַ����������������ַ�
				if(sb.charAt(i)==word[j]){//�����ǰ���ַ��ͽ����ַ�һ�£���ô�����ַ���Ӧ��huffman������д����
					for(int k=code[j].start;k<code[j].MaxN;k++){//�õ�huffman���������ַ����������
						builder.append(code[j].bit[k]);
					}
					break;
				}
			}
		}
		//��Ҫ����������������ַ��������⴦������8λ����󲻻��������
		System.out.println("�ַ���huffman������ʽ��"+builder.toString());
		try {
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			String tmp="0";//�����Ϊ�������һ��0����Ҫ��Ϊ�˲���8��λ��
			int count=1;
			for(int i=0;i<builder.length();i++){//�������ɵ�ASCII��ȫ����builder�д�ţ����ڿ�ʼÿ8λ����ASCII�벡д�뵽����ļ���
				if(count%8==0){//����������7λ�ַ�
					System.out.println("���һ���ü����ı��룺"+tmp);
					int r=binaryToDec(tmp);
					System.out.println("��������ת��ΪACSCII:"+(char)r);
					bw.write((char)r);//������ת��ΪASCCII����ַ���ʽ���뵽�ļ���
					bw.flush();
					tmp="0";//��λ
					count=1;
					--i;
				}else{
					tmp=tmp+builder.charAt(i);
					++count;
				}
			}
			//�������һ��Ԫ�أ���Ϊ���һ��Ԫ�غ��п�������Ϊ����8λ�����޷������������Ҫ���ľ��ǽ��в�λ��������
			//������8λ֮���ٴν������
			String zero="00000000";
			tmp=zero.substring(0,8-tmp.length())+tmp;//�ü�0Ԫ��������tmp
			int r=binaryToDec(tmp);
			System.out.println("��������ת��ΪACSCII:"+(char)r);
			bw.write((char)r);//������ת��ΪASCCII����ַ���ʽ���뵽�ļ���
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��ѹ�����ļ����л�ԭ
	 */
	public static void decompression(HuffNode[] treenode){
		String path="D:/Temp/eclipseTemp/write.txt";
		File file=new File(path);
		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line="";
			while((line=bf.readLine())!=null){//��ѹ���ļ������е��ַ�ȫ�����
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��ѹ���ļ���");
		System.out.println(sb.toString());
		

		//���������ַ�һ��һ����ת��������Ҳ��ܸ��ӣ�����Ҫ���ľ��ǣ������е��ַ�ȫ��ת��Ϊ�����ƴ���Ȼ��������ƴ��ָ����ַ�
		StringBuilder binString=new StringBuilder();
		for(int i=0;i<sb.length();i++){
			String tmp=decToBinary(sb.charAt(i));
			binString.append(tmp);
		}
		System.out.println("�����ƴ���"+binString);
		//������Ķ����ƴ�������huffman�����л�ԭ��Ҳ����˵��
		int i=0;
		HuffNode test=new HuffNode();//�����ñ���
		StringBuilder rewrite=new StringBuilder();
		while(i<binString.length()){
			HuffNode traverse=treenode[treenode.length-1];//��ȡ�����ڵ�
			while(i<binString.length() && traverse.leftChild!=-1 && traverse.rightChild!=-1){//���������ڵ�����
				if(binString.charAt(i++)=='1'){
					traverse=treenode[traverse.rightChild];
				}else{
					traverse=treenode[traverse.leftChild];
				}
				test=traverse;
			}
			rewrite.append(test.value);			
//			System.out.print(test.value);//�ǳ����죬�������ڲ���������⣬�����ǰ����ˣ���ô�ļ����޷�д�롣			
		}
		//���ļ�д�뵽�ı��ĵ���
		String filepath="D:/Temp/eclipseTemp/decompression.txt";
		File filename=new File(filepath);
		try {
			BufferedWriter dec=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
			dec.write(rewrite.toString());
			dec.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("rewrite:"+rewrite.toString());
		System.out.println();
	}
	/**
	 * ��ʮ������ת��Ϊ�����ƴ�����ʽ
	 * @param num
	 * @return
	 */
	public static String decToBinary(int num){
		String result="";
		while(num!=0){
			int tmp=num%2;
			result=tmp+result;
			num/=2;
		}
		String zero="00000000";
		if(result.length()<7){
			result=zero.substring(0,7-result.length())+result;//��������λ�����в��㣬��ֹ��ʧ0Ԫ�أ���Ϊ��huffman������0�Ǳ�Ҫ��
		}
		System.out.println("ʮ����ת��Ϊ�����ƴ���"+result);		
		return result;
	}
}
