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
        items.setCategoryId(itemsPojo.getCategoryId());
        items.setItemName(itemsPojo.getItemName());
        items.setPrice(itemsPojo.getPrice());
        items.setItemDetails(itemsPojo.getItemDetails());
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
    public void updateData(Integer id, ItemsPojo itemsPojo) {
        Optional<Items> itemsOptional = itemsRepo.findById(id);
//        if (itemsOptional.isPresent()) {
            Items existingItems = itemsOptional.get();
            // Update the existing student with the data from studentPojo
            updateStudentProperties(existingItems, itemsPojo);
            itemsRepo.save(existingItems); // Save the updated student
//        } else {
//            // Handle the case where the student with the given ID does not exist
//            throw new IllegalArgumentException("Student with ID " + id + " not found");
//        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(Items student, ItemsPojo studentPojo) {
        student.setItemName(studentPojo.getItemName());
        student.setItemDetails(studentPojo.getItemDetails());
        student.setCategoryId(studentPojo.getCategoryId());
        itemsRepo.save(student);
    }



    @Override
    public boolean existsById(Integer id) {
        return itemsRepo.existsById(id.intValue());
    }
}
