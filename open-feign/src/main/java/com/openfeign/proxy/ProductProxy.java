package com.openfeign.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openfeign.dto.PageDTO;
import com.openfeign.dto.ProductDTO;


@FeignClient(value = "ds-catalog", url = "http://localhost:8080")
public interface ProductProxy {

	@GetMapping(value = "/products")
	public ResponseEntity<PageDTO<ProductDTO>> findAll();

	@GetMapping(value = "/products/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id);

	@PostMapping(value = "/products")
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto);

	@PutMapping(value = "/products/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto);

	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id);
}
