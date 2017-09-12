package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class HiveJdbcTest {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	private static String url = "";
	private static String id = "";
	private static String passwd = "";

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetProcess rsp = new ResultSetProcess();
		String sql = args[0];

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, id, passwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			List<Map<String, String>> resultData = rsp.getResultData(rs);

			for (int idx = 0; idx < resultData.size(); idx++) {
				Map<String, String> hm = resultData.get(idx);
				Set<String> hmKey = hm.keySet();
				Iterator<String> hmKeyItor = hmKey.iterator();

				while (hmKeyItor.hasNext()) {

					String key = hmKeyItor.next();
					String value = hm.get(key);
					// System.out.print(key);
					System.out.println(value + ",");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
