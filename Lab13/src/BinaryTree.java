import java.util.Arrays;
public class BinaryTree {
    // TODO complete this method
    public static boolean isValid(int[] arr) {
        int level = 0;
        int counter = 0;
        int mod = 1;
        for (int x = 1; x < arr.length; x++){
            if (arr[x] == -1){
                return false;
            }
            counter++;
            if (counter % mod == 0){
                level++;
                counter = 0;
                mod = mod * 2;
            }
        }
        int sum = 1;
        for (int x = 0; x < level; x++){
            sum = sum * 2;
        }
        if (sum != arr.length){
            return false;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int x = 1; x < arr.length; x++){
            if (arr[x] > max){
                max = arr[x];
            }
            if (arr[x] < min){
                min = arr[x];
            }
        }
        boolean answer = BSTHelp(arr, 1, min, max);
        return answer;
    }
    public static boolean BSTHelp(int[] arr, int index, int min, int max){
        if (index <= 0 || index >= arr.length){
            return true;
        }
        if (arr[index] < min || arr[index] > max){
            return false;
        }
        boolean one = BSTHelp(arr, index* 2,min, arr[index]);
        boolean two = BSTHelp(arr,index*2+1,arr[index],max);
        if (!one || !two){
            return false;
        }
        return true;
    }
    public static void main (String args[]) {
        // milestone 1
        int[] arr1 = new int[]{-1,7,4,10,3,6,8,15};
        int[] arr2 = new int[]{-1,20,12,32,5,18,25,38};
        int[] arr3 = new int[]{-1,11,3,33,2,8,10,44};
        int[] arr4 = new int[]{-1,55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};
        System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
        System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
        System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
        System.out.println("arr4 valid: " + isValid(arr4));  // expected: false
    }
}
