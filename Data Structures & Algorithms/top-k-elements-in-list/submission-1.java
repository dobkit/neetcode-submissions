class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // QuickSelect Approach

        // Step 1: Build Frequency Map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int mapSize = freqMap.size();

        // Step 2: Build unique array
        int[] uniqArr = new int[mapSize];
        int idx = 0;
        for (int key : freqMap.keySet()) {
            uniqArr[idx++] = key;
        }

        // Step 3: Quick Select
        int target = mapSize - k;
        quickSelect(uniqArr, 0, mapSize - 1, target, freqMap);

        // Step 4: Collect result
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = uniqArr[target + i];
        }
        
        return res;
    }

    private void quickSelect(int[] arr, int left, int right, int k, Map<Integer, Integer> freqMap) {
        if (left >= right) return;

        int pivotIdx = partition(arr, left, right, freqMap);

        if (pivotIdx == k) return;
        else if (pivotIdx < k) quickSelect(arr, pivotIdx + 1, right, k, freqMap);
        else if (pivotIdx > k) quickSelect(arr, left, pivotIdx - 1, k, freqMap);
    }

    private int partition(int[] arr, int left, int right, Map<Integer, Integer> freqMap) {
        int storedIdx = left;
        int pivotFreq = freqMap.get(arr[right]);

        for(int i = left; i < right; i++){
            int leftFreq = freqMap.get(arr[i]);
            if (leftFreq < pivotFreq) {
                swap(arr, storedIdx, i);
                storedIdx++;
            }
        }

        swap(arr, storedIdx, right);
        return storedIdx;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
