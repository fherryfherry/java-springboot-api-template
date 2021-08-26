package com.sampleproject.sampleproject.services;

import com.sampleproject.sampleproject.models.Product;
import com.sampleproject.sampleproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllLatest()
    {
        return productRepository.findAll();
    }

    public Product findById(String id)
    {
        return productRepository.findFirstById(Long.valueOf(id));
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    // Custom Query
    public List<Product> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);

        List<Predicate> predicates = new ArrayList<>();

        // Filter not deleted
//        predicates.add(cb.isNull(root.get("deletedAt")));

        cq.where(predicates.toArray(new Predicate[] {}));
        TypedQuery<Product> q = this.entityManager.createQuery(cq)
                .setFirstResult(0)
                .setMaxResults(1000);
        return q.getResultList();
    }
}
