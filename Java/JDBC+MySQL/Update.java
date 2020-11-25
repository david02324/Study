import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) throws SQLException {
        // 객체 생성
        Connection con = null;
        java.sql.PreparedStatement st;
        
        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문
        String query = "update notice " +
                "set title=?," +
                "content=?," +
                "files=? " +
                "where id=?";

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


        // DB 선택
        st = con.prepareStatement(selectDB);
        st.executeQuery();

        String title="TEST3";
        String content="hahaha3";
        String files="";
        int id = 5;
        st = con.prepareStatement(query);
        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);

        int result = st.executeUpdate();

        System.out.println(result);


        // 접속 종료
        try {
            if(con != null)
                st.close();
                con.close();
        } catch (SQLException e) {}
    }
}
