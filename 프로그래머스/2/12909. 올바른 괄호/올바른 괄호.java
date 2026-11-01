import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack();
        if(s.charAt(0) != '(') {
            return false;
        }
        
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(0);
            } else {
                if(stack.isEmpty()) {
                    answer=false;
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        
        return answer;
    }
}