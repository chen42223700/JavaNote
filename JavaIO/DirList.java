package JavaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DirList {

	public static void main(String[] args) {
		//��ȡ��ǰ·��
		File path = new File(".");
		String[] list;
		System.out.println(path.getAbsolutePath());
		if (args.length == 0) {
			//File.list()����ȡ��ǰ�ļ����µ����ж����ļ����ļ��У�
			list = path.list();
		}else {
			//���������ȡһ�������б��磬����������չ��Ϊ.java���ļ���
			//�����Ǿ�Ҫ�õ�File.list(args)
			//�����ǵ���File��list(FilenameFilter filter) ����
			//���Զ�����FilenameFilter��accept()����
			list = path.list(new DirFilter(args[0]));
			
		}
		
		//��list����ĸ˳������
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String diritem : list) {
			System.out.println(diritem);
		}
	}
}



