package br.com.livecoding.service;

import br.com.livecoding.model.AbstractModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PageRanges;
import java.io.Serializable;
import java.util.Optional;

@Service
public abstract class AbstractService<T extends AbstractModel<Long>, Long extends Serializable> {

    private static final int PAGE_SIZE = 5;

    protected abstract JpaRepository<T, Long> getRepository();

    public Page<T> getList(Integer pageNumber) {
        return (Page<T>) PageRequest.of(pageNumber, PAGE_SIZE);

    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> get(Long id) {
        Optional<T> entity = getRepository().findById(id);
        return entity;
    }

    public void delete(Long id) {
        try {
            getRepository().deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            System.out.println("Erro ao deletar >> " + e.getMessage());

        }
    }
    public void update(T entity){
        Optional<T> getEntity = getRepository().findById(entity.getId());
        getRepository().save(entity);
    }

}















