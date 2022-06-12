package kr.co.clozet.algorithm._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
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
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
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

}
