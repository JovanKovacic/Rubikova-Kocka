package com.jovan.rubik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RubikApplicationTests {

    private RubikovaKocka kocka;

    @BeforeEach
    public void setUp() {
        kocka = new RubikovaKocka();
    }

    @Test
    public void testInitialCubeState() {
        String[][][] cube = kocka.getCube();
        for (int i = 0; i < 6; i++) {
            String color = cube[i][0][0];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    assertEquals(color, cube[i][j][k], "Each face should be a uniform color");
                }
            }
        }
    }

    @Test
    public void testRotationChangesCube() {
        String before = cubeToString(kocka.getCube());
        kocka.rotate("U", "CW");
        String after = cubeToString(kocka.getCube());
        assertNotEquals(before, after, "Cube should change after rotation");
    }

    @Test
    public void testFourRotationsReturnToOriginal() {
        String original = cubeToString(kocka.getCube());
        for (int i = 0; i < 4; i++) {
            kocka.rotate("U", "CW");
        }
        String after = cubeToString(kocka.getCube());
        assertEquals(original, after, "After 4 rotations, cube should return to original");
    }

    @Test
    public void testResetRestoresInitialState() {
        kocka.rotate("F", "CW");
        kocka.reset();
        String reset = cubeToString(kocka.getCube());
        RubikovaKocka nova = new RubikovaKocka();
        String novaCube = cubeToString(nova.getCube());
        assertEquals(novaCube, reset, "Reset should restore original state");
    }

    private String cubeToString(String[][][] cube) {
        StringBuilder sb = new StringBuilder();
        for (String[][] face : cube) {
            for (String[] row : face) {
                for (String cell : row) {
                    sb.append(cell);
                }
            }
        }
        return sb.toString();
    }
}
