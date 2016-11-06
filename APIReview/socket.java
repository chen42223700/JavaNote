package test.student_cxc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class socket {
	
	public static void main(String[] args) throws IOException {
		
		Socket socket = null;
		BufferedReader br =null;
		//path:����·������ʽ���ޣ�
		String path = "D:\\mylog.txt";
		//IP:Ҫ���͵�IP��ַ
		String IP = "255.255.255.1";
		//port:Ҫ���͵Ķ˿�
		int port = 8080;
		//charset:Ҫ���͵��ַ�������
		String charset = "utf-8"; 
		PrintWriter pw =null;
		
		
		try {
			socket = new Socket(IP,port);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"gbk"));
			pw = new PrintWriter(socket.getOutputStream());
			
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				//���ַ�����gbk��ʽ����
				byte[] b = msg.getBytes("gbk");
				//���ֽ���"utf-8"��ʽ����
				String str_utf8 = new String(b,charset);
				
				//�ѱ������ַ�������file��
				pw.println(str_utf8);
	
			}
			
			pw.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (socket != null) {
				socket.close();
			}
			
			if (br != null) {
				br.close();
			}
		}
	}
}
