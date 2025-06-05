package com.d3vlin13.market.persistence.mapper;

import com.d3vlin13.market.domain.Category;
import com.d3vlin13.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active"),
    })
    Category toCategory(Categoria category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Categoria toCategoria(Category category);

}
