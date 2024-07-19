package com.kishoreb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kishoreb.pojo.Flames;

public class RowMappers implements RowMapper<Flames> {

	@Override
	public Flames mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Flames fl=new Flames();
		fl.setYourname(rs.getString("Name"));
		fl.setCrushname(rs.getString("Crush Name"));
		fl.setResult(rs.getString("Result"));
		return fl;
	}

}
