package com.kishoreb.dao;

import java.util.List;

import com.kishoreb.pojo.Flames;

public interface Dao {
void insert(Flames fla);
void delete(int id);
List<Flames>getAll();
Flames getSingleRow(int id);
List<Flames>getAll_ResultSet();
Flames getSingleRow_ResultSet(int id);
int updateList(List<Flames> flam);
}
