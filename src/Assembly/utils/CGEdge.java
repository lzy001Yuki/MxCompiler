package Assembly.utils;

import Assembly.Operand.Reg;

public class CGEdge {
    public Reg u, v;
    public CGEdge(Reg r1, Reg r2) {
        u = r1;
        v = r2;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof CGEdge e) && (e.u == u && e.v == v);
    }

    @Override
    public int hashCode() {
        return u.hashCode() ^ v.hashCode();
    }
}
