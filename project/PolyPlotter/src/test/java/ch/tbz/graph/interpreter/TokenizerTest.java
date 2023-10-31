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

    //TODO: [sarinalusti] Implement this test, investigate
//    @Test
//    public void testGetVariable_ReturnsCorrectVariable() {
//        Tokenizer tokenizer = new Tokenizer("x+3");
//        assertEquals('x', tokenizer.getVariable());
//    }
}
