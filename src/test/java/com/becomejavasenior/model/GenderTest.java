package com.becomejavasenior.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Roman on 15.02.2016.
 */
@RunWith(JUnit4.class)
public class GenderTest extends TestCase{

    @Test
    public void genderTestWoman(){
        Assert.assertEquals(Gender.WOMAN, Gender.fromString("WOMAN"));
    }
    @Test
    public void genderTestMan(){
        Assert.assertEquals(Gender.MAN, Gender.fromString("MAN"));
    }

}
