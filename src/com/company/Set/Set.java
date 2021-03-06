package com.company.Set;

import java.util.Collection;
import java.util.Iterator;

public interface Set<T> {
    boolean add(T element);
    boolean addAll(Collection<T> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<T> c);
    boolean equals(Object o);
    int hashCode();

    Iterator iterator();
    boolean remove(Object o);
    boolean removeAll(Collection<T> c);
    boolean retainsAll(Collection<T> c);
    boolean isEmpty();
    int size();
    Object[] toArray();

}
