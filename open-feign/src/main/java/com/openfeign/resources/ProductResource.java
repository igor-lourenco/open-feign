package com.openfeign.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openfeign.dto.PageDTO;
import com.openfeign.dto.ProductDTO;
import com.openfeign.proxy.ProductProxy;

@RestController
@RequestMapping(value = "/relatorios")
public class ProductResource {

	@Autowired
	private ProductProxy proxy;
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
		var obj = proxy.insert(dto);
		return obj;
	}
	@PutMapping(value = "{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){
		var obj = proxy.update(id, dto);
		return obj;
	}
	@DeleteMapping(value = "{id}")
	public ResponseEntity<ProductDTO> delete(@PathVariable Long id){
		proxy.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<PageDTO<ProductDTO>> findAll(){
		var dto = proxy.findAll();
		return dto;
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
		var dto = proxy.findById(id);
		return dto;
	}
}
