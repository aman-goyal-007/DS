import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Test {
    public static class Pair {
        public int first;
        public int second;
    }
    public static Pair getAns(int N, int u, int v, int ui[], int vi[], int wi[]) {
        Pair res = new Pair();
        


        return res;
    }

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\sample.txt")));

        int N = Integer.parseInt(br.readLine());
        int[] ui = new int [N];
        int[] vi = new int [N];
        int[] wi = new int [N];
        for (int i = 1; i < N; i+=1) {
            String[] inp = br.readLine().split(" ");
            ui[i] = Integer.parseInt(inp[0]);
            vi[i] = Integer.parseInt(inp[1]);
            wi[i] = Integer.parseInt(inp[2]);
        }
        int Q = Integer.parseInt(br.readLine());
        while(Q > 0) {
            Q-=1;
            String[] inp = br.readLine().split(" ");
            int u = Integer.parseInt(inp[0]);
            int v = Integer.parseInt(inp[1]);
            Pair ans = getAns(N, u, v, ui, vi, wi);
            System.out.println(ans.first + " " + ans.second);
        }
    }
}