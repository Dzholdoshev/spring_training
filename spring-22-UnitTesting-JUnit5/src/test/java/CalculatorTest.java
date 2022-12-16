import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll is executed");
    }

    @AfterAll
    static void tearAfterAll(){
        System.out.println("AfterAll is executed");
    }
    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed.");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed.");
    }


    @Test
    @DisplayName("MyMethod")
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5,actual,"Test failed");
    }

    @Test
    void add2() {
     //   assertThrows(IllegalArgumentException.class, ()-> Calculator.add(3,2));
     //   assertThrows(AccessDeniedException.class, ()-> Calculator.add(3,2));
          assertThrows(IllegalArgumentException.class, ()-> Calculator.add(2,3));

    }
    @Test
    void testCase1(){
      //  System.out.println("Test Case 1");
        fail("not implemented yet");
    }

    @Test
    void testCase2(){
        System.out.println("Test Case 2");
        assertEquals("add",Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }
    @Test
    void testCase3(){
        System.out.println("Test Case 3");
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3},"Arrays are not the same");
    }
    @Test
    void testCase4(){
        System.out.println("Test Case 4");
        String nullString = null;
        String notNullString = "Cydeo";
        assertNull(nullString);
        assertNotNull(nullString); //failed because it is Null
    }
    @Test
    void testCase5(){
        System.out.println("Test Case 5");

        Object c1 = new Calculator();
        Object c2 = c1;
        Object c3 = new Calculator();


    }
//maven-surefire-plugin

}