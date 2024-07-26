package com.example.meatshop;



import com.example.meatshop.Entity.About;
import com.example.meatshop.Pojo.AboutPojo;
import com.example.meatshop.Repo.AboutRepo;
import com.example.meatshop.Service.Impl.AboutServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(AboutServiceImpl.class)
public class AboutRepositoryTest {

    @Autowired
    private AboutServiceImpl aboutService;

    @Autowired
    private AboutRepo aboutRepo;

    @Autowired
    private TestEntityManager entityManager;

    private About about;

    @BeforeEach
    public void setUp() {
        about = new About();
        about.setOurMission("Old Mission");
        about.setOurVision("Old Vision");
        entityManager.persistAndFlush(about);
    }

    @Test
    public void testUpdateAbout() {
        AboutPojo aboutPojo = new AboutPojo();
        aboutPojo.setOurMission("New Mission");
        aboutPojo.setOurVision("New Vision");

        aboutService.updateAbout(about.getAboutId(), aboutPojo);

        About updatedAbout = aboutRepo.findById(about.getAboutId()).orElse(null);
        assertNotNull(updatedAbout);
        assertEquals("New Mission", updatedAbout.getOurMission());
        assertEquals("New Vision", updatedAbout.getOurVision());
    }

    @Test
    public void testDeleteAbout() {
        aboutService.deleteAbout(about.getAboutId());
        assertFalse(aboutRepo.findById(about.getAboutId()).isPresent());
    }

    @Test
    public void testCreateAbout() {
        aboutRepo.deleteAll(); // Ensure there are no existing About entries

        AboutPojo aboutPojo = new AboutPojo();
        aboutPojo.setOurMission("Mission");
        aboutPojo.setOurVision("Vision");

        aboutService.createAbout(aboutPojo);

        List<About> aboutList = aboutRepo.findAll();
        assertEquals(1, aboutList.size());
        assertEquals("Mission", aboutList.get(0).getOurMission());
        assertEquals("Vision", aboutList.get(0).getOurVision());
    }

    @Test
    public void testGetAbout() {
        AboutPojo aboutPojo = aboutService.getAbout(about.getAboutId());
        assertNotNull(aboutPojo);
        assertEquals("Old Mission", aboutPojo.getOurMission());
        assertEquals("Old Vision", aboutPojo.getOurVision());
    }

    @Test
    public void testGetAllAbout() {
        About about2 = new About();
        about2.setOurMission("Second Mission");
        about2.setOurVision("Second Vision");
        entityManager.persistAndFlush(about2);

        List<AboutPojo> aboutPojos = aboutService.getAllAbout();
        assertEquals(2, aboutPojos.size());
    }
}
