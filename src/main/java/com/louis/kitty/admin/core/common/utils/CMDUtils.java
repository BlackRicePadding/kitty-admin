package com.louis.kitty.admin.core.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CMDUtils {
    public static String exeRestart(String exeCmd) {
        String result = "-1";
        String[] cmd = new String[]{"/bin/sh", "-c", exeCmd};
        try {
            String[] envp = {"LANG=UTF-8"};
            Process ps = Runtime.getRuntime().exec(cmd, envp, null);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("UTF-8")));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
