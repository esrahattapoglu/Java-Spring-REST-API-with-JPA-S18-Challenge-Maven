package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class CardRepositoryImpl implements CardRepository {

    private EntityManager entityManager;

    public CardRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Card save(Card card) {
        entityManager.persist(card);
        return card;
    }

    @Override
    public List<Card> findAll() {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c", Card.class);
        return query.getResultList();
    }

    @Override
    public List<Card> findByColor(String color) {
        TypedQuery<Card> query = entityManager.createQuery(
                "SELECT c FROM Card c WHERE c.color = :color", Card.class);
        query.setParameter("color", color);
        List<Card> result = query.getResultList();
        if (result.isEmpty()) {
            throw new CardException("Card not found", HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @Override
    public List<Card> findByValue(int value) {
        TypedQuery<Card> query = entityManager.createQuery(
                "SELECT c FROM Card c WHERE c.value = :value", Card.class);
        query.setParameter("value", value);
        return query.getResultList();
    }

    @Override
    public List<Card> findByType(String type) {
        TypedQuery<Card> query = entityManager.createQuery(
                "SELECT c FROM Card c WHERE c.type = :type", Card.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public Card update(Card card) {
        return entityManager.merge(card);
    }

    @Override
    public Card remove(Long id) {
        Card card = entityManager.find(Card.class, id);
        entityManager.remove(card);
        return card;
    }
}