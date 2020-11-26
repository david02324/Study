import java.sql.*;

public class SQLtest {
    public static void main(String[] args) throws SQLException {
        // 객체 생성
        Connection con = null;
        Statement st;
        ResultSet rs;
        
        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문
        String getOneRow = "SELECT * FROM NOTICE"; // 하나의 row 가져오기

        // 접속 정보
        String URL = "jdbc:mysql://localhost:3305?useSSL=false"; // 서버 주소
        String userName = "root"; //  접속자 id
        String password = "111111"; // 접속자 pw
        
        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }
        
        // 접속
        try {
            con = DriverManager.getConnection(URL, userName, password);
            System.out.println("연결 완료!");
        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }
            // statement 객체 지정
            st = con.createStatement();

            // DB 선택
            rs = st.executeQuery(selectDB);

            // row들 가져오기
            rs = st.executeQuery(getOneRow);

            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("TITLE");
                String writerId = rs.getString("writer_id");
                String content = rs.getString("content");
                Date regDate = rs.getDate("regDate");
                int hit = rs.getInt("hit");
                if(hit>=10)
                System.out.printf("id :%d, title:%s, writerId:%s, regDate:%s," +
                        "content:%s, hit:%d\n",id,title,writerId,regDate,content,hit);
            }
        // 접속 종료
        try {
            if(con != null)
                rs.close();
                st.close();
                con.close();
        } catch (SQLException e) {}
    }
}
