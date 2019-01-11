package at.htl.nvs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;


public class TestVerify {

    private static Verify verify;

    @BeforeAll
    public static void BeforeTests(){
        verify = new Verify();
    }
    @Test
    public void TestVerifyPassword(){
        assertTrue(verify.verifyPassword("password"));
        assertFalse(verify.verifyPassword("pass"));
    }
}
