package br.com.abc.javacore.ZZFdesignpatterns.classes;

public class Person {
    private String name;
    private String lastName;
    private String middleName;
    private String nickName;
    private String fathersName;

    public Person() {
    }

    private Person(String name, String lastName, String middleName, String nickName, String fathersName) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.nickName = nickName;
        this.fathersName = fathersName;
    }

    public static class PersonsBuilder {
        private String name;
        private String lastName;
        private String middleName;
        private String nickName;
        private String fathersName;

        public PersonsBuilder(String name) {
            this.name = name;
        }

        public PersonsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonsBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonsBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonsBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public PersonsBuilder fathersName(String fathersName) {
            this.fathersName = fathersName;
            return this;
        }
        public Person build() {
            return new Person(name, lastName, middleName, nickName, fathersName);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }
}
