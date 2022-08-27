package com.dutianze.designpattern.others.servicelayer.aggregate.spellbook;

import com.dutianze.designpattern.others.servicelayer.aggregate.spell.Spell;
import com.dutianze.designpattern.others.servicelayer.aggregate.wizard.Wizard;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Entity
@Table(name = "SPELLBOOK")
public class SpellBook {

    @Id
    @GeneratedValue
    @Column(name = "SPELLBOOK_ID")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "spellBooks", fetch = FetchType.EAGER)
    private Set<Wizard> wizards;

    @OneToMany(mappedBy = "spellBook", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Spell> spells;

    public SpellBook() {
        spells = new HashSet<>();
        wizards = new HashSet<>();
    }

    public SpellBook(String name) {
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

    public Set<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(Set<Wizard> wizards) {
        this.wizards = wizards;
    }

    public Set<Spell> getSpells() {
        return spells;
    }

    public void setSpells(Set<Spell> spells) {
        this.spells = spells;
    }

    public void addSpell(Spell spell) {
        spell.setSpellBook(this);
        spells.add(spell);
    }

    @Override
    public String toString() {
        return name;
    }
}

