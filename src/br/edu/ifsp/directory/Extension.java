package br.edu.ifsp.directory;

public class Extension {
    private String name;
    private boolean caseSensitive;

    public Extension(String name, boolean caseSensitive) {
        this.name = name;
        this.caseSensitive = caseSensitive;
    }

    public String getName() {
        return name;
    }
    public boolean getCaseSensitive() {
        return caseSensitive;
    }
}
