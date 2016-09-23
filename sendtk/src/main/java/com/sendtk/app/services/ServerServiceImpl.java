package com.sendtk.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendtk.app.models.Server;
import com.sendtk.app.models.VirtualServer;
import com.sendtk.app.models.dao.ServerDAO;
import com.sendtk.app.models.dao.VirtualServerDAO;

@Service
//@Scope("request")
public class ServerServiceImpl implements ServerService{

	@Autowired
	private ServerDAO MyServerDAO;
	@Autowired
	private VirtualServerDAO MyVirtualServerDAO;
	   
 	@Override
	public Integer addServer(Server p){
 		return MyServerDAO.AddServer(p);
	}

	@Override
	public boolean UpdateServer(Server p) {
		return MyServerDAO.UpdateServer(p);
	}

	@Override
	public List<Server> listServers() {
		return MyServerDAO.getAllServers();
	}

	@Override
	public Server getServerByMainIP(String ref) {
		return MyServerDAO.getServerByMainIP(ref);
	}

	@Override
	public Server getServerByID(int id) {
		return MyServerDAO.getServerByID(id);
	}

	@Override
	public boolean removeServer(int id) {
		return MyServerDAO.removeServer(id);
	}

	@Override
	public VirtualServer getVirtualServer(String ip) {
		return  MyVirtualServerDAO.getVirtualServerByMainIPServer(ip);
	}

	@Override
	public List<VirtualServer> getVirtualServerList(List<String> ips) {
		
		List<VirtualServer> VSList = new ArrayList<VirtualServer>();
		for (int i = 0; i < ips.size(); i++){
				VSList.add(getVirtualServer(ips.get(i)));
		}
		return VSList;
	}
	
	@Override
	public List<Server> getServerList(List<String> ips) {
		
		List<Server> ServerList = new ArrayList<Server>(0);
		
		for (int i = 0; i < ips.size(); i++){
			
			VirtualServer tmp = getVirtualServer(ips.get(i));
			Server 		   ts = MyServerDAO.getServerByID(tmp.getServer().getId());
			int 		index = ServerList.indexOf(ts);
			
			if(index == -1){
				tmp.setServer(null);
				ts.addCurrentVServer(tmp);
				ServerList.add(ts);
			}else{
				tmp.setServer(null);
				ServerList.get(index).addCurrentVServer(tmp);
			}
		}
		
		return ServerList;
	}

	@Override
	public List<Object[]> getAllServersIPs() {
		MyServerDAO.getALLServerIPS().toArray();
		return null;
	}

	
}
