package ru.mirea.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.edu.model.ItemInfo;

@Repository
public interface ItemInfoRepository extends JpaRepository<ItemInfo, Integer> {
}