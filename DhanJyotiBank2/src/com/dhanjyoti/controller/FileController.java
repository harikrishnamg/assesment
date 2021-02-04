package com.dhanjyoti.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyoti.model.CustomerKypDocs;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.service.FileService;

@Controller
public class FileController {
    @Autowired
    FileService fileService;
    
	@RequestMapping(value = "/getKypDocument/{id}", method = RequestMethod.GET)
	public void getCustomer(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("CustomerID::"+id);
		CustomerKypDocs customerDoc = fileService.getCustomerKYPDoc(id);
		response.setContentType(customerDoc.getDocType());
        response.setContentLength(customerDoc.getDocContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + customerDoc.getDocDescription() +"\"");
  
        FileCopyUtils.copy(customerDoc.getDocContent(), response.getOutputStream());
		
		

	}
}
