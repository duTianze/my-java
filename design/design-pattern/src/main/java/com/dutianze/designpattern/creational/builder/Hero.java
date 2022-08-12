package com.dutianze.designpattern.creational.builder;

import lombok.Getter;
import lombok.ToString;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html">java.lang.StringBuilder</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html#put-byte-">java.nio.ByteBuffer</a> as well as similar buffers such as FloatBuffer, IntBuffer and so on.</li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html#append-boolean-">java.lang.StringBuffer</a></li>
 * <li>All implementations of <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Appendable.html">java.lang.Appendable</a></li>
 * <li><a href="https://github.com/apache/camel/tree/0e195428ee04531be27a0b659005e3aa8d159d23/camel-core/src/main/java/org/apache/camel/builder">Apache Camel builders</a></li>
 * <li><a href="https://commons.apache.org/proper/commons-cli/apidocs/org/apache/commons/cli/Option.Builder.html">Apache Commons Option.Builder</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/7
 */
@Getter
@ToString
public class Hero {

    private final Profession profession;
    private final String name;
    private final HairType hairType;
    private final HairColor hairColor;
    private final Armor armor;
    private final Weapon weapon;

    private Hero(Builder builder) {
        this.profession = builder.profession;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
    }

    public static class Builder {

        private final Profession profession;
        private final String name;
        private HairType hairType;
        private HairColor hairColor;
        private Armor armor;
        private Weapon weapon;

        public Builder(Profession profession, String name) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession and name can not be null");
            }
            this.profession = profession;
            this.name = name;
        }

        public Builder withHairType(HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withArmor(Armor armor) {
            this.armor = armor;
            return this;
        }

        public Builder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}
