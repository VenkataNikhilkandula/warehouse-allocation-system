package com.stackly.serviceimplementation;

import com.stackly.DTO.ProductRequest;
import com.stackly.DTO.ProductResponse;
import com.stackly.entity.Product;
import com.stackly.repository.Productrepository;
import com.stackly.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public abstract class ProductServiceImpl implements ProductService {
//    @Autowired
//    private Productrepository repo;
//
//    public ProductResponse create(ProductRequest req) {
//        Product p = new Product();
//        p.setName(req.getName());
//        p.setSku(req.getSku());
//        p.setTotalStock(req.getTotalStock());
//        return repo.save(p);
//    }
//
//    public List<Product> getAll() {
//        return repo.findAll();
//    }
//}

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private Productrepository repo;

    @Override
    public Product create(ProductRequest req) {

        Product p = new Product();
        p.setName(req.getName());
        p.setSku(req.getSku());
        p.setTotalStock(req.getTotalStock());

        return repo.save(p);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

	@Override
	public ProductResponse getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductResponse update(Long id, ProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}