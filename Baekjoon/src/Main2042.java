import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2042 {

    static class SegmentTree{
        long[] segment, input;
        int N, left, right, index;
        long val;

        SegmentTree(int N) {
            // 완전 이진 트리 생성
            int height = (int)Math.ceil(Math.log(N) / Math.log(2));
            int max = 2 << height;
            segment = new long[max];

            // 입력값 배열 생성
            this.N = N;
            input = new long[N];
        }

        void init(int node, int start, int end){
            // Leaf Node
            if(start == end){
                segment[node] = input[start];
                return;
            }

            // Non-Leaf Node
            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            segment[node] = segment[node * 2] + segment[node * 2 + 1];
        }

        void updateInit(int index, long value){
            this.index = index;
            this.val = value;
            update(1, 0, N-1);
        }

        private void update(int node, int start, int end){
            // 범위를 넘어가는 값은 보지 않음
            if(index < start || index > end)
                return;

            // Leaf Node
            if(start == end){
                input[start] = val;
                segment[node] = val;
                return;
            }

            // Non-Leaf Node
            int mid = (start + end) / 2;
            update(node * 2, start, mid);
            update(node * 2 + 1, mid + 1, end);
            segment[node] = segment[node * 2] + segment[node * 2 + 1];
        }

        long queryInit(int left, int right){
            this.left = left;
            this.right = right;
            return query(1, 0, N - 1);
        }

        private long query(int node, int start, int end){
            if(left > end || right < start)
                return 0;

            if(left <= start && end <= right)
                return segment[node];

            int mid = (start + end) / 2;
            long l_val = query(node * 2, start, mid);
            long r_val = query(node * 2 + 1, mid + 1, end);
            return l_val + r_val;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        // SegmentTree Instance 생성
        SegmentTree segmentTree = new SegmentTree(N);

        // 데이터를 입력받음
        for(int i = 0 ; i < N ; i++){
            segmentTree.input[i] = Long.parseLong(br.readLine());
        }

        // SegmentTree 의 초기값 구성
        segmentTree.init(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            // Update
            if(operator == 1){
                int target_index = Integer.parseInt(st.nextToken());
                long update_number = Long.parseLong(st.nextToken());
                segmentTree.updateInit(target_index - 1, update_number);
            }
            // Query
            else{
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                long sum = segmentTree.queryInit(start - 1, end - 1);
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }

}
