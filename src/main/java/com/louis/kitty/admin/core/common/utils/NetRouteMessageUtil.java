package com.louis.kitty.admin.core.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetRouteMessageUtil {
    public static String seeCPUstate() {
        String result = "1";
        String resultTemp = "";
        try {
            // String[] cmd = new Str   ing[] { "/bin/sh", "-c", "netstat
            // -ntpl|grep " port "" };
            String[] cmd = new String[]{"/bin/sh", "-c", "top -bn 1 -i -c"};
            Process ps = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("UTF-8")));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Cpu(s)")) {
                    String resultArr[] = line.split(",");
                    result = resultArr[3];
                }
                sb.append(line);
            }
            resultTemp = sb.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        if (result.contains("i")) {
            int iIndex = result.indexOf('i');
            result = result.substring(0, (iIndex - 1));
            result = String.valueOf(Double.valueOf(result));
        }
        return result;
    }

    public static String neicunString(){
        String result = "";
        String resultTemp = "";
        try {
            String[] cmd = new String[]{"/bin/sh", "-c", "free -m"};
            Process ps = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("UTF-8")));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("Mem")){
                    String ss = line;
                    for(int i = 0; i < ss.length(); i++) {
                        if (String.valueOf(ss.charAt(i)).equals(" ")) {
                            continue;
                        }else {
                            if(i!=0){
                                if (String.valueOf(ss.charAt(i-1)).equals(" ") && (0 <= Integer.valueOf(ss.charAt(i)) || Integer.valueOf(ss.charAt(i)) >= 9)){
                                    resultTemp = resultTemp + ',';
                                }
                                resultTemp = resultTemp + ss.charAt(i);
                            }
                        }
                    }
                }
                sb.append(line);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        if(resultTemp.contains(",")){
            String sArr[] = resultTemp.split(",");
            result = String.valueOf(Double.valueOf(sArr[2])/Double.valueOf(sArr[1])*100);
        }
        return result;

    }


    /**
     * 杀毒
     *
     * @return
     */
    public static String killVirus(String antivirusPath,String filePath) {
        JSONArray array = new JSONArray();
        int a = 0;
        String bb = "-2";
        try {
            String cmd = antivirusPath+"  --arc -i --max-filesize=0 '"+filePath+"'";
            System.out.println(cmd+"#################################");
            Process ps = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("UTF-8")));
            StringBuffer sb = new StringBuffer();
            String line;
            bb = br.readLine();
            while ((line = br.readLine()) != null) {
                JSONObject object = new JSONObject();
                object.put((a++)+"",line);
                array.add(object);
                sb.append(line);
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        JSONObject object = JSON.parseObject(array.get(5).toString());
        String sss = object.get("5").toString();
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(sss);
        bb = m.replaceAll("").trim();
        return bb;
    }

}

