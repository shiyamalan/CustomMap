package com.custom.datastructure;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      MyMap<String, String> datastureImpl = new MyMap<String, String>();

      datastureImpl.put("Ac", "shiyam");
      datastureImpl.put("Bb", "Mine");
      datastureImpl.put("Bb1", "MyMom");
      datastureImpl.put("Ac", "new_shiyam");
      datastureImpl.put("Bb", "new_Mine");

      System.out.println(datastureImpl.get("Ac"));
      System.out.println(datastureImpl.get("Bb"));
      System.out.println(datastureImpl.get("Bb1"));
    }
}
