// Video leet :)
// Not super hard but you have to remember the way to do
// divide to solve this problem.

class Solution {
    // This problem is tricky as well.
    public String fractionToDecimal(int numerator, int denominator) {
        // edge case.
        if (numerator == 0 && denominator == 0){
            return "0";
        }
        // Check if the result is negative or not since I will change make 
        // both divisor and dividend their absolute number.
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || 
            (numerator < 0 && denominator > 0)){
            sb.append('-');
        }
        // convert them to long with human readable var name.
        long divisor =  Math.abs((long) numerator);
        long dividend =  Math.abs((long) denominator);
        sb.append(divisor / dividend);
        long remainder = divisor % dividend;
        if (remainder == 0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> recordMap = new HashMap<>();
        while(remainder != 0){
            if(recordMap.containsKey(remainder)){
                // Insert of stringbuilder is will make the interting thing 
                // be the index and make the existing character backward.
                sb.insert(recordMap.get(remainder), "(");
                sb.append(")");
                break;
            }
            recordMap.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / dividend);
            remainder = remainder % dividend;
        }
        
        return sb.toString();
    }
}

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0){
            return "";
        }
        
        boolean neg = false;
        
        if(numerator < 0 && denominator > 0){
            neg = true;
        }
        
        if(numerator > 0 && denominator < 0){
            neg = true;
        }
        
        StringBuilder quotientPart = new StringBuilder();
        StringBuilder remainderPart = new StringBuilder();
        Map<Long, Integer> findRep = new HashMap<>();
        long numerator_ = numerator >= 0 ? (long)numerator : -(long)numerator;
        long denominator_ = denominator >= 0 ? (long)denominator : -(long)denominator;
        
        long res = numerator_ / denominator_;
        long remainder = numerator_ % denominator_;
        
        if(neg){
            quotientPart.append('-');
        }
        quotientPart.append(res);
        
        
        int index = 0;
        while(remainder > 0){
            
            if(findRep.containsKey(remainder)){
                remainderPart.insert(findRep.get(remainder), "(");
                remainderPart.append(')');
                break;
            }
            else{
                findRep.put(remainder, index);
            }
            
            index ++;
            long r = remainder * 10 / denominator_;
            remainderPart.append(r);
            remainder = (remainder * 10) % denominator_;
        }
        
        if(remainderPart.length() > 0){
            return quotientPart.toString() + "." + remainderPart.toString();
        }
        
        return quotientPart.toString();
    }
}