import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i=0; i<nums.length; i++){
            int numberToFind = target - nums[i];
            if(map.containsKey(numberToFind)){
                return new int[] {map.get(numberToFind), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {}; // Return an empty array if no solution is found
    }
}
