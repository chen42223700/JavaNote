package JavaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 
 * @author Merengue c
 * ����һ��������ʽ  ƥ������������ļ�
 *
 */
public class DirFilter implements FilenameFilter {

	private Pattern pattern;
	public DirFilter(String regex) {
		//Pattern:������ʽ
		//Pattern.compile(String regex) ����һ��������ʽ
		pattern = Pattern.compile(regex);
	}
	
	/*
	 * ��дaccept����
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	public boolean accept(File dir, String name) {
		/*
		 * Pattern��matcher(String name) ����һ��Matcher����
		 * Matcher��matches() ����һ��boolean����
		 * ƥ��ɹ��Ƿ���true
		 * ƥ��ʧ���Ƿ���false
		 */
		return pattern.matcher(name).matches();
	}

}
