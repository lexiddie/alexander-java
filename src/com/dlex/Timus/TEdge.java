package com.dlex.Timus;

public class TEdge {
    public final int compareTo(TEdge otherInstance)
    {
        if (lessThan(otherInstance))
        {
            return -1;
        } else if (otherInstance.lessThan(this))
        {
            return 1;
        }

        return 0;
    }

    public int _begin;
    public int _end;
    public int _cost;


    public boolean lessThan(final TEdge e)
    {
        return _cost < e._cost;
    }
}
