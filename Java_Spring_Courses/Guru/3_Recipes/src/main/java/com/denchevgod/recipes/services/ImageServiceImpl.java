package com.denchevgod.recipes.services;

import com.denchevgod.recipes.domain.Recipe;
import com.denchevgod.recipes.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            byte[] primitiveBytesImg = file.getBytes();
            Byte[] img = new Byte[primitiveBytesImg.length];

            int i = 0;
            for (byte b : primitiveBytesImg) {
                img[i++] = b;
            }

            recipe.setImage(img);
        } catch (IOException e) {
            log.error("Error with saving image\n", e);
            e.printStackTrace();
        }
    }
}
