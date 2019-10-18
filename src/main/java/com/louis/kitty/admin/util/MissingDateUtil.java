package com.louis.kitty.admin.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class MissingDateUtil {
    /**
     * 查询近几个月的月初和月末
     *
     * @param num 近五个月 num=7
     * @return
     */
    public static synchronized List<Map<String, Object>> getRecentMonths(int num) {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        //当前时所在月份的第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        //设置startDate
        Calendar c = Calendar.getInstance();
        //设置endDate
        Calendar c2 = Calendar.getInstance();
        for (int i = 0; i < num; i++) {
            HashMap<String, Object> dateMap = new HashMap<String, Object>();
            //设置start
            //设置为1号,当前日期既为本月第一天
            c.set(Calendar.DAY_OF_MONTH, 1);
            //设置为0点0分0秒
            c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 0, 0, 0);
            //存入年月显示
            dateMap.put("yearMonthStr", format.format(c.getTime()));
            dateMap.put("startDate", c.getTime());
            //将c 设置为下个月
            c.add(c.DATE, -1);


            //设置end 为当前月的月底 23时59分59秒
            c2.set(Calendar.DAY_OF_MONTH, 1);
            //设置时间 23时59分59秒
            c2.set(c2.get(c.YEAR), c2.get(c.MONTH), c2.get(c.DAY_OF_MONTH), 23, 59, 59);
            //获得当前月最后一天
            c2.add(Calendar.MONTH, 1);
            c2.set(Calendar.DAY_OF_MONTH, 0);
            //存入map
            dateMap.put("endDate", c2.getTime());
            //获取当前时间的下一个月
            c2.add(Calendar.MONTH, -1);
            //将c2设置为当前时间上一个月
            c2.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH));
            //放入集合
            maps.add(dateMap);

        }
        return maps;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static List<String> getPastDate(int past) {
        List<String> stringList = new LinkedList<>();
        for (int i = (past - 1); i >= 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String result = format.format(today);
            stringList.add(result);
        }
        return stringList;
    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static List<String> getWeekList(int num) {
        List<String> stringList = new LinkedList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        for (int i = num; i >=0; i--) {
            c.setTime(new Date());
            c.add(Calendar.DATE, -(i * 7));
            Date d = c.getTime();
            String day = format.format(d);
            stringList.add(day);
        }
        return stringList;
    }
}
