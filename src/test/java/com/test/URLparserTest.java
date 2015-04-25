package com.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class URLparserTest {

    @Test
    public void test_basic_http_protocol() {
        URLparser p = new URLparser("http://www.essex.ac.uk");
        assertTrue(p.getProtocol().equals("http"));
    }

    @Test
    public void test_basic_ftp_protocol() {
        URLparser p = new URLparser("ftp://ftp.essex.ac.uk");
        assertTrue(p.getProtocol().equals("ftp"));
    }

    @Test
    public void test_basic_generic_protocol() {
        URLparser p = new URLparser("xyz://www.abc.com");
        assertTrue(p.getProtocol().equals("xyz"));
    }

    @Test
    public void test_simple_site() {
        URLparser p = new URLparser("http://www.essex.ac.uk");
        assertTrue(p.getSite().equals("www.essex.ac.uk"));
    }

    @Test
    public void test_simple_with_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/index.html");
        assertTrue(p.getSite().equals("www.essex.ac.uk"));
    }

    @Test
    public void test_simple_with_slash() {
        URLparser p = new URLparser("http://www.essex.ac.uk/");
        assertTrue(p.getSite().equals("www.essex.ac.uk"));
    }

    @Test
    public void test_simple_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/csee");
        assertTrue(p.getPathname().equals("csee"));
    }

    @Test
    public void test_complex_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/csee/staff/rpoli.html");
        assertArrayEquals("csee/staff/rpoli.html".getBytes(),p.getPathname().getBytes());
    }

    @Test
    public void test_simple_empty_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk");
        assertTrue(p.getPathname().equals(""));
    }

    @Test
    public void test_simple_single_slash_pathname() {
        URLparser p = new URLparser("http://www.essex.ac.uk/");
        assertTrue(p.getPathname().equals(""));
    }
}