package com.custom.datastructure;

import com.custom.internal.datastructure.Entity;
import com.custom.internal.datastructure.Node;

public class MyMap<K, V> 
{
  private static final int DEFAULT_SIZE = 1000;

  Object myBucket[];

  public MyMap(int mapSize)
  {
    myBucket = new Object[mapSize];
  }

  public MyMap()
  {
    this(DEFAULT_SIZE);
  }

  public V get(K key)
  {
    if (key == null)
    {
      return null;
    }
    else
    {
      int hashCode = getArrayIndex(getHashCode(key));
      Node<K, V> myNode = (Node<K, V>) myBucket[hashCode];

      if (myNode == null)
      {
        return null;
      }
      else if (myNode.entity.key.equals(key))
      {
        return myNode.entity.value;
      }
      else
      {
        while (myNode.next != null)
        {
          myNode = myNode.next;
          if (myNode.entity.key.equals(key))
          {
            return myNode.entity.value;
          }
        }
        return null;
      }
    }

  }

  public void put(K key, V value)
  {
    if (key == null)
    {
      return;
    }
    int hashCode = getArrayIndex(getHashCode(key));

    Node<K, V> node = new Node<K, V>();

    if (myBucket[hashCode] == null)
    {
      node.next = null;
      node.entity = getEntity(key, value);
      myBucket[hashCode] = node;
    }
    else
    {

      Node<K, V> headNode = (Node<K, V>) myBucket[hashCode];

      while (headNode.next != null)
      {
        if (existsKey(key, value, headNode))
        {
          return;
        }
        headNode = headNode.next;

        if (existsKey(key, value, headNode))
        {
          return;
        }
      }
      if (existsKey(key, value, headNode))
      {
        return;
      }
      node.entity = getEntity(key, value);
      node.next = null;
      headNode.next = node;
    }
  }

  private boolean existsKey(K key, V value, Node<K, V> headNode)
  {
    if (key.equals(headNode.entity.key))
    {
      headNode.entity = getEntity(key, value);
      return true;
    }
    return false;
  }

  private int getHashCode(K key)
  {
    if (key instanceof String)
    {
      int code = 0;
      char charArray[] = ((String) key).toCharArray();
      for (char ch : charArray)
      {
        code += ch;
      }
      return code;
    }

    else
    {
      return key.hashCode();
    }
  }

  private int getArrayIndex(int hashCode)
  {

    return hashCode % myBucket.length < 0 ? (-1) * (hashCode % myBucket.length) : hashCode % myBucket.length;
  }

  private Entity<K, V> getEntity(K key, V v)
  {
    Entity<K, V> entity = new Entity<K, V>();
    entity.key = key;
    entity.value = v;

    return entity;
  }

 
}
