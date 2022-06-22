package kr.co.clozet.algorithm._dfsBfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * 크기가 NxM인 미로가 있고, 미로는 크기가 1x1인 칸으로 나누어져 있다. 미로의 각 칸에는 문자가 하나 적혀
 * 있는데, 적혀있는 문자에 따라서 다른 칸으로 이동할 수 있다.
 * 어떤 칸(r, c)에 적힌 문자가
 * U인 경우에는 (r-1, c)로 이동해야 한다.
 * R인 경우에는 (r, c+1)로 이동해야 한다.
 * D인 경우에는 (r+1, c)로 이동해야 한다.
 * L인 경우에는 (r, c-1)로 이동해야 한다.
 * 미로에서 탈출 가능한 칸의 수를 계산해보자. 탈출 가능한 칸이란, 그 칸에서 이동을 시작해서 칸에 적힌대로
 * 이동했을 때, 미로의 경계 밖으로 이동하게 되는 칸을 의미한다.
 * <입력>
 * 첫째 줄에 미로의 크기 N, M이 주어진다. 둘째 줄부터 N개의 줄에는 미로의 각 칸에 적힌 문자가 주어진다
 * <출력>
 * 첫째 줄에 탈출 가능한 칸의 수를 출력한다
 * <입력 예시>
 * 3 3
 * DDD
 * DDD
 * DDD
 * <출력 예시>
 * 9
 *
 * packageName:kr.co.clozet.algorithm._dfsBfs
 * fileName        :미로탈출.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :백준 17090, https://moons-memo.tistory.com/239
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 미로탈출 {
//    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
//    public static class Solution{
//        int[] map;
//        int[] visited;
//        boolean[] successCheck;
//        int n;
//        int m;
//
//        @Override
//        public String toString(){
//            return String.format("");
//        }
//    }
//
//    @FunctionalInterface
//    public interface SolutionService{
//        Solution solution(Solution s);
//    }
//
//    class Service{
//        Solution test(Solution s) {
//            SolutionService f = e -> {
//
//
//                return Solution.builder().build();
//            };
//            return f.solution(s);
//        }
//    }
//
//    @Test
//    public void testSolution(){
//        Solution s = Solution.builder().build();
//        Service s2 = new Service();
//        System.out.println(s2.test(s));
//    }







}
