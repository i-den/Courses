package com.denchevgod.ds.trees;

import com.denchevgod.ds.trees.AbstractTree.TreeNode;

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {
    TreeNode<T> root();

    TreeNode<T> parent(TreeNode<T> node) throws IllegalArgumentException;

    Iterable<TreeNode<T>> children(TreeNode<T> node) throws IllegalArgumentException;

    int childCnt(TreeNode<T> node) throws IllegalArgumentException;

    boolean isInternal(TreeNode<T> node) throws IllegalArgumentException;

    boolean isExternal(TreeNode<T> node) throws IllegalArgumentException;

    boolean isRoot(TreeNode<T> node) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    Iterable<TreeNode<T>> positions();
}
