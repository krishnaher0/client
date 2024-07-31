package com.example.meatshop.Service;

import com.example.meatshop.Entity.Items;
import com.example.meatshop.Pojo.ItemsPojo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service

public interface ItemService {
    void addProducts(Items items, MultipartFile image) throws IOException;
    List<Items> getAll();
    void deleteById(Long id);
    Optional<Items> findById(Long id);
    void updateData(Long id, Items items,MultipartFile image) throws IOException;
    boolean existsById(Integer id);
    byte [] getProductImage(Long itemsId) throws IOException;
    Long ItemCount();
}
