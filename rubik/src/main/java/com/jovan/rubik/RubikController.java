package com.jovan.rubik;

import com.jovan.rubik.*;

import java.io.IOException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cube")
public class RubikController {

	RubikovaKocka kocka = new RubikovaKocka();
	
	/*
	@GetMapping
	public String[][][] getCube() {
		return 	kocka.getCube();
	}
	*/
	
	@PostMapping("/rotate")
	public String[][][] rotate(@RequestParam String face, @RequestParam String direction) {
		kocka.rotate(face, direction);
		return kocka.getCube();
	}
	
	@GetMapping("/reset")
	public String[][][] reset() {
		kocka = new RubikovaKocka();
		return kocka.getCube();
	}
	
	@GetMapping("/rotate")
	public String[][][] rotateGet(@RequestParam String face, @RequestParam String direction) {
	    kocka.rotate(face, direction);
	    return kocka.getCube();
	}

	@GetMapping
	public CubeState getCube() {
		return new CubeState(kocka.getCube());
	}
	
//	@PostMapping("/save")
//	public String saveCube() throws IOException {
//	    kocka.saveToFile("src/main/resources/cube-state.json");
//	    return "Saved.";
//	}
//
//	@PostMapping("/load")
//	public String loadCube() throws IOException {
//	    kocka.loadFromFile("src/main/resources/cube-state.json");
//	    return "Loaded.";
//	}
	
	@GetMapping("/save")
	public String saveCube() throws IOException {
	    kocka.saveToFile("src/main/resources/cube-state.json");
	    return "Saved.";
	}

	@GetMapping("/load")
	public String loadCube() throws IOException {
	    kocka.loadFromFile("src/main/resources/cube-state.json");
	    return "Loaded.";
	}


	
}
