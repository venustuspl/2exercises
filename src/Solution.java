import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int solution(int[] A) {
        int result1 = 0;
        int result2 = A.length;
        Set<Integer> intSet = new HashSet<>();
        for (int x : A) {
            intSet.add(x);
        }
        Set<Integer> intSetCopy =  new HashSet<>(intSet);
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (intSetCopy.contains(A[j])) {
                    intSetCopy.remove(A[j]);
                }
                result1++;
                if (intSetCopy.isEmpty()) {
                    if (result1 < result2) result2 = result1;
                    result1 = 0;
                    intSetCopy =  new HashSet<>(intSet);
                    break;
                }
            }

        }

        // write your code in Java SE 8
        return result2;
    }


    public static void main(String[] args) {
        int[] A = {7, 3, 7, 3, 1, 3, 4, 1};

        System.out.println(solution(A));
        System.out.print("b---");
        int[] B = {2, 1, 1, 3, 2, 1, 1, 3};
        System.out.println(solution(B));
        System.out.print("c----");
        int[] C = {7, 5, 2, 7, 2, 7, 4, 7};
        System.out.println(solution(C));

        int[] D = {7, 5,7,7,0};
        System.out.println("D: " + solution(D));

    }
}