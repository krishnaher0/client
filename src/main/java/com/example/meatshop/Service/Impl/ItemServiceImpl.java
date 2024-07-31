package com.example.meatshop.Service.Impl;

import com.example.meatshop.Entity.FileData;
import com.example.meatshop.Entity.Items;
import com.example.meatshop.Pojo.ItemsPojo;
import com.example.meatshop.Repo.ItemsRepo;
import com.example.meatshop.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemsRepo itemsRepo;
    private final StorageService storageService;

    @Override
    public void addProducts(Items items, MultipartFile image) throws IOException {
        String fileName = storageService.uploadImageToFileSystem(image);
        FileData imageData = FileData.builder()
                .name(fileName)
                .type(image.getContentType())
                .filePath(storageService.FOLDER_PATH + fileName)
                .build();
        items.setImageData(imageData);

        itemsRepo.save(items);
    }
    @Override
    public List<Items> getAll() {
        return itemsRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        itemsRepo.deleteById(id.intValue());
    }

    @Override
    public Optional<Items> findById(Long id) {
        return itemsRepo.findById(id.intValue());
    }

    @Override
    public void updateData(Long id, Items itemsPojo, MultipartFile image) throws IOException {
        Optional<Items> itemsOptional = itemsRepo.findById(id.intValue());
        if (itemsOptional.isPresent()) {
            Items existingItems = itemsOptional.get();
            existingItems.setItemName(itemsPojo.getItemName());
            existingItems.setPrice(itemsPojo.getPrice());
            existingItems.setItemDetails(itemsPojo.getItemDetails());
            if (image != null && !image.isEmpty()) {
                String fileName = storageService.uploadImageToFileSystem(image);
                FileData imageData = FileData.builder()
                        .name(fileName)
                        .type(image.getContentType())
                        .filePath(storageService.FOLDER_PATH + fileName)
                        .build();
                existingItems.setImageData(imageData);
            }
            itemsRepo.save(existingItems);
        } else {
            throw new IllegalArgumentException("Item with ID " + id + " not found");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return itemsRepo.existsById(id);
    }

    @Override
    public byte[] getProductImage(Long itemsId) throws IOException {
        System.out.println("Fetching image for product ID: " + itemsId);
        Optional<Items> optionalItems = itemsRepo.findById(itemsId.intValue());
        if (optionalItems.isPresent() && optionalItems.get().getImageData() != null) {
            String fileName = optionalItems.get().getImageData().getName();
            if (fileName != null) {
                System.out.println("Found image file name: " + fileName);
                byte[] imageData = storageService.downloadImageFromFileSystem(fileName);
                if (imageData == null) {
                    System.out.println("Failed to retrieve image data for file: " + fileName);
                }
                return imageData;
            } else {
                System.out.println("Image file name is null for product ID: " + itemsId);
            }
        } else {
            System.out.println("No image data found for product ID: " + itemsId);
        }
        return null;
    }

    @Override
    public Long ItemCount() {
        return itemsRepo.count();
    }
}
