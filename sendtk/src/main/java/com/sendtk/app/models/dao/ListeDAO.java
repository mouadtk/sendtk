package com.sendtk.app.models.dao;

import java.util.List;

import com.sendtk.app.models.Liste;

public interface ListeDAO {

	public Integer AddListe(Liste newList );
	public boolean UpdateListe (Liste newList);
	public List<Liste> getAllListes();
	public String generateReference();
	public String generateName(String ISP, String Type);
	public boolean disable(String ref);
	public boolean enable(String ref);
	
	
}
