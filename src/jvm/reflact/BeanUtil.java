package jvm.reflact;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Bean工具类,实现不同类型对象的属性复制
 */
public class BeanUtil {
	/**
	 * 属性复制
	 * 
	 * @param src
	 *            源类型对象
	 * @param dest
	 *            目标对象
	 */
	public static void copyProperties(Object src, Object dest) {
		//
		if (src == null || dest == null) {
			return;

		}
		try {
			// 源对象信息
			BeanInfo srcBi = Introspector.getBeanInfo(src.getClass());
			// 源对象属性描述符
			PropertyDescriptor[] srcPDS = srcBi.getPropertyDescriptors();

			for (PropertyDescriptor pd : srcPDS) {
				Method getter = pd.getReadMethod();
				Object value = getter.invoke(src);

			}

		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	// public static PropertyDesriptor[] getPds(Object obj) {
	// return Instro
	// }
}
