package com.yoonstore.yoonshop.domains.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void addItem(Item item) {
        this.itemRepository.save(item);
    }

    public List<Item> findItems() {
        return this.itemRepository.findAll();
    }

    public Item findOne(Long id) {
        return this.itemRepository.findOne(id);
    }

}
