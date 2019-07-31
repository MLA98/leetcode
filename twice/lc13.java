class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = s.length() - 1; i >= 0;){
            char c = s.charAt(i);
            if(c == 'I'){
                sum ++;
                i --;
            }
            else if(c == 'V'){
                if(i > 0 && s.charAt(i - 1) == 'I'){
                    sum += 4;
                    i -= 2;
                }
                else{
                    sum += 5;
                    i --;
                }
            }
            else if(c == 'X'){
                if(i > 0 && s.charAt(i - 1) == 'I'){
                    sum += 9;
                    i -= 2;
                }
                else{
                    sum += 10;
                    i --;
                }
            }
            else if(c == 'L'){
                if(i > 0 && s.charAt(i - 1) == 'X'){
                    sum += 40;
                    i -= 2;
                }
                else{
                    sum += 50;
                    i --;
                }
            }
            else if(c == 'C'){
                if(i > 0 && s.charAt(i - 1) == 'X'){
                    sum += 90;
                    i -= 2;
                }
                else{
                    sum += 100;
                    i --;
                }
            }
            else if(c == 'D'){
                if(i > 0 && s.charAt(i - 1) == 'C'){
                    sum += 400;
                    i -= 2;
                }
                else{
                    sum += 500;
                    i --;
                }
            }
            else if(c == 'M'){
                if(i > 0 && s.charAt(i - 1) == 'C'){
                    sum += 900;
                    i -= 2;
                }
                else{
                    sum += 1000;
                    i --;
                }
            }
        }
        
        return sum;
    }
}

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int preVal = 0;
        int sum = 0;
        
        for(int i = s.length() - 1; i >= 0; i --){
            char c = s.charAt(i);
            if(map.get(c) < preVal){
                sum -= map.get(c);
                preVal = map.get(c);
            }
            else{
                sum += map.get(c);
                preVal = map.get(c);
            }
        }
        
        return sum;
    }
}