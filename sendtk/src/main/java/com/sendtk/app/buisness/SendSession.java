package com.sendtk.app.buisness;

import java.net.ConnectException;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.smtp.SMTPTransport;

public class SendSession {

	private static final Logger logger = LoggerFactory.getLogger(SendSession.class);	

	Session InstanceSession;
	public SMTPTransport SMTPConn;
	String VMTA;
	String _IP;
	/**
	 * 
	 * @param IP
	 * @param SMTPPort
	 * @param vmta
	 * @param ConnectTimeOut
	 * @param TimeOut
	 * @throws MessagingException
	 */
	public SendSession(String IP, String SMTPPort , String vmta, String ConnectTimeOut , String TimeOut) throws MessagingException, ConnectException{
		
		this.InstanceSession =  getSession(IP, SMTPPort, ConnectTimeOut, TimeOut);
		this.SMTPConn = (SMTPTransport) InstanceSession.getTransport("smtp");
		this.Connect();
		this.VMTA = vmta;
		this._IP  = IP;
	}
	
	/**
	 * 
	 * @param _Message : [MailTo,From,MessageBody,Subject]
	 * @return int: last code from server
	 * @throws NoSuchProviderException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public int Send(Map< String, String> _Message) throws NoSuchProviderException, AddressException, MessagingException {
		
		if(SMTPConn.isConnected()){
			try {
				logger.info(_Message.get("From"));
				MimeMessage message = new MimeMessage(InstanceSession);
				message.setFrom(new InternetAddress(_Message.get("From")));
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(_Message.get("MailTo")));
				message.setSubject( _Message.get("Subject"	  ));
				message.setText   (	_Message.get("MessageBody"));
				message.setHeader ( "x-virtual-mta",  VMTA);
				
				SMTPConn.sendMessage(message, message.getAllRecipients());
				
			} catch (MessagingException e) {
				System.err.println(e);
				
			}
			return SMTPConn.getLastReturnCode();
		}
		return -1;
	}
	
	/**
	 * 
	 * @param IP
	 * @param SMTPPort
	 * @param ConnectTimeOut
	 * @param TimeOut
	 * @return
	 */
	private Session getSession(String IP, String SMTPPort , String ConnectTimeOut , String TimeOut) {
		logger.info("IP: "+IP+" Sending...");
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host",IP);
		properties.setProperty("mail.smtp.port", SMTPPort);
        properties.setProperty("mail.smtp.auth", "false");
	    properties.setProperty("mail.debug", "false");
	    if(ConnectTimeOut!=null)
	    	properties.setProperty("mail.smtp.connectiontimeout", ConnectTimeOut);
	    else 
	    	properties.setProperty("mail.smtp.connectiontimeout", "20000");
	    if(TimeOut!=null)
	    	properties.setProperty("mail.smtp.timeout", TimeOut);
	    else
	    	properties.setProperty("mail.smtp.timeout", "20000");
	    return  Session.getInstance(properties);
	}

	public boolean Connect(){
		if(SMTPConn!=null){
			if(SMTPConn.isConnected()) return true;
			try {
				SMTPConn.connect();
			} catch (MessagingException e) {
				logger.error("Problem with "+_IP);
				logger.error(e.getMessage());
				return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean DisConnect() throws MessagingException{
		if(SMTPConn!=null && SMTPConn.isConnected()){
			SMTPConn.close();
			return true;
		}
		return false;
	}

}
