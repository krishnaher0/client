package com.example.meatshop.Service;




import com.example.meatshop.Pojo.AboutPojo;

import java.util.List;

public interface AboutService {

    void updateAbout(Integer id, AboutPojo aboutPojo);

    void deleteAbout(Integer id);

    void createAbout(AboutPojo aboutPojo);

    AboutPojo getAbout(Integer id);

    List<AboutPojo> getAllAbout();
}