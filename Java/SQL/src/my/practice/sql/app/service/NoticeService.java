package my.practice.sql.app.service;

import my.practice.sql.app.entity.Notice;

import javax.sound.midi.MidiMessage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    // 접속 정보
    private String URL = "jdbc:mysql://localhost:3305?useSSL=false"; // 서버 주소
    private String userName = "root"; //  접속자 id
    private String password = "111111"; // 접속자 pw
    private String driver = "com.mysql.jdbc.Driver";


    public List<Notice> getList(int page) throws SQLException {

        int startRowNum = (page-1)*10;
        int amount = 10;

        // 객체 생성
        Connection con = null;
        Statement st;
        PreparedStatement pst;
        ResultSet rs;

        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문
        String setVar = "SET @rownum:=0";
        String getOnePage = "SELECT" +
                "  @rownum:=@rownum+1 as ROWNUM," +
                "  notice.* " +
                "FROM notice " +
                "limit ?,?";

        // JDBC 드라이버 로드
        try {
            Class.forName(driver);
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
        // DB지정
        st = con.createStatement();
        st.executeQuery(selectDB);

        // 변수 선언
        st.executeQuery(setVar);

        // 한 페이지 받아오기
        pst = con.prepareStatement(getOnePage);
        pst.setInt(1,startRowNum);
        pst.setInt(2,amount);
        rs = pst.executeQuery();

        List<Notice> list = new ArrayList<Notice>();

        while(rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("writer_id");
            String content = rs.getString("content");
            Date regDate = rs.getDate("regDate");
            int hit = rs.getInt("hit");
            String files = rs.getString("FILES");

            Notice notice = new Notice(
                    id,
                    title,
                    writerId,
                    content,
                    regDate,
                    hit,
                    files
            );

            list.add(notice);
        }
        // 접속 종료
        try {
            if(con != null)
                rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {}

        return list;
    }

    public List<Notice> getListFromTitle(String searchTitle) throws  SQLException {

        // 객체 생성
        Connection con = null;
        Statement st;
        PreparedStatement pst;
        ResultSet rs;

        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문
        String getRows = "SELECT * FROM NOTICE";

        // JDBC 드라이버 로드
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

        // DB지정
        st = con.createStatement();
        st.executeQuery(selectDB);


        // row 받아오기
        st = con.createStatement();
        rs = st.executeQuery(getRows);

        List<Notice> searchedList = new ArrayList<Notice>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("writer_id");
            String content = rs.getString("content");
            Date regDate = rs.getDate("regDate");
            int hit = rs.getInt("hit");
            String files = rs.getString("FILES");

            if (title.equals(searchTitle)) {

                Notice notice = new Notice(
                        id,
                        title,
                        writerId,
                        content,
                        regDate,
                        hit,
                        files
                );

                searchedList.add(notice);
            }
        }
        // 접속 종료
        rs.close();
        st.close();
        con.close();
        return searchedList;
    }

    public int getCount() throws SQLException {
        int count = 0;
        Connection con = null;
        Statement st;
        ResultSet rs;

        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문

        // 글 개수 받아오기
        String getCount = "SELECT COUNT(ID) COUNT FROM NOTICE";


        // JDBC 드라이버 로드
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

        // DB지정
        st = con.createStatement();
        st.executeQuery(selectDB);

        rs = st.executeQuery(getCount);
        if(rs.next()) {
            count = rs.getInt("COUNT");
        }
        // 접속 종료
        try {
            if(con != null)
                rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {}

        return count;
    }

    public int Insert(Notice notice) throws SQLException {
        // 객체 생성
        Connection con = null;
        java.sql.PreparedStatement st;

        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문
        String getOneRow = "insert into notice(" +
                "title," +
                "writer_id," +
                "content," +
                "files" +
                ") values(?,?,?,?)";


        // JDBC 드라이버 로드
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }


        // DB 선택
        st = con.prepareStatement(selectDB);
        st.executeQuery();

        String title=notice.getTitle();
        String writerId=notice.getWriterId();
        String content=notice.getContent();
        String files=notice.getFiles();
        st = con.prepareStatement(getOneRow);
        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setString(4,files);

        int result = st.executeUpdate();

        // 접속 종료
        if(con != null) {
            st.close();
            con.close();
        }
        return result;
    }

    public int Update(Notice notice) throws SQLException {
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

        // JDBC 드라이버 로드
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }


        // DB 선택
        st = con.prepareStatement(selectDB);
        st.executeQuery();

        String title=notice.getTitle();
        String content=notice.getContent();
        String files=notice.getFiles();
        int id = notice.getId();
        st = con.prepareStatement(query);
        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);

        int result = st.executeUpdate();


        // 접속 종료
        if(con != null) {
            st.close();
            con.close();
        }
        return result;
    }

    public int Delete(int id) throws SQLException {
        // 객체 생성
        Connection con = null;
        java.sql.PreparedStatement st;

        // 초기 쿼리
        String selectDB = "use testdb"; // DB 선택문
        String query = "DELETE FROM NOTICE WHERE ID=?";

        // JDBC 드라이버 로드
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }


        // DB 선택
        st = con.prepareStatement(selectDB);
        st.executeQuery();

        // 쿼리 전달;
        st = con.prepareStatement(query);
        st.setInt(1, id);

        // 실행
        int result = st.executeUpdate();


        // 접속 종료
        if (con != null) {
            st.close();
            con.close();
        }
        return result;
    }
}
