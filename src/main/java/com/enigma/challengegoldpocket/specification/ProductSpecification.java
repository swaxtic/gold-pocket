package com.enigma.challengegoldpocket.specification;

import com.enigma.challengegoldpocket.dto.ProductSearchDto;
import com.enigma.challengegoldpocket.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;

public class ProductSpecification {
    public static Specification<Product> findProducts(ProductSearchDto productSearchForm){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<Predicate>();

                if(!(productSearchForm.getProductName()==null) || productSearchForm.getProductName().equals("")){
                    final Predicate productPredicate = criteriaBuilder.like(root.get("productName"),"%"+productSearchForm.getProductName()+"%");
                    predicates.add(productPredicate); //memasukkan ke dalam list predicate
                }
                //where ... firstname
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
