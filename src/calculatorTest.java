import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {

    @org.junit.jupiter.api.Test
    void test_check_parentheses() {
        assertEquals(true,calculator.check_parentheses("(1+3)"));
        assertEquals(false,calculator.check_parentheses("(1+3)-5)"));
    }

    @org.junit.jupiter.api.Test
    void test_reverse_str() {
        assertEquals("5 3 + 10 * 2 /",calculator.reverse_str("(5+3)*10/2"));
        //assertEquals("5 3 + 10 * 2 ",calculator.reverse_str("(5+3)*10/2"));
    }

    @org.junit.jupiter.api.Test
    void test_result() {
        assertEquals(40,calculator.result(calculator.reverse_str("(5+3)*10/2")));
    }
}