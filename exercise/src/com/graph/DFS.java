package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yichli on 9/28/16.
 */
public class DFS {

    public int count;
    public HashMap<Character, Boolean> visited = new HashMap<>();

    public void DFS(Varr varr[],int[][] arcs, int v){
        varr[v].visit = true;
        System.out.println(varr[v].data);
        visited = new HashMap<>();
        for(int i = 0; i < varr.length; i++){
            if(arcs[v][i] == 1 && varr[i].visit == false)
                visited.put(varr[i].data, varr[i].visit);
                //DFS(varr, arcs, i);
        }
    }

    private void dfs(HashMap<Character , LinkedList<Character>> graph,HashMap<Character, Boolean> visited)
    {
        visit(graph, visited, 'u');//为了和图中的顺序一样，我认为控制了DFS先访问u节点
        visit(graph,visited,'w');
    }
    private void visit(HashMap<Character , LinkedList<Character>> graph,HashMap<Character, Boolean> visited,char start)
    {
        if(!visited.containsKey(start))
        {
            count++;
            System.out.println("The time into element "+start+":"+count);//记录进入该节点的时间
            visited.put(start, true);
            for (char c : graph.get(start))
            {
                if(!visited.containsKey(c))
                {
                    visit(graph,visited,c);//递归访问其邻近节点
                }
            }
            count++;
            System.out.println("The time out element "+start+":"+count);//记录离开该节点的时间
        }
    }


    public static void main(String[] args) {
        //Graphmatrix g = new Graphmatrix();
        DFS dfs = new DFS();
        //g.creatGraphmatrix();
        //dfs.DFS(g.varr,g.arcs,0);

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


        dfs.dfs(graph, dfs.visited);

    }
}
