package org.cboard.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hive")
public class HiveController {
    private static final String HIVE_JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    private static final String JDBC_URL = "jdbc:hive2://localhost:10000/mydb";

    @RequestMapping(value = "/getHiveData")
    public List<List<Object>> getHiveData(
            @RequestParam(name = "database", defaultValue = "mydb", required = false) String database,
            @RequestParam(name = "table", defaultValue = "u", required = false) String table) {
        String result = "No result";

        List<List<Object>> listListResult = null;
        try {
            listListResult = getHiveDataDetail(database, table);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("result=" + result);
        return listListResult;
    }

    private List<List<Object>> getHiveDataDetail(String database, String table) throws ClassNotFoundException, SQLException {
        String sql = "select * from " + database + "." + table;

        Class.forName(HIVE_JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(JDBC_URL, "", "");

        ResultSet rs = null;
        ResultSetMetaData resultMetaData = null;
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.println("Executing:\n\t" + sql);
        rs = pstmt.executeQuery();
        resultMetaData = rs.getMetaData();
        int nSize = resultMetaData.getColumnCount();

        List<List<Object>> listListRows = new ArrayList<List<Object>>();
        while (rs.next()) {
            List<Object> listOneRow = new ArrayList<Object>();
            for (int i = 1; i < nSize; i++) {
                switch (resultMetaData.getColumnType(i)) {
                case Types.VARCHAR:
                    listOneRow.add(rs.getString(resultMetaData.getColumnName(i)));
                    break;
                case Types.INTEGER:
                    listOneRow.add(new Integer(rs.getInt(resultMetaData.getColumnName(i))));
                    break;
                case Types.BIGINT:
                    listOneRow.add(new Long(rs.getLong(resultMetaData.getColumnName(i))));
                    break;
                case Types.TIMESTAMP:
                    listOneRow.add(rs.getDate(resultMetaData.getColumnName(i)));
                    break;
                case Types.DOUBLE:
                    listOneRow.add(rs.getDouble(resultMetaData.getColumnName(i)));
                    break;
                case Types.FLOAT:
                    listOneRow.add(rs.getFloat(resultMetaData.getColumnName(i)));
                    break;
                case Types.CLOB:
                    listOneRow.add(rs.getBlob(resultMetaData.getColumnName(i)));
                    break;
                default:
                    listOneRow.add("unknown data type");
                }
            }
            listListRows.add(listOneRow);
        }

        System.out.println(listListRows.size());
        for (List<Object> oneRow : listListRows) {
            for (Object column : oneRow) {
                System.out.print(column + "\t");
            }
            System.out.println();
        }

        return listListRows;
    }

}
