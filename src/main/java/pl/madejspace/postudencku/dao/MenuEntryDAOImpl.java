package pl.madejspace.postudencku.dao;

import pl.madejspace.postudencku.MenuEntry;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuEntryDAOImpl implements MenuEntryDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(MenuEntry menuEntry) {

    }

    @Override
    public MenuEntry findById(int id) {
        String query = "SELECT * FROM dishes WHERE id = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            MenuEntry entry = null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                entry = new MenuEntry(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        null // TODO: implement getting MenuCategory
                );
            }
            rs.close();
            ps.close();
            return entry;
        } catch(SQLException sqle) {
            return null;
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqle) {}
            }
        }
    }
}
