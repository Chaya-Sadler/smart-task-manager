package chaya.sadler.task_service.controller;

import chaya.sadler.task_service.model.CategoryEntity;
import chaya.sadler.task_service.model.CategoryRequest;
import chaya.sadler.task_service.model.CategoryResponse;
import chaya.sadler.task_service.model.TaskRequest;
import chaya.sadler.task_service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<?> createCategories(@Valid @RequestBody CategoryRequest categoryRequest) {
        return categoryService.createCategories(categoryRequest);
    }

    @GetMapping("/categories")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/categories/{id}")
    public CategoryResponse getAllCategoriesById(@PathVariable UUID id){
        return categoryService.getAllCategoriesById(id);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable UUID id) {
        return categoryService.deleteCategory(id);
    }

    @PutMapping("category/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable UUID id, @RequestBody CategoryRequest categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }
}
