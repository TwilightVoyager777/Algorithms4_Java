package leetcode.editor.en.ClassicDataStructureAlgorithms.ClassicStackQueueAlgorithms0818.StackExercises;

import java.util.*;

public class MaximumFrequencyStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        int maxFreq = 0;
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();

        public FreqStack() {
            
        }
        
        public void push(int val) {
            int freq = valToFreq.getOrDefault(val, 0) + 1;
            valToFreq.put(val, freq);
            freqToVals.putIfAbsent(freq, new Stack<>());
            freqToVals.get(freq).push(val);
            maxFreq = Math.max(maxFreq, freq);
        }
        
        public int pop() {
            Stack<Integer> vals = freqToVals.get(maxFreq);
            int v = vals.pop();
            int freq = valToFreq.get(v) - 1;
            valToFreq.put(v, freq);
            if (vals.isEmpty()) {
                maxFreq--;
            }
            return v;
        }
    }
    
    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */
    //leetcode submit region end(Prohibit modification and deletion)


}