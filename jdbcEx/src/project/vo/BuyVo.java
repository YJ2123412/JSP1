package project.vo;

import oracle.sql.DATE;

public class BuyVo {
    private String CUSTOMID;
    private String PCODE;
    private int QUANTITY;
    private int BUY_IDX;
    private DATE BUY_DATE;

    public BuyVo(int bUY_IDX, String cUSTOMID, String pCODE, int qUANTITY, DATE bUY_DATE) {
        CUSTOMID = cUSTOMID;
        PCODE = pCODE;
        QUANTITY = qUANTITY;
        BUY_IDX = bUY_IDX;
        BUY_DATE = bUY_DATE;
    }

    public String getCUSTOMID() {
        return CUSTOMID;
    }

    public String getPCODE() {
        return this.PCODE;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public int getBUY_IDX() {
        return BUY_IDX;
    }

    @Override
    public String toString() {
        return "BuyVo [CUSTOMID=" + CUSTOMID + ", PCODE=" + PCODE + ", QUANTITY=" + QUANTITY + ", BUY_IDX=" + BUY_IDX
                + ", BUY_DATE=" + BUY_DATE + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CUSTOMID == null) ? 0 : CUSTOMID.hashCode());
        result = prime * result + ((PCODE == null) ? 0 : PCODE.hashCode());
        result = prime * result + QUANTITY;
        result = prime * result + BUY_IDX;
        result = prime * result + ((BUY_DATE == null) ? 0 : BUY_DATE.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyVo other = (BuyVo) obj;
        if (CUSTOMID == null) {
            if (other.CUSTOMID != null)
                return false;
        } else if (!CUSTOMID.equals(other.CUSTOMID))
            return false;
        if (PCODE == null) {
            if (other.PCODE != null)
                return false;
        } else if (!PCODE.equals(other.PCODE))
            return false;
        if (QUANTITY != other.QUANTITY)
            return false;
        if (BUY_IDX != other.BUY_IDX)
            return false;
        if (BUY_DATE == null) {
            if (other.BUY_DATE != null)
                return false;
        } else if (!BUY_DATE.equals(other.BUY_DATE))
            return false;
        return true;
    }




    
    

    
}
