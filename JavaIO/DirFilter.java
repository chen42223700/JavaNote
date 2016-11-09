package JavaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 
 * @author Merengue c
 * 创造一个正则表达式  匹配符合条件的文件
 *
 */
public class DirFilter implements FilenameFilter {

	private Pattern pattern;
	public DirFilter(String regex) {
		//Pattern:正则表达式
		//Pattern.compile(String regex) 创建一个正则表达式
		pattern = Pattern.compile(regex);
	}
	
	/*
	 * 重写accept方法
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	public boolean accept(File dir, String name) {
		/*
		 * Pattern。matcher(String name) 返回一个Matcher对象
		 * Matcher。matches() 返回一个boolean对象
		 * 匹配成功是返回true
		 * 匹配失败是返回false
		 */
		return pattern.matcher(name).matches();
	}

}
