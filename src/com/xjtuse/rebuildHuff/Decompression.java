package com.xjtuse.rebuildHuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * �Ե�ǰ�ı����н�ѹ����ѹ����һ��Ҫ��֤��ȷ�ԣ�����ѹ���ͽ�ѹ���ǿջ�����Ϊ��ȷ��̫�ͣ��������޷�ʹ��
 * @author 22847
 */
public class Decompression {
	/**
	 * ��ѹ������ͨ���Ѿ������õ�huffman�������н�ѹ��ע����ڵ��ǽڵ���������һ����
	 * @param node
	 * @param inFilePath
	 */
	public static void decompression(HuffNode []node,String inFilePath,String outFilePath){
		String line="";
		try {
			//����ѹ���ļ�
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFilePath))));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFilePath))));
			String tmp="";//���������Ҫ��Ϊ�˲�׽�������Ĺ��������û������ı��룬��Ҫ���ⲿ�ֵı��������ı����������
			while((line=bf.readLine())!=null){//����һ��
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<line.length();i++){//�������ı�ת��Ϊ�����ƴ�
					char ch=line.charAt(i);
					String huff=decToBinary(ch);
					sb.append(huff);//�����е��ı�ת��Ϊ�˶����ƴ�����ʽ
				}
				//Ϊ�˷�ֹ�����������һ��ת������֮���ֱ�Ӹ��ݱ���õ���Ӧ���ַ�
				HuffNode root=node[node.length-1];
//				System.out.println("huffman��ѹ���룺"+tmp+sb.toString());
				System.out.println();
				int i=0;
				String connected=tmp+sb.toString();//����ǰ�ı�������һ���ı������
				
				tmp="";//����Ϊ�˱�֤�����tmp��������Ӱ��
				while(i<connected.length()){
					if(root.leftChild!=-1 && root.rightChild!=-1){
						if(connected.charAt(i)=='0'){
							tmp=tmp+'0';
							root=node[root.leftChild];
						}else if(connected.charAt(i)=='1'){
							root=node[root.rightChild];
							tmp=tmp+'1';
						}
					}else{
						System.out.print(root.value);
						bw.write(root.value);
						bw.flush();
						root=node[node.length-1];//���´Ӹ��ڵ㿪ʼ
						i--;	//������Ҫ����Ϊ����һ������û�н��б���Ӧ�ý�i�����һλ
						tmp="";
					}
					i++;
				}
				System.out.println("���ʣ�µı��룺��"+tmp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݶ�����ַ�ֵ���ַ�ת��Ϊ�����ƴ��������Ȳ�������λ
	 * @param ascii
	 * @return
	 */
	public static String decToBinary(int ascii){
		String result="";
		int yu=0;
		while(ascii!=0){
			yu=ascii%2;
			result=yu+result;
			ascii/=2;
		}
		/**
		 * ΪʲôҪ���в�λ��
		 * ԭ��ܼ򵥣���Ϊ��ѹ����ʱ���ǽ����еı������ƴ�ӳ�8λ��Ҳ���ǳ������λ��0���⣬
		 * ���඼����Ч�����֣�����0�������ڶ�����ʱ��ֱ���ҵ��˸ñ����ascii��Ȼ��ת��Ϊ
		 * �����ƣ�����ת��������ܻᶪ��ǰ�����õ�0Ԫ�أ������ڽ�ѹ����ʱ�������в�λ����ʧ
		 * ��0Ԫ�ز�����
		 */
		String mend="00000000";
		if(result.length()<7){//���������Ϊ7λ���ڽ��з���
			result=mend.subSequence(0,7-result.length())+result;
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		String outFilePath="D:/Temp/eclipseTemp/compression.txt";
		String inFile="D:/Temp/eclipseTemp/compression.txt";
		String outFilePath1="D:/Temp/eclipseTemp/newDecompression.txt";
		Scanning scan=new Scanning();
		Extract extract=new Extract();
		Initiation init=new Initiation();
		Encoding encode=new Encoding();
		Compression com=new Compression();
		List r1=extract.extractInfor(scan.scanning(filePath));
		HuffNode []nodes=init.initHuffTree(r1);
		HuffNode []node=init.treeBuilding(nodes);
		Code[] code=encode.encoding(node);
		com.compression(code,filePath,outFilePath);
		decompression(node,inFile,outFilePath1);
	}

}
