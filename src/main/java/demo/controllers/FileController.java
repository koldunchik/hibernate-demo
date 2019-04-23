package demo.controllers;

import demo.models.File;
import demo.models.FileDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileController {

  @RequestMapping(value="/all")
  @ResponseBody
  public String all() {
    try {
      List<File> listFiles = fileDao.getAll();
      String result = listFiles.stream().map(Object::toString).collect(Collectors.joining("<hr>"));
      return result;
    }
    catch (Exception ex) {
      return "Error searching all files: " + ex.toString();
    }
  }
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      File user = new File(id);
      fileDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the file: " + ex.toString();
    }
    return "File succesfully deleted!";
  }

  @Autowired
  private FileDao fileDao;
  
}