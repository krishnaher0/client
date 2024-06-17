package com.example.meatshop.Service.Impl;

import com.example.meatshop.Entity.Items;
import com.example.meatshop.Pojo.ItemsPojo;
import com.example.meatshop.Repo.ItemsRepo;
import com.example.meatshop.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service

public class ItemServiceImpl implements ItemService {
    private final ItemsRepo itemsRepo;
    @Override
    public void saveData(ItemsPojo itemsPojo) {
        Items items=new Items();
        items.setItemName(itemsPojo.getProductName());
        items.setPrice(itemsPojo.getPrice());
        items.setProductDetails(items.getProductDetails());
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

    public void updateData(Integer id, ItemsPojo itemsPojo) {
        Optional<Items> itemsOptional = itemsRepo.findById(id);
        if (itemsOptional.isPresent()) {
            Items existingItems = itemsOptional.get();

            updateCategory(existingItems, itemsPojo);
            itemsRepo.save(existingItems);
        } else {

            throw new IllegalArgumentException("Items with ID " + id + " not found");
        }
    }
    private void updateCategory(Items existingItems, ItemsPojo itemsPojo) {
        if (itemsPojo.getId()!= null) {
            existingItems.setItemName(itemsPojo.getProductName());
            existingItems.setPrice(itemsPojo.getPrice());
            existingItems.setProductDetails(existingItems.getProductDetails());
        }
        throw new IllegalArgumentException("Items with ID " +" not found");


    }

    @Override
    public boolean existsById(Integer id) {
        return itemsRepo.existsById(id.intValue());
    }
}
