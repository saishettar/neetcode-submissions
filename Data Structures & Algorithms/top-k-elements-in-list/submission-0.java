class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        // Initializing freq array (indices track frequency, and each element is an array list of integers that appear i times.)
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        // Actually getting the frequency of each number in nums using a hash map. Keys are the numbers themselves, while values are the frequencies. 
        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Filling freq array with the keys (numbers) from the hashmap. 

        //count.getValue() --> the frequenies
        //count.getKey() --> the numbers 
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        // Creating the result array of size k and initializing and returning it. 
        int[] res = new int[k];
        int index = 0;

        // Start at most frequent and iterate down. 
        // i > 0 because no element will occur zero times.
        for(int i = freq.length - 1; i > 0 && index < k; i--){

            for(int n: freq[i]){

                res[index++] = n;

                if(index == k){
                    return res;
                }
            }
        }

        return res;
        
    }
}
