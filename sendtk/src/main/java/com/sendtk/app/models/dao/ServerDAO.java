package com.sendtk.app.models.dao;

import java.util.List;
 


import com.sendtk.app.models.Server;

public interface ServerDAO {
	
	public Integer AddServer (Server newServer);
	public boolean UpdateServer(Server O);
	public List<Server> getAllServers();
	public Server getServerByMainIP(String ip);
	public Server getServerByID(int id);
	public boolean removeServer(int id);
	public List<Object[]> getALLServerIPS();

}
