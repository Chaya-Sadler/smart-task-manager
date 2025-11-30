package chaya.sadler.task_service.service;

import chaya.sadler.task_service.dao.CategoryRepository;
import chaya.sadler.task_service.model.CategoryEntity;
import chaya.sadler.task_service.model.CategoryRequest;
import chaya.sadler.task_service.model.CategoryResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<String> createCategories(CategoryRequest categoryRequest) {

        CategoryEntity categoryEntity = new CategoryEntity(categoryRequest.name(),
                categoryRequest.description());
        categoryRepository.save(categoryEntity);

        return new ResponseEntity<>("Category successfully commited", HttpStatus.CREATED);
    }

    public List<CategoryResponse> getAllCategories() {
         List<CategoryEntity> categoryEntities = categoryRepository.findAll();
         return categoryEntities.stream()
                 .map( e -> new CategoryResponse(e.getName(), e.getDescription()))
                 .collect(Collectors.toList());
    }

    public ResponseEntity<String> deleteCategory(UUID id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(" Category does not exist"));
        categoryRepository.delete(categoryEntity);
        return new ResponseEntity<>( " Category removed successfully!" , HttpStatus.OK);

    }

    public ResponseEntity<String> updateCategory(UUID id, CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(" Category does not exist"));

        categoryEntity.setName(categoryRequest.name());
        categoryEntity.setDescription(categoryRequest.description());
        categoryRepository.save(categoryEntity);

        return new ResponseEntity<>( " Category updated successfully!" , HttpStatus.OK);
    }

    public CategoryResponse getAllCategoriesById(UUID id) {

        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new CategoryResponse(categoryEntity.getName(), categoryEntity.getDescription());
    }
}
