package com.kishoreb.resultextracter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.kishoreb.pojo.Flames;

public class ResultExtractors implements ResultSetExtractor<List<Flames>> {

	@Override
	public List<Flames> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Flames>fla=new ArrayList<>();
		while(rs.next()) {
			Flames fl=new Flames();
			fl.setYourname(rs.getString("Name"));
		    fl.setCrushname(rs.getString("Crush Name"));
	        fl.setResult(rs.getString("Result"));
	        fla.add(fl);
		}
		return fla;
	}

}
