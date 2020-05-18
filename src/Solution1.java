
class Solution1 {
    public static int solution(int N, int K) {
        int result = 0;
        if (K == 0) {
            for (int i = 1; i < N; i++)
                result++;
            System.out.println("A");
        } else {

            while (N>1){
                if ((N % 2 == 0) && (K > 0)){
                    result++;
                    N = N - (N / 2);
                    System.out.println(N);
                    K--;
                    System.out.println(K);
                    System.out.println("B");
                } else {
                    result++;
                    N--;
                    System.out.println("C");

                }


            }

        }

        return result;
        // write your code in Java SE 8
    }

    public static void main(String[] args) {
        System.out.println(solution(18,2));
    }
}
