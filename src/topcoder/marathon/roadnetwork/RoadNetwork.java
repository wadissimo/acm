package topcoder.marathon.roadnetwork;

import java.io.*;
import java.util.*;

public class RoadNetwork {
    int[][] pathPrice;
    int[][] path;
    int[][] minValue;
    int[][] mConn;
    int[][] pConn;
    int[][] connEdges;
    int[][] edgeCnts;
    List<Integer>[][] edgesByValues;

    LinkedList<Edge>[] g;
    LinkedList<Edge>[][] subGraph;
    Route[] routes;
    Edge[] edges;
    PriorityQueue<Edge> bestEdgesByRatio;
    int n;
    int e;
    int r;
    int INF = 1_000_000_000;
    int numMaterials;
    public static final int BF_MAX_R = 10;

    class Edge{
        int from, to;
        int m, p;
        int id;
        int rate;

        public Edge(int from, int to, int m, int p, int id) {
            this.from = from;
            this.to = to;
            this.m = m;
            this.p = p;
            this.id = id;
            this.rate = p/m;
        }
    }
    class Route{
        int id;
        int from, to, p;
        int needMaterial;
        int connPrice;
        HashSet<Integer> usedEdges = new HashSet<>();

        public Route(int id, int from, int to, int p) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.p = p;
        }
    }

    class Path{
        int from, to;
        int m, p;

        public Path(int from, int to, int m, int p) {
            this.from = from;
            this.to = to;
            this.m = m;
            this.p = p;
        }
    }

    private void dijkstraByM(int start, List<Edge>[] g){
        int[] dp = minValue[start];
        Arrays.fill(dp, INF);
        int[] price = pathPrice[start];
        int[] path = this.path[start];
        Arrays.fill(path, -1);
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.m));
        for (Edge edge : g[start]) {
            pq.offer(new Path(edge.to, start, edge.m, edge.p));
            dp[edge.to] = edge.m;
            price[edge.to] = edge.p;
            path[edge.to] = start;
        }
        while(!pq.isEmpty()){
            Path top = pq.poll();
            if(dp[top.from] < top.m) continue;
            for (Edge edge : g[top.from]) {
                if(dp[top.from]+edge.m < dp[edge.to]){
                    dp[edge.to] = dp[top.from]+edge.m;
                    price[edge.to] = price[top.from] + edge.p;
                    path[edge.to] = top.from;
                    pq.offer(new Path(edge.to, start, dp[edge.to], price[edge.to]));
                }
            }
        }
    }



    private void processRoutes(){
        boolean[] used = new boolean[r];
        List<Route>[] rg = new List[n];
        for (int i = 0; i < n; i++) {
            rg[i] = new LinkedList<>();
        }
        for (Route route : routes) {
            if(!rg[route.from].isEmpty()){
                rg[route.from].add(route);
            } else
                rg[route.to].add(route);
        }
        for (int i = 0; i < n; i++) {
            if(rg[i].isEmpty()) continue;
            for (int ratio = 5; ratio > 0 ; ratio--) {
                dijkstraByM(i, subGraph[ratio]);
                for (Route route : rg[i]) {
                    if(!used[route.id]){
                        if(i == route.from && path[i][route.to] != -1){
                            used[route.id] = true;
                            int cur = route.to;
                            while(cur != route.from){
                                int next = path[i][cur];
                                route.usedEdges.add(connEdges[cur][next]);
                                route.needMaterial += edges[connEdges[cur][next]].m;
                                route.connPrice += edges[connEdges[cur][next]].p;
                                cur = next;
                            }
                        } else if(i == route.to && path[i][route.from] != -1){
                            used[route.id] = true;
                            int cur = route.from;
                            while(cur != route.to){
                                int next = path[i][cur];
                                route.usedEdges.add(connEdges[cur][next]);
                                route.needMaterial += edges[connEdges[cur][next]].m;
                                route.connPrice += edges[connEdges[cur][next]].p;
                                cur = next;
                            }
                        }
                    }
                }
            }
        }
        //todo:remove check
        for (int i = 0; i < r; i++) {
            if(!used[i])
                throw new RuntimeException("uncalcd route " + i);
        }

//        for (Route route : routes) {
//            if(!used[route.from]){
//                used[route.from] = true;
//                dijkstraByM(route.from, g);//todo:
//                //dijkstraByP(route.from);
//            }
//            int cur = route.to;
//            while(cur != route.from){
//                int next = path[route.from][cur];
//                route.usedEdges.add(connEdges[cur][next]);
//                cur = next;
//            }
//        }
    }

    class SingleSol{
        Route route;
        ArrayList<Integer> extraEdges;
        long score;

        public SingleSol(Route route) {
            this.route = route;
        }

        public SingleSol(Route route, ArrayList<Integer> extraEdges, long score) {
            this.route = route;
            this.extraEdges = extraEdges;
            this.score = score;
        }
    }

    private SingleSol calcPickSingleRoute(){
        SingleSol best = new SingleSol(null);
        for (Route route : routes) {
            route.needMaterial = minValue[route.from][route.to];
            route.connPrice = pathPrice[route.from][route.to];
            if(route.needMaterial < numMaterials){ // todo:knapsack
                int rem = numMaterials-route.needMaterial;
                ArrayList<Integer> extra = new ArrayList<>();
                int edgePoints = 0;
                for (Edge edge : bestEdgesByRatio) {
                    //System.err.println(edge.rate + " " + edge.p +" "+ edge.m);
                    if(route.usedEdges.contains(edge.id)) continue;
                    if(edge.m <= rem){
                        rem-=edge.m;
                        extra.add(edge.id);
                        edgePoints += edge.p;
                    }
                    if(rem == 0)
                        break;
                }
                long res = (edgePoints+route.connPrice)*route.p;
                if(res > best.score)
                    best = new SingleSol(route, extra, res);
                System.err.printf("route: %d %d %d, needMaterial %d, connPrice %d, edgePoitns %d, score %d%n",
                        route.from, route.to, route.p, route.needMaterial, route.connPrice, edgePoints, res);
            }
        }
        return best;
    }

    class State implements Comparable<State>{
        HashSet<Integer> usedEdges;
        HashSet<Integer> routes;
        boolean[] usedRoutes;
        int rp;
        int cp;
        int m;
        int extraPrice;
        long score;
        List<State> children;
        State parent;
        boolean invalid;

        public State() {
            usedEdges = new HashSet<>();
            routes = new HashSet<>();
            usedRoutes = new boolean[r];
            children = new LinkedList<>();
        }

        void merge(State parent, Route route){
            usedEdges.addAll(parent.usedEdges);
            usedEdges.addAll(route.usedEdges);
            routes.addAll(parent.routes);
            routes.add(route.id);
            for (Integer routeId : routes) {
                usedRoutes[routeId] = true;
            }
            this.parent = parent;
        }

        void merge(State state){
            usedEdges.addAll(state.usedEdges);
            routes.addAll(state.routes);
            for (Integer routeId : state.routes) {
                usedRoutes[routeId] = true;
            }
        }

        void add(Route route){
            usedEdges.addAll(route.usedEdges);
            routes.add(route.id);
            usedRoutes[route.id] = true;
        }

        void calcNoExtras(){
            for (Integer routeId : routes) {
                rp += RoadNetwork.this.routes[routeId].p;
            }
            for (Integer edgeId : usedEdges) {
                Edge edge = edges[edgeId];
                m += edge.m;
                cp += edge.p;
            }
            if(m > numMaterials){
                invalid = true;
                return;
            }
        }
        void calc(){
            int[][] curCnt = new int[6][38];
            for (Integer routeId : routes) {
                rp += RoadNetwork.this.routes[routeId].p;
            }
            for (Integer edgeId : usedEdges) {
                Edge edge = edges[edgeId];
                m += edge.m;
                cp += edge.p;
                curCnt[edge.rate][edge.m]++;
            }
            if(m > numMaterials){
                invalid = true;
//                System.err.println("INVALID STATE");
//                System.err.println(toString());
                return;
            }
            extraPrice = 0;
            int rem = numMaterials-m;//todo: test this
            for (int ratio = 5; ratio > 0 ; ratio--) { //todo: knapsack
                for (int mm = 37; mm > 0 ; mm--) {
                    if(mm <= rem) {
                        int remCnt = edgeCnts[ratio][mm] - curCnt[ratio][mm];
                        if (remCnt != 0) {
                            if (rem >= mm * remCnt) {
                                extraPrice += mm * remCnt * ratio;
                                rem -= mm * remCnt;
                            } else {
                                extraPrice += (rem / mm) * mm * ratio;
                                rem -= (rem / mm) * mm;
                            }
                        }
                    }
                }
            }
            score = (cp + extraPrice)*rp;
            //debug
            //System.err.println(toString());
        }

        @Override
        public String toString() {
            return "State{" +
                    "usedEdges=" + usedEdges +
                    ", routes=" + routes +
                    ", rp=" + rp +
                    ", cp=" + cp +
                    ", m=" + m +
                    ", extraPrice=" + extraPrice +
                    ", score=" + score +
                    ", invalid=" + invalid +
                    '}';
        }

        @Override
        public int compareTo(State state) {
            if(this.invalid && state.invalid)
                return 0;
            else if(state.invalid)
                return -1;
            else if(this.invalid)
                return 1;
            else return -Long.compare(score, state.score);
        }
    }

    void calcAll(State state){
//        System.err.println("calcAll begin");
        for (Route route : routes) {
//            System.err.println("Consider route: " + route.id);
            if(state.usedRoutes[route.id]) continue;
//            System.err.println("calc state");
            State child = new State();
            child.merge(state, route);
            child.calc();
            state.children.add(child);
        }
    }

    private int[] getSolutionFromState(State state){
        ArrayList<Integer> extraEdges = new ArrayList<>();
        int rem = numMaterials;
        if(state != null)
            rem -= state.m;
        System.err.println("rem = " + rem);
        for (int ration = 5; ration > 0; ration--) { // todo: knapsack
            for(int mm = 37; mm > 0; mm--){
                if(mm <= rem) {
                    for (Integer edgeId : edgesByValues[ration][mm]) {
                        if (state == null || !state.usedEdges.contains(edgeId)) {
                            extraEdges.add(edgeId);
                            rem -= mm;
                        }
                        if(rem < mm)
                            break;
                    }
                }
            }
        }
        System.err.println("rem = " + rem);

        int sz = extraEdges.size();
        if(state != null)
            sz += state.usedEdges.size();
        int[] res = new int[sz];
        int ii = 0;
        if(state != null) {
            for (Integer id : state.usedEdges) {
                res[ii++] = id;
            }
        }
        for (Integer id : extraEdges) {
            res[ii++] = id;
        }
        return res;
    }

    State getStateByMask(int mask){
        State state = new State();
        for (int bit = 0; bit < r; bit++) {
            if((mask&(1<<bit)) != 0){
                state.add(routes[bit]);
            }
        }
        state.calc();
        return state;
    }
    State bestState;
    private void dfs(State state){
        calcAll(state);
        Collections.sort(state.children);
    }

    private State greedyFast(){
        State state = new State();
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State state, State t1) {
                return -Double.compare((double)state.score/state.m, (double)t1.score/t1.m);
            }
        });
        for (Route route : routes) {
            //if(root.usedRoutes[route.id]) continue;
            State child = new State();
            child.add(route);
            child.calc();
            if(!child.invalid){
                pq.offer(child);
            }
        }
        while(!pq.isEmpty()){
            State top = pq.poll();
            top.merge(state);
            top.calc();
            if(top.invalid)
                continue;
            state = top;
        }

        if(state.invalid)
            throw new RuntimeException("invalid");
        return state;
    }

    public class DSU {
        int[] parent;
        int[] sizes;
        int n;

        public DSU(int n) {
            parent = new int[n];
            sizes = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i=0; i<n; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x]!=x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;
            if (sizes[xRoot] < sizes[yRoot]) {
                sizes[yRoot] += sizes[xRoot];
                parent[xRoot] = yRoot;
            } else {
                sizes[xRoot] += sizes[yRoot];
                parent[yRoot] = xRoot;
            }
        }

    }

    private State greedyByIntersections(int rate){

        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State state, State t1) {
                return -Double.compare((double)state.score/state.m, (double)t1.score/t1.m);
            }
        });

        for (Route route : routes) {
            //if(root.usedRoutes[route.id]) continue;
            State child = new State();
            child.add(route);
            child.calc();
            if(!child.invalid)
                pq.offer(child);
        }
        DSU dsu = new DSU(r);

        for (int i = 0; i < r; i++) {
            for (int j = i+1; j < r; j++) {
                if(intersections[i][j] > 0){
                    if(intersections[i][j] >= routes[i].usedEdges.size()/rate || intersections[i][j] >= routes[j].usedEdges.size()/rate){
                        dsu.union(i, j);
                    }
                }
            }
        }
        List<Integer>[] groups = new List[r];
        for (int i = 0; i < r; i++) {
            groups[i] = new LinkedList<>();
        }
        for (int i = 0; i < r; i++) {
            int p = dsu.find(i);
            if(dsu.sizes[p] > 1) {
                groups[p].add(i);
            }
        }
        for (int i = 0; i < r; i++) {
            if(groups[i].size() == 0) continue;
            System.err.println("group " + groups[i].size() + " : " + groups[i]);
            if(groups[i].size() > 10){
                System.err.println("too big skip");
                continue;
            }
            int[] group = new int[groups[i].size()];
            int sz = 0;
            for (Integer routeId : groups[i]) {
                group[sz++] = routeId;
            }
            for (int mask = 3; mask < 1<<sz ; mask++) {
                if(Integer.bitCount(mask) < 2)
                    continue;
                State cur = new State();
                for (int bit = 0; bit < sz; bit++) {
                    if((mask&(1<<bit)) != 0){
                        cur.add(routes[group[bit]]);
                    }
                }
                cur.calc();
                if(!cur.invalid) {
                    pq.offer(cur);
//                    System.err.println("adding to pq " + cur.toString());
//                    System.err.println("top is " + pq.peek().toString());
                }
            }

        }
        //knapsack
