package com.denchevgod.ds.trees;

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {

    TreeNode<T> root();

    TreeNode<T> parent(TreeNode<T> treeNode);

    Iterable<TreeNode<T>> children(TreeNode<T> treeNode);

    int childCnt(TreeNode<T> treeNode);

    boolean isInternal(TreeNode<T> treeNode);

    boolean isExternal(TreeNode<T> treeNode);

    boolean isRoot(TreeNode<T> treeNode);

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    Iterable<TreeNode<T>> nodes();
}
