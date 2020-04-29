package com.dcs.balaji.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcs.access.constant.CommonConstant;
import com.dcs.access.model.UserDto;

/**
 * 
 * @author deepakdubey
 * @since 26 December 2019
 * @version 1.0
 */
public final class DCSTaxUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(DCSTaxUtil.class);

	private DCSTaxUtil() {
	}

	/**
	 * This method is added by Deepak Dubey on 22 July 2019, to trim a String value
	 * even it null to secure NullPointerException. Use this utility in your
	 * conditions to replace exception probabilities.
	 **/
	public static String trimString(String arg) {
		if (arg != null)
			return arg.trim();
		else
			return "";
	}

	/**
	 * 
	 * @param <T>
	 * @param cls    {@link Class}
	 * @param values {@link Object}
	 * @return T {@code Returns T instance with given types and values.}
	 *         <ul>
	 *         <li>Note: values are those values, accepts in constructor.</li>
	 *         </ul>
	 */
	public static <T> T getInstance(Class<T> cls, final Object... VALUES) {
		T instance = null;
		if (cls != null) {
			try {
				Constructor<T> constructor = cls.getConstructor(getClassTypes(VALUES));
				instance = (T) constructor.newInstance(VALUES);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return instance;
	}

	/**
	 * @since 14 August 2019
	 * @param VALUES {@link Object}
	 * @return {@link Class} {@code returns the class types of given values}
	 */
	public static Class<?>[] getClassTypes(Object[] VALUES) {
		Class<?>[] classTypes = null;
		if (VALUES != null) {
			classTypes = new Class[VALUES.length];
			for (int i = 0; i < VALUES.length; i++) {
				classTypes[i] = VALUES[i] != null ? VALUES[i].getClass() : null;
			}
		}
		return classTypes;
	}

	/**
	 * 
	 * @param OBJ
	 * @param FIELD_NAME
	 * @return true if FIELD_NAME is available else false
	 */
	public static boolean isField(final Object OBJ, final String FIELD_NAME) {
		boolean flag = true;
		Field field = null;
		try {
			field = OBJ.getClass().getDeclaredField(FIELD_NAME);
			if (field == null)
				flag = false;
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	/**
	 * 
	 * @param cls
	 * @param FIELD_NAME
	 * @return
	 */
	public static boolean isField(Class<?> cls, final String FIELD_NAME) {
		boolean flag = true;
		Field field = null;
		try {
			field = cls.getDeclaredField(FIELD_NAME);
			if (field == null)
				flag = false;
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	/**
	 * 
	 * @param cls
	 * @param PROPERTY
	 * @param root
	 * @return
	 *         <h1>This method is used to get root path to apply sorting</h1>
	 */
	public static Path<Object> getRootPath(Class<?> cls, final String PROPERTY, Root<?> root) {
		Path<Object> path = null;
		Field field = null;
		if (PROPERTY != null) {
			try {
				field = cls.getDeclaredField(PROPERTY);
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (field != null) {
				Type type = field.getType();
				String typeName = type.getTypeName();
				if (typeName != null) {
					if (typeName.startsWith("com.ecom.mdm")) {
						Field field1 = null;
						try {
							field1 = Class.forName(type.getTypeName()).getDeclaredField("id");
						} catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (field1 != null) {
							path = root.get(PROPERTY).get("id");
						} else {
							path = root.get(PROPERTY);
						}
					} else {
						path = root.get(PROPERTY);
					}
				} else {
					path = root.get(PROPERTY);
				}
			}
		}
		return path;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static UserDto getUser(HttpServletRequest request) {
		return (UserDto) request.getAttribute(CommonConstant.Attributes.USER);
	}

}
