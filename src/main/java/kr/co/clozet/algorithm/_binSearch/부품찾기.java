package kr.co.clozet.algorithm._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;

/**
 * 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 어느 날 손님이 M개 종류의 부품을 대량으로 구매
 * 하겠다며 당일 날 견적서를 요청했다. 사장님은 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성
 * 해야 한다. 이때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자.
 * 예를 들어, 가게의 부품이 총 5개일 때 부품 번호가 다음과 같다고 하자.
 * N = 5
 * [8, 3, 7, 9, 2]
 * 손님은 총 3개의 부품이 있는지 확인 요청했는데, 부품 번호는 다음과 같다.
 * M = 3
 * [5, 7, 9]
 * 이 때, 부품이 있으면 YES, 없으면 NO를 출력한다.
 * [NO YES YES]
 * <입력 조건>
 * 첫번째 줄에 가게의 부품 총 개수 N이 입력된다.
 * 두번째 줄에 가게에 있는 부품의 부품번호가 입력된다.
 * 세번째 줄에 손님이 원하는 부품의 총 개수 M이 입력된다.
 * 네번째 줄에 손님이 원하는 부품의 부품번호가 입력된다.
 * <출력 조건>
 * 첫째 줄에 공백으로 구분하여 각 부품이 존재하면 YES, 없으면 NO를 출력한다.
 *
 * packageName:kr.co.clozet.algorithm._binSearch
 * fileName        :부품찾기.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            : https://velog.io/@yeon/TIL-3%EC%9B%94-24%EC%9D%BC-rtikc6e6
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 부품찾기 {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }

    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        int[] components;
        int[] askedComp;
        int n;
        int m;
        String[] result;
        @Override
        public String toString(){
            return String.format("%s", result);
        }
    }

    @FunctionalInterface
    public interface  SolutionService{
        Solution solution(Solution s);
    }

    static class Service {
        Solution test(Solution s) {
            SolutionService f = e -> {
                int[] components = new int[e.getN()];
                int[] askedComp = new int[e.getM()];
                String[] result = new String[e.getM()];
                Arrays.sort(e.getComponents());
                for (int i=0; i<e.getM(); i++) {
                    if (binarySearch(components, askedComp[i], 0, e.getN() - 1) >= 0) {
                        result[i] = "YES";
                    } else result[i] = "NO";
                }
                return Solution.builder()
                        .components(e.getComponents())
                        .askedComp(e.getAskedComp())
                        .result(e.getResult())
                        .build();
            };
            return f.solution(s);
        }
    }
    @Test
    public void testSolution(){
        int[] components = {8, 3, 7, 9, 2};
        int[] askedComp = {5, 7, 9};
        int n = 5;
        int m = 3;
        Solution s = Solution.builder()
                .components(components)
                .askedComp(askedComp)
                .n(n)
                .m(m)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("가게의 부품 총 개수");
//        int n = sc.nextInt();
//        int[] components = new int[n];
//        sc.nextLine();
//        System.out.println(n+"개의 부품번호");
//        for (int i = 0; i < n; i++) {
//            components[i] = sc.nextInt();
//        }
//        sc.nextLine();
//        System.out.println("손님이 문의한 부품 총 개수");
//        int m = sc.nextInt();
//        int[] askedComp = new int[m];
//        sc.nextLine();
//        System.out.println(m+"개의 부품번호");
//        for (int i = 0; i < m; i++) {
//            askedComp[i] = sc.nextInt();
//        }
//
//        String[] results = new String[m];
//
//        // 정렬
//        Arrays.sort(components);
//
//        // 이진탐색
//        for (int i = 0; i < m; i++) {
//            if (binarySearch(components, askedComp[i], 0, n - 1) >= 0) {
//                results[i] = "YES";
//            } else results[i] = "NO";
//        }
//
//        for (String result : results) {
//            System.out.print(result + " ");
//        }
//    }
}