/*
        int size = pq.size();
        System.err.println("pq size = " + size);
        if(size > 10_000){
            size = 10_000;
        }
        State[] states = new State[size];
        for (int i = 0; i < size; i++) {
            states[i] = pq.poll();
        }
        int[][] dp = new int[size + 1][numMaterials+1];
        int[][] path = new int[size + 1][numMaterials+1];
        for (int i = 0; i < size; i++) {
            for (int mm = 0; mm <= numMaterials; mm++) {
                dp[i+1][mm] = dp[i][mm];
                path[i+1][mm] = mm;
                if(mm-states[i].m >= 0){
                    int val = dp[i][mm - states[i].m] + states[i].rp * states[i].cp;
                    if(val > dp[i+1][mm]){
                       dp[i+1][mm] = val;
                       path[i+1][mm] = mm-states[i].m;
                    }
                }
            }
        }

        int curM = numMaterials;
        int best = 0;
        for (int mm = numMaterials; mm > 0 ; mm--) {
            if(dp[size][mm] > best){
                best = dp[size][mm];
                curM = mm;
            }
        }
        System.err.println("DP result " + dp[size][curM]);
        State res = new State();
        for (int i = size; i > 0 ; i--) {
            if(path[i][curM] != curM){
                System.err.println("curM = " + curM);
                System.err.println(" state " + states[i-1].toString());
                res.merge(states[i-1]);
                curM = path[i][curM];
            }
            if(curM == 0)
                break;
        }
        res.calc();

        */
       // System.err.println(" backpack results " + res.toString());
        State state = new State();
        while(!pq.isEmpty()){
            State top = pq.poll();
            top.merge(state);
            top.calc();
            if(top.invalid)
                continue;
//            System.err.println("top state " + top.toString());
            state = top;
        }

        if(state.invalid)
            throw new RuntimeException("invalid");

        return state;
    }

    int[][] intersections;
    int[] intersectionSum;
    private void calcIntersections(){
        for (int i = 0; i < r; i++) {
            for (int j = i+1; j < r; j++) {
                int cnt = 0;
                if(routes[i].needMaterial > numMaterials || routes[j].needMaterial > numMaterials)
                    continue;
                if(routes[i].usedEdges.size() < routes[j].usedEdges.size()){
                    for (Integer edgeId : routes[i].usedEdges) {
                        if(routes[j].usedEdges.contains(edgeId))
                            cnt++;
                    }
                } else {
                    for (Integer edgeId : routes[j].usedEdges) {
                        if(routes[i].usedEdges.contains(edgeId))
                            cnt++;
                    }
                }
                intersections[i][j] = intersections[j][i] = cnt;
                intersectionSum[i] += cnt;
                intersectionSum[j] += cnt;
            }
        }
    }



    public int[] findSolution(int NumMaterials, int N, int E, String[] edges, int R, String[] routes) {
        long t1 = System.currentTimeMillis();
        n = N;
        e = E;
        r = R;
        numMaterials = NumMaterials;
        pathPrice = new int[N][N];
        minValue = new int[N][N];
        mConn = new int[N][N];
        pConn = new int[N][N];
        path = new int[N][N];
        g = new LinkedList[N];
        subGraph = new LinkedList[6][n];
        this.edges = new Edge[E];
        bestEdgesByRatio = new PriorityQueue<>(Comparator.comparingInt((a)->-a.rate));
        connEdges = new int[N][N];
        edgeCnts = new int[6][38];
        edgesByValues = new List[6][38];
        intersections = new int[r][r];
        intersectionSum = new int[r];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 38; j++) {
                edgesByValues[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < n; j++) {
                subGraph[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < N; i++) {
            g[i] = new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer stok = new StringTokenizer(edges[i]);
            int from = Integer.parseInt(stok.nextToken());
            int to = Integer.parseInt(stok.nextToken());
            int m = Integer.parseInt(stok.nextToken());
            int p = Integer.parseInt(stok.nextToken());
            Edge e = new Edge(from, to, m, p, i);
            bestEdgesByRatio.add(e);
            this.edges[i] = e;
            g[from].add(e);
            Edge rev = new Edge(to, from, m, p, i);
            g[to].add(rev);
            mConn[from][to] = mConn[to][from] = m;
            pConn[from][to] = pConn[to][from] = p;
            connEdges[from][to] = connEdges[to][from] = i;
            int ratio = p/m;
            edgeCnts[ratio][m] ++;
            edgesByValues[ratio][m].add(i);
            for (int rr = ratio; rr < 6 ; rr++) {
                subGraph[rr][from].add(e);
                subGraph[rr][to].add(rev);
            }
        }

        this.routes = new Route[R];
        for (int i = 0; i < R; i++) {
            StringTokenizer stok = new StringTokenizer(routes[i]);
            int from = Integer.parseInt(stok.nextToken());
            int to = Integer.parseInt(stok.nextToken());
            int p = Integer.parseInt(stok.nextToken());
            this.routes[i] = new Route(i, from, to, p);
        }
        processRoutes();

        int[] ret;

        if(r <= BF_MAX_R){
            State best = null;
            for (int mask = 1; mask < 1<<r ; mask++) {
                State s = getStateByMask(mask);
                if(!s.invalid && (best == null || s.score > best.score)){
                    best = s;
                }
            }
            if(best == null){
                System.err.println("No routes to take after BF");
            }else {
                System.err.println("Taking the following routes after BF");
                System.err.println(best.toString());
            }
            ret = getSolutionFromState(best);
        } else {
            calcIntersections();
            State state = greedyByIntersections(4);
            System.err.println(".... and the best state is .... " + state.toString());
            //State state = greedyFast();
            ret = getSolutionFromState(state);
//            System.err.println("ret = " + Arrays.toString(ret));

//
//            State root = new State();
//            calcAll(root);
//
//            State bestChild = null;
//            for (State child : root.children) {
//                if (!child.invalid && (bestChild == null || bestChild.score < child.score)) {
//                    bestChild = child;
//                }
//            }
//
//            if (bestChild != null) {
//                State bestSub = null;
//                System.err.println("BEST Child = " + bestChild.toString());
//                calcAll(bestChild);
//                for (State child : bestChild.children) {
//                    if (!child.invalid && (bestSub == null || bestSub.score < child.score)) {
//                        bestSub = child;
//                    }
//                }
//                if (bestSub != null) {
//                    System.err.println("BEST Sub = " + bestSub.toString());
//                    bestChild = bestSub;
//                }
//
//            }


//            ret = getSolutionFromState(bestChild);
        }

//        SingleSol singleSol = calcPickSingleRoute();
//        if(singleSol.route == null) {
//            int rem = numMaterials;
//            ArrayList<Integer> res = new ArrayList<>();
//            for (Edge edge : bestEdgesByRatio) {
//                if(edge.m <= rem){
//                    rem-=edge.m;
//                    res.add(edge.id);
//                }
//                if(rem == 0)
//                    break;
//            }
//            int[] ret = new int[res.size()];
//            for (int i = 0; i < res.size(); i++) {
//                ret[i] = res.get(i);
//            }
//            return ret;
//        }
//
//        int[] ret = new int[singleSol.route.usedEdges.size() + singleSol.extraEdges.size()];
//        int ii = 0;
//        for (Integer usedEdge : singleSol.route.usedEdges) {
//            ret[ii++] = usedEdge;
//        }
//        for (Integer extraEdge : singleSol.extraEdges) {
//            ret[ii++] = extraEdge;
//        }
//        List<Integer> ret=new ArrayList<Integer>();
//
//        //build connections until we run out of materials
//        for (int i=0; i<E; i++)
//        {
//          String[] temp=edges[i].split(" ");
//          int cost=Integer.parseInt(temp[2]);
//
//          if (cost<=NumMaterials)
//          {
//            NumMaterials-=cost;
//            ret.add(i);
//            //System.err.println(edges[i]);
//          }
//        }
//
//        int[] ret2=new int[ret.size()];
//        for (int i=0; i<ret.size(); i++) ret2[i]=ret.get(i);
        long t2 = System.currentTimeMillis();
        System.err.println("time: " + (t2-t1)+ " ms");
        return ret;
    }


    public static void main(String[] args) {
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int NumMaterials = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        String[] edges=new String[E];
        for (int i=0; i<E; i++) edges[i]=br.readLine();             
        int R = Integer.parseInt(br.readLine());
        String[] routes=new String[R];
        for (int i=0; i<R; i++) routes[i]=br.readLine();                     
        
        RoadNetwork rn = new RoadNetwork();
        int[] ret = rn.findSolution(NumMaterials, N, E, edges, R, routes);

        System.out.println(ret.length);
        for (int i = 0; i < ret.length; ++i) {
            System.out.println(ret[i]);
        }        
    }
    catch (Exception e) {
        System.err.println(e);
    }
    }
}

