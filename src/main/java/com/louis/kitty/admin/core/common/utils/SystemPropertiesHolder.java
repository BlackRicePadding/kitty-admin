package com.louis.kitty.admin.core.common.utils;

import org.springframework.core.io.ContextResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SystemPropertiesHolder {
    public static Resource resource;

    public static Properties props;

    public static String path = "";

    static {
        String calssPath = String.valueOf(ContextResource.class.getResource(""));
        String pathArr[] = null;
        String path1 = "";
        if (calssPath.contains("/")) {
            pathArr = calssPath.split("/");
            if (pathArr.length >= 1) {
                for (int i = 0; i < pathArr.length; i++) {
                    File file;
                    if (path1.length() > 7) {
                        file = new File((path1.substring(11) + "//application.yml"));
                    } else {
                        file = new File((path1 + "//application.yml"));
                    }
                    if (!file.exists()) {
                        path1 += "//" + pathArr[i];
                        String path2 = "";
                        if (path1.length() > 7) {
                            path2 = path1.substring(11);
                        } else {
                            path2 = path1;
                        }
                    } else {
                        path = path1.substring(11) + "//application.yml";
                    }
                }
            }
        }
        if (path.length() > 0) {
            resource = new FileSystemResourceLoader().getResource(path);
        } else {
            resource = new FileSystemResourceLoader().getResource("classpath:application.yml");
        }
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        String s = null;
        try {
            if (null != props.getProperty(key)) {
                s = new String(props.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            s = props.getProperty(key);
        }
        return s;
    }
}