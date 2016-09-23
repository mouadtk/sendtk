package com.sendtk.app.models.dao;

import com.sendtk.app.models.Settings;

public interface SettingsDAO {
	
	public Integer AddSettings(Settings newSettings);
	public boolean UpdateSettings(Settings O);	
	public Settings getSettingsByID(int id);
	public boolean removeSettings(int id);

}
