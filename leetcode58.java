class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        s = s.trim();
        char[] sA = s.toCharArray();
        int found = -1;
        for (int i = sA.length - 1; i >= 0; i --){
            if (sA[i] == ' '){
                found = i;
                break;
            }
        }
        
        if (found == -1){
            return s.length();
        }

        return sA.length - 1 - found;
        
    }
}

// trim().... You gotta have to be more familiar with JAVA!

// here is the shorter version

public int lengthOfLastWord(String s) {
	s = s.trim();
    int lastIndex = s.lastIndexOf(' ') + 1;
    return s.length() - lastIndex;        
}