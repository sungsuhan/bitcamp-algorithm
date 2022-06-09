package kr.co.clozet.algorithm._binSearch;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


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

    public static int binarySearch(int[] arr, int target, int start, int end) {
        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] > mid)
                    total += arr[i] - mid;
            }
            if(total < target)
                end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("떡의 갯수");
        int n = sc.nextInt();
        System.out.println("원하는 떡의 길이");
        int m = sc.nextInt();
        sc.nextLine(); // 버퍼 제거

        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(n+"개의 개별 떡 높이");
        for(int i = 0; i < n; i++)
        {
            int temp = sc.nextInt();
            arrayList.add(temp);
        }

        Collections.sort(arrayList);
        int pr = binarySearch(arrayList.stream().mapToInt(i -> i).toArray(), m, 0, arrayList.get(n-1));
        System.out.println(pr);
    }


}

