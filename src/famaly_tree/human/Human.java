package famaly_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;

    // # Конструкторы

    /**
     * Конструктор класса Human для семейного древа.
     * Для умершего человека
     * @param name Имя
     * @param dob Дата рождения
     * @param dod Дата смерти
     * @param gender Пол
     * @param children Список детей
     * @param mother Мать
     * @param father Отец
     */
    public Human(String name, LocalDate dob, LocalDate dod , Gender gender, List<Human> children, Human mother, Human father) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = children;
        this.mother = mother;
        this.father = father;
    }


    public Human(String name, LocalDate dob, Gender gender) {
        this(name, dob, null, gender, null, null, null);
    }

    // # Геттеры
    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getChildrenNames(){
        StringBuilder childrenString = new StringBuilder();
        childrenString.append("{");
        if (this.getChildren()!=null){
            for (Human child : this.getChildren()) {
                childrenString.append(child.name);
                childrenString.append(", ");
            }
            childrenString.deleteCharAt(childrenString.length()-1);
            childrenString.deleteCharAt(childrenString.length()-1);
            childrenString.append("}");
        }
        else {
            return null;
        }
        return childrenString.toString();
    }
    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }


    // # Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void addChild(Human child){
        if (this.gender==gender.MALE){
            child.setFather(this);
        }
        if (this.gender==gender.FEMALE){
            child.setMother(this);
        }
        if (this.children == null) {
            children = new ArrayList<>();
        }
        this.children.add(child);
    }

    public void addParent(Human parent){
        if (parent.gender==gender.MALE){
            this.setFather(parent);
        }
        if (parent.gender==gender.FEMALE){
            this.setMother(parent);
        }
        parent.addChild(this);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Имя: ");
        stringBuilder.append(name);

        stringBuilder.append(", дата рождения: ");
        stringBuilder.append(dob);

        stringBuilder.append(", пол: ");
        stringBuilder.append(gender);

        stringBuilder.append(", дата смерти: ");
        if (dod != null) {
            stringBuilder.append(dod);
        } else {
            stringBuilder.append("неизвестна");
        }

        stringBuilder.append(", отец: ");
        if (father != null) {
            stringBuilder.append(getFather().getName());
        } else {
            stringBuilder.append("неизвестен");
        }

        stringBuilder.append(", мать: ");
        if (mother != null) {
            stringBuilder.append(getMother().getName());
        } else {
            stringBuilder.append("неизвестна");
        }

        stringBuilder.append(", дети: ");
        if (children != null) {
            stringBuilder.append(getChildrenNames());
        } else {
            stringBuilder.append("отсутствуют;");
        }

        return stringBuilder.toString();
    }
}