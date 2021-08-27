import java.io.*;
import java.util.*;


class Point {
    int now_value;
    int now_size;
    Point() {
        this.now_value = 0;
        this.now_size = 0;
    }
    Point(int a) {
        this.now_value = a;
        this.now_size = 0;
    }
    Point(int a, int b){
        this.now_value = a;
        this.now_size = b;
    }
}

class Solution {
    static int answer;
    static boolean[] visited;
    static int size;
    static Queue<Point> queue = new LinkedList<>();

    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        visited = new boolean[size];

        queue.add(new Point(0));
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            if(tmp.now_size == size){
                if(tmp.now_value == target){
                    answer += 1;
                }
                continue;
            }
            queue.add(new Point(tmp.now_value+numbers[tmp.now_size], tmp.now_size+1));
            queue.add(new Point(tmp.now_value-numbers[tmp.now_size], tmp.now_size+1));
        }
        
        return answer;
    }

}