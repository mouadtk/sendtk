package com.sendtk.app.services;

import java.util.List;

import com.sendtk.app.models.Server;
import com.sendtk.app.models.VirtualServer;

public interface ServerService {
	
	public Integer addServer(Server p);
	public boolean UpdateServer(Server p);
    public List<Server> listServers();
    public Server getServerByMainIP(String ref);
    public Server getServerByID(int id);
    public boolean removeServer(int id);
    public VirtualServer getVirtualServer(String ip);				 /* Return VS with its parent Server */
    public List<VirtualServer> getVirtualServerList (List<String> ips);
    public List<Server> getServerList(List<String> ips);
    public List<Object[]> getAllServersIPs();
}
