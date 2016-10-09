package com.graph;

import java.util.Scanner;

/**
 * Created by yichli on 9/28/16.
 */

class Varr
{
    char data;
    int du;
    boolean visit;
    public Varr(char data){
        this.data = data;
        this.du = 0;
        this.visit = false;
    }
}

public class Graphmatrix {
    Varr varr[];
    int[][] arcs;
    int vnum; // 顶点个数
    Scanner sc = new Scanner(System.in);

    public void creatGraphmatrix() {
        System.out.println("请输入顶点个数");
        vnum = sc.nextInt();
        varr = new Varr[vnum];
        arcs = new int[vnum][vnum];

        //init
        for (int i = 0; i < vnum; i++) {
            for (int j = 0; j < vnum; j++) {
                arcs[i][j] = 0;
            }
        }

        System.out.println("请输入顶点数据");
        String point = sc.next();
        char p[] = point.toCharArray();
        for (int i = 0; i < p.length; i++) {
            varr[i] = new Varr(p[i]);
        }

        System.out.println("请输入边的条数");

        int d = sc.nextInt();
        System.out.println("请输入各边");
        int i;
        String[] f = new String[d];
        for (i = 0; i < d; i++) {
            f[i] = sc.next();
        }
        for (int u = 0; u < vnum; u++) {
            int h = 0;
            char ap[] = new char[d];
            for (i = 0; i < d; i++) {
                char[] b = f[i].toCharArray();
                if (b[0] == varr[u].data) {
                    ap[h] = b[1];
                    h++;
                }
            }
            if (h == 0)
                continue;
            varr[u].du += h;
            for (int j = 0; j < vnum; j++) {
                for (int r = 0; r < h; r++) {
                    if ((varr[j].data == ap[r])) {
                        varr[j].du++;
                        break;
                    }
                }
            }

            int y;
            int ap_int[] = new int[d];       //存放邻接点下标
            if (h == 0)
                continue;//ap_int[0]=-1;
            else {
                for (int t = 0; t < h; t++) {          //获取邻接点下标
                    y = 0;
                    while (varr[y].data != ap[t] && y < varr.length) {
                        y++;
                    }
                    ap_int[t] = y;
                }
            }

            for (int r = 0; r < h; r++)
                arcs[u][ap_int[r]] = 1;

        }


    }


    public static void main(String[] args) {
        Graphmatrix g = new Graphmatrix();
        g.creatGraphmatrix();


        for(int i = 0; i < g.arcs.length; i++){
            for(int j = 0; j < g.arcs[0].length; j++){
                System.out.print(g.arcs[i][j] + " ");
            }
            System.out.println();
        }
    }
}