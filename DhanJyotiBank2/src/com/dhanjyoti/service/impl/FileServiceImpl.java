package com.dhanjyoti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyoti.dao.FileDao;
import com.dhanjyoti.model.CustomerKypDocs;
import com.dhanjyoti.service.FileService;
@Service
public class FileServiceImpl implements FileService{
    @Autowired
    FileDao fileDao;
	@Override
	public CustomerKypDocs getCustomerKYPDoc(Integer id) {
		// TODO Auto-generated method stub
		return fileDao.getCustomerKYPDoc(id);
	}

}
