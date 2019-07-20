class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String path: paths){
            String[] splited = path.split(" ");
            for(int i = 1; i < splited.length; i ++){
                String localPath = splited[i];
                int leftP = localPath.indexOf("(");
                int rightP = localPath.indexOf(")");
                String content = localPath.substring(leftP + 1, rightP);
                List<String> list = map.getOrDefault(content, new ArrayList<String>());
                list.add(splited[0] + "/" + localPath.substring(0, leftP));
                map.put(content, list);
            }
        }
        
        for(List<String> lists: map.values()){
            if(lists.size() > 1){
                ans.add(lists);
            }
        }
        
        return ans;
    }
}