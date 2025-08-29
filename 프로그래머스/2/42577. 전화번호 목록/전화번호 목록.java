import java.util.*;
import java.io.*;

class Solution {
    static HashSet<String> set;
    public boolean solution(String[] phone_book) {
        set = new HashSet<String>();
        for(String phone : phone_book) {
            set.add(phone);
        }
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(set.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        // boolean answer = true;
        return true;
    }
}