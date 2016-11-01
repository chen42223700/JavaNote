package memoryManage;

/**
 * 
 * @author Lenovo
 * 此类是nativeMethod的几个实例
 * 相关知识待补充
 */
public class nativeMethod {
	//TODO introduce about nativeMethod  
	native public void Native1(int x);
	native static public long Native2();
	native synchronized private float Native3(Object o);
	native void Native4(int[] ary) throws Exception;
}
