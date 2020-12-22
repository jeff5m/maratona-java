package br.com.abc.javacore.Kenum.classes;

public enum ClientType {
    // constant specific class body
    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica") {
        public String getId() {
            return "B";
        }
    };

    private int type;
    private String name;

    ClientType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getId() {
        return "A";
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
