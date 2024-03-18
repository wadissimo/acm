package codeforces.ecr61;

import chelper.io.FastScanner;
import common.Heap;

import java.io.PrintWriter;
import java.util.*;

public class D {
    class Note implements Comparable<Note>{
        long charge;
        long b;
        long rel; //charge/b
        int id;

        public Note(long charge, long b, int id) {
            this.charge = charge;
            this.b = b;
            this.id = id;
            this.rel = charge/b;
        }
        void update(long addCharge){
            charge += addCharge;
            rel = charge/b;
        }
        void reset(long a){
            charge = a;
            rel = charge/b;
        }

        @Override
        public int compareTo(Note o) {
            return Long.compare(this.rel, o.rel);
        }
    }
    boolean check(Note[] arr, int k, long x){
        Heap<Note> heap = new Heap<>(arr);
        for (int i = 0; i < k && heap.size > 0; i++) {
            Note first = heap.first();
            if(first.rel < i)
                return false;
            if(first.rel > k-1)
                return true;
            first.update(x);
            heap.moveDown(0);
        }
        for (int i = 0; i < heap.size; i++) {
            if(((Note)heap.h[i]).rel < k-1)
                return false;
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        long[] a = in.nal(n);
        long[] b = in.nal(n);
        ArrayList<Note> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Note note = new Note(a[i], b[i], i);
            if(note.rel < k-1)
                list.add(note);
        }
        Collections.sort(list);
        Note[] arr = new Note[list.size()];
        int ai = 0;
        for (Note note : list) {
            arr[ai++] = note;
        }
        long max = 2_000_000_000_000L;
        long left = 0, right = max;
        while(left < right){
            long mid = (left+right)/2;
            Note[] copy = Arrays.copyOf(arr, arr.length);
            if(!check(copy, k,mid)){
                left = mid+1;
            } else
                right = mid;
            for (Note note : arr) {
                note.reset(a[note.id]);
            }
        }
        if(left == max)
            out.println(-1);
        else
            out.println(left);

    }
}
