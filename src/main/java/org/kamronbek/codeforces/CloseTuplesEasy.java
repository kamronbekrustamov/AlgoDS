package org.kamronbek.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class CloseTuplesEasy {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T=fs.nextInt();
        for (int tt=0; tt<T; tt++) {
            int size = fs.nextInt();
            int[] arr = fs.readArray(size);
            if (size < 3) {
                System.out.println(0);
                continue;
            }
            int res = 0;
            sort(arr);
            for (int i = 0; i < size - 2; i++)  {
                for (int j = i + 2; j < size; j++ ) {
                    if (arr[j] - arr[i] <= 2) {
                        res += j - i - 1;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(res);

        }
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}

