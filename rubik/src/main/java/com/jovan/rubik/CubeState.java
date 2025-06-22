package com.jovan.rubik;

import java.util.HashMap;
import java.util.Map;

public class CubeState {
	
	public CubeState() {
	    
	}


	private Map<String, String[][]> faces = new HashMap<>();
	
	public CubeState(String[][][] cube) {
		
		String[] facesNames = {"U", "D", "F", "B", "L", "R"};
		
		for(int i=0; i<facesNames.length; i++) {
			faces.put(facesNames[i], cube[i]);
		}
		
	}
	
	public Map<String, String[][]> getFaces() {
		return faces;
	}
	
	public void setFaces(Map<String, String[][]> faces) {
		this.faces = faces;
	} 
	
}
