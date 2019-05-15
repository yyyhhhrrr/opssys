package com.zyou.ops.util.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.poi.hdgf.chunks.Chunk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Component
@PropertySource({"classpath:/config.properties"})
public class SendMail {

	@Value("${email.MailServerHost}")
	private String mailServerHost;
	@Value("${email.MailServerPort}")
	private  String mailServerPort;
	@Value("${email.fromName}")
	private String from_name;
	@Value("${email.fromPassword}")
	private  String from_passwrod;
	@Value("${email.fromMail}")
	private  String from_mail;

	public  void test(){
		System.out.println(mailServerHost);
	}

	public  boolean SendEmail(String content, String title, List<String> emailList) {
		boolean flag = false;
		MailSenderInfo mailInfo = new MailSenderInfo();
		// 邮箱的网址
		mailInfo.setMailServerHost(mailServerHost);
		mailInfo.setMailServerPort(mailServerPort);  // smtp.qq.com，使用SSL，端口号465或587
		mailInfo.setValidate(true);
		mailInfo.setUserName(from_name);
		// 成功开启POP3/SMTP服务,在第三方客户端登录时，密码框请输入以下授权码：

		// 成功开启IMAP/SMTP服务,在第三方客户端登录时，密码框请输入以下授权码：

		mailInfo.setPassword(from_passwrod);
		mailInfo.setFromAddress(from_mail);
		// 添加收件人
		mailInfo.setList(emailList);

		mailInfo.setSubject(title);
		// 发送激活链接到邮箱
		mailInfo.setContent(content);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		flag = sms.sendTextMail(mailInfo);// 发送文体格式
		// sms.sendHtmlMail(mailInfo);//发送html格式
		return flag;
	}

	public  void getContext(String service_name,String url,List<String> emailList,String httpCode){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer context = new StringBuffer();
		context.append("服务器:").append(service_name).append("\n");
		context.append("url:").append(url).append("\n");
		context.append("时间:").append(formatter.format(new Date())).append("\n");
		context.append("状态:").append(httpCode);
		SendEmail(context.toString(), "服务器检查邮件", emailList);

	}


}
