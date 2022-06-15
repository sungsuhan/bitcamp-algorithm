package kr.co.clozet.algorithm._dfsBfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로
 * 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할
 * 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers 가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록
 * solution 함수를 작성하시오.
 * <제한사항>
 * 컴퓨터의 개수 n은 1이상 200이하인 자연수
 * 각 컴퓨터는 0부터 n-1 인 정수로 표현
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현
 * computer[i][i]는 항상 1
 * <입출력 예시>
 * n              computer                    return
 * 3    [[1,1,0], [1,1,0], [0,0,1]]             2
 * 3    [[1,1,0], [1,1,1], [0,1,1]]             1
 *
 * packageName:kr.co.clozet.algorithm._dfsBfs
 * fileName        :네트워크.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 네트워크 {
//    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
//    public static class Solution{
//
//        @Override
//        public String toString(){
//            return String.format("");
//        }
//    }
//
//    @FunctionalInterface
//    public interface SolutionService{
//        Solution solution(Solution S);
//    }
//
//    class Service{
//        Solution test(Solution s) {
//            SolutionService f = e -> {
//
//                return Solution.builder().build();
//            };
//            return f.solution(s);
//        }
//    }
//
//    @Test
//    public void testSolution(){
//
//    }
//
//
//
//
//
//
//
//
//
//
//





}
