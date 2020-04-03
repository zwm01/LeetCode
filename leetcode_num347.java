package Array.num347;

import java.util.*;
/*思路：先用哈希表记录各数字出现的次数，然后遍历哈希表，用优先级队列筛选出
* 出现频率前k的数字
* 时间复杂度：O(N)
* 空间复杂度：O(N)*/
class data{
    int val;
    int count;

    public data(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        PriorityQueue<data> queue=new PriorityQueue<>(new Comparator<data>() {
            @Override
            public int compare(data o1, data o2) {
                return o1.count-o2.count;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]))
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            else
                hashMap.put(nums[i],1);
        }
        for (Integer key : hashMap.keySet()) {
            int count=hashMap.get(key);
            if (queue.size()<k)
                queue.add(new data(key,count));
            else if (queue.peek().count<count){
                queue.poll();
                queue.add(new data(key,count));
            }
        }
        while (!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }
}