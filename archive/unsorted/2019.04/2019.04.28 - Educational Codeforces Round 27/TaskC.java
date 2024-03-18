package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class TaskC {
    class Event{
        int x;
        boolean start;

        public Event(int x, boolean start) {
            this.x = x;
            this.start = start;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        Event[] e = new Event[2*n];
        for (int i = 0; i < n; i++) {
            e[i*2] = new Event(in.ni(), true);
            e[i*2+1] = new Event(in.ni(), false);
        }
        Arrays.sort(e, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                if(e1.x == e2.x){
                    return -Boolean.compare(e1.start, e2.start);
                } else
                    return Integer.compare(e1.x, e2.x);
            }
        });
        int running = 0;
        for (Event event : e) {
            if(event.start)
                running++;
            else
                running--;
            if(running > 2){
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
