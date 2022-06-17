package kr.co.clozet.algorithm._dfsBfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 두 개의 단어 begin, target 과 단어의 집합 words 가 있습니다. 아래와 같은 규칙을 이용하여 begin 에서 target 으로
 * 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words 에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin 이 "hit", target 가 "cog", words 가 ["hot", "dot", "dog", "lot", "log", "cog"]라면
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog" 와 같이 4단계를 거쳐 변환할 수 있습니다.
 * 두 개의 단어 begin, target 과 단어의 집합 words 가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin 을
 * target 으로 변활할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 * <제한사항>
 * begin 과 target 은 같지 않습니다.
 * 변환할 수 없는 경우에는 0을 return 합니다.
 * <입출력 예>
 * begin    target                      words                     return
 * "hit"    "cog"       ["hot","dot","dog","lot","log","cog"]       4
 * "hit"    "cog"       ["hot","dot","dog","lot","log"]             0
 *
 * packageName:kr.co.clozet.algorithm._dfsBfs
 * fileName        :단어변환.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            : https://technote-mezza.tistory.com/25
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 단어변환 {



    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        String begin;
        String target;
        String[] words;
        String now;
        int cnt;
        boolean[] visit;
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
        Solution test(Solution s) {
            SolutionService f = e -> {



                return Solution.builder()

                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        String begin = "hit";
        String target = "cog";
        String[] words ={"hot", "dot", "dog", "lot", "log"};
        Solution s = Solution.builder()
                .begin(begin)
                .target(target)
                .words(words)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));


    }







}
