
package jvm.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtil {

	/**
	 * 属性复制
	 */
	public static void copyProperties(Object src, Object dest) {
		if (src == null || dest == null) {
			return;
		}

		// 如果不为空
		try {
			// 源对象信息
			BeanInfo srcBI = Introspector.getBeanInfo(src.getClass());
			// 源对象属性描述符
			PropertyDescriptor[] srcPDS = srcBI.getPropertyDescriptors();

			for (PropertyDescriptor pd : srcPDS) {
				// 得到属性类型
				Class pType = pd.getPropertyType();
				String pName = pd.getName();

				Method getter = pd.getReadMethod(); // 源对象的get方法
				Object value = getter.invoke(src); // 通过源对象的get方法返回的值

				Method setter = getSetter(dest, pType, pName);
				if (setter != null) {
					setter.invoke(dest, value);
				}

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

	/**
	 * 得到obj的属性描述符集合
	 */
	public static PropertyDescriptor[] getPds(Object obj) {
		try {
			return Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到obj的指定type,name属性的set方法
	 */
	public static Method getSetter(Object obj, Class type, String name) {
		try {
			PropertyDescriptor[] pds = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				Class ptype = pd.getPropertyType();
				String pname = pd.getName();
				if (ptype == type && name.equals(pname)) {
					return pd.getWriteMethod();
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}
}