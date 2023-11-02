package ch.tbz.graph.interpreter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {

    @Test
    public void testGetTokens() {
        Tokenizer tokenizer = new Tokenizer("2+2+3");
        assertEquals(tokenizer.getTokens(), List.of("2", "+", "2", "+", "3"));
    }

    @Test
    public void testGetTokens_ReturnsCorrectly_WithParentheses() {
        Tokenizer tokenizer = new Tokenizer("3*(x^2+6)");
        assertEquals(tokenizer.getTokens(), List.of("3", "*", "(", "x", "^", "2", "+", "6", ")"));
    }

    @Test
    public void test_GetTokens_RemovesSpacesInString() {
        Tokenizer tokenizer = new Tokenizer("2+           4");
        assertEquals(tokenizer.getTokens(), List.of("2", "+", "4"));
    }

    @Test
    public void testGetVariable_CanHandleNoGivenVariable() {
        Tokenizer tokenizer = new Tokenizer("3*0.5");
        assertEquals('\0', tokenizer.getVariable());
    }
}
