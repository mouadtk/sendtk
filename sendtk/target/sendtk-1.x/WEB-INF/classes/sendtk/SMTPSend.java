package com.sendtk.mailling.buisness;

import java.net.ConnectException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sendtk.mailling.models.Campaign;
import com.sendtk.mailling.models.Server;
import com.sendtk.mailling.models.VirtualServer;
import com.sun.mail.smtp.SMTPTransport;
 

public class SMTPSend extends Thread {

	int id;
	String from;
	String Subject;
	String Msg;
	VirtualServer SendServer;
	Campaign cmp;
	String  DataFilePath;
	
	private boolean breakSend = false;
	
	public static String name;
	private volatile static int index = 0;
	
	public SMTPSend(){}
	
	public SMTPSend(int id, Campaign c,VirtualServer vs, String from,String subj,String ms){
		
		this.id 		= id;
		this.cmp 		= c;
		this.SendServer = vs;
		this.from		= from;
		this.Subject	= subj;
		this.Msg		= ms;
		
	}
	
	@Override
	public void run(){
		
		try {
			
			String MailAccount ="";
			Session session = this.Connect();
			SMTPTransport SMTPConn = null;
			while(( MailAccount = getMailAccount())!=null){
				
				if(breakSend){
					if(SMTPConn.isConnected())
						SMTPConn.close();
					return;
				}
				
				SMTPTransport SMTPConn = (SMTPTransport) session.getTransport("smtp");
	    		SMTPConn.connect();
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(this.from));
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(MailAccount));
				message.setSubject(this.Subject);
				message.setText(this.Msg);
				message.setHeader("x-virtual-mta", SendServer.getVMTA());
				SMTPConn.sendMessage(message, message.getAllRecipients());
				Transport.send(message);
			}
			
			if(SMTPConn.isConnected())
					SMTPConn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private Session Connect() throws java.net.ConnectException{
		System.out.println("connect");
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host",SendServer.getServer().getMainIP());
		System.out.println("connection with: "+SendServer.getServer().getMainIP());
		properties.setProperty("mail.smtp.port", SendServer.getServer().getSMTPPort()+"");
        properties.setProperty("mail.smtp.auth", "false");
	    properties.setProperty("mail.debug", "false");
	    properties.setProperty("mail.smtp.connectiontimeout", "30000");
	    properties.setProperty("mail.smtp.timeout", "300000");
	    
	    return  Session.getInstance(properties);
	}

	public synchronized String getMailAccount(){
		String mailAccount = "root@somsales.com";
		System.out.println(id+"tsayfita  ----  "+index+" -- mailAccount"+mailAccount);
		index++;
		if(index>10)
			return null;
		else
		return mailAccount;
	}

	public void StopSending() {
		
		 System.out.println("shalina shalina");
		 breakSend = true;
	}
	
	public void ResumeSending() {
		 System.out.println("shalina shalina");
		 breakSend = false;
	}
}
