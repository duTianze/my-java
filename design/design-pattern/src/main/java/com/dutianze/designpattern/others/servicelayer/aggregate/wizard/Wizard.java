package com.dutianze.designpattern.others.servicelayer.aggregate.wizard;

import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBook;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Entity
@Table(name = "WIZARD")
public class Wizard {

    @Id
    @GeneratedValue
    @Column(name = "WIZARD_ID")
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<SpellBook> spellBooks;

    public Wizard() {
        spellBooks = new HashSet<>();
    }

    public Wizard(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SpellBook> getSpellBooks() {
        return spellBooks;
    }

    public void setSpellBooks(Set<SpellBook> spellBooks) {
        this.spellBooks = spellBooks;
    }

    public void addSpellBook(SpellBook spellbook) {
        spellbook.getWizards().add(this);
        spellBooks.add(spellbook);
    }

    @Override
    public String toString() {
        return name;
    }
}

