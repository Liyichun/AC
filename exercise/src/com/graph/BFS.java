package com.graph;

import java.util.*;

/**
 * Created by yichli on 9/28/16.
 */
public class BFS {
    public void BFS(Varr varr[],int[][] arcs){
        int v = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < varr.length; i++){
            varr[i].visit = false;
        }
        q.add(v);
        while(!q.isEmpty()){
            v = q.poll();
            if(!varr[v].visit){
                varr[v].visit = true;
                System.out.println(varr[v].data);
            }
            for(int i = 0; i < varr.length; i++){
                if(arcs[v][i] == 1 && varr[i].visit == false){
                    q.add(i);
                }
            }
        }
    }

    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start)
    {
        HashMap<Character, LinkedList<Character>> ral = new HashMap<>();
        Queue<Character> q=new LinkedList<>();
        q.add(start);//将s作为起始顶点加入队列
        dist.put(start, 0);
        int i=0;
        while(!q.isEmpty())
        {
            char top=q.poll();//取出队首元素
            i++;
            System.out.println("The "+i+"th element:"+top+" Distance from s is:"+dist.get(top));
            int d=dist.get(top)+1;//得出其周边还未被访问的节点的距离
            for (Character c : graph.get(top)) {
                if(!dist.containsKey(c))//如果dist中还没有该元素说明还没有被访问
                {
                    if(ral.containsKey(top))
                        ral.get(top).add(c);
                    else {
                        LinkedList<Character> tmp = new LinkedList<>();
                        tmp.add(c);
                        ral.put(top,tmp);
                    }
                    dist.put(c, d);
                    q.add(c);
                }
            }
        }
        Iterator iter = ral.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                System.out.println(key + " " + val);
            }
    }




    public static void main(String[] args) {
//        Graphmatrix g = new Graphmatrix();
          BFS bfs = new BFS();
//        g.creatGraphmatrix();
//        bfs.BFS(g.varr,g.arcs);

        // s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<Character>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<Character>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<Character>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<Character>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<Character>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<Character>();
        list_y.add('u');
        list_y.add('x');
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
        char start = 's';
        bfs.bfs(graph, dist, start);

        System.out.println();
        Iterator iter = graph.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + " " + val);
        }

    }
}
