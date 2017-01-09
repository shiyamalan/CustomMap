package com.custom.datastructure;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class MyMapTest extends TestCase
{

  @Override
  protected void setUp() throws Exception
  {

    super.setUp();
  }

  public void testPut_withSameKeyValues()
  {
    MyMap<String, String> myMap = new MyMap<String, String>();
    myMap.put("Ac", "shiyam");
    myMap.put("Ac", "shiyamNew");

    assertEquals("shiyamNew", myMap.get("Ac"));
  }
  
  public void testPut_withSameHashCode()
  {
    MyMap<String, String> myMap = new MyMap<String, String>();
    myMap.put("Ac", "shiyam");
    myMap.put("Bb", "shiyamNew");

    assertEquals("shiyam", myMap.get("Ac"));
    assertEquals("shiyamNew", myMap.get("Bb"));
  }
  
  public void testPut_withDifferentKeyValues()
  {
    MyMap<String, String> myMap = new MyMap<String, String>();
    myMap.put("Ac", "shiyam");
    myMap.put("Ba", "shiyamNew");

    assertEquals("shiyam", myMap.get("Ac"));
    assertEquals("shiyamNew", myMap.get("Ba"));
  }
  
}
