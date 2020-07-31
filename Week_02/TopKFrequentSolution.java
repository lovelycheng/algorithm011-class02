package Week_02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chengtong
 * @date 2020/7/29 15:46
 */
public class TopKFrequentSolution {
    /**
     * 维护一个优先队列；
     * 两个map
     */
    class Node{
        Node next;
        Node prev;
        int key;
        int fle;
    }

    int[] ints = new int[16];

    public int[] topKFrequentUsePriorityQueue(int[] nums, int k) {

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue =
                new PriorityQueue<>(Comparator.comparing(Map.Entry<Integer,Integer>::getValue).reversed());

        // 大顶堆

        HashMap<Integer,Integer> frequentMap = new HashMap<>();
        for (int i:nums){
            frequentMap.put(i,frequentMap.getOrDefault(i,0)+1);
        }

        priorityQueue.addAll(frequentMap.entrySet());

        int[] returns = new int[k];
        for(int i =0;i< k ;i++){
            returns[i] = priorityQueue.poll().getKey();
        }
        return returns;
    }


    HashMap<Integer,Node> keyToNode = new HashMap<>();

    Node head;
    Node tail;

    public int[] topKFrequent(int[] nums, int k) {

        for (int i : nums){
            if(!keyToNode.containsKey(i)){
                Node node =new Node();
                if(head == null){
                    head = tail = node;
                }else {
                    node.prev =tail;
                    tail.next = node;
                    tail = node;
                }
                node.fle =1;
                node.key =i;

                keyToNode.put(i,node);
            }else {
                Node node = keyToNode.get(i);
                node.fle +=1;
                Node prev = node.prev;
                if(prev != null){
                    while(prev.fle < node.fle){
                        if(prev.prev == null){
                            //prev.prev - node
                            node.prev = null;

                            //prev - node.next
                            prev.next = node.next;
                            node.next.prev = prev;

                            //prev - node
                            prev.prev = node;
                            node.next = prev;

                            head = node;
                            break;
                        }
                        //prev.prev - node
                        prev.prev.next = node;
                        node.prev = prev.prev;

                        //prev - node.next
                        prev.next = node.next;
                        if(node.next == null){
                            tail = prev;
                        }else {
                            node.next.prev = prev;
                        }


                        //prev - node
                        prev.prev = node;
                        node.next = prev;

                        prev = node.prev;
                    }
                }

            };
        }
        int[] ints = new int[k];
        int i=0;
        while(i<k){
            ints[i] = head.key;
            i++;
            head = head.next;
        }
        return ints;

    }


    public static void main(String[] args) {
        TopKFrequentSolution solution = new TopKFrequentSolution();
        int[] ints = {4,1,-1,2,-1,2,3};
        int[] ss = solution.topKFrequentUsePriorityQueue(ints,2);
    }
}
