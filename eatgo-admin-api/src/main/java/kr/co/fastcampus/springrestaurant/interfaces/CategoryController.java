package kr.co.fastcampus.springrestaurant.interfaces;

import kr.co.fastcampus.springrestaurant.application.CategoryService;
import kr.co.fastcampus.springrestaurant.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> list() {
        return this.categoryService.getCategories();
    }

    @PostMapping("/categories")
    public ResponseEntity create(@RequestBody Category resource) throws URISyntaxException {
        Category category = categoryService.addCategory(resource.getName());
        String url = "categories/" + category.getId();
        System.out.println(category.getId());
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
