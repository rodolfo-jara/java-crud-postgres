package com.jaracode.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaracode.apirest.apirest.Entities.Product;
import com.jaracode.apirest.apirest.Respositorie.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    //LISTAR TODOS LOS PRODUCTOS
    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    //BUSCAR POR ID DEL PRODUCTO
    @GetMapping("/findById/{id}")
    public Product findById(@PathVariable Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nos se encontro el prducto con el id" + id));
        }


    //CREAR UN PRODUCTO
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        // TODO: process POST request
        return productRepository.save(product);
    }


    //ACTUALIZAR UN PRODUCTO
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product detalleProduct) {
        //TODO: process PUT request
        Product product =  productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nos se encontro el prducto con el id" + id));
        product.setNombre(detalleProduct.getNombre());
        product.setPrecio(detalleProduct.getPrecio());
        product.setDescription(detalleProduct.getDescription());
        product.setImage(detalleProduct.getImage());

        return productRepository.save(product);

    }

    //ELIMINAR UN PRODUCTO
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product =  productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Nos se encontro el prducto con el id" + id));
        productRepository.delete(product);
        return "el producto con el " +id+ "correctamente";
        }

}
