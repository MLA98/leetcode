class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] cellsNext = new int[8];
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int loopEnd = 0;
        for(int i = 0; i < N; i ++){
            cellsNext[0] = 0;
            cellsNext[7] = 0;
            for(int j = 1; j < cells.length - 1; j ++){
                cellsNext[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            String setKey = "";
            for(int k = 0; k < cells.length; k ++){
                setKey += Integer.toString(cellsNext[k]);
                cells[k] = cellsNext[k];
            }
            if(set.contains(setKey)){
                loopEnd = i;
                break;
            }
            else{
                set.add(setKey);
                list.add(setKey);
            }
        }
        
        
        if(loopEnd == 0){
            return cellsNext;
        }
        // System.out.println(loopEnd);
        // System.out.println(set.size());
        // for(String heyehye: list){
        //     System.out.println(heyehye);
        // }
        String ansString = list.get((N - 1) % (loopEnd));
        for(int i = 0; i < ansString.length(); i ++){
            cellsNext[i] = ansString.charAt(i) - '0';
        }
        return cellsNext;
    }
}