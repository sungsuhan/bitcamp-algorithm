package kr.co.clozet.algorithm._dfsBfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
 * 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하라.
 * 다음의 4 x 5 얼음 틀 예시에서는 아이스크림이 총 3개가 생성된다.
 * 00110
 * 00011
 * 11111
 * 00000
 * [입력]
 * 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다.
 * 두 번째 줄부터 N + 1 번째 줄까지 얼음 틀의 형태가 주어진다.
 * 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
 * [출력]
 * 한 번에 만들 수 있는 아이스크림의 개수를 출력한다.
 * [입력예시]
 * 4 5
 * 00110
 * 00011
 * 11111
 * 00000
 * [출력예시]
 * 3
 *
 * packageName:kr.co.clozet.algorithm._dfsBfs
 * fileName        :음료수얼려먹기.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 음료수얼려먹기 {

    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{


        @Override
        public String toString(){
            return String.format("");
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s) {
          SolutionService f = e -> {


              return Solution.builder().build();
          };
          return f.solution(s);
        }
    }

    @Test
    public void testSolution(){

        Solution s = Solution.builder().build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }


}
