package kr.co.clozet.algorithm._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;

/**
 * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
 * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어
 * 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을
 * 수도 있습니다.
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times 가 매개변수로 주어질 때,
 * 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 * <제한 사항>
 * 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하 입니다.
 * <입력 예>
 * n = 6, times = [7, 10]
 * <출력 예>
 * 28
 *
 * packageName:kr.co.clozet.algorithm._binSearch
 * fileName        :입국심사.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 입국심사 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        int n;
        int[] times;
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
                Arrays.sort(e.getTimes());
                int start = 1;
                int end = e.times[e.getTimes().length-1] * e.getN();

                while (start <= end) {
                    int sum = 0;
                    int mid = (start+end)/2;
                    for (int time : e.getTimes()) {
                        sum += mid / time;
                    }
                    if(sum >= e.getN()){ // 심사하는 사람의 수가 더 많거나 같으므로 시간을 줄일 수 있다.
                        end = mid-1;
                        e.answer = mid;
                    }else{// 심사하는 사람의 수가 적으므로 시간을 늘려야한다.
                        start = mid+1;
                    }
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
        int n = 6;
        int[] times = {7, 10};
        Solution s = Solution.builder()
                .n(n)
                .times(times)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));

    }


}




