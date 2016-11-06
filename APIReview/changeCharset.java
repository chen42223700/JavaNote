package test.student_cxc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class changeCharset {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader br_gbk = null;
		InputStream is = null;
		PrintWriter pw = null;
		int port = 8080;
		
		try {
	
			//�����յ���Ϣ��GBK��ʽ����
			br_gbk = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("D:\\sql�ʼ�.txt"),"gbk"));
			
			String file = "";
			
			//ѭ����ȡ���յ���Ϣ������file��
			while (true) {
				String str_gbk = br_gbk.readLine();
				//���������һ�У�����ѭ��
				if (str_gbk == null) {
					break;
				}
				
				
				//���ַ�����gbk��ʽ����
				byte[] b = str_gbk.getBytes("gbk");
				//���ֽ���"utf-8"��ʽ����
				String str_utf8 = new String(b,"utf-8");
				
				//�ѱ������ַ�������file��
				file += str_utf8;
				
			}
			
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream("D:\\changeCharset.txt"),"utf-8"));
			
			pw.println(file);
			
			//��fileתΪInputStream��
//			is = new ByteArrayInputStream(file.getBytes("utf-8"));		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			br_gbk.close();
//			is.close();
			pw.close();
		}
	}
}
