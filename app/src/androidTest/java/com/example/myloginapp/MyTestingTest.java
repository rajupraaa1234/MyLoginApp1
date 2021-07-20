package com.example.myloginapp;

import junit.framework.TestCase;

import org.junit.Test;

public class MyTestingTest extends TestCase {
       @Test
       public void test_add(){
           int expated = 30;
           int ex =30;
           int actual = MyTesting.add(10,20);

           assertEquals(expated,actual);
           assertEquals(ex,actual);
       }
}