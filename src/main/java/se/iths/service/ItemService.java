package se.iths.service;

import se.iths.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//@Transactional interagerar med db
@Transactional
public class ItemService {

    //EntityManager - hanterar entiteterna. Ansvarar för att skriva och hämta data fr db
    @PersistenceContext
    EntityManager entityManager;

    public Item createItem(Item item) {

        //persist = spara
        entityManager.persist(item);

        return item;
    }

    public Item updateItem(Item item) {

        entityManager.merge(item);
        return item;
    }

    public Item findItembyId(Long id) {

        //vill hitta ett objekt av typen Item. Får skriva .class. Söker på id
        return entityManager.find(Item.class, id);
    }

    public List<Item> getAllItems() {

        //JPQL query
        return entityManager.createQuery("SELECT i from Item i", Item.class).getResultList();
    }
}
