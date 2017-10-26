package com.company.Map;

import javax.swing.*;
import java.util.Collection;
import java.util.Set;

public interface Map<K,V> {
    void clear();
    boolean containsKey(Object key);
    boolean ContainsValue(Object value);
    //Set<Map.Entry<K,V>>entrySet();
    boolean equals(Object o);
    int hashCode();
    V get(Object key);
    boolean isEmpty();
    int size();
    Set<K> keySet();
    V put(K key,V value);
    void putAll(Map<? extends K,? extends V>m);
    V remove(Object key);
    Collection<V>values();
}
