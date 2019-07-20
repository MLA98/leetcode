class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String email: emails){
            String[] splited = email.split("@");
            String local = splited[0].replaceAll("\\.", "");
            if(local.contains("+")){
                local = local.substring(0, local.indexOf("+"));
            }
            
            sb.append(local);
            sb.append("@");
            sb.append(splited[1]);
            System.out.println(sb);
            set.add(sb);
        }
        return set.size();
    }
}