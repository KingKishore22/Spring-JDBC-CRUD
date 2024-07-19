package com.kishoreb.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.kishoreb.pojo.Flames;
import com.kishoreb.resultextracter.ResultExtractors;
import com.kishoreb.rowmapper.RowMappers;

@Repository("dao_s")
public class Dao_imp implements Dao {
	//JdbcTemplate temp=new JdbcTemplate(getSource());
	@Autowired
	JdbcTemplate temp;
	
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	@Override
	public void insert(Flames fla) {
		// TODO Auto-generated method stub
		String que="INSERT INTO HISTORYS1 VALUES(?,?,?,?)";
		Object[]objs={fla.getRo(),fla.getYourname(),fla.getCrushname(),fla.getResult()};
		int ro=temp.update(que,objs);
		System.out.println(ro+" Row Inserted");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String que="DELETE FROM HISTORYS1 WHERE id=?";
		int su=temp.update(que,id);
		System.out.println(su+" Row Deleted");
	}
	
	/*DataSource getSource() {
		String url="jdbc:mysql://localhost:3306/history?characterEncoding=utf8";
		String user="root";
		String password="kishore";
		DataSource ds=new DriverManagerDataSource(url,user,password);
		return ds;
	}*/
void cleanup() {
	String que="TRUNCATE TABLE HISTORYS1";
	temp.execute(que);
	System.out.println("All Datas Cleared!!!!!!!!");
}

@Override
public List<Flames> getAll() {
	// TODO Auto-generated method stub
	 String que = "SELECT id as id, " +
             "Name as yourname, " +
             "`Crush Name` as crushname, " +
             "Result as result " +
             "FROM HISTORYS1";
	//List<Flames>flam=temp.query(que, new RowMappers());
	// Bean Property Row Mapper
	List<Flames>flam=temp.query(que, new BeanPropertyRowMapper<Flames>(Flames.class));
	return flam;
}

@Override
public Flames getSingleRow(int id) {
	// TODO Auto-generated method stub
	String query="SELECT id as id, " +
    "Name as yourname, " +
    "`Crush Name` as crushname, " +
    "Result as result " +
    "FROM HISTORYS1 WHERE id=?";
	//Flames fl=temp.queryForObject(query,new RowMappers(),id);
	Flames fl=temp.queryForObject(query,new BeanPropertyRowMapper<Flames>(Flames.class),id);
	return fl;
}

@Override
public List<Flames> getAll_ResultSet() {
	// TODO Auto-generated method stub
	String que = "SELECT * FROM HISTORYS1";
	List<Flames> flam=temp.query(que, new ResultExtractors());
	return flam;
}

@Override
public Flames getSingleRow_ResultSet(int id) {
	// TODO Auto-generated method stub
		return null;
}

@Override
public int updateList(List<Flames> flam) {
	// TODO Auto-generated method stub
	String que="UPDATE HISTORYS1 SET Name=? WHERE id=?";
	temp.batchUpdate(que, new BatchPreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			// TODO Auto-generated method stub
			ps.setString(1, flam.get(i).getYourname());
			ps.setInt(2, flam.get(i).getRo());
	
		}
		
		@Override
		public int getBatchSize() {
			// TODO Auto-generated method stub
			return flam.size();
		}
	});
	System.out.println("Updated");
	return 0;
}
}
