package com.android.inputmethod.pinyin;

import java.lang.reflect.Method;

/**
 * Created by benny at 2023/2/28 14:15.
 */
class SystemPropertiesUtils {

    private static final Method get;

    static {
        Method method;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            method = cls.getMethod("get", String.class);
            method.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
            method = null;
        }
        get = method;
    }

    public static String get(String key) {
        if (get == null) {
            return null;
        } else {
            try {
                return (String) get.invoke(null, key);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
