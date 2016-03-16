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
    public void setName(String name) {
        this.name = name;
    }
    public boolean getCaseSensitive() {
        return caseSensitive;
    }
    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
}
