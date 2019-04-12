package com.cg.mobinv.mobileinventory.logic.api;

import org.springframework.stereotype.Component;

import com.cg.mobinv.mobileinventory.logic.api.cloning.EntityPostCloningProcessor;

import javax.transaction.Transactional;

@Component
@Transactional
public abstract class EntityCloner<T> {

    private EntityPostCloningProcessor<T> postCloningProcessor = null;

    public T clone(long id) {

        T entityToClone = getExistingEntity(id);
        T clonedEntity = startCloning(entityToClone);
        clonedEntity = postCloningProcessor.process(clonedEntity);
        return save(clonedEntity);
    }

    protected abstract T getExistingEntity(long id);

    protected abstract T startCloning(T entityToClone);

    protected abstract T save(T clonedEntity);

    public void setPostCloningProcessor(EntityPostCloningProcessor<T> postCloningProcessor) {

        this.postCloningProcessor = postCloningProcessor;
    }
}
