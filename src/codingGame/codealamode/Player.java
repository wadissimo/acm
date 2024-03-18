package codingGame.codealamode;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    private static final String ICE_CREAM = "ICE_CREAM";
    private static final String BLUEBERRIES = "BLUEBERRIES";
    private static final String DISH = "DISH";
    private static final String STRAWBERRIES = "STRAWBERRIES";
    private static final String CHOPPED_STRAWBERRIES = "CHOPPED_STRAWBERRIES";
    private static final String CROISSANT = "CROISSANT";
    private static final String DOUGH = "DOUGH";
    private static final String TART = "TART";
    public static final String CHOPPED_DOUGH = "CHOPPED_DOUGH";
    public static final String RAW_TART = "RAW_TART";
    private static final String NONE = "NONE";


    private static final int WIDTH = 11;
    private static final int HEIGHT = 7;

    public static final int DIST_TO_TABLE_TO_STEAL = 3;

    static class State{
        boolean hasDish;
        boolean hasIce;
        boolean hasBB;
        boolean hasSB;
        boolean hasCr;
        boolean hasRawTart;
        boolean hasTart;
        boolean hasChoppedDough;
        boolean hasDough;
        boolean hasChoppedSB;
        boolean needSB = false;
        boolean needIce = false;
        boolean needBB = false;
        boolean needCr = false;
        boolean needTart;
        Order order;
        public State(){

        }
        public void update(String playerItem){
            reset();
            hasDish = playerItem.contains(DISH);
            hasIce = playerItem.contains(ICE_CREAM);
            hasBB = playerItem.contains(BLUEBERRIES);
            hasCr = playerItem.contains(CROISSANT);
            hasDough = playerItem.contains(DOUGH) && !playerItem.contains(CHOPPED_DOUGH);
            if(playerItem.contains(CHOPPED_STRAWBERRIES))
                hasChoppedSB = true;
            else if(playerItem.contains(STRAWBERRIES))
                hasSB = true;
            hasTart = playerItem.contains(TART) && !playerItem.contains(RAW_TART);
            hasRawTart = playerItem.contains(RAW_TART);
            hasChoppedDough = playerItem.contains(CHOPPED_DOUGH);
        }
        public void reset(){
            hasDish = hasIce = hasBB = hasSB = hasChoppedSB = hasCr = hasDough = hasRawTart = hasTart = hasChoppedDough = false;
        }
        public void assign(Order order){
            this.order = order;
            needSB = order.needSB;
            needIce = order.needIce;
            needBB = order.needBB;
            needCr = order.needCr;
            needTart = order.needTart;
        }
        public boolean emptyHands(){
            if(hasDish || hasSB || hasCr || hasDough || hasChoppedSB || hasBB || hasIce ||hasTart || hasRawTart || hasChoppedDough)
                return false;
            else return true;
        }

        @Override
        public String toString() {
            return "State{" +
                    "hasDish=" + hasDish +
                    ", hasIce=" + hasIce +
                    ", hasBB=" + hasBB +
                    ", hasSB=" + hasSB +
                    ", hasCr=" + hasCr +
                    ", hasRawTart=" + hasRawTart +
                    ", hasTart=" + hasTart +
                    ", hasChoppedDough=" + hasChoppedDough +
                    ", hasDough=" + hasDough +
                    ", hasChoppedSB=" + hasChoppedSB +
                    ", needSB=" + needSB +
                    ", needIce=" + needIce +
                    ", needBB=" + needBB +
                    ", needCr=" + needCr +
                    ", needTart=" + needTart +
                    ", order=" + order +
                    '}';
        }
    }
    static class Action{
        int x, y;

        public Action(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Table{
        int x, y;
        String items;

        public Table(int x, int y, String items) {
            this.x = x;
            this.y = y;
            this.items = items;
        }
    }

    static class Order {
        boolean needIce, needBB, needSB, needCr, needTart;
        int award;
        public Order(String customerItem, int award){
            if(customerItem.contains(CHOPPED_STRAWBERRIES))
                needSB = true;
            if(customerItem.contains(BLUEBERRIES))
                needBB = true;
            if(customerItem.contains(ICE_CREAM))
                needIce = true;
            if(customerItem.contains(CROISSANT))
                needCr = true;
            if(customerItem.contains(TART))
                needTart = true;
            this.award = award;
        }
        public boolean isReady(State state){
            if(state.hasDish && needSB == state.hasChoppedSB && needIce == state.hasIce && needBB == state.hasBB
                    && needCr == state.hasCr && needTart == state.hasTart)
                return true;
            else
                return false;
        }
        public boolean equals(Order o){
            if(needIce == o.needIce && needBB == o.needBB && needSB == o.needSB && needCr == o.needCr && needTart == o.needTart)
                return true;
            else
                return false;
        }
        public boolean achievable(State state){
            if(!needIce && state.hasIce || !needBB && state.hasBB || !needSB && state.hasChoppedSB || !needCr && state.hasCr || !needTart && state.hasTart)
                return false;
            else return true;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "needIce=" + needIce +
                    ", needBB=" + needBB +
                    ", needSB=" + needSB +
                    ", needCr=" + needCr +
                    ", needTart=" + needTart +
                    ", award=" + award +
                    '}';
        }
    }

    private static int playerX;
    private static int playerY;
    private static int partnerX;
    private static int partnerY;
    private static int dishX = 0, dishY = 0, custX = 0, custY = 0;
    private static int iceX = 0, iceY = 0, bbX = 0, bbY = 0, sbX = 0, sbY = 0;
    private static int chopX = 0, chopY = 0;
    private static int ovenX= 0, ovenY = 0, doughX = 0, doughY = 0;
    private static char[][] grid;
    private static String ovenContents;
    private static int ovenTimer;
    public static Table[] tableItems;
    private static void parseKitchenLine(String kitchenLine, int i){
        int idx = kitchenLine.indexOf('D');
        if(idx != -1){
            dishY = i;
            dishX = idx;
        }
        idx = kitchenLine.indexOf('W');
        if(idx != -1){
            custY = i;
            custX = idx;
        }
        idx = kitchenLine.indexOf('B');
        if(idx != -1){
            bbY = i;
            bbX = idx;
        }
        idx = kitchenLine.indexOf('I');
        if(idx != -1){
            iceY = i;
            iceX = idx;
        }
        idx = kitchenLine.indexOf('C');
        if(idx != -1){
            chopY = i;
            chopX = idx;
        }
        idx = kitchenLine.indexOf('S');
        if(idx != -1){
            sbY = i;
            sbX = idx;
        }
        idx = kitchenLine.indexOf('O');
        if(idx != -1){
            ovenY = i;
            ovenX = idx;
        }
        idx = kitchenLine.indexOf('H');
        if(idx != -1){
            doughY = i;
            doughX = idx;
        }
    }
    private static void use(int x, int y){
        System.out.println("USE " +x + " " + y);
    }
    private static void takeAction(Action action){
        use(action.x, action.y);
    }



    static Action clear(State state){

        Action res = null;
        for (int i = 0; i < 8; i++) {
            int x = playerX + dgx[i];
            int y = playerY + dgy[i];
            if(!validCoord(x,y))
                continue;
            if(grid[y][x] == '#'){
                boolean occupied = false;
                for (Table tableItem : tableItems) {
                    if(tableItem.x == x && tableItem.y == y) {
                        occupied = true; break;
                    }
                }
                if(occupied)
                    continue;
                res = new Action(x, y);
                break;
            }
        }
        return res;
    }
    static boolean validCoord(int x, int y){
        if(x < 0 || x > WIDTH || y < 0 || y > HEIGHT || x == partnerX && y == partnerY)
            return false;
        else
            return true;
    }
    static int[] dgx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dgy = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static final int INF = 1_000_000_000;

    static int distToTarget(int targetX, int targetY, int playerX, int playerY, int partnerX, int partnerY, boolean[][] used){
        for (int i = 0; i < 8; i++) {
            if(targetX == playerX + dgx[i] && targetY == playerY + dgy[i]){
                return 0;
            }
        }
        int best = INF;
        for (int i = 0; i < 4; i++) {
            int x = playerX + dx[i];
            int y = playerY + dy[i];
            if(!validCoord(x,y))
                continue;
            if(!used[x][y] && grid[x][y] == '.'){
                used[x][y] = true;
                best = Math.min(best, distToTarget(targetX, targetY, x, y, partnerX, partnerY, used));
            }
        }
        if(best == INF)
            return INF;
        else
            return best+1;
    }
    private static Table findTableWithItem(int fromX, int fromY, String inclItem, String exclItem){
        Table best = null;
        int bestDist = INF;
        for (Table table : tableItems) {
            if(table.items.contains(inclItem) && (exclItem == null || !table.items.contains(exclItem))) {
                int dist = (fromX-table.x)*(fromX-table.x) + (fromY-table.y)*(fromY-table.y);
                if(best == null || dist < bestDist){
                    best = table;
                    bestDist = dist;
                }
            }
        }
        return best;
    }

    private static Table findTableWithItems(int fromX, int fromY, String[] items){
        Table best = null;
        int bestDist = INF;
        for (Table table : tableItems) {
            boolean found = true;
            for (String item : items) {
                if(!table.items.contains(item)){
                    found = false;
                    break;
                }
            }
            if(found) {
                int dist = (fromX-table.x)*(fromX-table.x) + (fromY-table.y)*(fromY-table.y);
                if(best == null || dist < bestDist){
                    best = table;
                    bestDist = dist;
                }
            }
        }
        return best;
    }

    static Action tryTakeCroissant(State state){
        if(ovenContents == null || NONE.equals(ovenContents))
            return null;
//        int myDist = distToTarget(ovenX, ovenY, playerX, playerY, partnerX, partnerY, new boolean[HEIGHT][WIDTH]);
//        int hisDist = distToTarget(ovenX, ovenY, partnerX, partnerY, playerX, playerY, new boolean[HEIGHT][WIDTH]);
        return new Action(ovenX, ovenY);
    }

    static Action tryTakeDoughAndBake(State state){
        if(ovenContents != null && !NONE.equals(ovenContents)) {
            if(state.hasDough){
                Action clear = clear(state);
                if(clear == null)
                    return new Action(custX, custY);
                else{
                    state.reset();
                    return clear;
                }

            }
            return null;
        }
        if(state.hasDough){
            return new Action(ovenX, ovenY);
        }
        if(state.emptyHands()){
            return new Action(doughX, doughY);
        }
        return null;
    }



    static Action tryChopBerries(State state){
        if(state.hasChoppedSB && !state.hasDish){
            return new Action(dishX, dishY);
        }
        if(state.hasSB){
            return new Action(chopX, chopY);
        }
        if(state.emptyHands()){
            return new Action(sbX, sbY);
        }
        return null;
    }

    static Action findAction(State state){
        if(state.order.isReady(state)){
            return new Action(custX, custY);
        }
        Table tableWithTart = findTableWithItem(playerX, playerY, TART, null);
        Table tableWithTartOnly = findTableWithItem(playerX, playerY, TART, DISH);
        Table tableWithTartDish = findTableWithItems(playerX, playerY, new String[]{TART, DISH});
        Table tableWithCr = findTableWithItem(playerX, playerY, CROISSANT, null);
        Table tableWithCrDish = findTableWithItems(playerX, playerY, new String[]{CROISSANT, DISH});
        Table tableWithSBDish = findTableWithItems(playerX, playerY, new String[]{CHOPPED_STRAWBERRIES, DISH});
        Table tableWithCrOnly = findTableWithItem(playerX, playerY, CROISSANT, DISH);
        Table tableWithSB = findTableWithItems(playerX, playerY, new String[]{CHOPPED_STRAWBERRIES});
        Table tableWithSBOnly = findTableWithItem(playerX, playerY, CHOPPED_STRAWBERRIES, DISH);
        boolean tartSat = !state.needTart || tableWithTart != null || state.hasTart;
        boolean crSat = !state.needCr || tableWithCr != null || state.hasCr;
        boolean sbSat = !state.needSB || tableWithSB != null || state.hasChoppedSB;
        System.err.print("tartSat = " + tartSat);
        System.err.print(", crSat = " + crSat);
        System.err.println(", sbSat = " + sbSat);
        if(state.order != null)
            System.err.println(state.order.toString());
        else
            System.err.println("empty order");
        System.err.println(state.toString());

        if(state.emptyHands()){
            System.err.println("empty hands");
            if(!tartSat) {
                if(TART.equals(ovenContents) && Math.abs(playerX-ovenX) + Math.abs(playerY-ovenY) < ovenTimer || RAW_TART.equals(ovenContents))
                    return new Action(ovenX, ovenY);
                if((NONE.equals(ovenContents) || DOUGH.equals(ovenContents) || CROISSANT.equals(ovenContents))){
                    return new Action(doughX, doughY);
                }
            }


            if(!sbSat) {
                return new Action(sbX, sbY);
            }
            //todo:rework

            if(!crSat){
                if(CROISSANT.equals(ovenContents) && Math.abs(playerX-ovenX) + Math.abs(playerY-ovenY) < ovenTimer || DOUGH.equals(ovenContents))
                    return new Action(ovenX, ovenY);
                return new Action(doughX, doughY);
            }

            //todo: can do better
            if(state.needTart && tableWithTartDish != null){
                return new Action(tableWithTartDish.x, tableWithTartDish.y);
            } else if(state.needCr && tableWithCrDish != null){
                return new Action(tableWithCrDish.x, tableWithCrDish.y);
            } else if(state.needSB && tableWithSBDish != null){
                return new Action(tableWithSBDish.x, tableWithSBDish.y);
            } else {
                if(state.needTart && tableWithTart != null){
                    return new Action(tableWithTart.x, tableWithTart.y);
                } else if(state.needCr && tableWithCr != null){
                    return new Action(tableWithCr.x, tableWithCr.y);
                } else if(state.needSB && tableWithSB != null){
                    return new Action(tableWithSB.x, tableWithSB.y);
                } else {
                    return new Action(dishX, dishY);
                }
            }
        } else if(state.hasDough) {
            System.err.println("hasDough");
            if(state.needTart && tableWithTart == null) {
                if(RAW_TART.equals(ovenContents) || TART.equals(ovenContents) && Math.abs(playerX-ovenX) + Math.abs(playerY-ovenY) < ovenTimer)
                    return new Action(ovenX, ovenY);
                return new Action(chopX, chopY);
            }else if(state.needCr && tableWithCr == null){
                return new Action(ovenX, ovenY);
            } else {
                Action clear = clear(state);
                if(clear != null){
                    state.reset();
                    return new Action(clear.x, clear.y);
                } else {
                    return new Action(custX, custY);
                }
            }
        } else if(state.hasSB){
            System.err.println("hasSB");
            return new Action(chopX, chopY);
        }else if(state.hasChoppedSB && !state.hasDish){
            System.err.println("hasChoppedSB");
            if(tartSat && crSat){
                if(state.needTart && tableWithTartDish != null){
                    return new Action(tableWithTartDish.x, tableWithTartDish.y);
                } else if(state.needCr && tableWithCrDish != null){
                    return new Action(tableWithCrDish.x, tableWithCrDish.y);
                } else{
                    return new Action(dishX, dishY);
                }
            } else {
                Action clear = clear(state);
                if(clear != null){
                    state.reset();
                    return new Action(clear.x, clear.y);
                } else {
                    return new Action(custX, custY);
                }
            }
        } else if(state.hasChoppedDough){
            System.err.println("hasChoppedDough");
            return new Action(bbX, bbY);
        } else if(state.hasRawTart){
            System.err.println("hasRawTart");
            return new Action(ovenX, ovenY);
        } else if(state.hasTart && !state.hasDish){
            System.err.println("hasTart");
            if(!crSat || !sbSat){
                Action clear = clear(state);
                if(clear != null){
                    state.reset();
                    return new Action(clear.x, clear.y);
                } else {
                    return new Action(custX, custY);
                }
            } else {
                if(state.needCr && tableWithCrDish != null){
                    return new Action(tableWithCrDish.x, tableWithCrDish.y);
                } else if(state.needSB && tableWithSBDish != null){
                    return new Action(tableWithSBDish.x, tableWithSBDish.y);
                } else{
                    return new Action(dishX, dishY);
                }
            }
        }
        else if(state.hasCr && !state.hasDish){
            System.err.println("hasCr");
            if(!tartSat || !sbSat){
                Action clear = clear(state);
                if(clear != null){
                    state.reset();
                    return new Action(clear.x, clear.y);
                } else {
                    return new Action(custX, custY);
                }
            } else {
                if(state.needTart && tableWithTartDish != null){
                    return new Action(tableWithTartDish.x, tableWithTartDish.y);
                } else if(state.needSB && tableWithSBDish != null){
                    return new Action(tableWithSBDish.x, tableWithSBDish.y);
                } else{
                    return new Action(dishX, dishY);
                }
            }
        }
        else if(state.hasDish){
            System.err.println("hasDish");
            if(!tartSat || !crSat || !sbSat){
                Action clear = clear(state);
                if (clear == null) {
                    return new Action(custX, custY);
                } else {
                    state.reset();
                    return clear;
                }
            }
            if(state.needTart && !state.hasTart){
                if(tableWithTartOnly == null){
                    if(TART.equals(ovenContents) || RAW_TART.equals(ovenContents)){
                        return new Action(ovenX, ovenY);
                    }
                    Action clear = clear(state);
                    if (clear == null) {
                        return new Action(custX, custY);
                    } else {
                        state.reset();
                        return clear;
                    }
                } else {
                    return new Action(tableWithTartOnly.x, tableWithTartOnly.y);
                }
            }
            if(state.needCr && !state.hasCr) {
                if(tableWithCrOnly == null){
                    if(CROISSANT.equals(ovenContents) || DOUGH.equals(ovenContents)){
                        return new Action(ovenX, ovenY);
                    }
                    Action clear = clear(state);
                    if (clear == null) {
                        return new Action(custX, custY);
                    } else {
                        state.reset();
                        return clear;
                    }
                } else {
                    return new Action(tableWithCrOnly.x, tableWithCrOnly.y);
                }
            }
            if(state.needSB && !state.hasChoppedSB) {
                if(tableWithSBOnly == null){
                    Action clear = clear(state);
                    if (clear == null) {
                        return new Action(custX, custY);
                    } else {
                        state.reset();
                        return clear;
                    }
                } else {
                    return new Action(tableWithSBOnly.x, tableWithSBOnly.y);
                }
            }

            if(state.needBB && !state.hasBB){
                return new Action(bbX, bbY);
            } else if(state.needIce && !state.hasIce){
                return new Action(iceX, iceY);
            }

        }
        return new Action(custX, custY);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numAllCustomers = in.nextInt();
        for (int i = 0; i < numAllCustomers; i++) {
            String customerItem = in.next(); // the food the customer is waiting for
            int customerAward = in.nextInt(); // the number of points awarded for delivering the food
        }
        in.nextLine();

        grid = new char[HEIGHT][];
        for (int i = 0; i < 7; i++) {
            String kitchenLine = in.nextLine();
            kitchenLine = kitchenLine.replaceAll("0", ".");
            kitchenLine = kitchenLine.replaceAll("1", ".");
            System.err.println(kitchenLine);
            grid[i] = kitchenLine.toCharArray();
            parseKitchenLine(kitchenLine, i);
        }


        State state = new State();
        // game loop
        while (true) {
            int turnsRemaining = in.nextInt();

            playerX = in.nextInt();

            playerY = in.nextInt();
            String playerItem = in.next();

            partnerX = in.nextInt();

            partnerY = in.nextInt();
            String partnerItem = in.next();
            int numTablesWithItems = in.nextInt(); // the number of tables in the kitchen that currently hold an item
            tableItems = new Table[numTablesWithItems];
            for (int i = 0; i < numTablesWithItems; i++) {
                int tableX = in.nextInt();
                int tableY = in.nextInt();
                String item = in.next();
                tableItems[i] = new Table(tableX, tableY, item);
            }


            ovenContents = in.next();

            ovenTimer = in.nextInt();
            int numCustomers = in.nextInt(); // the number of customers currently waiting for food

            Order[] orders = new Order[numCustomers];
            Order best = null;
            for (int i = 0; i < numCustomers; i++) {
                String customerItem = in.next();
                int customerAward = in.nextInt();
                orders[i] = new Order(customerItem, customerAward);
                if(best == null || best.award < orders[i].award)
                    best = orders[i];
            }
            if(state.order == null){
                state.assign(best);
            } else if(!state.order.equals(best)){
                //can I still do best?
                if(best.achievable(state))
                    state.assign(best);
                else {
                    // can I still find my order there?
                    Order achievable = null;
                    for (Order order : orders) {
                        if(order.achievable(state)){
                            if(achievable == null || achievable.award < order.award)
                                achievable = order;
                        }
                    }
                    if(achievable != null){
                        state.assign(achievable);
                    } else {
                        System.err.println("no achievable order - clear");
                        //todo: either clear or deliver wrong...
                        Action clear = clear(state);
                        if(clear == null){
                            use(custX, custY);
                        } else {
                            takeAction(clear);
                            state.reset();
                        }
                        continue;
                    }
                }
            }

            state.update(playerItem);


            // Analyze around

            boolean useShortCut = false;
            for(int i = 0; i < 8; i++){
                int x = playerX + dgx[i];
                int y = playerY + dgy[i];
                if(x < 0 || x > WIDTH || y < 0 || y > HEIGHT)
                    continue;
                if(grid[y][x] == 'B' && state.needBB && state.hasDish && !state.hasBB){
                    use(x,y);
                    useShortCut = true;
                    break;
                }
                if(grid[y][x] == 'I' && state.needIce && state.hasDish && !state.hasIce){
                    use(x,y);
                    useShortCut = true;
                    break;
                }
                if(grid[y][x] == 'O' && state.hasDish && (state.needCr && !state.hasCr || state.needTart && !state.hasTart)){
                    use(x,y);
                    useShortCut = true;
                    break;
                }

                /*if(grid[y][x] == 'W' && state.hasDish){ // can be removed....
                    for(int j = 0; j < numCustomers; j++){
                        if(orders[j].isReady(state)){
                            use(x,y);
                            useShortCut = true;
                            state.order = null;
                            state.reset();
                            break;
                        }
                    }

                    if(useShortCut)
                        break;
                }*/
            }

            //analyze tables

            //todo: rewrite to findAction
           /*
            Table tableToSteal = null;
            int tableToStealDist = 0;
            for (Table table : tableItems) {
                int dist = Math.abs(table.x - playerX) + Math.abs(table.y - playerY);//todo: replace with bfs
                if(!state.hasDish && table.items.contains(DISH)){
                    if(table.items.contains(TART) && !state.needTart ||
                            table.items.contains(CROISSANT) && !state.needCr ||
                            table.items.contains(CHOPPED_STRAWBERRIES) && !state.needSB ||
                            table.items.contains(BLUEBERRIES) && !state.needBB ||
                            table.items.contains(ICE_CREAM) && !state.needIce ||
                            table.items.contains(DOUGH) || table.items.contains(CHOPPED_DOUGH)
                    ){
                        continue;
                    }
                    if(tableToSteal == null || tableToStealDist > dist) {
                        tableToSteal = table;
                        tableToStealDist = dist;
                    }
                }
                if((state.hasDish && !table.items.contains(DISH)
                        && (state.needCr && !state.hasCr && table.items.contains(CROISSANT) ||
                            state.needTart && !state.hasTart && table.items.contains(TART) ||
                            state.needSB && !state.hasChoppedSB && table.items.contains(CHOPPED_STRAWBERRIES)
                        ))){
                    if(tableToSteal == null || tableToStealDist > dist){
                        tableToStealDist = dist;
                        tableToSteal = table;
                    }
                }
            }
            if(tableToSteal != null && (!state.hasDish || tableToStealDist <= DIST_TO_TABLE_TO_STEAL)){
                useShortCut = true;
                use(tableToSteal.x, tableToSteal.y);
            }
            if(useShortCut)
                System.err.println("USE SHORTCUT");
                continue;
*/
        if(useShortCut) {
            System.err.println("USE SHORTCUT");
            continue;
        }


            Action action = findAction(state);
            if(action != null){
                takeAction(action);
                continue;
            } else {
                System.err.println("NO ACTION");
                System.out.println("WAIT");
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // MOVE x y
            // USE x y
            // WAIT
            //System.out.println("WAIT");
        }
    }
}
