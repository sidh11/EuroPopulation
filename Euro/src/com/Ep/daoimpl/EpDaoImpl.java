package com.Ep.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Ep.bean.EP;
import com.Ep.dao.EPDao;
import com.Ep.util.ConnectionManager;
import com.Ep.util.DBconnect;

public class EpDaoImpl implements EPDao {
	String except;

	@Override
	public EP findById(int id) {
		EP ep = null;
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "Select * from countries where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ep = new EP();
				ep.setId(rs.getInt("id"));
				ep.setCname(rs.getString("Cname"));
				ep.setCpopulation(rs.getFloat("Cpopulation"));
			}
			pstmt.close();
			rs.close();
		}

		catch (SQLException except) {
			// TODO Auto-generated catch block
			except.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return ep;
	}

	@Override
	public EP findByName(String Cname) {
		EP ep = null;
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "Select * from countries where Name = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, Cname);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ep = new EP();
				ep.setId(rs.getInt("id"));
				ep.setCname(rs.getString("Cname"));
				ep.setCpopulation(rs.getFloat("Cpopulation"));
			}
			pstmt.close();
			rs.close();
		}

		catch (SQLException except) {
			// TODO Auto-generated catch block
			except.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return ep;

	}

	@Override
	public List<EP> findAll() {
		List<EP> europ = new ArrayList<>();
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "select * from countries";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			while (rs.next()) {
				europ.add(new EP(rs.getInt("id"), rs.getString("Cname"), rs.getFloat("Cpopulation")));
			}
			stmt.close();
			rs.close();
		}

		catch (SQLException except) {
			// TODO Auto-generated catch block
			except.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return europ;
	}

	@Override
	public int update(EP ep) {
		int count = 0;
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "update countries set Cname=?, Cpopulation=? WHERE id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, ep.getCname());
			pstmt.setFloat(2, ep.getCpopulation());
			pstmt.setInt(3, ep.getId());
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionManager.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int addEP(EP ep) {
		int count = 0;
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "insert into countries (id, Cname, Cpopulation)" + "Values(?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, ep.getId());
			pstmt.setString(2, ep.getCname());
			pstmt.setFloat(3, ep.getCpopulation());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionManager.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int delByID(int id) {
		int count = 0;
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "delete from Countries where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, id);
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return count;
	}

	@Override
	public int delByName(String Cname) {
		int count = 0;
		Connection conn = DBconnect.getInstance().getConnection();
		String strSQL = "delete from Countries where CName=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, Cname);
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return count;
	}

}
