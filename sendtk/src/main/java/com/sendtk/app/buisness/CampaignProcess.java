package com.sendtk.app.buisness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sendtk.app.models.Campaign;
import com.sendtk.app.models.Settings;
import com.sendtk.app.models.VirtualServer;

public class CampaignProcess extends Thread{
	
	private static final Logger logger = LoggerFactory.getLogger(CampaignProcess.class);	
	
	private int _Id;
	private Settings CampSettings;
	private boolean _break;
	private String DataFile;
	private Campaign _camp;
	private HashMap<String, String > _MSG = new HashMap<String, String>();
	private HashMap<String, SendSession> SessionList =  new HashMap<String, SendSession>();
	
	
	
	/**
	 * @param VSList list des VirtualServers
	 * @param camp Campaign
	 * @param data :  Emails File
	 */
	public CampaignProcess( List<VirtualServer> VSList, Campaign camp,String data, int MSGIP , int SED, int DELAY,  int COUNTDELAY, int FRACT ,HashMap<String, String > MSG) throws MessagingException{
		
		CampSettings= new Settings((MSGIP		!=0) 	? MSGIP 	: 1 ,
				 				   (SED  		>0 )	? SED		: 0 ,
				 				   (DELAY  		>0 )	? DELAY		: 0 ,
				 				   (COUNTDELAY  >0 )	? COUNTDELAY: 0 ,
				 				   (FRACT       >0 )	? FRACT: 0,   
				 					0);
		_camp    	=  camp;
		DataFile 	=  data;
		this._MSG   =  MSG;
		for (VirtualServer VS_Instance: VSList) {
			/**
			 * Open connections with drop Servers
			 */
			try{
			SessionList.put(VS_Instance.getIP(),
							new SendSession(VS_Instance.getIP(), VS_Instance.getServer().getSMTPPort()+"", VS_Instance.getVMTA(), null, null));
			}catch(ConnectException ex ){
				logger.info("problem de connextion avec "+VS_Instance.getIP());
			}
		}
		
	}
	
	public HashMap<String, Integer> SendCampaignTest() throws AddressException, NoSuchProviderException, MessagingException{
			HashMap<String, Integer> Results = new HashMap<String, Integer>(0);
			for(HashMap.Entry<String, SendSession> entry : SessionList.entrySet()){
					/**
					 * if we get connected to server : Send to mail 
					 */
					if(entry.getValue().Connect())
						Results.put(entry.getValue()._IP ,entry.getValue().Send(_MSG));
			}
			return Results;
	}
	
	public void run(){
		try {
			SendCampaign();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SendCampaign() throws Exception{
		
		logger.info("Send campaign function...");
		SendSession TmpSession;
		String AccountMail;
		int NbrServer = SessionList.size();
		List<SendSession> _Sessions  = new ArrayList<SendSession>(SessionList.values());
		
		while(!_break){
			
			/**
			 * Send number of Messages over an IP
			 */
			for(int j=0; j<CampSettings.getMsg_Per_IP(); j++){
				/**
				 * get Servcer Session 
				 */
				TmpSession = _Sessions.get(CampSettings.get_Index()%NbrServer);
				if(TmpSession.Connect()){
					/**
					 * _Message : [MailTo,From,MessageBody,Subject]
					 **/
					AccountMail =  getMailAccount();
					logger.info("Sending to :"+AccountMail);
					if(AccountMail == null){
						logger.info("Campaign has been sent successfully");
						SaveState();
						return;
					}
					_MSG.put("MailTo",AccountMail);
					/**Send mail*/
					
					TmpSession.Send(_MSG);
					System.out.println("ID: "+_Id+" -- "+CampSettings.get_Index());
					CampSettings.IncrementIndex();
					/** if we get to Sed  limit, we call Sed function */
					if(CampSettings.getSed() !=0 && CampSettings.get_Index() % CampSettings.getSed() == 0)
						launchSed();
					if(CampSettings.getCountDelay()!=0 && CampSettings.get_Index()%CampSettings.getCountDelay()== 0 ){
						try {
							logger.info("Sleeping a while...");
							logger.info(""+CampSettings.getxDelay());
							Thread.sleep(CampSettings.getxDelay());
						} catch (InterruptedException e) {
							SaveState();
							e.printStackTrace();
							return;
						} 
					}
				}
			}
			
		}
		SaveState();
		logger.info("Send campaign function End.");		
	}
	
	
	public boolean Pause(){
		logger.info("Campaign in pause!");
		logger.info("index : "+CampSettings.get_Index());
		_break = true;
		SaveState();
		return _break;
	}
	
	
	public boolean Resume(){
		_break = false;
		LoadState();
		return _break;

	}
	
	private String getMailAccount() throws Exception{
		BufferedReader in = new BufferedReader(new FileReader(DataFile));
		String Line;
		int count=0;
		while ((Line = in.readLine()) != null ){
			
			if(count == CampSettings.get_Index())
			return Line.split(",")[1];
			count++;
		}
		return null;
	}
	
	
	private void SaveState(){
		logger.info("Saving state...");
	}
	
	private void LoadState(){}
	
	private void launchSed(){
		logger.info("Sed function is launched...");
	}

	/**
	 * @return the dataFile
	 */
	public String getDataFile() {
		return DataFile;
	}

	
	/**
	 * @param dataFile the dataFile to set
	 */
	public void setDataFile(String dataFile) {
		DataFile = dataFile;
	}

	
	/**
	 * @return the sessionList
	 */
	public HashMap<String, SendSession> getSessionList() {
		return SessionList;
	}

	
	/**
	 * @param sessionList the sessionList to set
	 */
	public void setSessionList(HashMap<String, SendSession> sessionList) {
		SessionList = sessionList;
	}

	/**
	 * @return the _Id
	 */
	public int get_Id() {
		return _Id;
	}

	/**
	 * @param _Id the _Id to set
	 */
	public void set_Id(int _Id) {
		this._Id = _Id;
	}

}