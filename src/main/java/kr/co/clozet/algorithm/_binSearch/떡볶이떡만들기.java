package kr.co.clozet.algorithm._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * 오늘은 떡볶이 떡을 만드는 날이다. 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한 봉지 안에 들어가는
 * 떡의 총 길이는 절단기로 잘라서 맞춰준다.
 * 절단기의 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H위의 부분이 잘릴 것이고,
 * 낮은 떡은 잘리지 않는다. 이걸 처리 안 해줘서 시간을 허비했다. 예를 들어 높이가 19, 14, 10, 17cm인 떡이 나란히 있고
 * 절단기 높이를 15cm로 지정하면 자른 뒤 떡의 높이는 15, 14, 10, 15cm가 될 것이다.
 * 잘린떡의 길이는 차례대로 4, 0, 0, 2cm 이다. 손님은 6cm 만큼의 길이를 가져간다.
 * 손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M 만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는
 * 프로그램을 작성하시오.
 * <제한사항>
 * 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다. (1<=N<=1,000,000, 1<=M<=2,000,000,000)
 * 둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M 이상이므로, 손님은 필요한 양만큼 떡을 사갈 수 있다.
 * 높이는 10억보다 작거나 같은 양의 정수 또는 0 이다.
 * <입력예시>
 * 4 6
 * 19 15 10 17
 * <출력예시>
 * 15
 *
 * packageName:kr.co.clozet.algorithm._binSearch
 * fileName        :떡볶이떡만들기.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            : https://velog.io/@ikkoun/%EB%96%A1%EB%B3%B6%EC%9D%B4-%EB%96%A1-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EB%AC%B8%EC%A0%9C
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/

public class 떡볶이떡만들기 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        int n;
        int m;
        int[] arr;
        int result;

        @Override
        public String toString(){
            return String.format("%d", result);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s){
            SolutionService f = e ->{
                int start = 0;
                int end = (int) 1e9;
                e.result = 0;
                while (start <= end) {
                    long total = 0;
                    int mid = (start+end)/2;

                    for (int i=0; i<e.getN(); i++){  //잘랐을때의 떡의 양 계산
                        if (e.getArr()[i] > mid) {
                            total += e.getArr()[i] - mid;
                        }
                    }
                    if (total < e.getM()){ // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                        end = mid-1;
                    }
                    else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                        e.result = mid;
                        start = mid + 1;
                    }
                }

                return Solution.builder()
                        .result(e.result)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 4;
        int m = 6;
        int[] arr = {19, 15, 10, 17};
        Solution s = Solution.builder()
                .n(n)
                .m(m)
                .arr(arr)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 떡의 개수(N)와 요청한 떡의 길이(M)
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        // 각 떡의 개별 높이 정보
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//
//        // 이진 탐색을 위한 시작점과 끝점 설정 (1e9 = 1*10^9)
//        int start = 0;
//        int end = (int) 1e9;
//
//        //이진 탐색 수행 (반복적)
//        int result = 0;
//        while (start <= end) {
//            long total = 0;
//            int mid = (start+end)/2;
//            for (int i=0; i<n; i++){
//                //잘랐을때의 떡의 양 계산
//                if (arr[i]>mid) total += arr[i] - mid;
//            }
//            if (total<m) { // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
//                end = mid-1;
//            }
//            else { // 떡의 양이 충반한 경우 덜 자르기(오른쪽 부분 탐색)
//                result = mid; // 최대한 덜 잘랐을 때가 정답이므로 여기에서 result에 기록
//                start = mid + 1;
//            }
//        }
//        System.out.println(result);
//    }


}

