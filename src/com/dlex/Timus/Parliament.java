package com.dlex.Timus;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Parliament {
    static int t=0;
    static List<Integer> f= new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        StreamTokenizer in= new StreamTokenizer(new InputStreamReader(System.in));
        int n,i,j,k,l,m,c[];
        in.nextToken();
        n=(int) in.nval;
        c= new int[n];
        BST t= new BST();
        for(i=0;i<n;i++) {
            in.nextToken();
            c[i]=(int) in.nval;

        }
        for(i=n-1;i>=0;i--)
            t.insert(c[i]);
        t.print(t.head);
        System.out.println("");
    }

    private static class Node1{
        Node1 p,l,r;int val;
        Node1(int v) {
            p=null;
            l=null;
            r=null;
            val=v;
        }
    }
    private static class BST{
        Node1 head=null;
        public void insert(int num) {
            Node1 y = null;
            Node1 x=this.head;
            while(x!=null) {
                y=x;
                if (num<x.val)
                    x=x.l;
                else
                    x=x.r;
            }
            Node1 z= new Node1(num);
            z.p=y;
            if (y== null)
                this.head=z;
            else if (num<y.val)
                y.l=z;
            else
                y.r=z;
        }
        public void print(Node1 h) {
            if (h!=null) {
                print(h.r);
                print(h.l);
                System.out.print(h.val+" ");
            }
        }

    }

}
