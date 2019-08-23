package com.example.newsdemo;

import com.example.newsdemo.News.MailNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsdemoApplicationTests {


    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public  void  contextLoads() throws MessagingException {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 发送方邮箱
        helper.setFrom("略！！！！");
        // 接收方邮箱
        helper.setTo("略！！！！");
        //抄送
//        String[] cs={"邮箱1","邮箱2"};
 //       helper.setCc(cs);

        MailNews mn=new MailNews();
        String str=mn.getmsg("top");

        String str1="新闻列表如下：";
        helper.setSubject("邮件标题"+new Date());
        helper.setText(str1+"<table border=\\\"2\\\" style=\\\"border:solid 1px #E8F2F9;font-size=14px;>" +
                "<tr style=\\\"background-color: #428BCA; color:#ffffff\\\"><th>标题</th><th>时间</th><th>类型</th><th>作者</th><th>url</th><th>图片1</th><th>图片2</th></tr>" +
                str +
                "</table>",true);
        javaMailSender.send(mimeMessage);
    }


}
