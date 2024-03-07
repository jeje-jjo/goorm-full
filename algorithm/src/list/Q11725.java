package list;
import java.io.*;
import java.util.*;

public class Q11725 {

    static Map<Integer, List<Integer>> graph = new HashMap<>(); // 그래프를 나타내는 맵
    static int[] parents; // 각 노드의 부모를 저장하는 배열
    static boolean[] visited; // 방문한 노드를 추적하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수를 입력받음
        parents = new int[n + 1]; // 부모 배열 초기화
        visited = new boolean[n + 1]; // 방문 배열 초기화

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>()); // 그래프의 각 노드에 대한 인접 리스트 초기화
        }

        for(int i = 0; i < n -1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향이니까 각각에 넣기
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        DFS(1,0);       // 제일 상단 노드가 1이기때문에 1 설정하고, 최상단이므로 부모 존재 x

        for(int i = 2; i <= n; i++){
            bw.write(parents[i] + "\n");
        }

        bw.flush(); // 버퍼 비우기
        bw.close(); // 버퍼 닫기
        br.close(); // 리더 닫기
    }

    // DFS
    static void DFS(int node, int parent){
        visited[node] = true;           // 들어오면, visited에 해당 노드가 방문했음을 체크함
        parents[node] = parent;         // 현재 가져온 parent 인수를 node의 parent로

        // 현재 노드의 인접 노드를 방문 -> 그래프에 있는 node를 가져와 거기에 있는 것 탐색
        for(int nei : graph.get(node)){
            // 방문하지 않은 노드라면 (현재 방문 배열에 값이 존재하지 않으면 그것의 이웃 노드를 방문)
            if(!visited[nei]){

                // 재귀호출
                DFS(nei, node);
            }
        }
    }

}
