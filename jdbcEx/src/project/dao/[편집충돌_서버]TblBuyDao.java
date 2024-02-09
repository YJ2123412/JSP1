package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //tbl_buy 테이블을 대상으로 insert, update, delete 할 수 있는 dao 클래스 만들기 -TblBuyDao.java
    //테이블 컬럼과 1:1 대응되는 BuyVo.java 만들기 
    //테이블의 pk 컬럼은 BUY_IDX :  update, delete 할때 조건 컬럼으로 사용됨 (행을 식별) -> 모든 조건은 pk

    //장바구니 담기  - insert
    public void buy(BuyVo bv, String userId){
        String sql = "insert into tbl_buy(BUY_IDX, CUSTOMID, PCODE, QUANTITY, BUY_DATE)" +
        "VALUES(buy_pk_seq.nextval, ?, ?, ? , sysdate)";

        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
            )
            {   //2. 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행)
                pstmt.setString(1, userId);
                pstmt.setString(2, bv.getPCODE());
                pstmt.setInt(3, bv.getQUANTITY());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매 실행 예외 발생 : " + e.getMessage());
        }
    }

    //[2] 구매 취소   
    public void delete(BuyVo bv){
        String sql = "delete from tbl_buy where BUY_IDX =?";
        try (Connection connection = getConnection();      
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {pstmt.setInt(1, bv.getBUY_IDX());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매취소 실행 예외 발생 : " + e.getMessage());
    }
}

    //[3] 구매 수량 변경 -pk로 행을 식별 
    public void changNumber(BuyVo bv,int changeidx, int number){
        String sql ="UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";

        try (Connection connection = getConnection();      
            PreparedStatement pstmt = connection.prepareStatement(sql);){
            pstmt.setInt(1, number);
            pstmt.setInt(2, bv.getBUY_IDX());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("구매수량변경 실행 예외 발생 : " + e.getMessage());
        }
    }

    //mypage 기능의 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String costumerId){
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX, TB.PCODE, PNAME,PRICE,QUANTITY ,BUY_DATE \r\n" + 
            "FROM TBL_BUY tb \r\n" + 
            "JOIN TBL_PRODUCT tp \r\n" + 
            "ON TB.PCODE = TP.PCODE \r\n" + 
            "WHERE TB.CUSTOMID =? \r\n"+
            "ORDER by BUY_DATE desc";
            try (Connection connection = getConnection();      
                PreparedStatement pstmt = connection.prepareStatement(sql);)    
                {pstmt.setString(1, costumerId);
                 ResultSet rs = pstmt.executeQuery();
                //pstmt.executeQuery();//executeUpdate() write용 executeQuery() read용- 잘못됨
                while (rs.next()) {
                list.add(new CustomerBuyVo(rs.getInt("BUY_IDX"),
                                            rs.getString("PCODE"), 
                                            rs.getString("PNAME"), 
                                            rs.getInt("PRICE"),
                                            rs.getInt("QUANTITY"),
                                            rs.getTimestamp("BUY_DATE")));
                }
            } catch (SQLException e) {
            System.out.println("고객별 구매내역 실행 예외 발생 : " + e.getMessage());
            }return list;
    }
    




}
