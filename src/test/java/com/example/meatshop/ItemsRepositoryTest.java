package com.example.meatshop;



import com.example.meatshop.Entity.FileData;
import com.example.meatshop.Entity.Items;
import com.example.meatshop.Pojo.ItemsPojo;
import com.example.meatshop.Repo.ItemsRepo;

import com.example.meatshop.Service.Impl.ItemServiceImpl;
import com.example.meatshop.Service.Impl.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemsRepositoryTest {

    @Mock
    private ItemsRepo itemsRepo;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addProductsTest() throws IOException {
        MultipartFile image = mock(MultipartFile.class);
        when(image.getContentType()).thenReturn("image/png");
        when(image.isEmpty()).thenReturn(false);
        when(storageService.uploadImageToFileSystem(image)).thenReturn("test.png");

        Items item = new Items();
        item.setItemName("Item Name");

        itemService.addProducts(item, image);

        verify(storageService).uploadImageToFileSystem(image);
        verify(itemsRepo).save(any(Items.class));
    }

    @Test
    public void getAllTest() {
        Items item = new Items();
        item.setItemName("Item Name");

        when(itemsRepo.findAll()).thenReturn(Collections.singletonList(item));

        List<Items> items = itemService.getAll();

        assertNotNull(items);
        assertEquals(1, items.size());
        assertEquals("Item Name", items.get(0).getItemName());
    }

    @Test
    public void deleteByIdTest() {
        Long id = 1L;
        itemService.deleteById(id);
        verify(itemsRepo).deleteById(id.intValue());
    }

    @Test
    public void findByIdTest() {
        Long id = 1L;
        Items item = new Items();
        item.setItemName("Item Name");

        when(itemsRepo.findById(id.intValue())).thenReturn(Optional.of(item));

        Optional<Items> foundItem = itemService.findById(id);

        assertTrue(foundItem.isPresent());
        assertEquals("Item Name", foundItem.get().getItemName());
    }

    @Test
    public void updateDataTest() throws IOException {
        Long id = 1L;
        Items existingItem = new Items();
        existingItem.setItemName("Old Name");



        Items itemsPojo = new Items();
        itemsPojo.setItemName("New Name");

        MultipartFile image = mock(MultipartFile.class);
        when(image.getContentType()).thenReturn("image/png");
        when(image.isEmpty()).thenReturn(false);
        when(storageService.uploadImageToFileSystem(image)).thenReturn("new.png");

        when(itemsRepo.findById(id.intValue())).thenReturn(Optional.of(existingItem));

        itemService.updateData(id, itemsPojo, image);

        // Verify that the save method is called with the updated item
        verify(itemsRepo).save(existingItem);

        // Check that the item name has been updated
        assertEquals("New Name", existingItem.getItemName(), "Item name should be updated to 'New Name'");

        // Ensure the image data is set
        assertNotNull(existingItem.getImageData(), "Image data should not be null");
        assertEquals("new.png", existingItem.getImageData().getName(), "Image file name should be 'new.png'");
    }



    @Test
    public void existsByIdTest() {
        Integer id = 1;
        when(itemsRepo.existsById(id)).thenReturn(true);

        boolean exists = itemService.existsById(id);

        assertTrue(exists);
    }

    @Test
    public void getProductImageTest() throws IOException {
        Long id = 1L;
        Items item = new Items();
        FileData fileData = FileData.builder()
                .name("test.png")
                .build();
        item.setImageData(fileData);

        byte[] imageBytes = "image data".getBytes();
        when(itemsRepo.findById(id.intValue())).thenReturn(Optional.of(item));
        when(storageService.downloadImageFromFileSystem("test.png")).thenReturn(imageBytes);

        byte[] imageData = itemService.getProductImage(id);

        assertNotNull(imageData);
        assertArrayEquals(imageBytes, imageData);
    }

    @Test
    public void ItemCountTest() {
        when(itemsRepo.count()).thenReturn(10L);

        Long count = itemService.ItemCount();

        assertEquals(10L, count);
    }
}
