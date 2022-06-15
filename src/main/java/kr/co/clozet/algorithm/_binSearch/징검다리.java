package kr.co.clozet.algorithm._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;

/**
 * 출발지점부터 distance 만큼 떨어진 곳에 도착지점이 있습니다. 그리고 그 사이에는 바위들이 놓여있습니다.
 * 바위 중 몇 개를 제거하려고 합니다. 예를 들어, 도착지점이 25 만큼 떨어져 있고, 바위가 [2, 14, 11, 21, 17] 지점에
 * 놓여있을 때 바위 2개를 제거하면 출발지점, 도착지점, 바위 간의 거리가 아래와 같습니다.
 * 제거한 바위의 위치 / 각 바위 사이의 거리 / 거리의 최솟값
 *    [21, 17]        [2, 9, 3, 11]          2
 *    [2, 21]         [11, 3, 3, 8]          3
 *    [2, 11]         [14, 3, 4, 4]          3
 *    [11, 21]        [2, 12, 3, 8]          2
 *    [2, 14]         [11, 6, 4, 4]          4
 * 위에서 구한 거리의 최솟값 중에 가장 큰 값은 4입니다.
 * 출발지점부터 도착지점까지의 거리 distance, 바위들이 있는 위치를 담은 배열 rocks, 제거할 바위의 수 n이 매개변수로
 * 주어질 때, 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을 return 하도록 solution 함수를 작성해리.
 * <입력 예>
 * distance = 25, rocks = [2, 14, 11, 21, 17], n = 2
 * <출력 예>
 * 4
 *
 * packageName:kr.co.clozet.algorithm._binSearch
 * fileName        :징검다리.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 징검다리 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        int distance;
        int[] rocks;
        int n;
        int answer;

        @Override
        public String toString(){
            return String.format("%d", answer);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s){
            SolutionService f = e -> {
                e.answer = 0;
                int left = 0;
                int right = e.getDistance();
                Arrays.sort(e.getRocks());
                while (left <= right) {
                    int mid = (left + right)/2;
                    int removeRocks = 0;
                    int prev = 0;

                    for (int i=0; i<e.getRocks().length; i++){
                        if (e.getRocks()[i] - prev < mid)
                            removeRocks++;
                        else
                            prev = e.getRocks()[i];
                    }
                    if(e.getDistance() - e.getRocks()[e.getRocks().length-1] < mid)
                        removeRocks++;
                    if (removeRocks <= e.getN()) {
                        e.answer = mid;
                        left = mid + 1;
                    }
                    else
                        right = mid - 1;
                }
                return Solution.builder()
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        Solution s = Solution.builder()
                .distance(distance)
                .rocks(rocks)
                .n(n)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }









}
