package kr.co.clozet.algorithm._bruteForce;

import java.util.Scanner;
/**
 * packageName:kr.co.clozet.algorithm._bruteForce
 * fileName        :팀과제.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 팀과제 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("0.종료 1.팀별 과제 2.팀장이 맡은 과제 3.큐를 담당한 사람 4.팀원별 과제 수");
            String[] arr = {"김승현",           "김윤섭",        "최민서",        "한성수",
                            "Sort",             "Stack",        "Hash",        "Heap",
                            "Binary Search",    "Queue",        "Graph",       "DFS",
                            "Brute Force",       "DP",         "Greedy",       "BFS"};
            switch (scanner.next()){
                case "0": return;
                case "1": teamSubject(arr); break;
                case "2": teamLeaderSubject(arr); break;
                case "3": queueManager(arr); break;
                case "4": subjectCountPerPerson(arr); break;
            }
        }
    } // main

    static void teamSubject(String[] arr) {

        System.out.println("Q1.팀별 과제를 출력하세요");
        String s = "";
        for (int i = 0; i< arr.length; i++) {
            if (i%4==0) {
                s += "\n";
            }
            s += i + "." + arr[i] + "\t";
        }
        System.out.println(s);

    }
    static void teamLeaderSubject (String[] arr){
        System.out.println("Q2.팀장이 맡은 과제를 출력하세요"); //예) 김윤섭 : Stack, Queue, DP
        String s = "";
        for (int i = 0; i< arr.length; i++) {
            if (arr[i].equals("김윤섭")) {
                for (int j=0; j<4; j++) {
                    s += arr[i + j*4] + "\t";
                }
                if (i==15) {break;}
            }
        }
        System.out.println(s);
    }
    static void queueManager (String[] arr) {
        System.out.println("Q3.선택한 과목의 사람을 출력하세요"); //예) 큐를 담당한 사람 : 김윤섭
        String s = "";
        for (int i = 0; i< arr.length; i++) {
            if (arr[i].equals("Queue")) {
                s += arr[i%4];
            }
        }
        System.out.println(s);
    }

    static void subjectCountPerPerson (String[] arr){
        System.out.println("Q4.팀원별 과제 수를 출력하세요"); //예) 김승현(3개) 김윤섭(3개) 최민서(3개) 한성수(3개)

        String s = "";
        int[] intArr = new int[4];
        int[] resArr = new int[4];

        for (int i=4; i<arr.length; i++) {
            int a = i%4;
            for (int j=0; j<4; j++) {
                if (a==j) {
                    intArr[j]++;
                }
                resArr = intArr;
            }
        }
        for(int i = 0; i < 4; i++){
            System.out.println(arr[i]+"("+resArr[i]+"개)");
        }

    }
}
