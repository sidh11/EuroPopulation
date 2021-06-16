package com.Ep.dao;

import java.util.List;
import com.Ep.bean.*;

public interface EPDao {

	int update(EP ep);

	int addEP(EP ep);

	int delByID(int id);

	int delByName(String Cname);

	EP findById(int id);

	EP findByName(String Cname);

	List<EP> findAll();

}
