package com.dutianze.designpattern.behavioral.memento.star;

import com.dutianze.designpattern.behavioral.memento.StarMemento;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public class Star {

    private StarType type;
    private int ageYears;
    private int massTons;

    public Star(StarType startType, int startAge, int startMass) {
        this.type = startType;
        this.ageYears = startAge;
        this.massTons = startMass;
    }

    public void timePasses() {
        ageYears *= 2;
        massTons *= 8;
        switch (type) {
            case RED_GIANT -> type = StarType.WHITE_DWARF;
            case SUN -> type = StarType.RED_GIANT;
            case SUPERNOVA -> type = StarType.DEAD;
            case WHITE_DWARF -> type = StarType.SUPERNOVA;
            case DEAD -> {
                ageYears *= 2;
                massTons = 0;
            }
            default -> {
            }
        }
    }

    public StarMemento getMemento() {
        StarMementoInternal state = new StarMementoInternal();
        state.setAgeYears(ageYears);
        state.setMassTons(massTons);
        state.setType(type);
        return state;
    }

    public void setMemento(StarMemento memento) {
        StarMementoInternal state = (StarMementoInternal) memento;
        this.type = state.getType();
        this.ageYears = state.getAgeYears();
        this.massTons = state.getMassTons();
    }

    @Override
    public String toString() {
        return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
    }

    private static class StarMementoInternal implements StarMemento {

        private StarType type;
        private int ageYears;
        private int massTons;

        public StarType getType() {
            return type;
        }

        public void setType(StarType type) {
            this.type = type;
        }

        public int getAgeYears() {
            return ageYears;
        }

        public void setAgeYears(int ageYears) {
            this.ageYears = ageYears;
        }

        public int getMassTons() {
            return massTons;
        }

        public void setMassTons(int massTons) {
            this.massTons = massTons;
        }
    }
}