package com.bfhl.service;

import com.bfhl.dto.BfhlRequest;
import com.bfhl.dto.BfhlResponse;
import com.bfhl.service.impl.BfhlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    private BfhlService bfhlService;

    @BeforeEach
    public void setUp() {
        bfhlService = new BfhlServiceImpl();
    }

    @Test
    public void testExampleA() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertEquals("sarvesh_jadia_07042005", response.getUserId());
        assertEquals("sarveshjadia230885@acropolis.in", response.getEmail());
        assertEquals("0827CS231240", response.getRollNumber());
        assertEquals(Arrays.asList("1"), response.getOddNumbers());
        assertEquals(Arrays.asList("334", "4"), response.getEvenNumbers());
        assertEquals(Arrays.asList("A", "R"), response.getAlphabets());
        assertEquals(Arrays.asList("$"), response.getSpecialCharacters());
        assertEquals(Arrays.asList("$"), response.getSepcialCharacters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcatString());
    }

    @Test
    public void testExampleB() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertEquals(Arrays.asList("5"), response.getOddNumbers());
        assertEquals(Arrays.asList("2", "4", "92"), response.getEvenNumbers());
        assertEquals(Arrays.asList("A", "Y", "B"), response.getAlphabets());
        assertEquals(Arrays.asList("&", "-", "*"), response.getSpecialCharacters());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcatString());
    }

    @Test
    public void testExampleC() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertTrue(response.getOddNumbers().isEmpty());
        assertTrue(response.getEvenNumbers().isEmpty());
        assertEquals(Arrays.asList("A", "ABCD", "DOE"), response.getAlphabets());
        assertTrue(response.getSpecialCharacters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcatString());
    }

    @Test
    public void testEmptyRequest() {
        BfhlRequest request = new BfhlRequest(Collections.emptyList());
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertTrue(response.getOddNumbers().isEmpty());
        assertTrue(response.getEvenNumbers().isEmpty());
        assertTrue(response.getAlphabets().isEmpty());
        assertTrue(response.getSpecialCharacters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcatString());
    }

    @Test
    public void testNegativeNumbers() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("-2", "-5", "10"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isSuccess());
        assertEquals(Arrays.asList("-5"), response.getOddNumbers());
        assertEquals(Arrays.asList("-2", "10"), response.getEvenNumbers());
        assertEquals("3", response.getSum());
    }
}
