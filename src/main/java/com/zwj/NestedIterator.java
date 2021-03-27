package com.zwj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:zengwenjie
 * @Date:2021/3/23 22:06
 */
public class NestedIterator implements Iterator<Integer> {
    private List nestedList;
    private ArrayDeque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        //把列表直接放栈里
        stack = new ArrayDeque<NestedInteger>(nestedList);
    }


    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.size() == 0) {
            return false;
        }
        //如果栈顶不是数，就把栈顶的列表里的所有元素push入栈
        while (stack.size()!=0&&!stack.peek().isInteger()) {
            List<NestedInteger> nestedList = stack.pop().getList();
            //如果弹出的列表是空的，继续循环
            if (nestedList.size() == 0) {
                continue;
            }
            //从后面往前push入栈，保证pop时拿到的是第一个元素
            for (int i = nestedList.size()-1; i >=0; i--) {
                stack.push(nestedList.get(i));
            }
        }
        return stack.size() != 0;
    }
}
