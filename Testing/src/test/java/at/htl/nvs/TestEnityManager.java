package at.htl.nvs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



public class TestEnityManager {
    private static EntityManager entityManager;
    private static Verify mockeVerify;

    @BeforeAll
    public static void BeforeTests(){
        mockeVerify = mock(Verify.class);
        entityManager = new EntityManager(mockeVerify);
    }

    @Test
    public void TestAddUser(){
        when(mockeVerify.verifyPassword("pass")).thenReturn(true);
        assertTrue(entityManager.addUser("david", "pass"));
    }

}

