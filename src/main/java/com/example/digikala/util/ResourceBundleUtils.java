package com.example.digikala.util;

import java.util.ResourceBundle;

public class ResourceBundleUtils {
    public static String getExceptionMessage(String key) {
        return ResourceBundle.getBundle("exception_message").getString(key);
    }
}
