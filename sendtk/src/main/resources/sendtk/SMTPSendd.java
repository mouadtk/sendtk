package com.sendtk.mailling.buisness;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sendtk.mailling.models.Campaign;
import com.sendtk.mailling.models.Server;
import com.sendtk.mailling.models.VirtualServer;
import com.sun.mail.smtp.SMTPTransport;
 

public class SMTPSendd{

	int id;
	HashMap<String, String> Headers;
	String Subject;
	String Msg ;
	List<Server> Servers;
	List<VirtualServer> SendServer;
	Campaign Camp;
	String  DataFilePath;
	
	HashMap<String, Session> SessionList =  new HashMap<String, Session>();
	
	public SMTPSendd(Campaign    CMP, List<Server> Serv){		
		this.Camp = CMP;
		setSessions(Serv);		
	}
	
	private void setSessions( List<Server> Servers) {
	
		for (Server Instance_server : Servers) {
			
			for(Iterator<VirtualServer> iterator = Instance_server.getCurrentVServer().iterator() ; iterator.hasNext() ;  ) {
				VirtualServer VS = (VirtualServer) iterator.next();
				SessionList.put(VS.getIP(), Connect(Instance_server, null, null));
			}
			
		}
	}
	
	public void SendCampaign () throws MessagingException {
		
		int i=0;
		while(true){
			
			for(HashMap.Entry<String, Session> Line : SessionList.entrySet()){
				
				System.out.println("IP:"+Line.getKey()+" Session"+Line.getValue().getDebugOut().toString());
				SMTPTransport SMTPConn = (SMTPTransport) Line.getValue().getTransport("smtp");
	    		SMTPConn.connect();
				MimeMessage message = new MimeMessage(Line.getValue());
				message.setFrom(new InternetAddress("root@somsales.com"));
				message.addRecipient(Message.RecipientType.TO,new InternetAddress("mouadtk@somsales.com"));
				message.setSubject(this.Subject);
				message.setText(this.Msg);
				//message.setHeader("x-virtual- mta", "");
				SMTPConn.sendMessage(message, message.getAllRecipients());
			}
			
			if(i==10)break;
			else i++;
			
		}
	}
	
	/** a chaque appel, cette fonction renvoie une nouvelle Session avec le serveur **/
	public Session Connect(Server Vserv, String ConnectTimeOut , String TimeOut) {
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host",Vserv.getMainIP());
		properties.setProperty("mail.smtp.port", Vserv.getSMTPPort()+"");
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

}
