package com.becomejavasenior.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Роман on 14.02.2016.
 */
@RunWith(JUnit4.class)
public class RoleTest extends TestCase {

    @Test
    public void enumTestAdmin() {
        Assert.assertEquals(Role.ADMIN, Role.fromString("ADMIN"));
    }

    @Test
    public void enumTestClient() {
        Assert.assertEquals(Role.CLIENT, Role.fromString("CLIENT"));
    }

    @Test
    public void enumTestPaymaster() {
        Assert.assertEquals(Role.PAYMASTER, Role.fromString("PAYMASTER"));
    }
}
