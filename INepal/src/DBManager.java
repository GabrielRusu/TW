import java.sql.*;
import java.util.List;

public class DBManager {

    public static final String HOST = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "ION";
    public static final String PASS = "ION";
    Statement statement;
    String huge = new String("");
    String query = new String("");
    Connection connection;
    ResultSet rs;

    public DBManager() throws SQLException {
        connection = DriverManager.getConnection(HOST, USER, PASS);
        statement = connection.createStatement();
    }

    public String show(List<String> list, String page) throws SQLException {

        try {
            query += "select * from projects where";

            if (list.size() != 0) {
                if (list.get(0).equals("null")) {
                    query += " clus_id is null and";
                } else if (list.get(0).equals("not null")) {
                    query += " clus_id is not null and";
                } else if (!list.get(0).equals("")) {
                    query += " clus_id = '" + list.get(0) + "' and";
                }

                if (list.get(1).equals("null")) {
                    query += " dis_id is null and";
                } else if (list.get(1).equals("not null")) {
                    query += " dis_id is not null and";
                } else if (!list.get(1).equals("")) {
                    query += " dis_id = '" + list.get(1) + "' and";
                }

                if (list.get(2).equals("null")) {
                    query += " mun_id is null and";
                } else if (list.get(2).equals("not null")) {
                    query += " mun_id is not null and";
                } else if (!list.get(2).equals("")) {
                    query += " mun_id = '" + list.get(2) + "' and";
                }

                if (list.get(3).equals("null")) {
                    query += " activity_type is null and";
                } else if (list.get(3).equals("not null")) {
                    query += " activity_type is not null and";
                } else if (!list.get(3).equals("")) {
                    query += " activity_type like '%" + list.get(3) + "%' and";
                }

                if (list.get(4).equals("null")) {
                    query += " item is null and";
                } else if (list.get(4).equals("not null")) {
                    query += " item is not null and";
                } else if (!list.get(4).equals("")) {
                    query += " item like '%" + list.get(4) + "%' and";
                }

                if (list.get(5).equals("null")) {
                    query += " total is null and";
                } else if (list.get(5).equals("not null")) {
                    query += " total is not null and";
                } else if (!list.get(5).equals("")) {
                    query += " total = '" + list.get(5) + "' and";
                }

                if (list.get(6).equals("null")) {
                    query += " unit is null and";
                } else if (list.get(6).equals("not null")) {
                    query += " unit is not null and";
                } else if (!list.get(6).equals("")) {
                    query += " unit like '%" + list.get(6) + "%' and";
                }

            }

            query += " clus_id = clus_id";
            rs = statement.executeQuery(query);

            int nr = Integer.parseInt(page);
            int x = 0;
            if (nr > 1) {
                while (x < 50 * nr && rs.next()) {
                    x++;
                }
            }
            x = 0;
            while (x < 50 && rs.next()) {

                String district = "     ";
                for (int i = 1; i <= 7; i++) {
                    district += rs.getString(i) + "     |     ";
                }

                rs.next();
                huge += district + ">";
                x++;
            }

            while (rs.next()) {
                x++;
            }

            huge += " > > \t\t Mai sunt " + (x + 1) / 50 + " pagini";

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return huge;
    }

    public String insert(List<String> list) throws SQLException {

        try {
            query += "insert into PROJECTS values(";

            if (list.size() != 0) {
                if (!list.get(0).equals("")) {
                    query += "'" + list.get(0) + "',";
                } else {
                    query += "'', ";
                }
                if (!list.get(1).equals("")) {
                    query += "'" + list.get(1) + "',";
                } else {
                    query += "'', ";
                }
                if (!list.get(2).equals("")) {
                    query += "'" + list.get(2) + "',";
                } else {
                    query += "'', ";
                }
                if (!list.get(3).equals("")) {
                    query += "'" + list.get(3) + "',";
                } else {
                    query += "'', ";
                }
                if (!list.get(4).equals("")) {
                    query += "'" + list.get(4) + "',";
                } else {
                    query += "'', ";
                }
                if (!list.get(5).equals("")) {
                    query += "'" + list.get(5) + "',";
                } else {
                    query += "'', ";
                }
                if (!list.get(6).equals("")) {
                    query += "'" + list.get(6) + "')";
                } else {
                    query += "'') ";
                }
            }

            rs = statement.executeQuery(query);

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        huge = "        SUCCESS ";

        return huge;
    }

    public String update(List<String[]> list) throws SQLException {
        int ok = 0;
        try {
            query += "update PROJECTS set";

            if (list.size() != 0) {
                if (list.get(0)[0].equals("null")) {
                    query += " clus_id = null,";
                } else if (!list.get(0)[0].equals("")) {
                    query += " clus_id = '" + list.get(0)[0] + "',";
                }
                if (list.get(1)[0].equals("null")) {
                    query += " dis_id = null,";
                } else if (!list.get(1)[0].equals("")) {
                    query += " dis_id = '" + list.get(1)[0] + "',";
                }
                if (list.get(2)[0].equals("null")) {
                    query += " mun_id = null,";
                } else if (!list.get(2)[0].equals("")) {
                    query += " mun_id = '" + list.get(2)[0] + "',";
                }
                if (list.get(3)[0].equals("null")) {
                    query += " activity_type = null,";
                } else if (!list.get(3)[0].equals("")) {
                    query += " activity_type = '" + list.get(3)[0] + "',";
                }
                if (list.get(4)[0].equals("null")) {
                    query += " item = null,";
                } else if (!list.get(4)[0].equals("")) {
                    query += " item = '" + list.get(4)[0] + "',";
                }
                if (list.get(5)[0].equals("null")) {
                    query += " total = null,";
                } else if (!list.get(5)[0].equals("")) {
                    query += " total = '" + list.get(5)[0] + "',";
                }
                if (list.get(6)[0].equals("null")) {
                    query += " unit = null,";
                } else if (!list.get(6)[0].equals("")) {
                    query += " unit = '" + list.get(6)[0] + "',";
                }

                if (query.endsWith(",")) {
                    query = query.substring(0, query.length() - 1);
                }
                query += " where ";

                if (list.get(0).length > 1) {
                    if (list.get(0)[1].equals("null")) {
                        query += " clus_id is null and";
                    } else if (list.get(0)[1].equals("not null")) {
                        query += " clus_id is not null and";
                    } else if (!list.get(0)[1].equals("")) {
                        query += " clus_id like '%" + list.get(0)[1] + "%' and";
                    }
                }
                if (list.get(1).length > 1) {
                    if (list.get(1)[1].equals("null")) {
                        query += " dis_id is null and";
                    } else if (list.get(1)[1].equals("not null")) {
                        query += " dis_id is not null and";
                    } else if (!list.get(1)[1].equals("")) {
                        query += " dis_id like '%" + list.get(1)[1] + "%' and";
                    }
                }
                if (list.get(2).length > 1) {
                    if (list.get(2)[1].equals("null")) {
                        query += " mun_id is null and";
                    } else if (list.get(2)[1].equals("not null")) {
                        query += " mun_id is not null and";
                    } else if (!list.get(2)[1].equals("")) {
                        query += " mun_id like '%" + list.get(2)[1] + "%' and";
                    }
                }
                if (list.get(3).length > 1) {
                    if (list.get(3)[1].equals("null")) {
                        query += " activity_type is null and";
                    } else if (list.get(3)[1].equals("not null")) {
                        query += " activity_type is not null and";
                    } else if (!list.get(3)[1].equals("")) {
                        query += " activity_type like '%" + list.get(3)[1] + "%' and";
                    }
                }
                if (list.get(4).length > 1) {
                    if (list.get(4)[1].equals("null")) {
                        query += " item is null and";
                    } else if (list.get(4)[1].equals("not null")) {
                        query += " item is not null and";
                    } else if (!list.get(4)[1].equals("")) {
                        query += " item like '%" + list.get(4)[1] + "%' and";
                    }
                }
                if (list.get(5).length > 1) {
                    if (list.get(5)[1].equals("null")) {
                        query += " total is null and";
                    } else if (list.get(5)[1].equals("not null")) {
                        query += " total is not null and";
                    } else if (!list.get(5)[1].equals("")) {
                        query += " total like '%" + list.get(5)[1] + "%' and";
                    }
                }
                if (list.get(6).length > 1) {
                    if (list.get(6)[1].equals("null")) {
                        query += " unit is null and";
                    } else if (list.get(6)[1].equals("not null")) {
                        query += " unit is not null and";
                    } else if (!list.get(6)[1].equals("")) {
                        query += " unit like '%" + list.get(6)[1] + "%' and";
                    }
                }

                query += " clus_id = clus_id";
            }

            ok = statement.executeUpdate(query);

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        if (ok > 0) {
            huge = "        SUCCESS ";
        } else {
            huge = "    FAILURE ";
        }

        return huge;
    }

    public String delete(List<String> list) throws SQLException {

        try {
            query += "delete from projects where";

            if (list.size() != 0) {
                if (!list.get(0).equals("cluster") && !list.get(0).equals("")) {
                    query += " clus_id = '" + list.get(0) + "' and";
                }
                if (!list.get(1).equals("district") && !list.get(1).equals("")) {
                    query += " dis_id = '" + list.get(1) + "' and";
                }
                if (!list.get(2).equals("municipality") && !list.get(2).equals("")) {
                    query += " mun_id = '" + list.get(2) + "' and";
                }
                if (!list.get(3).equals("activity") && !list.get(3).equals("")) {
                    query += " activity_type like '%" + list.get(3) + "%' and";
                }
                if (!list.get(4).equals("item") && !list.get(4).equals("")) {
                    query += " item like '%" + list.get(4) + "%' and";
                }
                if (!list.get(5).equals("total") && !list.get(5).equals("")) {
                    query += " total = '" + list.get(0) + "' and";
                }
                if (!list.get(6).equals("units") && !list.get(6).equals("")) {
                    query += " unit like '%" + list.get(0) + "%' and";
                }
            }

            query += " clus_id  = clus_id";

            rs = statement.executeQuery(query);

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        huge = "        SUCCESS ";
        return huge;
    }

    public String showFunction() throws SQLException {
        CallableStatement stmt = null;
        ResultSet myRs = null;

        try {
            String functie = "{ call ION.STATISTICS(?) }";
            stmt = connection.prepareCall(functie);

            // avem doar parametru out care este un string
            stmt.registerOutParameter(1, java.sql.Types.VARCHAR);

            if (stmt.executeUpdate() > 0)
                huge = stmt.getString(1);

            //System.out.println(huge);
            stmt.close();
            connection.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            huge = se.getMessage();
        } catch (Exception e) {
            //Handle errors for Class.forName
            huge = e.getMessage();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                huge = se2.getMessage();
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                huge = se.getMessage();
            }
        }

        return huge;
    }


    public String showFunction2() throws SQLException {
        CallableStatement stmt = null;
        ResultSet myRs = null;

        try {
            String functie = "{ ? = call functii.ceva() }";
            stmt = connection.prepareCall(functie);

            //int x = 15;
            //stmt.setInt(1, x);
            stmt.registerOutParameter(1, java.sql.Types.INTEGER);

            if (stmt.executeUpdate() > 0)
                huge = stmt.getString(1);

            //System.out.println(huge);
            stmt.close();
            connection.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            huge = se.getMessage();
        } catch (Exception e) {
            //Handle errors for Class.forName
            huge = e.getMessage();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                huge = se2.getMessage();
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                huge = se.getMessage();
            }
        }

        return huge;
    }


    public String showFunction3() throws SQLException {
        CallableStatement stmt = null;
        ResultSet myRs = null;

        try {
            String functie = "{ ? = call functii.copaci() }";
            stmt = connection.prepareCall(functie);

            // avem doar parametru out care este un string
            stmt.registerOutParameter(1, java.sql.Types.VARCHAR);

            if (stmt.executeUpdate() > 0)
                huge = stmt.getString(1);

            //System.out.println(huge);
            stmt.close();
            connection.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            huge = se.getMessage();
        } catch (Exception e) {
            //Handle errors for Class.forName
            huge = e.getMessage();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                huge = se2.getMessage();
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                huge = se.getMessage();
            }
        }

        return huge;
    }

}
