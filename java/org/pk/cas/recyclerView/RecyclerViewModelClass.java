package org.pk.cas.recyclerView;

public class RecyclerViewModelClass {

    String id,textName, textContact, textE_mail;

    public RecyclerViewModelClass(String id, String textName, String textContact, String textE_mail) {
        this.textName = textName;
        this.textContact = textContact;
        this.textE_mail = textE_mail;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextContact() {
        return textContact;
    }

    public void setTextContact(String textContact) {
        this.textContact = textContact;
    }

    public String getTextE_mail() {
        return textE_mail;
    }

    public void setTextE_mail(String textE_mail) {
        this.textE_mail = textE_mail;
    }
}
