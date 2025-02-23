package com.crud.mapper;

/**
 * A generic abstract class for mapping between Entity and DTO.
 * @param <ENTITY> The entity type
 * @param <DTO> The DTO type
 */
public abstract class AbstractMapper<ENTITY, DTO> {

    /**
     * Converts a DTO to an Entity.
     * @param dto the DTO object
     * @return the corresponding Entity object
     */
    public abstract ENTITY toEntity(DTO dto);

    /**
     * Converts an Entity to a DTO.
     * @param entity the Entity object
     * @return the corresponding DTO object
     */
    public abstract DTO toDto(ENTITY entity);
}
