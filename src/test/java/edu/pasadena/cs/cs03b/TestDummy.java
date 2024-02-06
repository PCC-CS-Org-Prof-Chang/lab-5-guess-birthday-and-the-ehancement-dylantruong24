package edu.pasadena.cs.cs03b;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestDummy {

   @Test
   public void testDummy()
   {

    int[] test1 = {1, 0, 0, 1, 1};
    int iResult = Dummy.binaryToInt(test1);
    assertEquals(19, iResult);

    int[] test2 = {1, 1, 0, 0, 1};
    int iResult2 = Dummy.binaryToInt(test2);
    assertEquals(27, iResult2);

    int[] test3 = {1, 0, 0, 0, 0};
    int iResult3 = Dummy.binaryToInt(test3);
    assertEquals(16, iResult3);

    int[] test4 = {1, 0, 1, 1, 0};
    int iResult4 = Dummy.binaryToInt(test4);
    assertEquals(22, iResult4);

   }
}
