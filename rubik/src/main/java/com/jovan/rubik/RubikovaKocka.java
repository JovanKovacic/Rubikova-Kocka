package com.jovan.rubik;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class RubikovaKocka {

	//Trodimenzionalni niz, 6 stranica, svaka 3x3 kvadrata
	private String[][][] cube; 
	// Boje(White, Yellow, Red, Orange, Green, Blue)
	private static final String[] colors = {"W", "Y", "R", "O", "G", "B"};
	
	
	public RubikovaKocka() {
		
		cube = new String[6][3][3];
		
		for(int i=0; i<colors.length; i++) {
			for (int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					cube[i][j][k] = colors[i];
				}
			}
		}
	}
	
	public String[][][] getCube() {
		return cube;
	}
	
	public void printCube() {
		
		String[] faces = {"UP", "DOWN", "FRONT", "BACK", "LEFT", "RIGHT"};
		
		for(int i=0; i<6; i++) {
			System.out.println("Face " + faces[i]);
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					System.out.print(cube[i][j][k] + " ");
				}
				System.out.println();
			}
		}
		
	}
	
	private void rotateClockWise(int face) {
		
		String[][] newFace = new String[3][3];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				newFace[j][2-i] = cube[face][i][j];
			}
		}
		
		cube[face] = newFace;
		
	}
	
	public void rotate(String face, String direction) {
		
		if(!direction.equals("CW")) {
			System.out.println("Wrong Direction!");
			System.out.println("Only CW direction");
			return;
		}
		
		switch(face) {	
			case "U":
				rotateUClockWise();
				break;
			case "D":
				rotateDClockWise();
				break;
			case "F":
				rotateFClockWise();
				break;
			case "B":
				rotateBClockWise();
				break;
			case "L":
				rotateLClockWise();
				break;
			case "R":
				rotateRClockWise();
				break;
			default:
				System.out.println("Unknown Face");
		}
		
	}
	
	private void rotateUClockWise() {
		
		rotateClockWise(0);
		
		String[] front = cube[2][0].clone();
		String[] right = cube[5][0].clone();
		String[] back = cube[3][0].clone();
		String[] left = cube[4][0].clone();
		
		cube [2][0] = left;
		cube[5][0] = front;
		cube[3][0] = right;
		cube[4][0] = back;
		
	}
	
	private void rotateDClockWise() {
	    rotateClockWise(1);
	    String[] front = cube[2][2].clone();
	    String[] right = cube[5][2].clone();
	    String[] back = cube[3][2].clone();
	    String[] left = cube[4][2].clone();

	    cube[2][2] = right;
	    cube[5][2] = back;
	    cube[3][2] = left;
	    cube[4][2] = front;
	}
	
	private void rotateFClockWise() {
		rotateClockWise(2);
	    String[] up = new String[]{ cube[0][2][0], cube[0][2][1], cube[0][2][2] };
	    String[] right = new String[]{ cube[5][0][0], cube[5][1][0], cube[5][2][0] };
	    String[] down = new String[]{ cube[1][0][2], cube[1][0][1], cube[1][0][0] };
	    String[] left = new String[]{ cube[4][2][2], cube[4][1][2], cube[4][0][2] };

	    for (int i = 0; i < 3; i++) {
	        cube[0][2][i] = left[i];
	        cube[5][i][0] = up[i];
	        cube[1][0][2 - i] = right[i];
	        cube[4][i][2] = down[i];
	    }
	}
	
	private void rotateBClockWise() {
		rotateClockWise(3);
	    String[] up = new String[]{ cube[0][0][2], cube[0][0][1], cube[0][0][0] };
	    String[] right = new String[]{ cube[5][2][2], cube[5][1][2], cube[5][0][2] };
	    String[] down = new String[]{ cube[1][2][0], cube[1][2][1], cube[1][2][2] };
	    String[] left = new String[]{ cube[4][0][0], cube[4][1][0], cube[4][2][0] };

	    for (int i = 0; i < 3; i++) {
	        cube[0][0][2 - i] = left[i];
	        cube[5][i][2] = up[i];
	        cube[1][2][i] = right[i];
	        cube[4][i][0] = down[i];
	    }
	}
	
	private void rotateLClockWise() {
		rotateClockWise(4);
	    String[] up = new String[]{ cube[0][0][0], cube[0][1][0], cube[0][2][0] };
	    String[] front = new String[]{ cube[2][0][0], cube[2][1][0], cube[2][2][0] };
	    String[] down = new String[]{ cube[1][2][0], cube[1][1][0], cube[1][0][0] };
	    String[] back = new String[]{ cube[3][2][2], cube[3][1][2], cube[3][0][2] };

	    for (int i = 0; i < 3; i++) {
	        cube[0][i][0] = back[i];
	        cube[2][i][0] = up[i];
	        cube[1][2 - i][0] = front[i];
	        cube[3][i][2] = down[i];
	    }
	}
	
	private void rotateRClockWise() {
		rotateClockWise(5);
	    String[] up = new String[]{ cube[0][0][2], cube[0][1][2], cube[0][2][2] };
	    String[] front = new String[]{ cube[2][0][2], cube[2][1][2], cube[2][2][2] };
	    String[] down = new String[]{ cube[1][2][2], cube[1][1][2], cube[1][0][2] };
	    String[] back = new String[]{ cube[3][2][0], cube[3][1][0], cube[3][0][0] };

	    for (int i = 0; i < 3; i++) {
	        cube[0][i][2] = front[i];
	        cube[2][i][2] = down[2 - i];
	        cube[1][i][2] = back[i];
	        cube[3][2 - i][0] = up[i];
	    }
	}
	
	private void initializeCube() {
		
		cube = new String[6][3][3];
		
		for(int i=0; i<colors.length; i++) {
			for (int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					cube[i][j][k] = colors[i];
				}
			}
		}
	}

	
	public void reset() {
		initializeCube();
	}
	
	public void saveToFile(String filename) throws IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(new File(filename), new CubeState(this.cube));
	}

	public void loadFromFile(String filename) throws IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    CubeState state = mapper.readValue(new File(filename), CubeState.class);
	    Map<String, String[][]> faces = state.getFaces();

	    String[] faceOrder = {"U", "D", "F", "B", "L", "R"};
	    for (int i = 0; i < faceOrder.length; i++) {
	        this.cube[i] = faces.get(faceOrder[i]);
	    }
	}
	
}
