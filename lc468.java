class Solution {
    public String validIPAddress(String IP) {
        if(IP.contains(".") && !IP.contains(":")){
            return validIPv4(IP)? "IPv4": "Neither";
        }
        else if(IP.contains(":") && !IP.contains(".")){
            return validIPv6(IP)? "IPv6": "Neither";
        }
        else{
            return "Neither";
        }
    }
    
    private boolean validIPv4(String IP){
        if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.'){
            return false;
        }
        String[] splited = IP.split("\\.");
        
        if(splited.length !=  4){
            return false;
        }
        
        for(String ip: splited){
            if(ip.length() == 0){
                return false;
            }
            
            if(ip.charAt(0) == '0' && ip.length() > 1){
                return false;
            }
                 
            int ipInt = 0;
                
            try{
                ipInt = Integer.parseInt(ip);
            }
            catch(Exception e){
                return false;
            }
            
            if(ipInt > 255 || ipInt < 0){
                return false;
            }
            
            if(ipInt == 0 && ip.charAt(0) == '-'){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean validIPv6(String IP){
        if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':'){
            return false;
        }
        String[] splited = IP.split("\\:");
        if(splited.length != 8){
            return false;
        }
        
        for(String ip: splited){
            if(ip.length() == 0 || ip.length() > 4){
                return false;
            }
            
            char[] chars = ip.toCharArray();
            for(char c: chars){
                boolean isDigit = (c - '0') < 10 && (c - '0' >= 0);
		        boolean isUppercaseAF = (c - 'A') < 6 && (c -'A' >= 0);
		        boolean isLowerCaseAF = (c - 'a') < 6 && (c -'a' >= 0);
		        if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
			        return false;
            }    
        }
        return true;
    }
}