package br.univates.ticketmasterplus.business;

public class Person {

    private String nome;
    private String doc;
    private String docType;
    private String fone;
    private String email;

    public Person(String nome, String doc, String docType, String fone, String email) {
        this.nome = nome;
        this.doc = doc;
        this.docType = docType;
        this.fone = fone;
        this.email = email;
    }
    
    public Person(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
