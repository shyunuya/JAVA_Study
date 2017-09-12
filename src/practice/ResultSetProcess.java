package jdbcTest;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultSetProcess {

	public Map<String, String> getHeaderData(ResultSetMetaData metaData) throws SQLException {

		Map<String, String> returnHeader = null;
		int headerCount = metaData.getColumnCount();

		if (headerCount < 1)
			return returnHeader;

		returnHeader = new HashMap<String, String>();

		String columnName = null;
		String columnTypeName = null;

		for (int indexI = 1; indexI <= headerCount; ++indexI) {
			columnName = metaData.getColumnName(indexI);
			columnTypeName = metaData.getColumnTypeName(indexI);
			returnHeader.put(columnName, columnTypeName);
		}

		return returnHeader;
	}

	public Map<String, String> getHeaderData(ResultSet subResultSet) throws SQLException {

		if (subResultSet == null)
			return null;

		ResultSetMetaData rsmd = subResultSet.getMetaData();
		return getHeaderData(rsmd);

	}

	public List<Map<String, String>> getResultData(ResultSet subResultSet) throws SQLException {

		List<Map<String, String>> returnDataList = null;

		Map<String, String> headerInfo = getHeaderData(subResultSet);

		if (headerInfo == null)
			return returnDataList;

		returnDataList = new ArrayList<Map<String, String>>();

		while (subResultSet.next()) {

			Set<String> keySet = headerInfo.keySet();
			Iterator<String> keyItor = keySet.iterator();
			String columnName = null;
			String columnValue = null;
			Map<String, String> rowResult = new HashMap<String, String>();

			while (keyItor.hasNext()) {

				columnName = keyItor.next();
				columnValue = subResultSet.getString(columnName);

				rowResult.put(columnName, columnValue);

			}

			returnDataList.add(rowResult);

		}

		return returnDataList;

	}

}
