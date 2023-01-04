package guru.springfamework.bootstrap;

import guru.springfamework.repositories.CategoryRepository;

public class Bootstarp {
    private CategoryRepository categoryRepository;

    public Bootstarp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
