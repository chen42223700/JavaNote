package JavaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DirList {

	public static void main(String[] args) {
		//获取当前路径
		File path = new File(".");
		String[] list;
		System.out.println(path.getAbsolutePath());
		if (args.length == 0) {
			//File.list()：获取当前文件集下的所有对象（文件或文件夹）
			list = path.list();
		}else {
			//当我们想获取一个受限列表（如，想获得所有扩展名为.java的文件）
			//那我们就要用到File.list(args)
			//当我们调用File。list(FilenameFilter filter) 方法
			//会自动调用FilenameFilter。accept()方法
			list = path.list(new DirFilter(args[0]));
			
		}
		
		//将list按字母顺序排序
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String diritem : list) {
			System.out.println(diritem);
		}
	}
}



