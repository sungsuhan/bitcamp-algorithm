package kr.co.clozet.algorithm._sort;

<<<<<<< HEAD
=======
import kr.co.clozet.algorithm._greedy.최대최소값;
>>>>>>> 029fc03af7f5fdeb4a1573cb623bfc7febbdff2f
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
* 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 *
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 * 입출력 예
 * array    commands   return
 * [1, 5, 2, 6, 3, 7, 4]    [[2, 5, 3], [4, 4, 1], [1, 7, 3]]  [5, 6, 3]
 * 입출력 예 설명
 * [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

 * packageName:kr.co.clozet.algorithm._sort
 * fileName        :K번째수.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class K번째수 {
<<<<<<< HEAD
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
=======

    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
>>>>>>> 029fc03af7f5fdeb4a1573cb623bfc7febbdff2f
    public static class Solution{
        private int[] array;
        int[][] commands;
        private int[] answer;

        @Override
        public String toString() {
            return String.format("array: %s\ncommands: %s\nreturn: %s\n",
                    Arrays.toString(array), Arrays.deepToString(commands), Arrays.toString(answer));
        }
    }

    @FunctionalInterface
    public interface SolutionService {
        Solution solution(Solution s);
    }

    class Service {
        Solution test(Solution s) {
            SolutionService f = e -> {
                int[] answer = new int[3];
                int answerIndex = 0;
                for (int[] command : e.getCommands()) {
                    int[] temp = new int[command[1] - command[0] + 1];
                    int tempIndex = 0;
                    for (int i = command[0]; i <= command[1]; i++) {
                        temp[tempIndex++] = e.getArray()[i - 1];
                    }
                    Arrays.sort(temp);
                    answer[answerIndex++] = temp[command[2] - 1];
                }
                return Solution.builder()
                        .array(e.getArray())
                        .commands(e.getCommands())
                        .answer(answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    void testSolution(){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        Solution s = Solution.builder()
                .array(array)
                .commands(commands)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));


    }

<<<<<<< HEAD
=======



>>>>>>> 029fc03af7f5fdeb4a1573cb623bfc7febbdff2f
}
