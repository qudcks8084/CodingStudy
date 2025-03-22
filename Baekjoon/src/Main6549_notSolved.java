import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6549_notSolved {

    static class Node{
        long[] min;         // 구간의 최소 높이와 width
        long[] totalMin;    // 구간의 최소 높이
        long[] prefixMin;   // 왼쪽에서 시작하는 최소
        long[] suffixMin;   // 왼쪽에서 시작하는 최소
        long sum;           // 구간의 최대 역역
        long maxSum;        // 최대값
        long prefixSum;     // 왼쪽에서 시작하는 최대합
        long suffixSum;     // 오른쪽에서 시작하는 최대합

        // LeafNode를 생성하는 경우에 사용
        public Node(long value) {
            this.sum = value;
            this.maxSum = value;
            this.prefixSum = value;
            this.suffixSum = value;
        }

        // 기본 생성자
        public Node(){
            sum = 0;
            maxSum = Long.MIN_VALUE;
            prefixSum = Long.MIN_VALUE;
            suffixSum = Long.MIN_VALUE;
        }
    }

    static class GMSegmentTree{
        Node[] seg;
        int left, right;
        int N, index;
        long value;

        GMSegmentTree(int N){
            this.N = N;
            int height = (int) Math.ceil(Math.log(N) / Math.log(2));
            int size = 2 << height;
            seg = new Node[size];
            for(int i = 0 ; i < size ; i++){
                seg[i] = new Node();
            }
        }

        Node merge(Node left, Node right){
            Node result = new Node();

            // 전체 합계는 그냥 두 개의 합으로 넘겨줌
            result.sum = left.sum + right.sum;

            // 왼쪽에서 시작하는 합계를 계산
            result.prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);

            // 오른쪽에서 시작하는 합계를 계산
            result.suffixSum = Math.max(right.suffixSum, right.sum + left.suffixSum);

            // 왼쪽의 최대합, 오른쪽의 최대합, 두개의 중간 합을 비교
            result.maxSum = Math.max(Math.max(left.maxSum, right.maxSum), left.suffixSum + right.prefixSum);

            return result;
        }

        void init(int node, int start, int end){
            if(start == end){
                seg[node] = new Node(input[start]);
                return;
            }

            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            seg[node] = merge(seg[node * 2], seg[node * 2 + 1]);
        }

        void updateInit(int index, long value){
            this.index = index;
            this.value = value;
            update(1, 0, N - 1);
        }

        void update(int node, int start, int end) {
            if(index < start || index > end) return;

            if(start == end){
                seg[index] = new Node(value);
                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid);
            update(node * 2 + 1, mid + 1, end);
            seg[node] = merge(seg[node * 2], seg[node * 2 + 1]);
        }

        long queryInit(int left, int right){
            this.left = left;
            this.right = right;
            return query(1, 0, N - 1).maxSum;
        }

        Node query(int node, int start, int end) {
            if(start > right || end < left) return new Node();

            if(start >= left && end <= right) return seg[node];

            int mid = (start + end) / 2;
            return merge(query(node * 2, start, mid),
                    query(node * 2 + 1, mid + 1, end));
        }
    }

    static long[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        input = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        GMSegmentTree gms = new GMSegmentTree(N);
        gms.init(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int l1 = Integer.parseInt(st.nextToken()) - 1;
            int l2 = Integer.parseInt(st.nextToken()) - 1;
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            sb.append(gms.queryInit(l1, r2)).append("\n");
        }
        System.out.println(sb);
    }
}
