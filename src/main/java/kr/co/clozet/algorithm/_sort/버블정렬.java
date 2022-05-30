package kr.co.clozet.algorithm._sort;

import kr.co.clozet.algorithm._bruteForce.계산기;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Random;
/**
 * packageName:kr.co.clozet.algorithm._sort
 * fileName        :버블정렬.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 버블정렬 {
    @Data
    @AllArgsConstructor
    static class Solution{


        @Override public String toString(){
            Random random = new Random();
            int[] arr = new int[100];
            for(int i = 0; i < arr.length; i++) {

                for(int j = 0 ; j < arr.length - i - 1 ; j++) {

                    if(arr[j] > arr[j+1]) {

                        int temp = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = temp;

                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){

    }
}
