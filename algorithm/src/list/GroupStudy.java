package list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class GroupStudy {


    public void q1181(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        String temp = "";
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
            if(i > 0){
                for(int j = 0; j < i; j++ ){
                    if(arr[i].length() == arr[j].length()){
                        if(arr[i].compareTo(arr[j]) < 0){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }else if(arr[i].compareTo(arr[j]) == 0){
                            arr[j] = "";
                        }
                    }
                }
            }
        };

        //1. 길이가 짧은 순서대로 정렬
        Arrays.sort(arr, (String fst, String snd) -> fst.length() - snd.length());


        // 비어있는 값 제거 후 출력
        for(int i = 0; i < n; i++){
            if(arr[i] != ""){
                System.out.println(arr[i]);
            }
        }

    }

    public void q1931(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int count = 0;
        int end = 0;
        int temp = 0;

        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < n; i ++){
            if(end <= arr[i][0]){
                end = arr[i][1];
                count++;
            }

        }

        System.out.println(count);
    }

    public void q1918(){
        Scanner sc = new Scanner(System.in);
        Deque<String> deq = new ArrayDeque<>();
        String me = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < me.length(); i++){
            char temp = me.charAt(i);

            // 문자일 경우
            if(Character.isLetter(temp)){
                sb.append(temp);

            // ( < 이 괄호면 스택에 넣고
            }else if(temp == '(') {
                deq.addFirst(String.valueOf(temp));

                // ) < 이 괄호면 전에 ( 괄호가 나왔던 곳까지 스택에서 출력해서 sb에 넣기
            }else if(temp == ')'){
                while(!deq.isEmpty() && deq.peek().charAt(0) != '('){
                    sb.append(deq.pop());
                }
                deq.pop(); // '(' 제거, 괄호 내부 연산자 처리 후 '(' 제거

            // 괄호를 제외한 연산자일 경우 스택에 쌓음, but 이전에 들어있는 연산자보다 우선순위가 높거나 같을 경우 빼기
            }else{
                while(!deq.isEmpty() && ck(deq.peek().charAt(0)) >= ck(temp)){
                    sb.append(deq.pop());
                }
                deq.addFirst(String.valueOf(temp));
            }
        }
        // 마지막에 쌓인 것 처리하기
        while(!deq.isEmpty()){
            sb.append(deq.pop());
        }
           System.out.println(sb);
    }
    static int ck(char item){
        if(item == '(') return 0;
        else if(item == '+' || item == '-') return 1;
        else return 2; // '*', '/'
    }


    public void q1166(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        double s = 0;
        double f = Math.max(Math.max(l, w), h);

        for(int i = 0 ; i < 10000 ; ++i){
            double m = (s + f) / 2;
            if((long)(l/m) * (long)(w/m) * (long)(h/m) >= n){
                s = m;
            }else{
                f = m;
            }
        }
        System.out.println(f);
    }

    public void q1966(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int point = sc.nextInt();
        Deque<Integer> deq = new ArrayDeque<>();
        int[] arr = new int[len];
        boolean ck = true;
        int code = 0;

        for(int i = 0; i < len; i++){
            deq.add(sc.nextInt());
        }

        // 덱을 순회

        int i = 0;
        int j = 0;
        while(ck){

            // 덱이 비어있을 경우
            if(deq.isEmpty()){
                ck = false;
            // 덱에 남아있는 것이 하나일 때
            }else if(deq.size() == 1){
                arr[len-1] = deq.getFirst();
                if(code == 0) code = len-1;
                ck = false;
            // 덱에 2 이상이 남아있을 때
            }else{
                int num = deq.pollFirst();
                boolean boo = false;

                for(int d : deq){
                    boo = false;
                    // 덱의 첫번째부터 순회하면서 num보다 높은 값이 있는지 확인
                    if(num < d){
                        boo = true;
                        break;
                    }
                }
                // 덱에 아직 높은 값이 존재함
                if(boo){
                    deq.add(num);
                    if(j == point){
                        point = deq.size() - 1;
                        j = 0;

                    }else{
                        j++;
                    }
                }else{
                    arr[i] = num;

                    if(j == point){
                        code = i + 1;
                    }
                    i++;
                    j++;
                }


            }

        }



        System.out.println(code);
    }

    public void q1966_1(){
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new ArrayDeque<>();
        int n = sc.nextInt();
        int m = sc.nextInt();


        for(int i = 0; i <n ; i++){
            q.offer(new int[]{sc.nextInt(),i});
        }

        int i = 0;
        while(!q.isEmpty()){
            int[] fst = q.poll();       // 첫번째 값 담기
            boolean ck = true;         // 인쇄여부

            // 돌아가면서 비교
            for(int[] nums : q){

                // 첫번째 값보다 클 경우
                if(nums[0] > fst[0]){
                    q.offer(fst);
                    ck = false;
                    break;
                }
            }

            if(ck){
                i++;
                if(fst[1] == m) {
                    break;
                }
            }

        }

        System.out.println(i);
    }


    public void q11725() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) ;
        int[][] arr = new int[n][2];
        int[] parents = new int[n+1];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        //int[] items = new int[n];


        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rNum = Integer.parseInt(st.nextToken());
            int lNum = Integer.parseInt(st.nextToken());



            List<Integer> l = new LinkedList<>();

            if(hm.get(rNum) == null){
                l.add(lNum);
                hm.put(rNum, l);
            }else{
                l.addAll(hm.get(rNum));
                l.add(lNum);
                hm.put(rNum, l);
            }

            List<Integer> r = new LinkedList<>();
            if(hm.get(lNum) == null){
                r.add(rNum);
                hm.put(lNum, r);
            }else{
                r.addAll(hm.get(lNum));
                r.add(rNum);
                hm.put(lNum, r);
            }
        }

        // 맵이 빌 때까지 반복함
        while(!hm.isEmpty()){


            Set<Integer> keySet = hm.keySet();
            for(int key : keySet){
                List<Integer> lst = new ArrayList<>();

                // 1이 최상단이기때문에 최상단 내의 value들은 각각의 배열에 삽입
                if(key == 1){
                    for(int i = 0; i < hm.get(key).size(); i++){
                        int num = (hm.get(key)).get(i);

                        parents[num-2] = key;


                        // 부모가 정해진 val은 자신이 key인 곳에서 현재 부모 삭제하기

                        hm.get(num).remove(Integer.valueOf(key));

                    }

                    // 전부 끝났으면 맵에서 해당 제거
                    hm.remove(key);
                    // for문이 새로 돌아야 하니까 break
                    break;


                }else if(hm.get(key).size() == 1){
                    int num = (hm.get(key)).get(0);


                    // 현재 아무 해당하는 키에 아무 값도 들어있지 않을 경우
                    if(parents[key-2] == 0){
                        parents[key-2] = num;
                        hm.get(num).remove(Integer.valueOf(key));
                    }else if(parents[num-2] == 0){
                        parents[num-2] = key;
                        hm.get(num).remove(Integer.valueOf(key));
                    }
                    hm.remove(key);
                    break;
                }else if(hm.get(key).size() == 0){
                    hm.remove(key);
                    break;
                }

            }
        }

        for(int i = 0; i < parents.length; i++){

            if(parents[i] != 0){
                int num = parents[i];
                System.out.println(num);
                //bw.write(i == parents.length-1 ? num+"" : num + "\n" );
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    public void q11725_1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) ;
        int[] parents = new int[n+1];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] r = new int[(n-1)*2];
        int[] l = new int[(n-1)*2];

        for(int i = 0; i < n-1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            l[i+n-1] = r[i];
            l[i] = Integer.parseInt(st.nextToken());
            r[i+n-1] = l[i];
        }

        for(int i = 0; i < r.length; i++){
            if(hm.get(r[i]) == null){
                hm.computeIfAbsent(r[i], k -> new ArrayList<>()).add(l[i]);
            }else{
                List<Integer> list = hm.getOrDefault(r[i], new ArrayList<>());
                list.add(l[i]);
                hm.put(r[i], list);
            }
        }

        int list = hm.size();
        int num = list;
        int test = 0;
        while(!hm.isEmpty()){

            if(hm.get(num) != null){
                if(num == 1){
                    for(int i : hm.get(num)){
                        parents[i] = num;
                        hm.get(i).remove(Integer.valueOf(num));
                    }
                    hm.remove(num);
                    continue;

                } else if(hm.get(num).size() == 1){
                    int dumm = hm.get(num).get(0);
                    if(parents[num] == 0){
                        parents[num] = dumm;
                    }else if(parents[dumm] == 0){
                        parents[dumm] = num;
                    }
                    hm.get(dumm).remove(Integer.valueOf(num));
                    hm.remove(num);
                    continue;
                }else if(hm.get(num).size() == 0){
                    hm.remove(num);
                    continue;
                }
            }

            System.out.println(num);

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void q11725_2() throws IOException {
        Map<Integer, List<Integer>>  map = new HashMap<>();     // 저장할 맵

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());        // 노드 갯수 입력받음
        int[] parents = new int[n+1];                   // 부모 저장
        boolean[] ck = new boolean[n+1];                // 방문여부 체크용

        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());              // 우선 키와 빈 리스트로 초기화
        }

    }

    static void DFS(int node, int parent){

    }


}

