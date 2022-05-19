package B201210007;

import java.sql.*;

public class VeritabaniIslemleri implements IVeritabaniIslemleri{
    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nyat",
                    "postgres", "180951");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public boolean giris(String username, String password) {
        try {
            boolean girisDurumu;
            Connection conn = this.baglan();
            String sql = "SELECT *  FROM \"data\" WHERE \"kullanici\"='" + username + "' and \"password\"='" + password + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.close();
            Thread.sleep(500);
            if(!rs.next()){
                System.out.println("Böyle bir kullanıcı bulunamadi...");
                girisDurumu = false;
            }else {
                System.out.println("Giris basarili...");
                girisDurumu = true;
            }
            rs.close();
            stmt.close();
            return girisDurumu;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
