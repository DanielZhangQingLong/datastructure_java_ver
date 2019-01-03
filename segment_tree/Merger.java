package com.daniel.datastructures.segment_tree;

public interface Merger<E> {
    E merge(E a, E b);
}
