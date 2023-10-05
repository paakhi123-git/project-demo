//Author : Manish Kote S
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
    	if (item.getItemName() == null || item.getItemPrice() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid item data");
        }

        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with ID: " + id);
        }
    }

    public Item updateItem(Long id, Item updatedItem) {
        if (!itemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with ID: " + id);
        }
        updatedItem.setItemID(id);
        return itemRepository.save(updatedItem);
    }

    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with ID: " + id);
        }
        itemRepository.deleteById(id);
    }

}