package com.dutianze.designpattern.others.servicelayer.aggregate.spell;

import com.dutianze.designpattern.others.servicelayer.aggregate.spellbook.SpellBook;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Entity
@Table(name = "SPELL")
public class Spell {

    @Id
    @GeneratedValue
    @Column(name = "SPELL_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "SPELLBOOK_ID_FK", referencedColumnName = "SPELLBOOK_ID")
    private SpellBook spellBook;

    public Spell() {
    }

    public Spell(String name) {
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

    public SpellBook getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(SpellBook spellbook) {
        this.spellBook = spellbook;
    }

    @Override
    public String toString() {
        return name;
    }
}
