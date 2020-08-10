package com.denchevgod.petclinic.services.map;

import com.denchevgod.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T obj) {
        if (obj == null)
            throw new RuntimeException("Obj cannot be null");

        if (obj.getId() == null) {
            obj.setId(getNextId());
        }
        map.put(obj.getId(), obj);
        return obj;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T obj) {
        map.entrySet().removeIf(e -> e.getValue().equals(obj));
    }

    private Long getNextId() {
        if (map.isEmpty())
            return 0L;
        return Collections.max(map.keySet()) + 1;
    }
}
