package Week_01;

import java.util.Stack;

/**
 * @author chengtong
 * @date 2020/7/24 07:48
 */
public class TrapSolution {
    /**
     * 初始的思路，三个三个找
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int a = 0;
        for (int s = 0; s < height.length - 2; s++) {
            a += findTrap(s, height);
        }
        return a;
    }

    /**
     * 错误的地方是只向旁边挪一步。理论上要找所有。最多也就是个优化的暴力解法弃之无用。
     *
     * @param s
     * @param height
     * @return
     */
    private int findTrap(int s, int[] height) {

        int tallLeft = height[s];
        int tallBottom = height[s + 1];
        int tallRight = height[s + 2];

        if (tallBottom >= tallLeft || tallBottom >= tallRight) {
            return 0;
        }

        int area = Math.min(tallLeft, tallRight) - tallBottom;

        // try to find bigger
        int p1 = s, p2 = s + 2;
        while (true) {
            if (p1 > 0 && tallLeft <= tallRight) {
                if (height[p1 - 1] > height[p1]) {
                    int areaAddTall = height[p1 - 1] > tallRight ? tallRight - height[p1] : height[p1 - 1] - height[p1];
                    int areaAdd = areaAddTall * (p2 - p1);
                    area = area + areaAdd;
                    p1--;
                    tallLeft = height[p1];
                } else {
                    break;
                }
            } else if (p2 < height.length - 1 && tallRight < tallLeft) {
                if (height[p2 + 1] > height[p2]) {
                    int areaAddTall = height[p2 + 1] > tallLeft ? tallLeft - height[p2] : height[p2 + 1] - height[p2];
                    int areaAdd = areaAddTall * (p2 - p1);
                    area = area + areaAdd;
                    p2++;
                    tallRight = height[p2];
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println(p1 + "  " + p2 + "  area:" + area);
        return area;
    }


    private int trapStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int index = 0;
        while (index < heights.length) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[index]) {
                int currentTall = heights[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }
                int minCurrent = Math.min(heights[stack.peek()], heights[index]) - currentTall;
                int bottom = index - stack.peek() - 1;
                area += (minCurrent * bottom);
            }
            stack.push(index);
            index++;
        }
        return area;
    }

    private int trapDoubleEnd(int[] heights){
        int[] leftMaxs = new int[heights.length];
        int[] rightMaxs = new int[heights.length];

        int leftMax = 0;
        for(int i = 0;i<heights.length;i++ ){
            leftMaxs[i] = leftMax;
            if(heights[i] > leftMax){
                leftMax = heights[i];
            }
        }
        int rightMax = 0;
        for(int i = heights.length -1 ;i>=0;i-- ){
            rightMaxs[i] = rightMax;
            if(heights[i] > rightMax){
                rightMax = heights[i];
            }
        }
        int area =0;
        for (int i = 0;i<heights.length;i++){
            if(heights[i] < rightMaxs[i] && heights[i] < leftMaxs[i]){
                area += Math.min(rightMaxs[i],leftMaxs[i]) - heights[i];
            }
        }
        return area;
    }

    public static void main(String[] args) {
        TrapSolution solution = new TrapSolution();

        int[] s = {0,1,0,2,1,0,1,3,2,1,2,1};

        int area = solution.trapDoubleEnd(s);
    }

}
