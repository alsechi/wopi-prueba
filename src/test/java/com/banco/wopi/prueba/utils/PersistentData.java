package com.banco.wopi.prueba.utils;

public class PersistentData {
	
	private static PersistentData pd = null;
	
	private String _dato1;
	public String getDato1() {return this._dato1;}
	public void setDato1(String dato) {this._dato1 = dato;}
	
	public static PersistentData getPersistentData()
	{
		if(pd == null)
			pd = new PersistentData();
		
		return pd;
	}
	
}
