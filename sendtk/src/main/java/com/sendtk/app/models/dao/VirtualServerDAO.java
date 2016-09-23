package com.sendtk.app.models.dao;

import java.util.List;

import com.sendtk.app.models.Server;
import com.sendtk.app.models.VirtualServer;

public interface  VirtualServerDAO {

	public Integer AddVirtualServer (VirtualServer newVirtualServer);
	public boolean UpdateVirtualServer(VirtualServer O);
	public List<VirtualServer> getAllVirtualServersByIDServer();
	public VirtualServer getVirtualServerByMainIPServer(String ip);
	public Server getParentServer(int id);
	public VirtualServer getVirtualServerByID(int id);
	public boolean removeVirtualServer(int id);
	
}
