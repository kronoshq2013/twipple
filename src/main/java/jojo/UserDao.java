package jojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	// public List<UserDTO> findAll(){return null;}
	
	public int count(String name, String password) throws SQLException {
		int result = 0;
		try {
			StringBuilder sbSQL = new StringBuilder();
			sbSQL.append("select");
			sbSQL.append("       count(*) as count");
			sbSQL.append("  from users");
			sbSQL.append(" where name = ?");
			sbSQL.append("   and password = ?");

			PreparedStatement ps = con.prepareStatement(sbSQL.toString());
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			// ここもうまくやりたいね
			
			System.out.println(e.getMessage());
		} finally {
			// ps もクローズしましょう
			
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public int insert(String name, String password ) throws SQLException {
		int result = 0;
		
		// SQL文を作成する
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" insert into users ");
		sbSQL.append("select ");
	    sbSQL.append("       max(usid) + 1 as usid ");
	    sbSQL.append("     ,? ");
	    sbSQL.append("      ,? ");
	    sbSQL.append("      from users ");
		
		// SQL文に値を設定する
		PreparedStatement stmt = con.prepareStatement(sbSQL.toString());
		
		stmt.setString(1, name);
		stmt.setString(2, password);


		
		try {
			// SQL文を実行し、その結果を取得する
			result = stmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			// コネクションを閉じる
			try {
				if (con != null) { 
				con.close();
				}
			}catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
		return result;
	}
	public int speakInsert(String speak) throws SQLException {
		int result = 0;
		
		// SQL文を作成する
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" insert into tsubuyaki ");
		sbSQL.append("select ");
	    sbSQL.append("       max(id) + 1 as id ");
	    sbSQL.append("     , ? ");
	    sbSQL.append("      ,systimestamp ");
	    sbSQL.append("          from tsubuyaki ");
		
		// SQL文に値を設定する
		PreparedStatement stmt = con.prepareStatement(sbSQL.toString());
		
		stmt.setString(1, speak);


		
		try {
			// SQL文を実行し、その結果を取得する
			result = stmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			// コネクションを閉じる
		}
		return result;
	}
	
	// Ctrl + Shift + G
	public List<TsubuyakiDto> getSpeak(Connection con) throws SQLException{
		PreparedStatement ps = null;
		try {
			StringBuilder sbSQL = new StringBuilder();
			sbSQL.append("select");
			sbSQL.append("  speak");
			sbSQL.append("  , to_char(dt,'yyyy/mm/dd hh24:mi:ss') as dt ");
			sbSQL.append("from");
			sbSQL.append("  tsubuyaki");
//			sbSQL.append("  where rownum <=10");
			sbSQL.append("  order by id desc");
		    ps = con.prepareStatement(sbSQL.toString());
		    
		    System.out.println(sbSQL.toString());
			
		    ResultSet rs = ps.executeQuery();
			// Userオブジェクトを格納するリストを作ります。
			List<TsubuyakiDto> users = new ArrayList<TsubuyakiDto>();
			while(rs.next()){
				// ResultSetの結果をDTOに詰め込みます！
				TsubuyakiDto userDTO = new TsubuyakiDto();
				userDTO.setSpeak(rs.getString("speak"));
				userDTO.setDt(rs.getString("dt"));
				users.add(userDTO);
			}
			return users;
		} catch (SQLException e) {
			// どうしよ？
			// nullを返す？ 空っぽのリストを返す？ SQLExceptionをそのまま返す？ 独自の例外クラスを返す？
			e.printStackTrace();
			throw e;
		} finally{
			if (ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}
	}
}
		

