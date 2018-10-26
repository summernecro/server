package com.summer.timing;

import com.summer.base.bean.BaseResBean;
import com.summer.imageclassfy.AccessTokenBean;
import com.summer.util.DateFormatUtil;
import com.summer.util.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.summer.util.HttpRequest.sendPost;


@Component("taskJob")
public class QuartzTask {

    /**
     * CRON表达式                含义 
    "0 0 12 * * ?"            每天中午十二点触发 
    "0 15 10 ? * *"            每天早上10：15触发 
    "0 15 10 * * ?"            每天早上10：15触发 
    "0 15 10 * * ? *"        每天早上10：15触发 
    "0 15 10 * * ? 2005"    2005年的每天早上10：15触发 
    "0 * 14 * * ?"            每天从下午2点开始到2点59分每分钟一次触发 
    "0 0/5 14 * * ?"        每天从下午2点开始到2：55分结束每5分钟一次触发 
    "0 0/5 14,18 * * ?"        每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
    "0 0-5 14 * * ?"        每天14:00至14:05每分钟一次触发 
    "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发 
    "0 15 10 ? * MON-FRI"   每个周一、周二、周三、周四、周五的10：15触发
     */
    
    /**
     * 每天4点触发（清空验证码表t_captcha中的数据）
     */
    @Scheduled(cron = "0 10 4 * * ?")
    public void testTask(){
        System.out.println("test quarttask "+DateFormatUtil.getdDateStr(DateFormatUtil.SECOND+"-"+DateFormatUtil.MINUTE+"-"+DateFormatUtil.HOUR,new Date()));

        BaseResBean baseResBean = new BaseResBean();
        baseResBean.setData("0");
        String str = HttpRequest.sendGet("http://222.186.36.75:8888/record/imageclassify/classify", baseResBean, null);
        System.out.println(str);
    }

    @Scheduled(cron = "0 0 4 * * ?")
    public void testTask2(){

    }
}